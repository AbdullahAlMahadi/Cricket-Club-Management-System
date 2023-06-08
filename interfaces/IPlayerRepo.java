package interfaces;

import java.lang.*;

import entity.*;

public interface IPlayerRepo
{
	public void insertInDB(Player p);
	public void deleteFromDB(String playerId);
	public void updateInDB(Player p);
	public Player searchPlayer(String playerId);
	public String[][] getAllPlayer();
}