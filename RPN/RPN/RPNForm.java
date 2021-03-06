
package RPN ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
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

public class RPNForm extends JFrame implements ActionListener {
  
  private Container contentPane;
  private JPanel displayPanel;
  private JLabel RPNLabel;
  public static JTextField displayTextField;
  private JPanel buttonPanel;
  private String inString = "";
  
  private JButton[][] buttonGrid;
  public static RPNCalculator calc;
  
  double firstnum;
  double secondnum;
  double result;
  String operations;
  String answer;
  
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
        
         if (event.getSource()==buttonGrid[0][6]) {
         	firstnum = Double.parseDouble(displayTextField.getText());
         	 displayTextField.setText("");
         	 operations = "+" ;
        }
        if (event.getSource()==buttonGrid[0][7]) {
         	firstnum = Double.parseDouble(displayTextField.getText());
         	 displayTextField.setText("");
         	 operations = "*" ;
        }
        if (event.getSource()==buttonGrid[1][6]) {
         	firstnum = Double.parseDouble(displayTextField.getText());
         	 displayTextField.setText("");
         	 operations = "-" ;
        }
        if (event.getSource()==buttonGrid[1][7]) {
         	firstnum = Double.parseDouble(displayTextField.getText());
         	 displayTextField.setText("");
         	 operations = "/" ;
        }
        if (event.getSource()==buttonGrid[2][6]) {
         	firstnum = Double.parseDouble(displayTextField.getText());
         	 displayTextField.setText("");
         	 operations = "^" ;
        }
        if (event.getSource()==buttonGrid[2][7]) {
         	firstnum = Double.parseDouble(displayTextField.getText());
         	 displayTextField.setText("");
         	 operations = "%" ;
        }
        if (event.getSource()==buttonGrid[3][7]) {
        	String answer;
        	secondnum = Double.parseDouble(displayTextField.getText());
        calc.AddLast(displayTextField.getText());
        	if(operations=="+"){
        		result = firstnum+secondnum;
        		answer = String.format("%.2f",result);
        		displayTextField.setText(answer);
        	}
        	if(operations=="*"){
        		result = firstnum*secondnum;
        		answer = String.format("%.2f",result);
        		displayTextField.setText(answer);
        	}
        	if(operations=="-"){
        		result = firstnum-secondnum;
        		answer = String.format("%.2f",result);
        		displayTextField.setText(answer);
        	}
        	if(operations=="/"){
        		result = firstnum/secondnum;
        		answer = String.format("%.2f",result);
        		displayTextField.setText(answer);
        	}
        	if(operations=="^"){
        		result =Math.pow(firstnum,secondnum);
        		answer = String.format("%.2f",result);
        		displayTextField.setText(answer);
        	}if(operations=="%"){
        		result = firstnum%secondnum;
        		answer = String.format("%.2f",result);
        		displayTextField.setText(answer);
        	}
         
        }
    
        
        dealWith(event.getActionCommand()); }
  
  

 public void dealWith(String actionCommand) {
    if (actionCommand.equals("eXit")) {
        System.exit(0);
}
}

}
