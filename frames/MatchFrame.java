package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class MatchFrame extends JFrame implements ActionListener
{
	private JLabel MatchNo, MatchType, Schedule,Status;
	private JTextField MatchNoTF, MatchTypeTF, StatusTF, ScheduleTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn ,logoutBtn;
	private JPanel panel;
	private JTable MatchTable;
	private JScrollPane MatchTableSP;
	private Color color ;
	private User user;
	private MatchRepo mtr;
	private UserRepo ur;
	
	
	public MatchFrame(User user)
	{
		super("Match Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		mtr= new MatchRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		color = new Color(255,248,220);
		panel.setBackground(color);
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"MatchNo", "MatchType", "Schedule","Status"};
		
		MatchTable = new JTable(data,head);
		MatchTableSP = new JScrollPane(MatchTable);
		//MatchTableSP.setBounds(10, 10, 780, 150);
		MatchTable.setEnabled(false);
		panel.add(MatchTableSP);
		
		MatchNo = new JLabel("MatchNo :");
		MatchNo.setBounds(10,200,100,30);
		panel.add(MatchNo);
		
		MatchNoTF = new JTextField();
		MatchNoTF.setBounds(90,200,100,30);
		panel.add(MatchNoTF);
		
		MatchType = new JLabel("MatchType :");
		MatchType.setBounds(10,250,100,30);
		panel.add(MatchType);
		
		MatchTypeTF = new JTextField();
		MatchTypeTF.setBounds(90,250,100,30);
		panel.add(MatchTypeTF);
		
		
		
		Schedule = new JLabel("Schedule : ");
		Schedule.setBounds(10,300,100,30);
		panel.add(Schedule);
		
		ScheduleTF = new JTextField();
		ScheduleTF.setBounds(90,300,100,30);
		panel.add(ScheduleTF);
		
		Status = new JLabel("Status: ");
		Status.setBounds(10,350,100,30);
		panel.add(Status);
		
		StatusTF = new JTextField();
		StatusTF.setBounds(90,350,100,30);
		panel.add(StatusTF);
		
		
		
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(440,200,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(540,200,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(540,250,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(440,250,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(490,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		//getAllBtn.setBounds(700,170,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(580, 370, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(700, 370, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			
			if(!MatchNoTF.getText().equals("") || !MatchNoTF.getText().equals(null))
			{
				Match mt = mtr.searchMatch(MatchNoTF.getText());
				if(mt!= null)
				{
					MatchTypeTF.setText(mt.getMatchType());
					StatusTF.setText(mt.getStatus());
					ScheduleTF.setText(mt.getSchedule());
					
					
					MatchNoTF.setEnabled(false);
					MatchTypeTF.setEnabled(true);
					ScheduleTF.setEnabled(true);
					StatusTF.setEnabled(true);
					
					if(this.user.getStatus()==0)
					{

					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
					}
					else
					{
						updateBtn.setEnabled(false);
						deleteBtn.setEnabled(false);
						refreshBtn.setEnabled(true);
						insertBtn.setEnabled(false);
						loadBtn.setEnabled(true);
					}
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Match mt = new Match();
			
			mt.setMatchNo(MatchNoTF.getText());
			mt.setMatchType(MatchTypeTF.getText());
			mt.setSchedule(ScheduleTF.getText());
			mt.setStatus(StatusTF.getText());
			
			mtr.insertInDB(mt);
		
			
			JOptionPane.showMessageDialog(this, "Match No: "+MatchNoTF.getText()+" inserted");
			
			MatchNoTF.setText("");
			MatchTypeTF.setText("");
			StatusTF.setText("");
			ScheduleTF.setText("");
			
			
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			MatchNoTF.setText("");
			MatchTypeTF.setText("");
			StatusTF.setText("");
			ScheduleTF.setText("");
			
			MatchNoTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Match mt = new Match ();
			
			mt.setMatchNo(MatchNoTF.getText());
			mt.setMatchType(MatchTypeTF.getText());
			mt.setStatus(StatusTF.getText());
			mt.setSchedule(ScheduleTF.getText());
			
			mtr.updateInDB(mt);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			MatchNoTF.setText("");
			MatchTypeTF.setText("");
			StatusTF.setText("");
			ScheduleTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			MatchNoTF.setEnabled(true);
			MatchTypeTF.setEnabled(true);
			StatusTF.setEnabled(true);
			ScheduleTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			mtr.deleteFromDB(MatchNoTF.getText());
			ur.deleteUser(MatchNoTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			MatchNoTF.setText("");
			MatchTypeTF.setText("");
			StatusTF.setText("");
			ScheduleTF.setText("");
			
			MatchNoTF.setEnabled(true);
			MatchTypeTF.setEnabled(true);
			StatusTF.setEnabled(true);
			ScheduleTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			
			
			String data[][] = mtr.getAllMatch();
			String head[] = {"MatchNo", "MatchType", "Schedule","Status"};
			
			panel.remove(MatchTableSP);
			
			MatchTable = new JTable(data,head);
			MatchTable.setEnabled(false);
			MatchTableSP = new JScrollPane(MatchTable);
			//MatchTableSP.setBounds(10, 10, 780, 150);
			panel.add(MatchTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(backBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				ManagerHome mh = new ManagerHome(user);
				mh.setVisible(true);
				this.setVisible(false);
			}
			else if(user.getStatus()==1)
			{
				CoachHome ch = new CoachHome(user);
				ch.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				PlayerHome ph = new PlayerHome(user);
				ph.setVisible(true);
				this.setVisible(false);
			}
		}
		
		
		
		else{}
		
	}
	
}