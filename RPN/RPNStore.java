
package RPN ;


import java.util.LinkedList;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
 
import javax.swing.JScrollPane; 

class RPNStore extends JFrame implements ActionListener{

public static RPNCalculator calc;
 
Container c;

JButton add,out,adi,dvi,store,edit,clearall,close ;
JList text_result;
/////////////////////////////////////////////////////////////
public RPNStore(){
super("RPN Store");
this.calc = new RPNCalculator();
c = getContentPane();

c.setLayout(null);
text_result = new JList(RPNForm.calc.register);
JScrollPane scroll = new JScrollPane();

scroll.setViewportView(text_result);
//text_result.setLayoutOrientation(JList.VERTICAL);
scroll.setBounds(410,20,20,300);

//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//scroll.setBorder(BorderFactory.createLineBorder(Color.red));
text_result.setBounds(20,20,360,400);
text_result.setSize(390,300);
add = new JButton("+"); add.setBounds(90,350,45,45);add.addActionListener(this);
out = new JButton("-"); out.setBounds(150,350,45,45);out.addActionListener(this);
adi = new JButton("x"); adi.setBounds(210,350,45,45);adi.addActionListener(this);
dvi = new JButton("/"); dvi.setBounds(270,350,45,45);dvi.addActionListener(this);
store = new JButton("Store"); store.setBounds(20,430,80,40);store.addActionListener(this);
edit = new JButton("Edit Label"); edit.setBounds(120,430,90,40);edit.addActionListener(this);
clearall = new JButton("ClearAll"); clearall.setBounds(230,430,80,40);clearall.addActionListener(this);
close = new JButton("Close");close.setBounds(330,430,80,40);close.addActionListener(this);






 c.add(text_result);

c.add(scroll);
c.add(add);c.add(out);c.add(adi);c.add(dvi);c.add(store);c.add(edit);c.add(clearall);c.add(close);
setSize(450,550);

setVisible(true);

}

public void actionPerformed(ActionEvent event) { 
if (event.getSource()==close){
	
 System.exit(0);
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

if (event.getSource()==add){
	
 int s = text_result.getSelectedIndex();
 double d = RPNForm.calc.register[s].getValue();
 
 String s1 = RPNForm.calc.Instructions.removeLast();
 RPNForm.calc.Instructions.addLast(s1);
 double d1 = Double.parseDouble(s1);
 
 double result = d1+d;
 RPNForm.calc.register[s].setValue(result);
 
 System.out.println("The stack"+RPNForm.calc.Instructions);
 System.out.println("The new value for selected value is"+result);
  
}

//***************************************************************************
if (event.getSource()==adi){
	
 int s = text_result.getSelectedIndex();
 double d = RPNForm.calc.register[s].getValue();
 
 String s1 = RPNForm.calc.Instructions.removeLast();
 RPNForm.calc.Instructions.addLast(s1);
 double d1 = Double.parseDouble(s1);
 
 double result = d1*d;
 RPNForm.calc.register[s].setValue(result);
 
 System.out.println("The stack"+RPNForm.calc.Instructions);
 System.out.println("The new value for selected value is"+result);
  
}

/////////////////////////////////////////////////////////////////////////////////

if (event.getSource()==dvi){
	
 int s = text_result.getSelectedIndex();
 double d = RPNForm.calc.register[s].getValue();
 
 String s1 = RPNForm.calc.Instructions.removeLast();
 RPNForm.calc.Instructions.addLast(s1);
 double d1 = Double.parseDouble(s1);
 
 double result = d/d1;
 RPNForm.calc.register[s].setValue(result);
 
 System.out.println("The stack"+RPNForm.calc.Instructions);
 System.out.println("The new value for selected value is"+result);
  
}

//--------------------------------------------------------------------------------

if (event.getSource()==out){
	
 int s = text_result.getSelectedIndex();
 double d = RPNForm.calc.register[s].getValue();
 
 String s1 = RPNForm.calc.Instructions.removeLast();
 RPNForm.calc.Instructions.addLast(s1);
 double d1 = Double.parseDouble(s1);
 
 double result = d-d1;
 RPNForm.calc.register[s].setValue(result);
 
 System.out.println("The stack"+RPNForm.calc.Instructions);
 System.out.println("The new value for selected value is"+result);
  
}

//___________clear____________________________________________

if (event.getSource()==clearall){
	
	for(int x=0;x<26;x++){
	 RPNForm.calc.register[x].setValue(0);	
	 RPNForm.calc.register[x].setLable("no lable");
	
	}
	 System.out.println("The Registers have been cleared");	
	
}

//________________________edit lable_____________________________

if (event.getSource()==edit){
	
String label=JOptionPane.showInputDialog("Enter the lable :");	
int s = text_result.getSelectedIndex();	
 RPNForm.calc.register[s].setLable(label);	

}

//__________________store_______________________________________

if (event.getSource()==store){
int s = text_result.getSelectedIndex();	

String s1 = RPNForm.calc.Instructions.removeLast();
double d1 = Double.parseDouble(s1);
RPNForm.calc.register[s].setValue(d1);

System.out.println("The stack"+RPNForm.calc.Instructions);
}

//______________________________________________________________________________________________________________

}



//public static void main(String[] args){
//	new RPNStore();
	
//}
}