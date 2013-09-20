package nl.hanze.designpatterns.db;

import java.sql.ResultSet;
import java.util.Iterator;

public class RowIterator<T> implements Iterator<T>
{
	ResultSet resultSet;
	
	/**
	 * RowIterator is made to protected so it can only be instantiated from the database package,
	 * but can't be instantiated by classes in other packages. Classes in other packages shouldn't
	 * have any reason to instantiate this class.
	 * 
	 * @param resultSet
	 */
	protected RowIterator(ResultSet resultSet)
	{
		this.resultSet = resultSet;
	}
	
	@Override
	public boolean hasNext()
	{
		return false;
	}

	@Override
	public T next()
	{
		return null;
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}

/* This may be a pretty good example of the reflector expected in the next() method:
 * 
//	// A row is stored as a combination of column name (String) and its value (Object)
//	ArrayList<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();
//	
//	while (resultSet.next())
//	{
//		HashMap<String, Object> row = new HashMap<String, Object>();
//		
//		// Column names are stored in the metaData
//		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//		
//		for (int columnIndex = 0; true; columnIndex++)
//		{
//			try
//			{
//				row.put(resultSetMetaData.getColumnName(columnIndex), resultSet.getObject(columnIndex));
//			}
//			// When the last column ID is reached, an SQLException is thrown. Break on this point.
//			catch (SQLException e)
//			{
//				break;
//			}
//		}
//		
//		rows.add(row);
//	}
//	
//	//return rows.iterator();
 * 
 */
