package e4;

import java.util.ArrayList;

public class Calculator {
    ArrayList<String> entrada= new ArrayList<>();
    /**
     * Public constructor of the calculator .
     */
    public Calculator () {}
    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations () {
        entrada.clear();
    }
    /**
     * Add a new operation to the internal state of the calculator .
     * It is worth mentioning that the calculator behaves in an accumulative way ,
     * thus only first operation has two operands .
     * The rest of computations work with the accumulated value and only an extra
     * new operand . Second input value must be ignored if the operation does not
     * correspond to the first one .
     *
     * @param operation operation to add , as string , "+" , " -" , "*" , "/".
     * @param values Operands of the new operation ( one or two operands ).
     * Uses the varargs feature .
     * https :// docs . oracle . com / javase /8/ docs / technotes / guides / language / varargs . html
     * @throws IllegalArgumentException If the operation does not exist .
     */
    public void addOperation ( String operation , float ... values ) {
        if (operation.length()!=1){
            throw new IllegalArgumentException();
        }
        if (Character.compare(operation.charAt(0),'/')!=0&&Character.compare(operation.charAt(0),'+')!=0&&
                Character.compare(operation.charAt(0),'-')!=0&&Character.compare(operation.charAt(0),'*')!=0) {
            throw new IllegalArgumentException();
        }
        entrada.add(operation);
        if (values.length==2&&entrada.size()==1) {
           entrada.add(""+values[0]);
           entrada.add(""+values[1]);
        }
        else {
            entrada.add(""+values[0]);
        }
    }
    /**
     * Execute the set of operations of the internal state of the calculator .
     * Once execution is finished , internal state ( operands and operations )
     * is restored ( EVEN if exception occurs ).
     * This calculator works with " Batches " of operations .
     * @return result of the execution
     * @throws ArithmeticException If the operation returns an invalid value
     * ( division by zero )
     */
    public float executeOperations () {
        float solucion=0;
        Calculator calculator= new Calculator();
        int size = entrada.size();
        int i=0;
        float dato1;
        float dato2;

        if (size==0)
            return 0;
        if(entrada.get(0).equals("+")){
            calculator.setOperation(Operation.SUMA);
        }
        else if (entrada.get(0).equals("-")){
            calculator.setOperation(Operation.RESTA);
        }
        else if (entrada.get(0).equals("/")){
            calculator.setOperation(Operation.DIVISION);
        }
        else if (entrada.get(0).equals("*")){
            calculator.setOperation(Operation.MULT);
        }
        if (calculator.operation==Operation.DIVISION) {
            if (Float.parseFloat(entrada.get(2))==0){
                entrada.clear();
                throw new ArithmeticException();
            }
        }
        dato1 =(Float.parseFloat(entrada.get(1)));
        dato2= (Float.parseFloat(entrada.get(2)));
        solucion=calculator.performOperation(dato1,dato2);
        for (i=3;i<size;i=i+2){
            if(entrada.get(i).equals("+")){
                calculator.setOperation(Operation.SUMA);
            }
            else if (entrada.get(i).equals("-")){
                calculator.setOperation(Operation.RESTA);
            }
            else if (entrada.get(i).equals("/")){
                calculator.setOperation(Operation.DIVISION);
            }
            else if (entrada.get(i).equals("*")){
                calculator.setOperation(Operation.MULT);
            }
            if (calculator.operation==Operation.DIVISION) {
                if (Float.parseFloat(entrada.get(i+1))==0){
                    entrada.clear();
                    throw new ArithmeticException();
                }
            }
            dato1 =(Float.parseFloat(entrada.get(i+1)));
            solucion=calculator.performOperation(solucion,dato1);
        }
       entrada.clear();
        return solucion;
    }
    /**
     * Current internal state of calculator is printed
     * FORMAT :
     * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
     * EXAMPLES : JUnit tests
     * @return String of the internal state of the calculator
     */
    @Override
    public String toString () {
        StringBuilder salida = new StringBuilder();
        salida.append("[STATE:");
        if (entrada.size()==0)
            return "[STATE:]";
        salida.append("[").append(entrada.get(0)).append("]");
        salida.append(entrada.get(1)).append("_");
        salida.append(entrada.get(2));
        for(int i=3;i< entrada.size();i=i+2){
             salida.append("[").append(entrada.get(i)).append("]");
             salida.append(entrada.get(i+1));
        }
        salida.append("]");
        return salida.toString();
    }
//---------------------------------------------------------------------------
Operation operation;
    public float performOperation(float dato1,float dato2){
        return operation.perform(dato1, dato2);
    }
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    public enum Operation {
        SUMA("+") {
            @Override
            public float perform(float operand1, float operand2) {
                return operand1 + operand2;
            }
        },
        RESTA("-"){
          @Override
          public float perform(float operand1, float operand2){
              return operand1-operand2;
          }
        },
        MULT("*"){
            @Override
            public float perform(float operand1, float operand2){
                return operand1*operand2;
            }
        },
        DIVISION("/") {
            @Override
            public float perform(float operand1, float operand2){
                return operand1/operand2;
        }
    };
        private final String operator;
        Operation(String operator) {
            this.operator = operator;
        }
        public abstract float perform(float operand1, float operand2);
    }
}
