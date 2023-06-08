package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CoachHome extends JFrame implements ActionListener,MouseListener
{
	JButton logoutBtn, managerBtn, coachBtn, playerBtn, matchBtn, changePasswordBtn;
	Color color ;
	JPanel panel;
	
	User user;
	
	public CoachHome(User user)
	{
		super("Coach Home");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		Font myFont = new Font("Cambria", Font.ITALIC | Font.BOLD, 18);
		Font mytext = new Font("Cambria", Font.ITALIC | Font.BOLD, 25);
		
		
		color = new Color(219,213,146);
		panel.setBackground(color);
		
		
		
		
		
		managerBtn = new JButton("View Manager");
		managerBtn.setBounds(170,100,180,70);
		color = new Color(0,153,153);
		managerBtn.setBackground(color);
		managerBtn.addActionListener(this);
		managerBtn.addMouseListener(this);
		managerBtn.setFont(myFont);
		panel.add(managerBtn);
		
		coachBtn = new JButton("Manage Coach");
		coachBtn.setBounds(170, 200, 180, 70);
		color = new Color(0,153,153);
		coachBtn.setBackground(color);
		coachBtn.addActionListener(this);
		coachBtn.addMouseListener(this);
		coachBtn.setFont(myFont);
		panel.add(coachBtn);
		
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(170, 300, 180, 70);
		color = new Color(255,127,80);
		changePasswordBtn.setBackground(color);
		changePasswordBtn.addActionListener(this);
		changePasswordBtn.addMouseListener(this);
		changePasswordBtn.setFont(myFont);
		panel.add(changePasswordBtn);
		
		
		
		playerBtn = new JButton("Manage Player");
		playerBtn.setBounds(450, 100, 180, 70);
		color = new Color(0,153,153);
		playerBtn.setBackground(color);
		playerBtn.addActionListener(this);
		playerBtn.addMouseListener(this);
		playerBtn.setFont(myFont);
		panel.add(playerBtn);
		
		
		matchBtn = new JButton("View Match");
		matchBtn.setBounds(450, 200, 180, 70);
		color = new Color(0,153,153);
		matchBtn.setBackground(color);
		matchBtn.addActionListener(this);
		matchBtn.addMouseListener(this);
		matchBtn.setFont(myFont);
		panel.add(matchBtn);
		
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(450, 300, 180, 70);
		color = new Color(255,51,51);
		logoutBtn.setBackground(color);
		logoutBtn.setForeground(Color.WHITE);
		logoutBtn.addActionListener(this);
		logoutBtn.addMouseListener(this);
		logoutBtn.setFont(mytext);
		panel.add(logoutBtn);
		
		
		this.add(panel);
	
		
	}
	
	
	
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		
		if(me.getSource() == managerBtn)
		{
			managerBtn.setBackground(color = new Color(51,153,255));
			managerBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== playerBtn)
		{
			playerBtn.setBackground(color = new Color(51,153,255));
			playerBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== matchBtn)
		{
			matchBtn.setBackground(color = new Color(51,153,255));
			matchBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== coachBtn)
		{
			coachBtn.setBackground(color = new Color(51,153,255));
			coachBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== changePasswordBtn)
		{
			changePasswordBtn.setBackground(color = new Color(255,69,0));
			changePasswordBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== logoutBtn)
		{
			logoutBtn.setBackground(color = new Color(246,65,65));
			logoutBtn.setForeground(Color.WHITE);
		}
		
		else{}
		
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == managerBtn)
		{
			managerBtn.setBackground(color = new Color(0,153,153));
			managerBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== playerBtn)
		{
			playerBtn.setBackground(color = new Color(0,153,153));
			playerBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== matchBtn)
		{
			matchBtn.setBackground(color = new Color(0,153,153));
			matchBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== coachBtn)
		{
			coachBtn.setBackground(color = new Color(0,153,153));
			coachBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== changePasswordBtn)
		{
			changePasswordBtn.setBackground(color = new Color(255,127,80));
			changePasswordBtn.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()== logoutBtn)
		{
			logoutBtn.setBackground(color = new Color(255,51,51));
			logoutBtn.setForeground(Color.WHITE);
		}
		
		else{}
		
	}
	
	public void mousePressed(MouseEvent me)
	{
		//passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		//passPF.setEchoChar('*');
	}
	
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(managerBtn.getText()))
		{
			if(user.getStatus()==1)
			{
				ManagerFrame mf = new ManagerFrame(user);
				mf.setVisible(true);
				this.setVisible(false);
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(coachBtn.getText()))
		{
			if(user.getStatus()==1)
			{
				CoachFrame cf = new CoachFrame(user);
				cf.setVisible(true);
				this.setVisible(false);
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		
		else if(command.equals(playerBtn.getText()))
		{
			if(user.getStatus()==1)
			{
				PlayerFrame pf = new PlayerFrame(user);
				pf.setVisible(true);
				this.setVisible(false);
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(matchBtn.getText()))
		{
			if(user.getStatus()==1)
			{
				MatchFrame mtf = new MatchFrame (user);
				mtf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else if(command.equals(changePasswordBtn.getText()))
		{
			if(user.getStatus()==1)
			{
				ChangePassword cp = new ChangePassword (user);
				cp.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		
		else{}
		
	}
	
	
	
}