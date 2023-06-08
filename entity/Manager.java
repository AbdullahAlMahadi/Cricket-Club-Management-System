package entity;

import java.lang.*;

public class Manager
{
	private String managerId;
	private String managerName;
	private String email;
	private int phone;
	private double salary;
	
	public Manager()
	{
		
	}
	public Manager(String managerId, String managerName, String email, int phone, double salary)
	{
		this.managerId=managerId;
		this.managerName=managerName;
		this.email=email;
		this.phone=phone;
		this.salary=salary;
	}
	public void setManagerId(String managerId)
	{
		this.managerId=managerId;
	}
	public void setManagerName(String managerName)
	{
		this.managerName=managerName;
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
	
	public String getManagerId(){return managerId;}
	public String getManagerName(){return managerName;}
	public String getEmail(){return email;}
	public int getPhone(){return phone;}
	public double getSalary(){return salary;}
	
}