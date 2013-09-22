package nl.hanze.designpatterns.db;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;

public class RowIterator<T> implements Iterator<T>
{
	private ResultSet resultSet;
	
	private Class<T> c;
	
	/**
	 * RowIterator is made to protected so it can only be instantiated from the database package,
	 * but can't be instantiated by classes in other packages. Classes in other packages shouldn't
	 * have any reason to instantiate this class.
	 * 
	 * @param resultSet
	 * @param c
	 */
	protected RowIterator(ResultSet resultSet, Class<T> c)
	{
		this.resultSet = resultSet;
		
		this.c = c;
	}
	
	@Override
	public boolean hasNext()
	{
		try
		{
			if (!resultSet.isLast())
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public T next()
	{
		try
		{
			resultSet.next();
			
			// Instantiate T to fill be able to fill it with result data
			T instance = c.newInstance();
			
			// Column names are stored in the metaData
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			for (int columnIndex = 1; true; columnIndex++)
			{
				try
				{
					String columnName = resultSetMetaData.getColumnName(columnIndex);
					
					// Capitalize first character
					columnName = columnName.substring(0, 1).toUpperCase() + columnName.substring(1);

					Method instanceSetMethod;
					
					// Try getting a set method from T that matches the current column name
					try
					{
						instanceSetMethod = instance.getClass().getMethod("set" + columnName, Object.class);
					}
					catch (NoSuchMethodException | SecurityException e)
					{
						continue;
					}
					
					// Invoke retrieved method with the data from the result set
					try
					{
						instanceSetMethod.invoke(instance, resultSet.getObject(columnIndex));
					}
					catch (IllegalArgumentException | InvocationTargetException e)
					{
						continue;
					}
				}
				// When the last column ID is reached, an SQLException is thrown. Break on this point.
				catch (SQLException e)
				{
					break;
				}
			}
			
			return instance;
		}
		catch (SQLException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}
