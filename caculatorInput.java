package calculatoroop;

import java.io.*;

/**
 *
 * @author Davi
 */

class CalculatorEngine {
    int value;
    int keep;
    char toDo;
    
    void binaryOperation(char op) {
        keep = value;
        value = 0;
        toDo = op;
    }
    
    void add() { binaryOperation('+'); }
    void subtract() { binaryOperation('-'); }
    void multiply() { binaryOperation('*'); }
    void divide() { binaryOperation('/'); }
    
    void compute(){
        switch(toDo) {
            case '+':
                value = value + keep;
                break;
            case '-':
                value = keep - value;
                break;
            case '*':
                value = keep*value;
                break;
            case '/':
                value = keep/value;
                break;
        }
         keep = 0;
    }
    
    void clear() {
        value = 0;
        keep = 0;
    }
    
    void digit(int x) {
        value = value*10 + x;
    }
    
    int display() {
        return value;
    }
    
    CalculatorEngine() { clear(); }
}


public class CalculatorInput {
    
    BufferedReader stream;
    CalculatorEngine engine;
    
    CalculatorInput(CalculatorEngine e) {
        InputStreamReader input = new InputStreamReader(System.in);
        stream = new BufferedReader(input);
        engine = e;
    }
    
    void run() throws Exception {
        for(;;) {
            System.out.print("[" + engine.display() + "]");
            String m = stream.readLine();
            if (m==null) break;
            if(m.length()>0) {
                char c = m.charAt(0);
                if(c=='+') engine.add();
                else if(c=='-') engine.subtract();
                else if(c=='*') engine.multiply();
                else if(c=='/') engine.divide();
                else if(c>='0' && c<='9') engine.digit(c-'0');
                else if(c == '=') engine.compute();
                else if(c=='c' || c=='C') engine.clear();
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        CalculatorEngine e = new CalculatorEngine();
        CalculatorInput x = new CalculatorInput(e);
        x.run();
    }
    
}
