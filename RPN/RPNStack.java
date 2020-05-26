package RPN ;
import java.util.LinkedList;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

 class RPNStack extends JFrame implements ActionListener{
private DefaultListModel<String> model = new DefaultListModel<String>();
public static RPNCalculator calc;
public static String cop;
Container c;
JLabel label_nr1, thes;
JButton button_add,up,down,copy,edit,delete,clear ;

static String s1[] = new String[26];
 private JList<String> text_result;


////////////////////////////////////////////////////////////////////////////


public RPNStack(String s1[]){
super("Stack");

//this.s = new DefaultListModel();
s1 = new String[26];
this.calc = new RPNCalculator();

c = getContentPane();


c.setLayout(null);

label_nr1 = new JLabel("Top>> "); label_nr1.setBounds(20,60,100,20);
label_nr1.setForeground(Color.green);
thes = new JLabel("The stack"); thes.setBounds(140,20,100,20);
thes.setForeground(Color.blue);
//thes.setFont(Color,blue);

////////////////////////
 //RPNForm.calc.Instructions.toArray(s1);	
//int size = RPNForm.calc.Instructions.size();	 	
 	for(int n=0;n<size;++n){
 	
 		System.out.println("Stack is :"+s1[n]);	
model.addElement(s1[n]);
 	}
 	

//this.text_result = new JList(s1);
 text_result = new JList<String>(model);
////////////////////////
//////////////////////////
//JScrollPane pane = new JScrollPane(text_result);
//pane.setBounds(350,60,20,250);
/////////////////////
text_result.setBounds(70,60,100,20);
text_result.setSize(280,250);
button_add = new JButton("close"); button_add.setBounds(215,320,80,30);button_add.addActionListener(this);


//pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//pane.setBorder(BorderFactory.createLineBorder(Color.red));



up = new JButton("UP"); up.setBounds(400,60,80,30);up.addActionListener(this);
down = new JButton("DOWN"); down.setBounds(400,100,80,30);down.addActionListener(this);
copy = new JButton("Copy"); copy.setBounds(400,140,80,30);copy.addActionListener(this);
edit = new JButton("Edit"); edit.setBounds(400,180,80,30);edit.addActionListener(this);
delete = new JButton("Delete"); delete.setBounds(400,220,80,30);delete.addActionListener(this);
clear = new JButton("Clear"); clear.setBounds(400,260,80,30);clear.addActionListener(this);



c.add(label_nr1); c.add(thes);

//c.add(pane);

 c.add(text_result);

c.add(button_add);
c.add(up);c.add(down);c.add(copy);c.add(edit);c.add(delete);c.add(clear);
setSize(550,450);

setVisible(true);

}


 public void actionPerformed(ActionEvent event){
 	RPNForm.calc.Instructions.toArray(s1);

 this.s1 = s1;
 this.text_result = text_result;	
 

 if(event.getSource()==button_add){
 	System.exit(0);
 }	
//___________________UP____________________________

 
 if(event.getSource()==up){
 	
 int n=text_result.getSelectedIndex();
 String d =text_result.getSelectedValue();	
 RPNForm.calc.Instructions.remove(text_result.getSelectedIndex());
 RPNForm.calc.Instructions.push(d);
 System.out.println("Stack is :"+RPNForm.calc.Instructions);
 model.remove(n);
 model.add(0,d);		
 }
 
 //________________________DOWN___________________________		
 	
 	
  if (event.getSource()==down) {
  	int n=text_result.getSelectedIndex();
    String d =text_result.getSelectedValue();
    RPNForm.calc.Instructions.remove(text_result.getSelectedIndex());
			RPNForm.calc.Instructions.addLast(d);
		    System.out.println("Stack is :"+RPNForm.calc.Instructions);
 	model.remove(n);
 	model.addElement(d);
		
        }	
 
 //__________________________clear_________________________
 
 
  if (event.getSource()==clear) {
         
		model.removeAllElements();	
			 RPNForm.calc.Instructions = new LinkedList<String>();
			 System.out.println("Stack is Empty");
        }		
 	
 //___________________________copy____________________________
 
 if (event.getSource()==copy) {
 	 	
 	 	cop=text_result.getSelectedValue();
 	 	System.out.println("You Copied :"+cop);
 	 	
 	 	}
 
 //_______________________Edit________________________________
 if (event.getSource()==edit) {
 	
 	String num=JOptionPane.showInputDialog("Add Number:");
 	
 	 model.addElement(num);	
 	 RPNForm.calc.Instructions.addLast(num);	
 	 System.out.println("Stack is :"+RPNForm.calc.Instructions);	
 	 	}
 
 //_______________________delete_______________________________
 
 	 if (event.getSource()==delete) {
 	 	
 	 
 	 	
	 DefaultListModel<String> model = (DefaultListModel<String>) text_result.getModel();
 	  	RPNForm.calc.Instructions.remove(text_result.getSelectedIndex());
 	  model.remove(text_result.getSelectedIndex());
 	  System.out.println("Stack is :"+RPNForm.calc.Instructions);
 	 		
      
 	 	 	 	
 	 	
 	 	}
         
			
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 }





//public static void main(String[] args){
	
//	String s1[] = new String[26];

//	new RPNStack(s1);
	
	
//}

}