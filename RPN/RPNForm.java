
package RPN ;

import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.EmptyStackException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class RPNForm extends JFrame implements ActionListener{
  
  private Container contentPane;
  private JPanel displayPanel;
  private JLabel RPNLabel;
  public static JTextField displayTextField;
  private JPanel buttonPanel;
  private String inString = "";
  
  private JButton[][] buttonGrid;
  public static RPNCalculator calc;
  public static Register reg; 
  double firstnum;
  double secondnum;
  double result;
  String operations;
  String answer;
  static int q = 0;
  int i=0;
  boolean help = false;
  File stackFile = new File("Stack.txt");
  FileInputStream in = null;
  //OutputStream out = null;
  int fl = 0;
  
  public static void main(String[] args) {
    RPNForm gui = new RPNForm();
    gui.setVisible(true);
  }
	
  
  
  
  public RPNForm() {
    this.calc = new RPNCalculator();
   
   
   
    setSize(660, 330);
    setDefaultCloseOperation(3);
    setTitle("  RPN Calculator");
    this.contentPane = getContentPane();
    this.contentPane.setLayout(new BorderLayout());
    
    this.displayPanel = new JPanel();
    this.displayPanel.setLayout(new BoxLayout(this.displayPanel, 0));
    this.displayPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(204, 153, 255)));
    
    this.RPNLabel = new JLabel(" RPN ");
    this.RPNLabel.setBackground(new Color(51, 0, 102));
    this.RPNLabel.setFont(new Font("Courier New", 1, 36));
    this.RPNLabel.setForeground(new Color(102, 51, 102));
    this.displayPanel.add(this.RPNLabel);
    
    this.displayTextField = new JTextField("");
    this.displayTextField.setFont(new Font("Courier New", 1, 24));
    this.displayTextField.setHorizontalAlignment(4);
    this.displayTextField.setActionCommand("Enter");
    this.displayTextField.addActionListener(this);
    this.displayPanel.add(this.displayTextField);
    this.contentPane.add(this.displayPanel, "North");
    
    this.buttonPanel = new JPanel();
    this.buttonPanel.setBackground(new Color(255, 239, 223));
    this.buttonPanel.setLayout(new GridLayout(4, 8));
    this.buttonPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(153, 255, 255)));
    
    this.buttonGrid = new JButton[4][8];
    
    for (int i = 0; i < 4; i++) {
      
      for (int j = 0; j < 8; j++) {
        
        this.buttonGrid[i][j] = new JButton();
        this.buttonGrid[i][j].setFont(new Font("Courier New", 1, 16));
        this.buttonGrid[i][j].addActionListener(this);
        this.buttonGrid[i][j].setBorder(BorderFactory.createBevelBorder(1));
        this.buttonPanel.add(this.buttonGrid[i][j]);
      } 
    } 
    this.buttonGrid[0][0].setText("eXit");
    this.buttonGrid[0][1].setText("C");
    this.buttonGrid[0][2].setText("CE");
    this.buttonGrid[0][3].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[0][3].setBackground(new Color(240, 246, 255));
    this.buttonGrid[0][3].setForeground(new Color(153, 0, 102));
    this.buttonGrid[0][3].setText("7");
    this.buttonGrid[0][4].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[0][4].setBackground(new Color(240, 246, 255));
    this.buttonGrid[0][4].setForeground(new Color(153, 0, 102));
    this.buttonGrid[0][4].setText("8");
    this.buttonGrid[0][5].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[0][5].setBackground(new Color(240, 246, 255));
    this.buttonGrid[0][5].setForeground(new Color(153, 0, 102));
    this.buttonGrid[0][5].setText("9");
    this.buttonGrid[0][6].setText("+");
    this.buttonGrid[0][7].setText("x");
    this.buttonGrid[1][0].setText("STO");
    this.buttonGrid[1][1].setText("RCL");
    this.buttonGrid[1][2].setText("Up");
    this.buttonGrid[1][3].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[1][3].setBackground(new Color(240, 246, 255));
    this.buttonGrid[1][3].setForeground(new Color(153, 0, 102));
    this.buttonGrid[1][3].setText("4");
    this.buttonGrid[1][4].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[1][4].setBackground(new Color(240, 246, 255));
    this.buttonGrid[1][4].setForeground(new Color(153, 0, 102));
    this.buttonGrid[1][4].setText("5");
    this.buttonGrid[1][5].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[1][5].setBackground(new Color(240, 246, 255));
    this.buttonGrid[1][5].setForeground(new Color(153, 0, 102));
    this.buttonGrid[1][5].setText("6");
    this.buttonGrid[1][6].setText("-");
    this.buttonGrid[1][7].setText("/");
    this.buttonGrid[2][0].setText("Load");
    this.buttonGrid[2][1].setText("Save");
    this.buttonGrid[2][2].setText("Down");
    this.buttonGrid[2][3].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[2][3].setBackground(new Color(240, 246, 255));
    this.buttonGrid[2][3].setForeground(new Color(153, 0, 102));
    this.buttonGrid[2][3].setText("1");
    this.buttonGrid[2][4].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[2][4].setBackground(new Color(240, 246, 255));
    this.buttonGrid[2][4].setForeground(new Color(153, 0, 102));
    this.buttonGrid[2][4].setText("2");
    this.buttonGrid[2][5].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[2][5].setBackground(new Color(240, 246, 255));
    this.buttonGrid[2][5].setForeground(new Color(153, 0, 102));
    this.buttonGrid[2][5].setText("3");
    this.buttonGrid[2][6].setText("^");
    this.buttonGrid[2][7].setText("%");
    this.buttonGrid[3][0].setText("BSP");
    this.buttonGrid[3][1].setText("Stack");
    this.buttonGrid[3][2].setText("?");
    this.buttonGrid[3][3].setText("+/-");
    this.buttonGrid[3][4].setFont(new Font("Courier New", 1, 20));
    this.buttonGrid[3][4].setBackground(new Color(240, 246, 255));
    this.buttonGrid[3][4].setForeground(new Color(153, 0, 102));
    this.buttonGrid[3][4].setText("0");
    this.buttonGrid[3][5].setText(".");
    this.buttonGrid[3][6].setText("1/n");
    this.buttonGrid[3][7].setFont(new Font("Courier New", 1, 15));
    this.buttonGrid[3][7].setBackground(new Color(246, 240, 255));
    this.buttonGrid[3][7].setForeground(new Color(153, 0, 102));
    this.buttonGrid[3][7].setText("Enter");
    
    this.contentPane.add(this.buttonPanel, "Center");
  }

  
  

  
  public void actionPerformed(ActionEvent event) { 
  	 if (event.getSource()==buttonGrid[2][3]) {
        String EnterNum = displayTextField.getText()+"1";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[2][4]) {
        String EnterNum = displayTextField.getText()+"2";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[3][4]) {
        String EnterNum = displayTextField.getText()+"0";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[3][5]) {
        String EnterNum = displayTextField.getText()+".";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[2][5]) {
        String EnterNum = displayTextField.getText()+"3";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[1][3]) {
        String EnterNum = displayTextField.getText()+"4";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[1][4]) {
        String EnterNum = displayTextField.getText()+"5";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[1][5]) {
        String EnterNum = displayTextField.getText()+"6";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[0][5]) {
        String EnterNum = displayTextField.getText()+"9";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[0][4]) {
        String EnterNum = displayTextField.getText()+"8";
        displayTextField.setText(EnterNum);}
        
         if (event.getSource()==buttonGrid[0][3]) {
        String EnterNum = displayTextField.getText()+"7";
        displayTextField.setText(EnterNum);}
      //+++++++++++++++++++++++++++++++++++++++++++  
         if (event.getSource()==buttonGrid[0][6]) {
         if(help==false){
         
         try{
			Double d1=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d2=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d3=d1+d2;
			
			RPNForm.calc.Instructions.addLast(Double.toString(d3));
			displayTextField.setText(Double.toString(d3));
			System.out.println("Stack is :"+RPNForm.calc.Instructions);
		}catch(EmptyStackException e){
	         System.out.println("Empty or with one element list");	
		}
         	
         }
         else{
         	JOptionPane.showMessageDialog(null,"This button sums the top two elements in the stack");
		help = false;
         }
        }
        //**************************************************
        if (event.getSource()==buttonGrid[0][7]) {
        	if(help==false){
         	try{
			Double d1=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d2=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d3=d1*d2;
			
			RPNForm.calc.Instructions.addLast(Double.toString(d3));
			displayTextField.setText(Double.toString(d3));
			System.out.println("Stack is :"+RPNForm.calc.Instructions);
		}catch(EmptyStackException e){
	         System.out.println("Empty or with one element list");	
		}
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button multiplies the top two elements in the stack");
		help = false;
         }
        }
        //---------------------------------------------------------
        if (event.getSource()==buttonGrid[1][6]) {
        	if(help==false){
         	try{
			Double d1=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d2=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d3=d2-d1;
			
			RPNForm.calc.Instructions.addLast(Double.toString(d3));
			displayTextField.setText(Double.toString(d3));
			System.out.println("Stack is :"+RPNForm.calc.Instructions);
		}catch(EmptyStackException e){
	         System.out.println("Empty or with one element list");	
		}
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button subtract the top two elements in the stack");
		help = false;
         }
        }
        /////////////////////////////////////////////////////////////
        if (event.getSource()==buttonGrid[1][7]) {
        	if(help==false){
         try{
			Double d1=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d2=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d3=d2/d1;
			if (d1!=0){	
			RPNForm.calc.Instructions.addLast(Double.toString(d3));
			displayTextField.setText(Double.toString(d3));
			System.out.println("Stack is :"+RPNForm.calc.Instructions);
			}
			else{RPNForm.calc.Instructions.addLast("0");
			System.out.println("Stack is :"+RPNForm.calc.Instructions);//if divide by zero return zero
			displayTextField.setText(String.valueOf(0));}
		}catch(EmptyStackException e){
	         System.out.println("Empty or with one element list");	
		}
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button divied the top two elements in the stack");
		help = false;
         }
        }
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        if (event.getSource()==buttonGrid[2][6]) {
        	if(help==false){
         	try{
			Double d1=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d2=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d3=Math.pow(d2,d1);
			
			RPNForm.calc.Instructions.addLast(Double.toString(d3));
			displayTextField.setText(Double.toString(d3));
			System.out.println("Stack is :"+RPNForm.calc.Instructions);
		}catch(EmptyStackException e){
	         System.out.println("Empty or with one element list");	
		}
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button powers the top two elements in the stack");
		help = false;
         }
        }
        //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        if (event.getSource()==buttonGrid[2][7]) {
        	if(help==false){
         try{
			Double d1=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d2=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			Double d3=d2%d1;
			
			RPNForm.calc.Instructions.addLast(Double.toString(d3));
			displayTextField.setText(Double.toString(d3));
			System.out.println("Stack is :"+RPNForm.calc.Instructions);
		}catch(EmptyStackException e){
	         System.out.println("Empty or with one element list");	
		}
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button %?? the top two elements in the stack");
		help = false;
         }
        }
        
        
        //________ENTER________________________________________
        
        if (event.getSource()==buttonGrid[3][7]) {
        	if(help==false){
        	String answer;
        	secondnum = Double.parseDouble(displayTextField.getText());
           RPNForm.calc.Instructions.addLast(displayTextField.getText());
           System.out.println("Stack is :"+RPNForm.calc.Instructions);
           displayTextField.setText("");
        	}
        else{
         	JOptionPane.showMessageDialog(null,"This button pushs the text numbers to the stack");
		help = false;
         }	
           }
         
         //___________________ÊÛííÑ ÇáÇÔÇÑÉ ______________________________
         if (event.getSource()==buttonGrid[3][3]) {
         if(help==false){
			Double d1=Double.parseDouble(displayTextField.getText());
			d1*=-1;
			displayTextField.setText(Double.toString(d1));
         }
          else{
         	JOptionPane.showMessageDialog(null,"This button multiply the text numbers by -1");
		help = false;
         }	
        }  
        //____________________ãÚßæÓ ÇáÚÏÏ____________________________________
        if (event.getSource()==buttonGrid[3][6]) {
         if(help==false){
			Double d1=Double.parseDouble(displayTextField.getText());
			d1=Math.pow(d1,-1);
			displayTextField.setText(Double.toString(d1));
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button inverse the number in text");
		help = false;
         }	
        }	
        //_______________clear____-C-_________________________________________	
       
       
       if (event.getSource()==buttonGrid[0][1]) {
           if(help==false){
		   displayTextField.setText("");
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button clear all text");
		help = false;
         }	
       }	
       
       //______________clear all elements______-CE-____________________________
       
       
       if (event.getSource()==buttonGrid[0][2]) {
         if(help==false){ 
		 RPNForm.calc.Instructions = new LinkedList<String>();
         System.out.println("Stack is cleared ");
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button clear all stack elementst");
		help = false;
         }	
       }
        
        
        //___________BackSpace___-BSP-_______________________	
       
       if (event.getSource()==buttonGrid[3][0]) {
         if(help==false){ 
			int d1=Integer.parseInt(displayTextField.getText());
			d1=d1/10;
			displayTextField.setText(Integer.toString(d1));
        }
         else{
         	JOptionPane.showMessageDialog(null,"This button deletes last writen number");
		help = false;
         }	
       }	
       
       //____________Down_______________________________
       if (event.getSource()==buttonGrid[2][2]) {
         if(help==false){
			Double d1=Double.parseDouble(RPNForm.calc.Instructions.remove());
			RPNForm.calc.Instructions.addLast(Double.toString(d1));
		    System.out.println("Stack is :"+RPNForm.calc.Instructions);
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button rotate the stack down");
		help = false;
         }	
       }	
       //____________UP__________________________________
       if (event.getSource()==buttonGrid[1][2]) {
         if(help==false){
			Double d1=Double.parseDouble(RPNForm.calc.Instructions.removeLast());
			RPNForm.calc.Instructions.push(Double.toString(d1));
		    System.out.println("Stack is :"+RPNForm.calc.Instructions);
        }
        else{
         	JOptionPane.showMessageDialog(null,"This button rotate the stack up");
		help = false;
         }
       }	
        	
       //_____________Stack_________________________________
       
        if (event.getSource()==buttonGrid[3][1]) {
        	 if(help==false){
         String s1[] = new String[26];
        RPNForm.calc.Instructions.toArray(s1);
          new RPNStack(s1);
        	 }
         else{
         	JOptionPane.showMessageDialog(null,"This button shows the stack");
		help = false;
         }	 

        }	
       //___________________recall____________________________
       
       if (event.getSource()==buttonGrid[1][1]) {
       	if(help==false){
          new RPNRecall();
       	}
       	else{
         	JOptionPane.showMessageDialog(null,"This button shows the recall for registers window ");
		help = false;
         }

        }	 	
     	
       
	   //___________________________Save______________________
           
		 if (event.getSource()==buttonGrid[2][1]){
          if(help==false)	 
	new file();
	else{
	
		JOptionPane.showMessageDialog(null,"This button save the stack and the register in two ceparate files");
		help = false;
       } 
		 } 	
  //______________STO________________________________  	
   if (event.getSource()==buttonGrid[1][0]) {
    
     if(help==false){     
//	q=i;
//	   while(RPNForm.calc.register[i].getValue()>0){
	   	q++;
//	 i++;
//	   }
	  
	
	/*  
	   String label="Stored";
	  
	    	secondnum = Double.parseDouble(displayTextField.getText());
	    RPNForm.calc.register[i].setValue(secondnum);
	    RPNForm.calc.register[i].setLable(label);
	   
      
         
          System.out.println("You Saved at :"+RPNForm.calc.register[i]);
           displayTextField.setText("");
          q++;
	 i++;	 
	 */
	 
	  	 new RPNStore();
        }
       else{
	
		JOptionPane.showMessageDialog(null,"This button store number to one of 26 internal registers and open store window");
		help = false;
       }  
   }
  
  //_____________LOAD_________________________________
  if (event.getSource()==buttonGrid[2][0]) {
  if(help==false){ 
  new filereader();
  }
  else{
	
		JOptionPane.showMessageDialog(null,"This button load the stack and the register from two ceparate files");
		help = false;
       } 
  }
  
  
        	
   //____________________??????_________________________________	
        	
        	
   if (event.getSource()==buttonGrid[3][2]) {
  
  help = true;
  System.out.println("Help mode is active !!");
  }
  
  
  //_______________________________________________________________________     	
        	
       
         
        dealWith(event.getActionCommand()); }
  
  

 public void dealWith(String actionCommand) {
    if (actionCommand.equals("eXit")) {
        System.exit(0);
}
}

}
