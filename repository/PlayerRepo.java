package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class PlayerRepo implements IPlayerRepo
{
	DatabaseConnection dbc;
	
	public PlayerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Player p)
	{
		String query = "INSERT INTO player VALUES ('"+p.getPlayerId()+"','"+p.getPlayerName()+"','"+p.getEmail()+"','"+p.getPhone()+"','"+p.getSalary()+"',"+p.getPlayerType()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String playerId)
	{
		String query = "DELETE from player WHERE playerId='"+playerId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Player p)
	{
		String query = "UPDATE player SET playerName='"+p.getPlayerName()+"',  email='"+p.getEmail()+"',phone='"+p.getPhone()+"',salary='"+p.getSalary()+"',playerType="+p.getPlayerType()+" WHERE playerId='"+p.getPlayerId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Player searchPlayer(String playerId)
	{
		Player pl = null;
		String query = "SELECT `playerName`, `email`,`phone`,`salary`,`PlayerType` FROM `player` WHERE `playerId`='"+playerId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String playerName = dbc.result.getString("playerName");
				String email = dbc.result.getString("email");
				int phone = dbc.result.getInt("phone");
				double salary = dbc.result.getDouble("salary");
				String playerType = dbc.result.getString("playerType");
				
				pl = new Player();
				pl.setPlayerId(playerId);
				pl.setPlayerName(playerName);
				pl.setEmail(email);
				pl.setPhone(phone);
				pl.setSalary(salary);
				pl.setPlayerType(playerType);
				
				
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return pl;
	}
	public String[][] getAllPlayer()
	{
		ArrayList<Player> ar = new ArrayList<Player>();
		String query = "SELECT * FROM player;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String playerId = dbc.result.getString("playerId");
				String playerName = dbc.result.getString("playerName");
				String email = dbc.result.getString("email");
				int phone = dbc.result.getInt("phone");
				double salary = dbc.result.getDouble("salary");
				String playerType = dbc.result.getString("playerType");
				
				
				Player p = new Player(playerId,playerName,email,phone,salary,playerType);
				ar.add(p);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Player)obj[i]).getPlayerId();
			data[i][1] = ((Player)obj[i]).getPlayerName();
			data[i][2] = ((Player)obj[i]).getEmail();
			data[i][3] = (((Player)obj[i]).getPhone())+"";
			data[i][4] = (((Player)obj[i]).getSalary())+"";
			data[i][5] = ((Player)obj[i]).getPlayerType();
			
		}
		return data;
	}
}




