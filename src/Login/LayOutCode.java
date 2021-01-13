package Login;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class LayOutCode {
public static boolean RIGHT_TO_LEFT = false;
    
    public static void addComponentsToPane(Container pane) {
        
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }
        
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        JButton button = new JButton("Button 1 (PAGE_START)");
        pane.add(button, BorderLayout.PAGE_START);
        
        //Make the center component big, since that's the
        //typical usage of BorderLayout.
        button = new JButton("Button 2 (CENTER)");
        button.setPreferredSize(new Dimension(200, 100));
        pane.add(button, BorderLayout.CENTER);
        
        button = new JButton("Button 3 (LINE_START)");
        pane.add(button, BorderLayout.LINE_START);
        
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, BorderLayout.PAGE_END);
        
        button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        
        //Create and set up the window.
        JFrame frame = new JFrame("BorderLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        //Use the content pane's default BorderLayout. No need for
        //setLayout(new BorderLayout());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void ChayLayout() {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                
            }
        });
    }
    
    public void GridLayOut() {
    	JFrame frame;
        frame = new JFrame();
        
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
 
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
 
        // thiet lap 3 hang va 3 cot cho grid layout
        frame.setLayout(new GridLayout(3, 3));
 
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setTitle("GRID LAYOUT");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void BothLayout() {
    	JFrame frame;
        frame = new JFrame();
        
        JPanel panel = new JPanel();
		JPanel childTopPanel = new JPanel();
		JPanel childBottomPanel = new JPanel();
		
		
//		panel.setLocation(10,10);
//		panel.setPreferredSize(new Dimension(100, 100));
//		panel.setLayout(null);
		
		//top panel
		childTopPanel.setLocation(0,0);
		childTopPanel.setPreferredSize(new Dimension(600, 300));
		childTopPanel.setLayout(null);
		

		
		
	    JButton bt1=new JButton("1");  
	    JButton bt2=new JButton("2");  
	    JButton bt3=new JButton("3");  
	    JButton bt4=new JButton("4");  
	    JButton bt5=new JButton("5");  
	              
	    childTopPanel.add(bt1);
	    childTopPanel.add(bt2);
	    childTopPanel.add(bt3);
	    childTopPanel.add(bt4);
	    childTopPanel.add(bt5);  
	      
	    childTopPanel.setLayout(new FlowLayout());  
   
   
        
		
		
		
		//bottom panel
		
		childBottomPanel.setLocation(0,301);
		childBottomPanel.setPreferredSize(new Dimension(500, 100));
		childBottomPanel.setLayout(null);
		
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
 
        childBottomPanel.add(b1);
        childBottomPanel.add(b2);
        childBottomPanel.add(b3);
        childBottomPanel.add(b4);
        childBottomPanel.add(b5);
        childBottomPanel.add(b6);
        childBottomPanel.add(b7);
        childBottomPanel.add(b8);
        childBottomPanel.add(b9);
 
        // thiet lap 3 hang va 3 cot cho grid layout
        childBottomPanel.setLayout(new GridLayout(3, 3));
		
		
		
		
		
        
		//
		panel.add(childTopPanel);
		panel.add(childBottomPanel);
		
		frame.add(panel);
		frame.setSize(605,605);
		
        frame.setTitle("Ví dụ GridLayout trong Java Swing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}










