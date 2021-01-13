package Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;

public class StackAndQuence {
	ArrayList<String> stackQuence = new  ArrayList<String>();
	ArrayList<String> stackQuenceDapAn = new ArrayList<String>();
	public void Play() {
		JFrame fr = new JFrame("Play Form");
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
		

		
		
		for(int j =0; j<listSubject.length;j++) {
//			for(int j1 = 0; j1<listIdSubject.length;j1++) {
				
			
				if( left  < 550 && j % 2 != 0  ) {
					
					JButton btn = new JButton(listSubject[j]);
					LayOutGame lg = new LayOutGame();
					btn.setBounds(left,right,120,40);
					panel.add(btn);
					left+= 130;
					int i = j-1;
					btn.addActionListener( new ActionListener() {
						int i1 =i;
						MySQL mySQL = new MySQL();
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(btn, listSubject[i1]);
							try {
								mySQL.SubjectQuestionMySQL(listSubject[i1]);
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								lg.LayoutGame();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
				

				}
				
				else	if ( left  >550 && j % 2 != 0  ) {
					left = 0;
					right = 150;
					JButton btn = new JButton(listSubject[j]);
					btn.setBounds(left,right,120,40);
					panel.add(btn);
					left+= 130;
					
					int i = j-1;
					btn.addActionListener( new ActionListener() {
						int i1 =i;
						MySQL mySQL = new MySQL();
						LayOutGame lg = new LayOutGame();
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(btn, listSubject[i1]);
							try {
								mySQL.SubjectQuestionMySQL(listSubject[i1]);
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							try {
								lg.LayoutGame();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});

				}
				
				
			
			

			
			System.out.println("1 "+listSubject[j]);
//		}
		}
		
		
		panel.setLayout(null);
		
		
//		
		JButton stackBtn = new JButton("Stack");
//		stackBtn.setBounds(150,100,100,40);
		
		JButton quenceBtn = new JButton("Quence");
//		quenceBtn.setBounds(350,200,100,40);
		
		
		quenceBtn.addActionListener(new ActionListener() {
			LayOutGame lg = new LayOutGame();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					lg.LayoutGame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		stackBtn.addActionListener(new ActionListener() {
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

		

		panel.add(quenceBtn);
		panel.add(stackBtn);

		panel.setBackground(new Color(0,139,139));
		
		
		
		fr.add(panel);
//		fr.setLayout(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(650,300);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);

		
	}
	
	//lay file len
	public void OutStreamQuestion() throws IOException {
		stackQuence.add("");
		
		ArrayList<String>  questionArr = new ArrayList<String>() ; 
		
		
		JFileChooser file =  new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		file.setMultiSelectionEnabled(true);
			int r = file.showOpenDialog(null);
			if (r == JFileChooser.APPROVE_OPTION) {
				File[] inFiles = file.getSelectedFiles();
				
				for(File inFile:inFiles)
				{
				FileReader fileReader = new FileReader(inFile);
				BufferedReader bufReader = new BufferedReader(fileReader);

				
				String line; 
				while((line =  bufReader.readLine())!= null) {
					
					questionArr.add(line);

				}
				
				bufReader.close();
				}
			}
			
			else
			{
				
	                System.out.println("the user cancelled the operation"); 
			}
			
			System.out.println("vo vong");
		
		

		
		stackQuence.addAll(questionArr);
//		return stackQuence ;
	}
	// lay file xuong
	public void QuestionArr() throws IOException {
		
		String [] questionArr =  new String[stackQuence.size()] ;
		for(int i = 0; i< stackQuence.size();i++) {
			questionArr[i] = stackQuence.get(i); 
		}
		
		 File outFile = new File("D:/java/GameQ&A/src/Login/StackQuence.txt");
			FileOutputStream outFileStream  = new FileOutputStream(outFile);
			PrintWriter outStream = new PrintWriter(outFileStream);
			
			
			

		      for(int i = 0; i < questionArr.length; i++) {
		    	  if(i%2 != 0) {
			    	  outStream.println(questionArr[i]);
			    	  System.out.println(questionArr[i]);
		    	  }

		       }
			
			
			outStream.close();

	
}
	// lay file len lai
	public ArrayList OutStreamQuestionGet() throws IOException {
		OutStreamQuestion();
		QuestionArr();
		File inFile = new File("D:/java/GameQ&A/src/Login/StackQuence.txt");
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
	
		
		ArrayList<String>  questionArr = new ArrayList<String>() ; 
		


		String line; 
		while((line =  bufReader.readLine())!= null) {
			
			questionArr.add(line);
			
			
		}
		bufReader.close();
		
		
		
		return questionArr;

		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////

//	public void OutStreamARR() throws IOException {
//		
//		
//		ArrayList<String>  questionArr = new ArrayList<String>() ; 
//		
//		
//		JFileChooser file =  new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//		int r =0;
//		while(r ==0 ) {
//			r = file.showOpenDialog(null);
//			if (r == JFileChooser.APPROVE_OPTION) {
//				File inFile = new File(file.getSelectedFile().getAbsolutePath());
//				FileReader fileReader = new FileReader(inFile);
//				BufferedReader bufReader = new BufferedReader(fileReader);
//
//				
//				String line; 
//				while((line =  bufReader.readLine())!= null) {
//					
//					questionArr.add(line);
//
//				}
//				
//				bufReader.close();
//				
//			}
//			
//			else
//			{
//				
//	                System.out.println("the user cancelled the operation"); 
//			}
//			
//			System.out.println("vo vong");
//		}
//		
//
//		
//		stackQuenceDapAn.addAll(questionArr);
////		return stackQuence ;
//	}
	// lay file xuong
	public void AnwserArr() throws IOException {
		
		String [] questionArr =  new String[stackQuence.size()] ;
		for(int i = 0; i< stackQuence.size();i++) {
			questionArr[i] = stackQuence.get(i); 
		}
		
		 File outFile = new File("D:/java/GameQ&A/src/Login/StackQuence DapAn.txt");
			FileOutputStream outFileStream  = new FileOutputStream(outFile);
			PrintWriter outStream = new PrintWriter(outFileStream);
			
			
			

		      for(int i = 0; i < questionArr.length; i++) {
		    	  if(i%2 == 0) {
			    	  outStream.println(questionArr[i]);
			    	  System.out.println(questionArr[i]);
		    	  }

		       }
			
			
			outStream.close();

	
}
	
	
	public ArrayList OutStreamAnwserGet() throws IOException {
//		OutStreamARR();
		AnwserArr();
		File inFile = new File("D:/java/GameQ&A/src/Login/StackQuence DapAn.txt");
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
	
		
		ArrayList<String>  questionArr = new ArrayList<String>() ; 
		


		String line; 
		while((line =  bufReader.readLine())!= null) {
			
			questionArr.add(line);
			
			
		}
		bufReader.close();
		
		
		
		return questionArr;

		
	}
	//////////////////stack question//////////////////
	
	//lay file len
		public void OutStreamQuestionStack() throws IOException {
			
			
			ArrayList<String>  questionArr = new ArrayList<String>() ; 
			
			
			JFileChooser file =  new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			file.setMultiSelectionEnabled(true);
				int r = file.showOpenDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) {
					File[] inFiles = file.getSelectedFiles();
					
					for(File inFile:inFiles)
					{
					FileReader fileReader = new FileReader(inFile);
					BufferedReader bufReader = new BufferedReader(fileReader);

					
					String line; 
					while((line =  bufReader.readLine())!= null) {
						
						questionArr.add(line);

					}
					
					bufReader.close();
					}
				}
				
				else
				{
					
		                System.out.println("the user cancelled the operation"); 
				}
				
				System.out.println("vo vong");
			
			

			
			stackQuence.addAll(questionArr);
			
//			return stackQuence ;
		}
		// lay file xuong
		public void QuestionArrStack() throws IOException {
			
			String [] questionArr =  new String[stackQuence.size()] ;
			
			for(int i = 0; i< stackQuence.size();i++) {
				questionArr[i] = stackQuence.get(i); 
			}
			
			 File outFile = new File("D:/java/GameQ&A/src/Login/StackQuence.txt");
				FileOutputStream outFileStream  = new FileOutputStream(outFile);
				PrintWriter outStream = new PrintWriter(outFileStream);
				
				
				

			      for(int i = questionArr.length -1; i >= 0; i--) {
			    	  if(i%2 == 0) {
				    	  outStream.println(questionArr[i]);
				    	  System.out.println(questionArr[i]);
			    	  }

			       }
				
				
				outStream.close();

		
	}
		// lay file len lai
		public ArrayList OutStreamQuestionGetStack() throws IOException {
			OutStreamQuestionStack();
			QuestionArrStack();
			File inFile = new File("D:/java/GameQ&A/src/Login/StackQuence.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);
		
			
			ArrayList<String>  questionArr = new ArrayList<String>() ; 
			


			String line; 
			while((line =  bufReader.readLine())!= null) {
				
				questionArr.add(line);
				
				
			}
			bufReader.close();
			
			
			
			return questionArr;

			
		}
		//////////////////////////////////////////////////////////////////
//		public void OutStreamARRStack() throws IOException {
//			
//			
//			ArrayList<String>  questionArr = new ArrayList<String>() ; 
//			
//			
//			JFileChooser file =  new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//			int r =0;
//			while(r ==0 ) {
//				r = file.showOpenDialog(null);
//				if (r == JFileChooser.APPROVE_OPTION) {
//					File inFile = new File(file.getSelectedFile().getAbsolutePath());
//					FileReader fileReader = new FileReader(inFile);
//					BufferedReader bufReader = new BufferedReader(fileReader);
//
//					
//					String line; 
//					while((line =  bufReader.readLine())!= null) {
//						
//						questionArr.add(line);
//
//					}
//					
//					bufReader.close();
//					
//				}
//				
//				else
//				{
//					
//		                System.out.println("the user cancelled the operation"); 
//				}
//				
//				System.out.println("vo vong");
//			}
//			
//
//			
//			stackQuenceDapAn.addAll(questionArr);
////			return stackQuence ;
//		}
		// lay file xuong
		public void AnwserArrStack() throws IOException {
			String [] questionArr =  new String[stackQuence.size()] ;
			for(int i = 0; i< stackQuence.size();i++) {
				questionArr[i] = stackQuence.get(i); 
			}
			
			 File outFile = new File("D:/java/GameQ&A/src/Login/StackQuence DapAn.txt");
				FileOutputStream outFileStream  = new FileOutputStream(outFile);
				PrintWriter outStream = new PrintWriter(outFileStream);
				
				outStream.println(questionArr[1]);
				

			      for(int i = questionArr.length -1; i >= 0; i--) {
			    	  if(i % 2 != 0) {
				    	  outStream.println(questionArr[i]);
				    	  System.out.println(questionArr[i]);
			    	  }

			       }
				
				
				outStream.close();

		
	}
		
		
		public ArrayList OutStreamAnwserGetStack() throws IOException {
//			OutStreamARRStack();
			AnwserArrStack();
			File inFile = new File("D:/java/GameQ&A/src/Login/StackQuence DapAn.txt");
			FileReader fileReader = new FileReader(inFile);
			BufferedReader bufReader = new BufferedReader(fileReader);
		
			
			ArrayList<String>  questionArr = new ArrayList<String>() ; 
			


			String line; 
			while((line =  bufReader.readLine())!= null) {
				
				questionArr.add(line);
				
				
			}
			bufReader.close();
			
			
			
			return questionArr;

			
		}

}
























