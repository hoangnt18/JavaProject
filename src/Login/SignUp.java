package Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.ButtonGroup;



public class SignUp {
	




	public void SignUp(String userName, String password) throws IOException {
		File outFile = new File("D:/java/GameQ&A/src/Login/Login.txt");
		FileOutputStream outFileStream  = new FileOutputStream(outFile);
		PrintWriter outStream = new PrintWriter(outFileStream);
		
		SaveFileLocal s = new SaveFileLocal();
		
		ArrayList<String>  userPassArrJava= s.GetUserNameAndPassword() ;
		
		userPassArrJava.add(userName);
		userPassArrJava.add(password);
		
		String [] userPassNew =  new String[userPassArrJava.size()] ;
		
		for(int i = 0; i< userPassArrJava.size();i++) {
			userPassNew[i] = userPassArrJava.get(i); 
		}
		
		
		

		
	      for(int i = 0; i < userPassNew.length; i++) {
	    	  if( i % 2 != 0) {
	    		  outStream.println(userPassNew[i]);
	    	  }
	    	  
	    	  else
	    		  outStream.print(userPassNew[i]+"\t");
	    	  
	       }
		
		
		outStream.close();

	}
	
	

	
	
	//SIGN UP
	public void SignUpLayout() throws IOException {
		JFrame fr = new JFrame("hello");
		JPanel panel = new JPanel();
		JPanel childTopPanel = new JPanel();
		JPanel childBottomPanel = new JPanel();
		JPanel inforPanel = new JPanel();
		
		
		Border blackline = BorderFactory.createLineBorder(Color.black) ;
		panel.setLayout(null);
		
		//Infor's account

		
		
		
		
//		Part of top Pannel
		childTopPanel.setLocation(0,0);
		

		childTopPanel.setLayout(null);
		childTopPanel.setBounds(40, 30, 500, 200);//  to move
		
		
		
		TextField userNameTF = new TextField();
		userNameTF.setBounds(190, 27, 280, 50);
				
		JPasswordField passwordTF= new JPasswordField(20);
		passwordTF.setBounds(190, 107, 280, 50);
		
		JLabel userNameLB,passwordLB;
		
		userNameLB =  new JLabel("USER_NAME:");
		userNameLB.setBounds(10,27, 150, 20);
		userNameLB.setFont(new java.awt.Font("Times New Roman", 1,20));
		
		passwordLB =  new JLabel("PASSWORD:");
		passwordLB.setBounds(10,107, 150, 20);
		passwordLB.setFont(new java.awt.Font("Times New Roman", 1,20));
		
		
//		JButton loginBTN = new JButton("LOGIN");
//		loginBTN.setBounds(370,160,100,40);
		
		
		Button signUpBTN =  new Button("SIGN UP");
		signUpBTN .setBounds(370,160, 100, 40);
		signUpBTN .setFont(new java.awt.Font("Times New Roman", 1,20));
		signUpBTN .setForeground(Color.red);
		
		childTopPanel.add(userNameTF);
		childTopPanel.add(passwordTF);
		childTopPanel.add(userNameLB);
		childTopPanel.add(passwordLB);
//		childTopPanel.add(loginBTN);
		childTopPanel.add(signUpBTN);
		
		
//		 xu ly
		signUpBTN.addActionListener(new ActionListener() {
			
			String userNameSignUp = "" ;
			String passwordSignUp = "" ;
			MySQL mySQL = new MySQL();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userNameSignUp  = userNameTF.getText();
				passwordSignUp = passwordTF.getText();
				
				try {
					mySQL.SignUpSQL(userNameSignUp,passwordSignUp);
					Object[] options = {"Yes, please", "No way!"};
                    int n = JOptionPane.showOptionDialog(panel,
                                    "Do you want to Login to play game",
                                    "Sign up successfull",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                    if (n == JOptionPane.YES_OPTION) {
                        Layout ly = new Layout();
                        ly.Layout();
                    } else if (n == JOptionPane.NO_OPTION) {
                        setLabel("Do you want to exit program");
                    } else {
                        setLabel("Come on!");
                    }
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				
			}

			private void setLabel(String string) {
				// TODO Auto-generated method stub
				
			}
		});
		


//		call to do
		
		panel.add(childTopPanel);
		
		
		
		
		fr.add(panel);
//		fr.setLayout(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(600,300);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);

	}

}
