package arrays;

import serializationTesting.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by libsys on 2/2/2023.
 */
public class BasicCalculator2 {

    public static int calculate(String s){
        Map<Character,Integer> priority = new HashMap<>();
        priority.put('+',0);
        priority.put('-',0);
        priority.put('/',1);
        priority.put('*',1);

        int n = s.length();
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        StringBuilder operandBuilder = new StringBuilder();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == ' ')    continue;

            if(Character.isDigit(c)){
                operandBuilder.append(c);
            } else {
                operands.push(Integer.parseInt(operandBuilder.toString()));
                operandBuilder = new StringBuilder();
                while(!operators.isEmpty() && priority.get(operators.peek()) >= priority.get(c)){
                    int operand2 = operands.pop();
                    int operand1 = operands.pop();
                    char operator = operators.pop();
                    int res = compute(operand1,operator,operand2);
                    operands.push(res);

                }
                operators.push(c);
            }
        }
        operands.push(Integer.parseInt(operandBuilder.toString()));
        while(!operators.isEmpty()){
            int operand2 = operands.pop();
            int operand1 = operands.pop();
            char operator = operators.pop();
            int res = compute(operand1,operator,operand2);
            operands.push(res);
        }
        return operands.pop();

    }
    public static int compute(Integer operand1,Character operator,Integer operand2){
        int res = 0;
        switch(operator){
            case '+':   res = operand1+operand2;
                break;
            case '-':   res = operand1-operand2;
                break;
            case '/':   res = operand1/operand2;
                break;
            case '*':   res = operand1*operand2;
                break;
        }
        return res;
    }
    public static void main(String[] args){
       /* System.out.println(calculate(" 1 +2*5 /  3+6/4*2"));
        System.out.println(calculate("1+2*5/3+6/4*2"));*/
        System.out.println(
                Arrays.asList(new Employee("IT","1",10)
                        ,new Employee("IT","2",9)
                        ,new Employee("HR","3",15)
                        ,new Employee("HR","4",14)
                )
                        .stream()
                        .collect(
                                Collectors.groupingBy(Employee::getDept,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),Optional::get))
                        )

        );
    }
}
class Employee{
    String dept;
    String id;
    int salary;
    public Employee(String dept,String id,int salary){
        this.dept = dept;
        this.id = id;
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
