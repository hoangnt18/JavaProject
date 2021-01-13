package Login;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;



import java.lang.*;


public class Layout {
	
	public void Layout() throws IOException {
		JFrame fr = new JFrame("hello");
		JPanel panel = new JPanel();
		JPanel childTopPanel = new JPanel();
		JPanel childBottomPanel = new JPanel();
		JPanel inforPanel = new JPanel();
		
		
		Border blackline = BorderFactory.createLineBorder(Color.black) ;
		panel.setLayout(null);
		
//		//Infor's account
//		inforPanel.setLocation(0,100);
//		inforPanel.setPreferredSize(new Dimension(500, 200));
//		inforPanel.setLayout(null);
		
		JLabel backgroundUser=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/userRed.png"));
		backgroundUser.setBounds(100, 10, 256, 256);
		fr.add(backgroundUser);
		
		
		
		
//		Part of top Pannel
		childTopPanel.setLocation(0,0);
		childTopPanel.setLayout(null);
		childTopPanel.setBounds(-100, 240, 500, 500);//  to move
		
		
		
		TextField userNameTF = new TextField();
		userNameTF.setBounds(190, 27, 280, 50);
				
		JPasswordField passwordTF= new JPasswordField(20);
		passwordTF.setBounds(190, 107, 280, 50);
		
		JLabel userNameLB,passwordLB;
		

		

		
		
		JButton loginBTN = new JButton("LOGIN");
		loginBTN.setBounds(190,180,280,40);
		
		
		Button signUpBTN =  new Button("SIGN UP");
		signUpBTN.setBounds(190,250, 280, 40);
		signUpBTN.setFont(new java.awt.Font("Times New Roman", 1,20));
		signUpBTN.setForeground(Color.red);
		
		childTopPanel.add(userNameTF);
		childTopPanel.add(passwordTF);

		childTopPanel.add(loginBTN);
		childTopPanel.add(signUpBTN);
		panel.setBackground(new Color(0,139,139));
		childTopPanel.setBackground(new Color(0,139,139));
		
//		 xu ly
		SaveFileLocal s = new SaveFileLocal();
		
		ArrayList<String>  userPassArrJava= s.GetUserNameAndPassword() ;
		String [] userPassArr=  new String[userPassArrJava.size()] ;
		
		for(int i = 0; i< userPassArrJava.size();i++) {
			userPassArr[i] =userPassArrJava.get(i); 
			
		}
		
		
		

		
		
		loginBTN.addActionListener(new ActionListener() {
			String userNameLogin = "" ;
			String passwordLogin = "" ;
			MySQL mySQL = new MySQL();
			UserChoose userChoose = new UserChoose();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userNameLogin = userNameTF.getText();
				mySQL.userNameSQL = userNameTF.getText();
				passwordLogin = passwordTF.getText();
				LayOutGame lg = new LayOutGame();
				QuestionAndAnwser qsa = new QuestionAndAnwser();
				StackAndQuence sAndQ = new StackAndQuence();
//				for(int i = 0 ;i<userPassArr.length;i++) {
//					
//						String userName = userPassArr[i].split("\t")[0];
//						String password = userPassArr[i].split("\t")[1];
//						
//						if(userNameLogin.equalsIgnoreCase(userName) && passwordLogin.equalsIgnoreCase(password)) {
//							
////							try {
//////								qsa.OutStreamQuestion();
//////								qsa.AnwserArr();
////								
//////								lg.LayoutGame();
////								s
////								
////							} catch (IOException e1) {
////								// TODO Auto-generated catch block
////								e1.printStackTrace();
////							}
//							sAndQ.Play();
//						}
//						
//						else
//						{
//								JOptionPane.showMessageDialog(null, "Fail");
//
//						}
//					
//					
//					
//				}
				
				try {
					if(mySQL.LoginMySQL(userNameLogin, passwordLogin) == 1){
						userChoose.UserChoose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Fail");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		
		
		
		
		// sign up
		
		
	
		signUpBTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignUp signUp = new SignUp();
				try {
					signUp.SignUpLayout();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		//Bottom


		JLabel hrLB = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		hrLB.setFont(new java.awt.Font("Times New Roman", 1,10));
		hrLB.setBounds(0, 550, 500, 10);
		hrLB.setForeground(Color.WHITE);
		

		JLabel teacherLB = new JLabel("Giảng viên hướng đãn: Đặng Thanh Dũng");
		teacherLB.setFont(new java.awt.Font("Times New Roman", 1,20));
		teacherLB.setBounds(90, 530, 500, 100);
		teacherLB.setForeground(Color.YELLOW);
		
		JLabel groupLB = new JLabel("GROUP 7");
		groupLB.setFont(new java.awt.Font("Times New Roman", 1,18));
		groupLB.setBounds(190, 560, 200, 100);
		groupLB.setForeground(Color.YELLOW);
		
		
		JLabel member1LB = new JLabel("Nguyễn Trần Hoàng, Trần Ngọc Thuận");
		member1LB.setFont(new java.awt.Font("Times New Roman", 1,18));
		member1LB.setBounds(90, 590, 500, 100);
		member1LB.setForeground(Color.YELLOW);
		
		JLabel member2LB = new JLabel("Nguyễn Minh Pháp, Phan Hồng Phút");
		member2LB.setFont(new java.awt.Font("Times New Roman", 1,18));
		member2LB.setBounds(90, 620, 500, 100);
		member2LB.setForeground(Color.YELLOW);

		fr.add(teacherLB);
		fr.add(hrLB);
		fr.add(groupLB);
		fr.add(member1LB);
		fr.add(member2LB);

		
		
//		call to do
		
		panel.add(childTopPanel);
		panel.add(childBottomPanel);
//		panel.add(inforPanel);
		
		
		
		fr.add(panel);
//		fr.setLayout(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(500,730);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);

	}



}

