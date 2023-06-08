package interfaces;

import java.lang.*;

import entity.*;

public interface IManagerRepo
{
	public void insertInDB(Manager m);
	public void deleteFromDB(String managerId);
	public void updateInDB(Manager m);
	public Manager searchManager(String managerId);
	public String[][] getAllManager();
}