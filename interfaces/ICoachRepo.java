package interfaces;

import java.lang.*;

import entity.*;

public interface ICoachRepo
{
	public void insertInDB(Coach c);
	public void deleteFromDB(String coachId);
	public void updateInDB(Coach c);
	public Coach searchCoach(String coachId);
	public String[][] getAllCoach();
}