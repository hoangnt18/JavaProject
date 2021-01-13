package Login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class QuestionAndAnwser {
	ArrayList<String>  questionArr = new ArrayList<String>() ;
	
	
	public void QuestionArr() throws IOException {
		
		
		
			 File outFile = new File("D:/java/GameQ&A/src/Login/QuestionAndAnwserARR.txt");
				FileOutputStream outFileStream  = new FileOutputStream(outFile);
				PrintWriter outStream = new PrintWriter(outFileStream);
				
				String [] question = {"1+1", "1+2","1+3","Number of questions has run out. \\ n Press the answer button to view your score"};
				

			      for(int i = 0; i < question.length; i++) {
			    	  outStream.println(question[i]);
			    	  
			       }
				
				
				outStream.close();

		
	}
	
	public void AnwserArr() throws IOException {
		
		
		
			File outFile = new File("D:/java/GameQ&A/src/Login/AnwserArr.txt");
			FileOutputStream outFileStream  = new FileOutputStream(outFile);
			PrintWriter outStream = new PrintWriter(outFileStream);
			
			String [] anwser = {"","2", "3", "4"};
			

		      for(int i = 0; i < anwser.length; i++) {
		    	  outStream.println(anwser[i]);
		    	  
		       }
		      outStream.close();

		

	}
	
	public void Play(File f) throws IOException {
		FileReader fileReader = new FileReader(f);
		BufferedReader bufReader = new BufferedReader(fileReader);

		
		String line; 
		while((line =  bufReader.readLine())!= null) {
			
			questionArr.add(line);
			
			
		}
		bufReader.close();
	}
	
	public ArrayList OutStreamQuestion() throws IOException {
		 
		JFileChooser file =  new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int r = file.showOpenDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			File inFile = new File(file.getSelectedFile().getAbsolutePath());
			Play(inFile);
			
		}
		
		else
		{
			
                System.out.println("the user cancelled the operation"); 
		}
		
		System.out.println("vo vong");
		
		
		return questionArr;

		
	}
	
	public ArrayList OutStreamQuestionGet() throws IOException {
		File inFile = new File("D:/java/GameQ&A/src/Login/addNewQuestion.txt");
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
	
	public ArrayList OutStreamAnwser() throws IOException {
		File inFile = new File("D:/java/GameQ&A/src/Login/AnwserArr.txt");
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
	
		
		ArrayList<String>  anwserArr = new ArrayList<String>() ; 
		


		String line; 
		while((line =  bufReader.readLine())!= null) {
			
			anwserArr.add(line);
			
			
		}
		bufReader.close();
		
		
		
		return anwserArr;
		

		
	}
	
	public ArrayList OutStreamAnwserss() throws IOException {
		File inFile = new File("D:/java/GameQ&A/src/Login/addNewAnwser.txt");
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
	
		
		ArrayList<String>  anwserArr = new ArrayList<String>() ; 
		


		String line; 
		while((line =  bufReader.readLine())!= null) {
			
			anwserArr.add(line);
			
			
		}
		bufReader.close();
		
		
		
		return anwserArr;
		

		
	}
	
	
	public ArrayList OutStreamAnwserGET() throws IOException {
		File inFile = new File("D:/java/GameQ&A/src/Login/addNewAnwser.txt");
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);
	
		
		ArrayList<String>  anwserArr = new ArrayList<String>() ; 
		


		String line; 
		while((line =  bufReader.readLine())!= null) {
			
			anwserArr.add(line);
			
			
		}
		bufReader.close();
		
		
		
		return anwserArr;
		

		
	}

	
	
	
	

}
