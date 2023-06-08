package entity;

import java.lang.*;

public class Coach
{
	private String coachId;
	private String coachName;
	private String email;
	private int phone;
	private double salary;
	
	public Coach()
	{
		
	}
	public Coach(String coachId, String coachName, String email, int phone, double salary)
	{
		this.coachId=coachId;
		this.coachName=coachName;
		this.email=email;
		this.phone=phone;
		this.salary=salary;
	}
	public void setCoachId(String coachId)
	{
		this.coachId=coachId;
	}
	public void setCoachName(String coachName)
	{
		this.coachName=coachName;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setPhone(int phone)
	{
		this.phone=phone;
	}
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	
	public String getCoachId(){return coachId;}
	public String getCoachName(){return coachName;}
	public String getEmail(){return email;}
	public int getPhone(){return phone;}
	public double getSalary(){return salary;}
	
}