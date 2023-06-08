package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class CoachRepo implements ICoachRepo
{
	DatabaseConnection dbc;
	
	public CoachRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	///////////////////////////
	
	
	public void insertInDB(Coach c)
	{
		String query = "INSERT INTO coach VALUES ('"+c.getCoachId()+"','"+c.getCoachName()+"','"+c.getEmail()+"','"+c.getPhone()+"',"+c.getSalary()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	////////////////////////////
	
	public void deleteFromDB(String coachId)
	{
		String query = "DELETE from coach WHERE coachId='"+coachId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	////////////////////////////////
	
	
	public void updateInDB(Coach c)
	{
		String query = "UPDATE coach SET coachName='"+c.getCoachName()+"', email = '"+c.getEmail()+"', phone = '"+c.getPhone()+"', salary="+c.getSalary()+" WHERE coachId='"+c.getCoachId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	/////////////////////////////////
	
	
	public Coach searchCoach(String coachId)
	{
		Coach co = null;
		String query = "SELECT `coachName`, `email`,`phone`,`salary` FROM `coach` WHERE `coachId`='"+coachId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				//String coachId = dbc.result.getString("coachId");
				String coachName = dbc.result.getString("coachName");
				String email = dbc.result.getString("email");
				int phone = dbc.result.getInt("phone");
				double salary = dbc.result.getDouble("salary");
				
				
				co = new Coach();
				co.setCoachId(coachId);
				co.setCoachName(coachName);
				co.setEmail(email);
				co.setPhone(phone);
				co.setSalary(salary);
						
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return co;
	}
	
	/////////////////////////////////////
	
	public String[][] getAllCoach()
	{
		ArrayList<Coach> ar = new ArrayList<Coach>();
		String query = "SELECT * FROM coach;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String coachId = dbc.result.getString("coachId");
				String coachName = dbc.result.getString("coachName");
				String email = dbc.result.getString("email");
				int phone = dbc.result.getInt("phone");
				double salary = dbc.result.getDouble("salary");
				
				Coach c = new Coach(coachId,coachName,email,phone,salary);
				ar.add(c);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Coach)obj[i]).getCoachId();
			data[i][1] = ((Coach)obj[i]).getCoachName();
			data[i][2] = ((Coach)obj[i]).getEmail();
			data[i][3] = (((Coach)obj[i]).getPhone())+"";
			data[i][4] = (((Coach)obj[i]).getSalary())+"";
		}
		return data;
	}
}
