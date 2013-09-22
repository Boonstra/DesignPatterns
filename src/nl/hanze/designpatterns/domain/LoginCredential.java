package nl.hanze.designpatterns.domain;

public class LoginCredential
{
	private int ID;
	
	private String userName;
	private String password;
	
	public LoginCredential() { }
	
	public LoginCredential(String userName, String password)
	{
		this.setUserName(userName);
		this.setPassword(password);
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public void setID(Object ID)
	{
		try
		{
			this.ID = Integer.parseInt(ID.toString());
		}
		catch (NumberFormatException e)
		{
			this.ID = 0;
		}
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public void setUserName(Object userName)
	{
		this.userName = userName.toString();
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setPassword(Object password)
	{
		this.password = password.toString();
	}
	
	@Override
	public String toString()
	{
		return userName+"::"+password;
	}
}
