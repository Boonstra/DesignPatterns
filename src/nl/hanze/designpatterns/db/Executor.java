package nl.hanze.designpatterns.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Executor
{
	private static final String MYSQL_ERROR_PREFIX = "MySQL error: ";
	
	private String url;
	private String user;
	private String password;
	
	private static Executor executor;
	
	private Executor() throws ExecutorException
	{
		try
		{
			// Load MySQL driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception e)
		{
			throw new ExecutorException(MYSQL_ERROR_PREFIX + "MySQL driver could not be found");
		}
	}
	
	/**
	 * Singleton method
	 * 
	 * @return executor
	 */
	public static Executor getInstance() throws ExecutorException
	{
		if (executor == null)
		{
			executor = new Executor();
		}
		
		return executor;
	}
	
	/**
	 * Execute update query
	 * 
	 * @param query
	 * 
	 * @throws Exception
	 */
	public void executeQuery(String query) throws ExecutorException
	{
		Connection connection = null;
		Statement  statement  = null;
		
		try
		{
			connection = DriverManager.getConnection(url, user, password);
			
			statement = connection.createStatement();
			
			statement.executeUpdate(query);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (statement != null)
				{
					statement.close();
				}
				
				if (connection != null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Execute select query
	 * 
	 * @param <T>
	 * @param query
	 * @param c
	 * 
	 * @return iterator
	 * 
	 * @throws Exception
	 */
	public <T> Iterator<T> getIterator(String query, Class<T> c) throws ExecutorException
	{
		Connection connection = null;
		Statement  statement  = null;
		
		try
		{
			// Connect
			connection = DriverManager.getConnection(url, user, password);
			
			statement = connection.createStatement();
			
			// Execute query and create a new typed RowIterator 
			return new RowIterator<T>(statement.executeQuery(query), c);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * @param url
	 */
	public void setUrl(String url)
	{
		if (this.url == null)
		{
			this.url = url;
		}
	}

	/**
	 * @param user
	 */
	public void setUser(String user)
	{
		if (this.user == null)
		{
			this.user = user;
		}
	}

	/**
	 * @param password
	 */
	public void setPassword(String password)
	{
		if (this.password == null)
		{
			this.password = password;
		}
	}
	
	/**
	 * ExecutorException
	 */
	public class ExecutorException extends Exception
	{
		private static final long serialVersionUID = 8283479030956203260L;
		
		public ExecutorException(String message) { super(message); }
	}
}
