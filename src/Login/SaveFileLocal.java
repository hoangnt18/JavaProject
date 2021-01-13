package Login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class SaveFileLocal {
	public void LoginArr() throws IOException {
		File outFile = new File("D:/java/GameQ&A/src/Login/Login.txt");
		FileOutputStream outFileStream  = new FileOutputStream(outFile);
		PrintWriter outStream = new PrintWriter(outFileStream);
		
		String [] login = {};
		
	      for(int i = 0; i < login.length; i++) {
	    	  if( i % 2 != 0) {
	    		  outStream.println(login[i]);
	    	  }
	    	  
	    	  else
	    		  outStream.print(login[i]+"\t");
	    	  
	       }
		
		
		outStream.close();

	}
	
	public ArrayList GetUserNameAndPassword() throws IOException {
		File inFile = new File("D:/java/GameQ&A/src/Login/Login.txt");
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
	
		
		ArrayList<String>  userPassArr = new ArrayList<String>() ; 
		


		String line; 
		while((line =  bufReader.readLine())!= null) {
			
			userPassArr.add(line);
			
			
		}
		bufReader.close();
		
		
		
		return userPassArr;
		

		
	}
}
