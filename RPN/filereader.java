package RPN ;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class filereader {
 
	public filereader() {
		int x =0;
		BufferedReader br = null;
		BufferedReader rbr = null;
		try {
			br = new BufferedReader(new FileReader("Stack.txt"));
			rbr = new BufferedReader(new FileReader("Regs.txt"));
			String line,rline;
				RPNForm.calc.Instructions = new LinkedList<String>();
			while ((line = br.readLine()) != null) {
			
				RPNForm.calc.Instructions.addLast(line);
			}
			while ((rline = rbr.readLine()) != null && x<26 ) {
				Double num = Double.parseDouble(rline);
				RPNForm.calc.register[x].setValue(num);
				if(RPNForm.calc.register[x].getValue()>0)
				 RPNForm.calc.register[x].setLable("Loaded");	
			
				x++;
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	System.out.println("The Stack:"+RPNForm.calc.Instructions+"has been loaded");
	}
 
}