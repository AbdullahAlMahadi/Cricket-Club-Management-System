package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class ManagerRepo implements IManagerRepo
{
	DatabaseConnection dbc;
	
	public ManagerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	///////////////////////////
	
	
	public void insertInDB(Manager m)
	{
		String query = "INSERT INTO manager VALUES ('"+m.getManagerId()+"','"+m.getManagerName()+"','"+m.getEmail()+"','"+m.getPhone()+"',"+m.getSalary()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	////////////////////////////
	
	
	
	public void deleteFromDB(String managerId)
	{
		String query = "DELETE from manager WHERE managerId='"+managerId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	////////////////////////////////
	
	
	
	public void updateInDB(Manager m)
	{
		String query = "UPDATE manager SET managerName='"+m.getManagerName()+"', email = '"+m.getEmail()+"', phone ='"+m.getPhone()+"',salary="+m.getSalary()+" WHERE managerId='"+m.getManagerId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	/////////////////////////////////
	
	
	
	public Manager searchManager(String managerId)
	{
		Manager mg = null;
		String query = "SELECT `managerName`,`email`,`phone`,`salary` FROM `manager` WHERE `managerId`='"+managerId+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				//String managerId = dbc.result.getString("managerId");
				String managerName = dbc.result.getString("managerName");
				String email = dbc.result.getString("email");
				int phone = dbc.result.getInt("phone");
				double salary = dbc.result.getDouble("salary");
				
				
				mg = new Manager();
				mg.setManagerId(managerId);
				mg.setManagerName(managerName);
				mg.setEmail(email);
				mg.setPhone(phone);
				mg.setSalary(salary);
						
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return mg;
	}
	
	/////////////////////////////////////
	
	
	
	public String[][] getAllManager()
	{
		ArrayList<Manager> ar = new ArrayList<Manager>();
		String query = "SELECT * FROM manager;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String managerId = dbc.result.getString("managerId");
				String managerName = dbc.result.getString("managerName");
				String email = dbc.result.getString("email");
				int phone = dbc.result.getInt("phone");
				double salary = dbc.result.getDouble("salary");
				
				Manager m = new Manager(managerId,managerName,email,phone,salary);
				ar.add(m);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Manager)obj[i]).getManagerId();
			data[i][1] = ((Manager)obj[i]).getManagerName();
			data[i][2] = ((Manager)obj[i]).getEmail();
			data[i][3] = (((Manager)obj[i]).getPhone())+"";
			data[i][4] = (((Manager)obj[i]).getSalary())+"";
		}
		return data;
	}
}
