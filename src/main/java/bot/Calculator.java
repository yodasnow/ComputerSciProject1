package bot;

public class Calculator {
    public int calculate(String operator, int firstNum, int secondNum) {
        if (operator.equals("+")){
            return(firstNum + secondNum);
        }
        else if (operator.equals("-")){
            return (firstNum - secondNum);
        }
        else if (operator.equals("*") || operator.equals("x")){
            return (firstNum * secondNum);
        }
        else if (operator.equals("/")){
            return  (firstNum / secondNum);
        }
        else if (operator.equals("%")){
            return (firstNum % secondNum);
        }
        return(0);
    }
}
