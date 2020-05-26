package RPN ;


import java.util.LinkedList;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
 
 


class RPNRecall extends JFrame implements ActionListener{

public static RPNCalculator calc;

Container c;
JScrollPane scroll;
JButton recall,close;
JList text_result;
/////////////////////////////////////////////////////////////
public RPNRecall(){
super("RPN Recall");
this.calc = new RPNCalculator();

c = getContentPane();
//String s2[]=new String[26];
//int i = 0;
        
c.setLayout(null);
//DefaultListModel<String> model = new DefaultListModel<String>(); //text_result.getModel();


RPNForm.q=0;


text_result = new JList(RPNForm.calc.register);
scroll = new JScrollPane();
scroll.setViewportView(text_result);
scroll.setBounds(403,20,20,300);
text_result.setLayoutOrientation(JList.VERTICAL);



text_result.setBounds(20,20,360,400);
text_result.setSize(390,300);
/////////////////////////////////////////
//for(char c='A';c<='Z';c++,++i){
//int i = 0;
//char c = 'A'; 
//int s1[] = new int[26];//åäÇ æÞÝÊ 
//s1[i]=Integer.parseInt(s2[i]);
//model.addElement(c+" = "+s1[i]+"      -\t-\t-                                                   -");


//}
recall = new JButton("Recall"); recall.setBounds(80,350,80,40);//up.addActionListener(this);
close = new JButton("Close");close.setBounds(250,350,80,40);//clear.addActionListener(this);





c.add(scroll);
recall.addActionListener(this);
 c.add(text_result);close.addActionListener(this);


c.add(recall);c.add(close);
setSize(450,550);
setVisible(true);
scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
scroll.setBorder(BorderFactory.createLineBorder(Color.red));
}




public void actionPerformed(ActionEvent event) { 
if (event.getSource()==close){
	
 System.exit(0);
}
//___________________________

if (event.getSource()==recall){
	 

    
	int s = text_result.getSelectedIndex();

    Double d=	RPNForm.calc.register[s].getValue();
    
		String n = d.toString();
RPNForm.q=s;	
  RPNForm.calc.Instructions.addLast(n);
   System.out.println("Stack is :"+RPNForm.calc.Instructions);
  // RPNForm.calc.register[RPNForm.q].setValue(0);
  // RPNForm.calc.register[RPNForm.q].setLable("not lable");
   
   
   
   
   
}



}







//public static void main(String[] args){
//	new RPNRecall();
	
//}
}