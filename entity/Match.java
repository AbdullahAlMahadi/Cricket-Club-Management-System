package entity;

import java.lang.*;

public class Match
{
	private String matchNo;
	private String matchType;
	private String schedule;
	private String status;
	
	public Match(){}
	public Match(String matchNo,String matchType,String schedule,String status)
	{
		this.matchNo=matchNo;
		this.matchType=matchType;
		this.schedule=schedule;
		this.status=status;
	}
	public void setMatchNo(String matchNo)
	{
		this.matchNo=matchNo;
	}
	public void  setMatchType(String matchType)
	{
		this.matchType=matchType;
	}
	public void setSchedule(String schedule)
	{
		this.schedule=schedule;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}
	
	public String getMatchNo(){return matchNo;}
	public String getMatchType(){return matchType;}
	public String getSchedule(){return schedule;}
	public String getStatus(){return status;}
	
}