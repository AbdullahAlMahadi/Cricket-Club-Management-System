package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.awt.*;

import repository.*;
import entity.*;

public class ChangePassword extends JFrame implements ActionListener
{
	private JLabel oldPassLabel, newPassLabel, newConLabel;
	private JTextField oldPassTF, newPassTF,confirmTF;
	private JButton confirmBtn, backBtn, logoutBtn;
	private Color color ;
	private JPanel panel;
	//String userId;
	//String status;
    //int access=0;
	
	
	private User user;
	private UserRepo ur;
	
	public ChangePassword(User user)
	{
		super("Change Password");
		
	
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		

	   color = new Color(216,191,216);
	   panel.setBackground(color);
		
		oldPassLabel=new JLabel("Enter old password:");
		oldPassLabel.setBounds(50,50,700,40);
		panel.add(oldPassLabel);
		
		oldPassTF=new JTextField("");
		oldPassTF.setBounds(200,50,200,40);
		panel.add(oldPassTF);
		
		newPassLabel=new JLabel("Enter new password:");
		newPassLabel.setBounds(50,100,700,40);
		panel.add(newPassLabel);
		
		newPassTF=new JTextField("");
		newPassTF.setBounds(200,100,200,40);
		panel.add(newPassTF);
		
		
		newConLabel=new JLabel("Confirm new password:");
		newConLabel.setBounds(50,150,700,40);
		panel.add(newConLabel);
		
		
		confirmTF=new JTextField("");
		confirmTF.setBounds(200,150,200,40);
		panel.add(confirmTF);
		
		confirmBtn=new JButton("Confirm");
		confirmBtn.setBounds(200,200,200,40);
		confirmBtn.addActionListener(this);
		confirmBtn.setBackground(Color.ORANGE);
		panel.add(confirmBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(320, 250, 80, 40);
		logoutBtn.addActionListener(this);
		logoutBtn.setBackground(Color.RED);
		logoutBtn.setForeground(Color.WHITE);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(200,250,80,40);
		backBtn.addActionListener(this);
		backBtn.setBackground(Color.GREEN);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(confirmBtn.getText()))
		{
			User u = ur.getUser(user.getUserId(),user.getPassword());

			if((oldPassTF.getText()).equals(user.getPassword())&& (newPassTF.getText()).equals(confirmTF.getText()))
			{
				u.setUserId(user.getUserId());
				u.setPassword(newPassTF.getText());
				u.setStatus(user.getStatus());
				
				ur.updateUser(u);
				JOptionPane.showMessageDialog(this, "Password Changed");
			
				oldPassTF.setText("");
				newPassTF.setText("");
				confirmTF.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Changing Denied");
			}
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
			else if (user.getStatus()==2)
			{
				PlayerHome ph = new PlayerHome(user);
				ph.setVisible(true);
				this.setVisible(false);
			}
			
		}
		
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
	}
	
	
	
	
	
}