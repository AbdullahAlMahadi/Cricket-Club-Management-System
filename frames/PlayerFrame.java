package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class PlayerFrame extends JFrame implements ActionListener
{
	private JLabel PlayerId, PlayerName, PlayerEmail, PlayerSalary,PlayerPhone,PlayerType;
	private JTextField PlayerIdTF, PlayerNameTF, PlayerEmailTF, PlayerSalaryTF,PlayerPhoneTF,PlayerTypeTF;
	JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, logoutBtn, backBtn;
	private JPanel panel;
	private JTable PlayerTable;
	private JScrollPane PlayerTableSP;
	private Color color ;
	private User user;
	private PlayerRepo pr;
	private UserRepo ur;
	
	
	public PlayerFrame(User user)
	{
		super("Player Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		pr= new PlayerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		color = new Color(255,248,220);
		panel.setBackground(color);
		
		String data[][] = {{"", "", "", "","",""}};
		
		String head[] = {"Id", "Name", "Email","Salary","Phone","playerType"};
		
		PlayerTable = new JTable(data,head);
		PlayerTableSP = new JScrollPane(PlayerTable);
		PlayerTableSP.setBounds(10, 10, 780, 150);
		PlayerTable.setEnabled(false);
		panel.add(PlayerTableSP);
		
		PlayerId = new JLabel("ID :");
		PlayerId.setBounds(10,200,100,30);
		panel.add(PlayerId);
		
		PlayerIdTF = new JTextField();
		PlayerIdTF.setBounds(70,200,100,30);
		panel.add(PlayerIdTF);
		
		PlayerName = new JLabel("Name :");
		PlayerName.setBounds(10,250,100,30);
		panel.add(PlayerName);
		
		PlayerNameTF = new JTextField();
		PlayerNameTF.setBounds(70,250,100,30);
		panel.add(PlayerNameTF);
		
		
		
		PlayerSalary = new JLabel("Salary: ");
		PlayerSalary.setBounds(10,300,100,30);
		panel.add(PlayerSalary);
		
		PlayerSalaryTF = new JTextField();
		PlayerSalaryTF.setBounds(70,300,100,30);
		panel.add(PlayerSalaryTF);
		
		PlayerEmail = new JLabel("Email: ");
		PlayerEmail.setBounds(10,350,100,30);
		panel.add(PlayerEmail);
		
		PlayerEmailTF = new JTextField();
		PlayerEmailTF.setBounds(70,350,100,30);
		panel.add(PlayerEmailTF);
		
		
		PlayerPhone = new JLabel("Phone: ");
		PlayerPhone.setBounds(200,200,100,30);
		panel.add(PlayerPhone);
		
		PlayerPhoneTF = new JTextField();
		PlayerPhoneTF.setBounds(275,200,100,30);
		panel.add(PlayerPhoneTF);
		
		PlayerType = new JLabel("Player Type: ");
		PlayerType.setBounds(200,250,100,30);
		panel.add(PlayerType);
		
		PlayerTypeTF = new JTextField();
		PlayerTypeTF.setBounds(275,250,100,30);
		panel.add(PlayerTypeTF);
		
		
		
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
		getAllBtn.setBounds(700,170,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(700, 370, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(580, 370, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!PlayerIdTF.getText().equals("") || !PlayerIdTF.getText().equals(null))
			{
				Player p = pr.searchPlayer(PlayerIdTF.getText());
				if(p!= null)
				{
					PlayerNameTF.setText(p.getPlayerName());
					PlayerEmailTF.setText(p.getEmail());
					PlayerPhoneTF.setText(p.getPhone()+"");
					PlayerSalaryTF.setText(p.getSalary()+"");
					PlayerTypeTF.setText(p.getPlayerType());
					
					
					PlayerIdTF.setEnabled(false);
					PlayerNameTF.setEnabled(true);
					PlayerEmailTF.setEnabled(true);
					PlayerSalaryTF.setEnabled(true);
					PlayerPhoneTF.setEnabled(true);
					PlayerTypeTF.setEnabled(true);
					
					
					
					
					if(this.user.getStatus()==2)
					{
						updateBtn.setEnabled(false);
						deleteBtn.setEnabled(false);
						refreshBtn.setEnabled(true);
						insertBtn.setEnabled(false);
						loadBtn.setEnabled(false);

					}
					else
					{
						loadBtn.setEnabled(false);
						insertBtn.setEnabled(false);
						updateBtn.setEnabled(true);
						deleteBtn.setEnabled(true);
						refreshBtn.setEnabled(true);
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
			Player p = new Player();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			p.setPlayerId(PlayerIdTF.getText());
			p.setPlayerName(PlayerNameTF.getText());
			p.setEmail(PlayerEmailTF.getText());
			p.setPhone(Integer.parseInt(PlayerPhoneTF.getText()));
			p.setSalary(Double.parseDouble(PlayerSalaryTF.getText()));
			p.setPlayerType(PlayerTypeTF.getText());
			
			
			u.setUserId(PlayerIdTF.getText());
			u.setPassword(x+"");
			u.setStatus(2);
			
	
			
			pr.insertInDB(p);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+PlayerIdTF.getText()+"and Password: "+x);
			
			PlayerIdTF.setText("");
			PlayerNameTF.setText("");
			PlayerEmailTF.setText("");
			PlayerPhoneTF.setText("");
			PlayerSalaryTF.setText("");
			PlayerTypeTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			PlayerIdTF.setText("");
			PlayerNameTF.setText("");
			PlayerEmailTF.setText("");
			PlayerPhoneTF.setText("");
			PlayerSalaryTF.setText("");
			PlayerTypeTF.setText("");
			
		
			
			PlayerIdTF.setEnabled(true);
			if(this.user.getStatus()==3)
			{
				updateBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				refreshBtn.setEnabled(false);
				insertBtn.setEnabled(false);
				loadBtn.setEnabled(true);

			}
			
		}
		else if(command.equals(updateBtn.getText()))
		{
			Player p = new Player();
			
			p.setPlayerId(PlayerIdTF.getText());
			p.setPlayerName(PlayerNameTF.getText());
			p.setEmail(PlayerEmailTF.getText());
			p.setPhone(Integer.parseInt(PlayerPhoneTF.getText()));
			p.setSalary(Double.parseDouble(PlayerSalaryTF.getText()));
			p.setPlayerType(PlayerTypeTF.getText());
			
			pr.updateInDB(p);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			PlayerIdTF.setText("");
			PlayerNameTF.setText("");
			PlayerEmailTF.setText("");
			PlayerPhoneTF.setText("");
			PlayerSalaryTF.setText("");
			PlayerTypeTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			PlayerIdTF.setEnabled(true);
			PlayerNameTF.setEnabled(true);
			PlayerEmailTF.setEnabled(true);
			PlayerPhoneTF.setEnabled(true);
			PlayerSalaryTF.setEnabled(true);
			PlayerTypeTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			pr.deleteFromDB(PlayerIdTF.getText());
			ur.deleteUser(PlayerIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			PlayerIdTF.setText("");
			PlayerNameTF.setText("");
			PlayerEmailTF.setText("");
			PlayerPhoneTF.setText("");
			PlayerSalaryTF.setText("");
			PlayerTypeTF.setText("");
			
			PlayerIdTF.setEnabled(true);
			PlayerNameTF.setEnabled(true);
			PlayerEmailTF.setEnabled(true);
			PlayerPhoneTF.setEnabled(true);
			PlayerSalaryTF.setEnabled(true);
			PlayerTypeTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pr.getAllPlayer();
			String head[] = {"Id", "Name", "Email","Phone", "Salary","PlayerType"};
			
			panel.remove(PlayerTableSP);
			
			PlayerTable = new JTable(data,head);
			PlayerTable.setEnabled(false);
			PlayerTableSP = new JScrollPane(PlayerTable);
			PlayerTableSP.setBounds(10, 10, 780, 150);
			panel.add(PlayerTableSP);
			
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