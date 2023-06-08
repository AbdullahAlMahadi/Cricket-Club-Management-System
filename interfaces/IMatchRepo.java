package interfaces;

import java.lang.*;

import entity.*;

public interface IMatchRepo
{
	public void insertInDB(Match m);
	public void deleteFromDB(String matchNo);
	public void updateInDB(Match m);
	public Match searchMatch(String matchNo);
	public String[][] getAllMatch();
}