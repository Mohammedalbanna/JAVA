package RPN ;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
 public class file {
 
	public file() {

	int size =RPNForm.calc.Instructions.size();
 String s1[]=new String[size];
 RPNForm.calc.Instructions.toArray(s1);
		try {
		File file = new File("Stack.txt");
        File regfile = new File("Regs.txt");
		if(!file.exists()) {
				file.createNewFile();	
		}
		
		PrintWriter pw = new PrintWriter(file);
		PrintWriter bw = new PrintWriter(regfile);
		
		for(int x=0;x<s1.length;x++)
		pw.println(s1[x]);	
		pw.close();
		
		for(int z=0;z<26;z++)
		bw.println(RPNForm.calc.register[z].getValue());	
		bw.close();
		
		System.out.println("Save process is done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}