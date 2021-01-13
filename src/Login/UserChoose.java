package Login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UserChoose {
	ArrayList<String> stackQuence = new  ArrayList<String>();
	ArrayList<String> stackQuenceDapAn = new ArrayList<String>();
	public void UserChoose() {
		JFrame fr = new JFrame("User Choose");
		JPanel panel = new JPanel();

		int left = 0, right =100;
		
		MySQL mySQL = new MySQL();
		mySQL.SubjectMySQl();
		ArrayList<String> listSubjectJava = mySQL.SubjectMySQl();
		
		String [] listSubject = new String[listSubjectJava.size()];

		for(int i =0; i<listSubjectJava.size();i++) {
			listSubject[i] = listSubjectJava.get(i);
		}
//		panel.setLayout(new GridLayout(3, 3));
		

		
		
		
				
				
			
			

			

		
		
		panel.setLayout(null);
		
			
		JButton chooseFileBtn = new JButton("CHOOSE FILE");
		chooseFileBtn.setBounds(100,110,200,40);
		
		JButton avilableBtn = new JButton("QUESTIONS AVAILABLE");
		avilableBtn.setBounds(350,110,200,40);
		
		
		avilableBtn.addActionListener(new ActionListener() {
			LayOutGame lg = new LayOutGame();
			StackAndQuence sAndQ = new StackAndQuence();
			@Override
			public void actionPerformed(ActionEvent e) {
				sAndQ.Play();
			}
		});
		
		chooseFileBtn.addActionListener(new ActionListener() {
//			LayoutGameStack ls = new LayoutGameStack();
			ChooseStackAndQueue choose = new ChooseStackAndQueue();
			@Override
			public void actionPerformed(ActionEvent e) {
				choose.UserChoose();
			}
		});
		
		JLabel backgroundHeo=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/heoSleep.gif"));
		backgroundHeo.setBounds(80, 150, 484, 319);
		fr.add(backgroundHeo);
		
		JLabel iconCloudy1=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		iconCloudy1.setBounds(-25, -25, 150, 150);
		fr.add(iconCloudy1);
		JLabel iconCloudy2=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		iconCloudy2.setBounds(70, -25, 150, 150);
		fr.add(iconCloudy2);
		
		JLabel iconCloudy3=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		iconCloudy3.setBounds(165, -25, 150, 150);
		fr.add(iconCloudy3);
		
		JLabel iconCloudy5=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		iconCloudy5.setBounds(260, -25, 150, 150);
		fr.add(iconCloudy5);
		
		JLabel iconCloudy4=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		iconCloudy4.setBounds(355, -25, 150, 150);
		fr.add(iconCloudy4);
		
		JLabel iconCloudy6=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		iconCloudy6.setBounds(450, -25, 150, 150);
		fr.add(iconCloudy6);
		
		JLabel iconCloudy7=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		iconCloudy7.setBounds(545, -25, 150, 150);
		fr.add(iconCloudy7);
		
		JLabel iconCloudy8=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		iconCloudy8.setBounds(640, -25, 150, 150);
		fr.add(iconCloudy8);
//		
//		JLabel iconQAndA=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/Q&A.png"));
//		iconQAndA.setBounds(330, -70, 250, 250);
//		fr.add(iconQAndA);

		

		panel.add(avilableBtn);
		panel.add(chooseFileBtn);

		
		
		panel.setBackground(new Color(0,139,139));
		fr.add(panel);
//		fr.setLayout(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(650,500);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);

		
	}
}
