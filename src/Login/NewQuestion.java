package Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
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

public class NewQuestion {
	public void NewQuestionLayout() throws IOException {
		JFrame fr = new JFrame("Add Question");
		JPanel panel = new JPanel();
		JPanel childTopPanel = new JPanel();
		JPanel childBottomPanel = new JPanel();
		JPanel inforPanel = new JPanel();
		
		
		Border blackline = BorderFactory.createLineBorder(Color.black) ;
		panel.setLayout(null);
		
		//Infor's account

		
		
		
		
//		Part of top Pannel
		childTopPanel.setLocation(0,0);
		childTopPanel.setBorder(blackline);
		childTopPanel.setPreferredSize(new Dimension(600, 250)); //setSize
		childTopPanel.setLayout(null);
		
		
		
		TextField addQuestionTF = new TextField();
		addQuestionTF .setBounds(40, 40, 500, 100);
				
		
		JButton addQuestionBTN = new JButton("Sub quesiton");
		addQuestionBTN.setBounds(300,160,200,40);
		
//		JButton addAnwserBTN = new JButton("Sub answer");
//		addAnwserBTN.setBounds(0,160,200,40);
		
		
		addQuestionBTN.addActionListener(new ActionListener() {
			String useraddQuestion = "" ;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				useraddQuestion = addQuestionTF.getText();
				QuestionAndAnwser qsa = new QuestionAndAnwser();
				
				
				
				try {
					ArrayList<String>  questionJava = qsa.OutStreamQuestionGet() ;
					questionJava.add(useraddQuestion);
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					addQuestionTF.setText("");
					String [] questionArr =  new String[questionJava.size()] ;
					
					for(int i = 0; i< questionJava.size();i++) {
						questionArr[i] = questionJava.get(i); 
					}
					
					 File outFile = new File("D:/java/GameQ&A/src/Login/addNewQuestion.txt");
						FileOutputStream outFileStream  = new FileOutputStream(outFile);
						PrintWriter outStream = new PrintWriter(outFileStream);
						
						
						

					      for(int i = 0; i < questionArr.length; i++) {
					    	  outStream.println(questionArr[i]);
					    	  
					       }
						
						
						outStream.close();

					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
//		addAnwserBTN.addActionListener(new ActionListener() {
//			String useraddAnwser = "" ;
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				useraddAnwser = addQuestionTF.getText();
//				QuestionAndAnwser qsa = new QuestionAndAnwser();
//				
//				try {
//					ArrayList<String>  anwserArrJava = qsa.OutStreamAnwserGET() ;
//					anwserArrJava.add(useraddAnwser);
//					
//					String [] anwserArr=  new String[anwserArrJava.size()] ;
//					
//					for(int i = 0; i< anwserArrJava.size();i++) {
//						anwserArr[i] = anwserArrJava.get(i); 
//					}
//					
//					 File outFile = new File("D:/java/GameQ&A/src/Game/addNewAnwser.txt");
//						FileOutputStream outFileStream  = new FileOutputStream(outFile);
//						PrintWriter outStream = new PrintWriter(outFileStream);
//						
//						
//						
//
//					      for(int i = 0; i < anwserArr.length; i++) {
//					    	  outStream.println(anwserArr[i]);
//					    	  
//					       }
//						
//						
//						outStream.close();
//
//					
//					
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
		
	
		

		
		childTopPanel.add(addQuestionTF );


		childTopPanel.add(addQuestionBTN);

//		childTopPanel.add(addAnwserBTN);

		
//		panel.add(childTopPanel);

		
		
		
		fr.add(childTopPanel);

		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(600,300);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);

	}

}
