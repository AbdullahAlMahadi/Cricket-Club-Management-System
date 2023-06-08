package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class MatchRepo implements IMatchRepo
{
	DatabaseConnection dbc;
	
	public MatchRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Match m)
	{
		String query = "INSERT INTO match VALUES ('"+m.getMatchNo()+"','"+m.getMatchType()+"','"+m.getSchedule()+"',"+m.getStatus()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String matchNo)
	{
		String query = "DELETE from match WHERE matchNo='"+matchNo+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Match m)
	{
		String query = "UPDATE match SET matchType='"+m.getMatchType()+"',  schedule = '"+m.getSchedule()+"',status = "+m.getStatus()+" WHERE matchNo='"+m.getMatchNo()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Match searchMatch(String matchNo)
	{
		Match mat = null;
		String query = "SELECT  `matchType`,`schedule`,`status` FROM `match` WHERE `matchNo`='"+matchNo+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				//String matchNo = dbc.result.getString("matchNo");
				String matchType = dbc.result.getString("matchType");
				String schedule = dbc.result.getString("schedule");
				String status = dbc.result.getString("status");
				
				mat = new Match();
				mat.setMatchNo(matchNo);
				mat.setMatchType(matchType);
				mat.setSchedule(schedule);
				mat.setStatus(status);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return mat;
	}
	public String[][] getAllMatch()
	{
		ArrayList<Match> ar = new ArrayList<Match>();
		String query = "SELECT * FROM match;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String matchNo = dbc.result.getString("matchNo");
				String matchType = dbc.result.getString("matchType");
				String schedule = dbc.result.getString("schedule");
				String status = dbc.result.getString("status");
				
				Match m = new Match(matchNo,matchType,schedule,status);
				ar.add(m);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Match)obj[i]).getMatchNo();
			data[i][1] = ((Match)obj[i]).getMatchType();
			data[i][3] = ((Match)obj[i]).getSchedule();
			data[i][4] = (((Match)obj[i]).getStatus());
		}
		return data;
	}
}




