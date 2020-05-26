package RPN;

import java.util.Deque;
import java.util.LinkedList;





public class RPNCalculator
{
  
  public static final int NUMBER_OF_REGISTERS = 26;
  public Deque<Double> theStack = new LinkedList<Double>();
  public LinkedList<String> Instructions = new LinkedList<String>();
  public Register[] register = new Register[NUMBER_OF_REGISTERS];

    public RPNCalculator() {
        for(int i=0;i<register.length;++i){
            register[i]= new Register(0.0,"no lable",""+(char)('A'+i));
        

}
    }
}





