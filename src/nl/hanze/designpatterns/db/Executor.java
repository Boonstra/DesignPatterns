package nl.hanze.designpatterns.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Executor
{
	private Connection connection;
	private Statement  statement;
	private ResultSet  resultSet;
	
	private String url;
	private String user;
	private String password;
	
	public Executor(String url, String user, String password)
	{
		this.url      = url;
		this.user     = user;
		this.password = password;
		
		connect();
	}
	
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			
			return;
		}
		
		try
		{
			connection = DriverManager.getConnection(url, user, password);
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("SELECT VERSION()");
			
			if (resultSet.next())
			{
				System.out.println(resultSet.getString(1));
			}
		}
		catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		finally
		{
			try
			{
				if (resultSet != null)
				{
					resultSet.close();
				}
				
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
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void executeQuery(String query) throws Exception
	{
			
	}
	
	public <T> Iterator<T> getIterator(String query, Class<T> c) throws Exception
	{
		return null;
	}
}
