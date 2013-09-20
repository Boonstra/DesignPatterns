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
