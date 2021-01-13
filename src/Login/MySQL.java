package Login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQL {
	ArrayList<String> questionSQL= new ArrayList<String>();
	ArrayList<String> anwserSQL= new ArrayList<String>();
	int score;
	String userNameSQL = "";
	
	public void MySQL() {
		anwserSQL.add("");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionDB","root","1234");
			Statement stml = con.createStatement();
			ResultSet rs = stml.executeQuery("select * from QUESTION_ANWSER");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " = " + rs.getString(2));
				questionSQL.add(rs.getString(1));
				anwserSQL.add(rs.getString(2));
				
			}
			con.close();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		

	}
	//Qustion Arr in xuong
public void QuestionArr() throws IOException {

		
		String [] questionArr =  new String[questionSQL.size()] ;
		for(int i = 0; i< questionSQL.size();i++) {
			questionArr[i] = questionSQL.get(i); 
		}
		
		 File outFile = new File("D:/java/GameQ&A/src/Login/StackQuence.txt");
			FileOutputStream outFileStream  = new FileOutputStream(outFile);
			PrintWriter outStream = new PrintWriter(outFileStream);

		      for(int i = 0; i < questionArr.length; i++) {
			    	  outStream.println(questionArr[i]);
			    	  System.out.println(questionArr[i]);

		       }
			
			outStream.close();

	
}
//Question arr lay len
public ArrayList OutStreamQuestionGetMySQL() throws IOException {
//	MySQL();
//	QuestionArr();
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

//Array in xuong

public void AnwserArr() throws IOException {
	
	String [] questionArr =  new String[anwserSQL.size()] ;
	for(int i = 0; i< anwserSQL.size();i++) {
		questionArr[i] = anwserSQL.get(i); 
	}
	
	 File outFile = new File("D:/java/GameQ&A/src/Login/StackQuence DapAn.txt");
		FileOutputStream outFileStream  = new FileOutputStream(outFile);
		PrintWriter outStream = new PrintWriter(outFileStream);
		
		
		

	      for(int i = 0; i < questionArr.length; i++) {
	    	  
		    	  outStream.println(questionArr[i]);
		    	  System.out.println(questionArr[i]);
	    	  

	       }
		
		
		outStream.close();


}


public ArrayList OutStreamAnwserGetMySQL() throws IOException {

//	AnwserArr();
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

//Login
	public int LoginMySQL(String nameLogin, String passWordLogin) throws FileNotFoundException {
	    String databaseUsername = "";
	    String databasePassword = "";
	    int result;
		File outFile = new File("D:/java/GameQ&A/src/Login/LoginText.txt");
		FileOutputStream outFileStream  = new FileOutputStream(outFile);
		PrintWriter outStream = new PrintWriter(outFileStream);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionDB","root","1234");
			Statement stml = con.createStatement();
			String querySQL = "SELECT *\r\n FROM LOGIN WHERE USER_NAME ='"+nameLogin+ "' && PASSWORD ='" +passWordLogin+"'";
			ResultSet rs = stml.executeQuery(querySQL);;
			while (rs.next())
				 {
					System.out.println(rs.getString(1) + " = " + rs.getString(2));
		        	databaseUsername = rs.getString(1);
		        	databasePassword = rs.getString(2);
		        	 outStream.println(databaseUsername);
		        	 outStream.close();
		        	System.out.println("user_name"+userNameSQL);
		        	result = 1;
			    	System.out.println(databaseUsername);
			    	System.out.println(databasePassword);
			    
				}
				
			con.close();
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	    if (nameLogin.equals(databaseUsername) && passWordLogin.equals(databasePassword)) {
	    	System.out.println(databaseUsername);
	    	System.out.println(databasePassword);
	        return 1;
	    } else {
	        return 0;
	    }
		
	}
	

	
	
	//SUBJECT
	public ArrayList SubjectMySQl() {
		ArrayList<String> listSubject = new ArrayList<String>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionDB","root","1234");
			Statement stml = con.createStatement();
			ResultSet rs = stml.executeQuery("SELECT * FROM SUBJECTS");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " = " + rs.getString(2));
				listSubject.add(rs.getString(1));
				listSubject.add(rs.getString(2));
//				System.out.println(listSubject.get(0));
			}
				
			con.close();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return listSubject;
	}
	
	public void SubjectQuestionMySQL(String iDSubject) throws IOException {
		anwserSQL.add("");

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionDB","root","1234");
			Statement stml = con.createStatement();
			String querySQL = "SELECT *\r\n FROM SUBJECT_QESTIONS WHERE ID_SUBJECT ='"+iDSubject+"'";
			ResultSet rs = stml.executeQuery(querySQL);
			while (rs.next()) {
				System.out.println(rs.getString(3) + " = " + rs.getString(4));
				questionSQL.add(rs.getString(3));
				anwserSQL.add(rs.getString(4));

			}
				
			con.close();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		finally {
			QuestionArr();
			AnwserArr();
		}
	}
	
	
	//get User Name
	public  String GetUserName() throws IOException {
		File inFile = new File("D:/java/GameQ&A/src/Login/LoginText.txt");
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
		
		String userName = "";
		String line; 
		while((line =  bufReader.readLine())!= null) {
			
			userName = line;
			
			
		}
		bufReader.close();
		

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionDB","root","1234");
			Statement stml = con.createStatement();
			String querySQL = "SELECT * FROM LOGIN WHERE USER_NAME='"+userName+"'" ;
			ResultSet rs = stml.executeQuery(querySQL);
			while (rs.next()) {
				userName = rs.getString(1);
			}
				
			con.close();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		finally {
			return userName;
		}
	}
	
	
	public  int  GetScore() throws IOException {
		File inFile = new File("D:/java/GameQ&A/src/Login/LoginText.txt");
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
		
		String userName = "";
		String line; 
		while((line =  bufReader.readLine())!= null) {
			
			userName = line;
			
			
		}
		bufReader.close();
		
		int score = 0;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionDB","root","1234");
			Statement stml = con.createStatement();
			String querySQL = "SELECT * FROM LOGIN  WHERE USER_NAME = '"+userName+"'";
			ResultSet rs = stml.executeQuery(querySQL);
			while (rs.next()) {
				score = rs.getInt(3);
			}
				
			con.close();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		finally {
			return score;
		}
	}
	
	//update score
	public void UpdateScore( int score  ) throws IOException {
		String userName = GetUserName();

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionDB","root","1234");
			Statement stml = con.createStatement();
			String querySQL = "UPDATE LOGIN SET SCORE ='"+score+ "' WHERE USER_NAME='" +userName+"'";
			int rs = stml.executeUpdate(querySQL);			
			System.out.println("user_Name"+userName);
			con.close();
	}
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
	}
	
	// Sign Up 
	public void SignUpSQL(String userName,String passWord) {


		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionDB","root","1234");
			Statement stml = con.createStatement();
			String querySQL = "INSERT INTO LOGIN(USER_NAME,PASSWORD) VALUES('"+userName+"','"+passWord+"');";

			int rs = stml.executeUpdate(querySQL);			
			System.out.println("user_Name"+userName);
			con.close();
	}
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	


}


















