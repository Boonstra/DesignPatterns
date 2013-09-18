package nl.hanze.designpatterns.DAO.main;

import nl.hanze.designpatterns.db.Executor;

public class Main
{
	public static void main(String[] args)
	{
		Executor executor = new Executor("jdbc:mysql://localhost:3306/designpatterns", "root", "");
	}
}
