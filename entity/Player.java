package entity;

import java.lang.*;

public class Player
{
	private String playerId;
	private String playerName;
	private String email;
	private int phone;
	private double salary;
	private String playerType;
	
	public Player(){}
	public Player(String playerId,String playerName,String email, int phone, double salary,String playerType)
	{
		this.playerId=playerId;
		this.playerName=playerName;
		this.email=email;
		this.phone=phone;
		this.salary=salary;
		this.playerType=playerType;
	}	
	
	public void setPlayerId(String playerId)
	{
		this.playerId=playerId;
	}
		
	public void setPlayerName(String playerName)
	{
		this.playerName=playerName;
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
	public void setPlayerType(String playerType)
	{
		this.playerType=playerType;
	}
		
	public String getPlayerId(){return playerId;}
	public String getPlayerName(){return playerName;}
	public String getEmail(){return email;}
	public int getPhone(){return phone;}
	public double getSalary(){return salary;}
    public String getPlayerType(){return playerType;}	
			
}