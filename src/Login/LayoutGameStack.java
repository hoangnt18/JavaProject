package Login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LayoutGameStack {
public void LayoutGame() throws IOException {
		
//		Arraylist
		


		
		
// 	
		JFrame fr = new JFrame("hello");
		JPanel panel = new JPanel();
		JPanel childTopPanel = new JPanel();
		JPanel childBottomPanel = new JPanel();
		JPanel inforPanel = new JPanel();
		
		PlayTheSound playS = new PlayTheSound();
		try {
			playS.PlayMusic("D:/java/GameQ&A/src/Login/Music/FileMusic.wav", 100);
		} catch (UnsupportedAudioFileException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (LineUnavailableException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		
		//Infor's account
		inforPanel.setLocation(350, 300);
		inforPanel.setPreferredSize(new Dimension(600, 100));
		inforPanel.setLayout(null);
		
		JLabel nameLable,scoreLable;
		nameLable =  new JLabel("Tên người tham gia:");
		scoreLable =  new JLabel("Điểm số:");
		
		nameLable.setBounds(0, 0, 200, 50);
		scoreLable.setBounds(0, 40, 200, 50);
		
		nameLable.setFont(new java.awt.Font("Times New Roman", 0,18));
		scoreLable.setFont(new java.awt.Font("Times New Roman", 0,18));
		
		JTextField nameTF,scoreTF;
		 nameTF = new JTextField("Nguyen Tran Hoang");
		 scoreTF = new JTextField("");
		
		 nameTF.setBounds(150,10,200,30);
		 scoreTF.setBounds(70,50,100,30);
		 
		 nameTF.setEditable(false);
		 scoreTF.setEditable(false);
		 
		 nameTF.setBorder(null);
		 scoreTF.setBorder(null);
		 
		 nameTF.setFont(new java.awt.Font("Times New Roman", 1,26));
		 scoreTF.setFont(new java.awt.Font("Times New Roman", 1,26));
		
		inforPanel.add(nameLable);
		inforPanel.add(scoreLable);
		inforPanel.add(nameTF);
		inforPanel.add(scoreTF);
		
		
		
		
//		Part of top Pannel
		childTopPanel.setLocation(0,0);
		childTopPanel.setBorder(blackline);
		childTopPanel.setPreferredSize(new Dimension(600, 250)); //setSize
		childTopPanel.setLayout(null); //  to move
		
		
		JLabel question = new JLabel("Câu hỏi:");
		question.setFont(new java.awt.Font("Times New Roman", 1,30));
		question.setBounds(5, -30, 200, 100);
		question.setForeground(Color.WHITE);
//		question.setOpaque(true);
		
		
		JTextArea topicQuestion = new JTextArea(580,180);
		topicQuestion.setFont(new java.awt.Font("Times New Roman", 1,30));
		topicQuestion.setBounds(5, 50, 420, 180);
		topicQuestion.setLineWrap(true); // break down
		topicQuestion.setEditable(false); //read only
		
		String questionText = "Ấn 2 và button trả lời để tiếp tục chơi !!!";
		topicQuestion.setText(questionText);
		
		childTopPanel.add(question);
		childTopPanel.add(topicQuestion);
		

//		Menu
		JMenuBar menuBar = new JMenuBar();
		JMenu questionMenu = new JMenu("Question");
		JMenu acountMenu= new JMenu("Account Manager");
		
		
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setActionCommand("New");
		
		JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setActionCommand("Open");
        
		JMenuItem layOutCode = new JMenuItem("Layout Code");
		layOutCode.setActionCommand("Layout Code");
		
		JMenuItem bothLayOut = new JMenuItem("Connect 2 Layout");
		bothLayOut.setActionCommand("Connect 2 Layout");
        
        questionMenu.add(newMenuItem);
        questionMenu.add(openMenuItem);
        questionMenu.add(layOutCode);
        questionMenu.add(bothLayOut);
		

//		JMenu editMenu = new JMenu("Open");
		
		menuBar.add(questionMenu);
		menuBar.add(acountMenu);

		
		
		layOutCode.addActionListener(new ActionListener() {
			LayOutCode ly = new LayOutCode();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ly.ChayLayout();
				
			}
		});


		
		newMenuItem.addActionListener(new ActionListener() {
			NewQuestion newLayoutQuestion = new NewQuestion();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					newLayoutQuestion.NewQuestionLayout();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		


		bothLayOut.addActionListener(new ActionListener() {
			LayOutCode ly = new LayOutCode();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ly.BothLayout();
			}
		});

		

		
		
		
		
		
//		Part of bottom Pannel
		childBottomPanel.setLocation(350, 300);
		childBottomPanel.setPreferredSize(new Dimension(600, 200));
		childBottomPanel.setLayout(null); //  to move
		
		
		TextField anwserTF = new TextField();
		anwserTF.setBounds(0, 27, 480, 50);
		
		JButton anwserBTN = new JButton("Trả lời");
		anwserBTN.setBounds(500,27,100,50);
		
		

		
		JLabel anwserLB = new JLabel("Câu trả lời sai, vui lòng nhập lại câu trả lời:");
		anwserLB.setBounds(0, 100, 480, 50);
		anwserLB.setForeground(Color.red);
		anwserLB.setVisible(false);

		childBottomPanel.add(anwserTF);
		childBottomPanel.add(anwserBTN);

		childBottomPanel.add(anwserLB);
		
		
		MySQL mySQL = new MySQL();
		nameTF.setText(mySQL.GetUserName());
		int scoreMySQL = mySQL.GetScore();
		scoreTF.setText(""+scoreMySQL);

		

		
		
		QuestionAndAnwser qsa = new QuestionAndAnwser();
		StackAndQuence sandQ = new StackAndQuence();
		
		ArrayList<String>  questionJava = sandQ.OutStreamQuestionGetStack();  /////////// doi code
//		sandQ.QuestionArr();
		String [] questionArr =  new String[questionJava.size()] ;
		

		ArrayList<String>  anwserJava = sandQ.OutStreamAnwserGetStack() ; /////////doi code
		String [] anwserARR=  new String[anwserJava.size()] ;
		
		for(int i = 0; i< questionJava.size();i++) {
			questionArr[i] = questionJava.get(i); 
		}
		
		for(int j = 0; j< anwserJava.size();j++) {
			anwserARR [j] = anwserJava.get(j); 
		}
		
		
		openMenuItem.addActionListener(new ActionListener() {
			
			LayOutGame lg = new LayOutGame();
//			ArrayList<String>  anwserJava = qsa.OutStreamAnwser() ;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					lg.LayoutGame();
					QuestionAndAnwser qsa = new QuestionAndAnwser();
					
					ArrayList<String>  questionJava = qsa.OutStreamQuestion() ;
					
					String [] questionArr =  new String[questionJava.size()] ;
					

					ArrayList<String>  anwserJava = qsa.OutStreamAnwserss() ;
					String [] anwserARR=  new String[anwserJava.size()] ;
					
					for(int i = 0; i< questionJava.size();i++) {
						questionArr[i] = questionJava.get(i); 
					}
					
					for(int j = 0; j< anwserJava.size();j++) {
						anwserARR [j] = anwserJava.get(j); 
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				

				
			}
		});
		
		
		
		
		
		
		anwserBTN.addActionListener(new ActionListener() {
			int indexQuestion = 0;
			int indexAnswer = 0;
			int score = 0;
			String userAnwser = "";
			MySQL mySQL = new MySQL();
			int scoreMySQL1 = mySQL.GetScore();
			
			PlayTheSound playSBTN = new PlayTheSound();
			PlayTheSoundGood PlayGood = new PlayTheSoundGood();
			PlayTheSoundFail playFail = new PlayTheSoundFail();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			
				
				if(indexQuestion >= questionArr.length) {

					topicQuestion.setText("Score của bạn: "+ score);
					scoreMySQL1 = scoreMySQL1 + score;
					try {
						mySQL.UpdateScore(scoreMySQL1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 scoreTF.setText(""+scoreMySQL1); 
					anwserBTN.setEnabled(false);

				}
				
				else{

					anwserLB.setVisible(false);
					topicQuestion.setText(questionArr[indexQuestion]);
					
					System.out.println(indexQuestion);
					
					userAnwser = anwserTF.getText();
				
					if(userAnwser.equalsIgnoreCase(anwserARR[indexQuestion])) {
//						playFail.StopMusic();
						score ++;
						System.out.println("score:"+score);
						 anwserTF.setText("");
						 
							indexAnswer ++;
							indexQuestion ++;
							try {
								PlayGood.PlayMusicGood("D:/java/GameQ&A/src/Login/Music/File4.wav", 1);
							} catch (UnsupportedAudioFileException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (LineUnavailableException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}


					}
					else {
						System.out.println("false");
						PlayGood.StopMusic();
						indexAnswer --;
						indexQuestion --;
						topicQuestion.setText(questionArr[indexQuestion]);

						anwserLB.setVisible(true);
						System.out.println("index sai:"+questionArr[indexQuestion]);
						try {
							playSBTN.PlayMusic("D:/java/GameQ&A/src/Login/Music/file5.wav", 1);
						} catch (UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						do {
							
							if(userAnwser.equalsIgnoreCase(anwserARR[indexQuestion])) {
							playFail.StopMusic();
								++score ;
								System.out.println("score:"+score);
								 anwserTF.setText("");
								 
							}

							indexAnswer ++;
							indexQuestion ++;
							try {
								playFail.PlayMusicFail("D:/java/GameQ&A/src/Login/Music/File4wav", 1);
							} catch (UnsupportedAudioFileException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (LineUnavailableException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}


							
							
						}while(userAnwser.equalsIgnoreCase(anwserARR[indexQuestion]));


					}


			}
			}
		});
		
		
		
		//update 
		panel.setBackground(new Color(0,139,139));
		inforPanel.setBackground(new Color(0,139,139));
		
		childTopPanel.setBackground(new Color(0,139,139));
		childBottomPanel.setBackground(new Color(0,139,139));

		nameTF.setBackground(new Color(0,139,139));
		scoreTF.setBackground(new Color(0,139,139));
		topicQuestion.setBackground(new Color(0,139,139));
		
		scoreTF.setForeground(Color.WHITE);
		nameLable.setForeground(Color.WHITE);
		nameTF.setForeground(Color.WHITE);
		scoreLable.setForeground(Color.WHITE);
		topicQuestion.setForeground(Color.WHITE);
		
		//cau vong left
		JLabel backgroundl1=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		JLabel backgroundl2=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		JLabel backgroundl3=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		JLabel backgroundl4=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		JLabel backgroundl5=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		JLabel backgroundl6=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		JLabel backgroundl7=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		JLabel backgroundl8=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		JLabel backgroundl9=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		JLabel backgroundl10=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVong.gif"));
		
		backgroundl1.setBounds(0, 0, 40, 87);
		backgroundl10.setBounds(0, 87, 40, 87);
		backgroundl2.setBounds(0, 174, 40, 87);
		backgroundl3.setBounds(0, 261, 40, 87);
		backgroundl4.setBounds(0, 348, 40, 87);
		backgroundl5.setBounds(0, 435, 40, 87);
		backgroundl6.setBounds(0, 522, 40, 87);
		backgroundl7.setBounds(0, 609, 40, 87);
		backgroundl8.setBounds(0, 696, 40, 87);
		backgroundl9.setBounds(0, 783, 40, 87);

		fr.add(backgroundl1);
		fr.add(backgroundl2);
		fr.add(backgroundl3);
		fr.add(backgroundl4);
		fr.add(backgroundl5);
		fr.add(backgroundl6);
		fr.add(backgroundl7);
		fr.add(backgroundl8);
		fr.add(backgroundl9);
		fr.add(backgroundl10);

		//cau vong up 
		JLabel backgroundUp1=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVongUp.gif"));
		JLabel backgroundUp2=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVongUp.gif"));
		JLabel backgroundUp3=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVongUp.gif"));
		JLabel backgroundUp4=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVongUp.gif"));
		JLabel backgroundUp5=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVongUp.gif"));
		JLabel backgroundUp6=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVongUp.gif"));
		JLabel backgroundUp7=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVongUp.gif"));
		JLabel backgroundUp8=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVongUp.gif"));
		JLabel backgroundUp9=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cauVongUp.gif"));


		
		backgroundUp1.setBounds(40, 550, 87, 39);
		backgroundUp2.setBounds(127, 550, 87, 39);
		backgroundUp3.setBounds(214, 550, 87, 39);
		backgroundUp4.setBounds(301, 550, 87, 39);
		backgroundUp5.setBounds(388, 550, 87, 39);
		backgroundUp6.setBounds(475, 550, 87, 39);
		backgroundUp7.setBounds(562, 550, 87, 39);
		backgroundUp8.setBounds(649, 550, 87, 39);
		backgroundUp9.setBounds(736, 550, 87, 39);

		
		fr.add(backgroundUp1);
		fr.add(backgroundUp2);
		fr.add(backgroundUp3);
		fr.add(backgroundUp4);
		fr.add(backgroundUp5);
		fr.add(backgroundUp6);
		fr.add(backgroundUp7);
		fr.add(backgroundUp8);
		fr.add(backgroundUp9);

		
		//hoa van
//		JLabel backgroundHeo=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/heoSleep.gif"));
//		backgroundHeo.setBounds(350, -40, 484, 319);
//		fr.add(backgroundHeo);
		
		//sun
		JLabel backgroundSun=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/Sun.png"));
		backgroundSun.setBounds(314, -70, 484, 319);
		fr.add(backgroundSun);

		//couldy
		
		JLabel backgroundCloudy1=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		JLabel backgroundCloudy2=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		JLabel backgroundCloudy3=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		JLabel backgroundCloudy4=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		JLabel backgroundCloudy5=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		JLabel backgroundCloudy6=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		JLabel backgroundCloudy7=new JLabel(new ImageIcon("D:/java/GameQ&A/src/Login/Image/cloudy.png"));
		backgroundCloudy1.setBounds(40, 450, 100, 100);
		backgroundCloudy2.setBounds(140, 450, 100, 100);
		backgroundCloudy3.setBounds(240, 450, 100, 100);
		backgroundCloudy4.setBounds(340, 450, 100, 100);
		backgroundCloudy5.setBounds(440, 450, 100, 100);
		backgroundCloudy6.setBounds(540, 450, 100, 100);
		backgroundCloudy7.setBounds(640, 450, 100, 100);

		fr.add(backgroundCloudy1);
		fr.add(backgroundCloudy2);
		fr.add(backgroundCloudy3);
		fr.add(backgroundCloudy4);
		fr.add(backgroundCloudy5);
		fr.add(backgroundCloudy6);
		fr.add(backgroundCloudy7);
		
	

		
		panel.add(inforPanel);
		panel.add(childTopPanel);
		panel.add(childBottomPanel);
		
		fr.add(menuBar);
		fr.add(panel);
		fr.setJMenuBar(menuBar);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(700,650);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);
		
	}




}
