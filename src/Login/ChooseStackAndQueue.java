package Login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChooseStackAndQueue {

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
//			panel.setLayout(new GridLayout(3, 3));
			

			

			
			
			panel.setLayout(null);
			
				
			JButton queue = new JButton("PLAY IN ORDER");
			queue.setBounds(100,100,200,40);
			
			JButton stack = new JButton("PLAY FROM BELOW");
			stack.setBounds(350,100,200,40);
			
			
			queue.addActionListener(new ActionListener() {
				LayoutGameQueue lg = new LayoutGameQueue();
//				StackAndQuence sAndQ = new StackAndQuence();
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						lg.LayoutGameQueue();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			stack.addActionListener(new ActionListener() {
				LayoutGameStack ls = new LayoutGameStack();
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						ls.LayoutGame();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			

			panel.add(queue);
			panel.add(stack);

			
			
			panel.setBackground(new Color(0,139,139));
			fr.add(panel);
//			fr.setLayout(null);
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr.setSize(650,300);
			fr.setVisible(true);
			fr.setLocationRelativeTo(null);

			
		}
	}

