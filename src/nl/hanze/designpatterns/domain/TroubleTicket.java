package nl.hanze.designpatterns.domain;

public class TroubleTicket
{
	private int ID;
	
	private String userName;
	private String callerName;
	private String description;
	private String dateTime;
	
	public TroubleTicket(String userName, String callerName, String description, String dateTime)
	{
		this.setUserName(userName);
		this.setCallerName(callerName);
		this.setDescription(description);
		this.setDateTime(dateTime);
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
		this.ID = Integer.parseInt(ID.toString());
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

	public String getCallerName()
	{
		return callerName;
	}

	public void setCallerName(String callerName)
	{
		this.callerName = callerName;
	}
	
	public void setCallerName(Object callerName)
	{
		this.callerName = callerName.toString();
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setDescription(Object description)
	{
		this.description = description.toString();
	}

	public String getDateTime()
	{
		return dateTime;
	}

	public void setDateTime(String dateTime)
	{
		this.dateTime = dateTime;
	}
	
	public void setDateTime(Object dateTime)
	{
		this.dateTime = dateTime.toString();
	}
}
