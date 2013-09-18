package nl.hanze.designpatterns.db;

import java.util.*;

public class RowIterator<T> implements Iterator<T>
{
	/**
	 * TODO Add explanation of why RowIterator is made protected.
	 */
	protected RowIterator() { }
	
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
