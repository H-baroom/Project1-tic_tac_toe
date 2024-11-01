import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the first number : ");
        double first_number = input.nextInt();
        System.out.println("please enter the second number : ");
        double second_number = input.nextInt();
        int number_menu = 0 ;
        ArrayList<Double> all_results = new ArrayList();
        double lastResult =0;
        do{
            menu();
            number_menu = input.nextInt();
            switch (number_menu){
                case 1:
                    System.out.println("Addition Result: "+addition(first_number,second_number));
                    lastResult = addition(first_number,second_number);
                    all_results.add(addition(first_number,second_number));
                    break;
                case 2:
                    System.out.println("Subtraction Result: " + subtraction(first_number,second_number));
                    lastResult = subtraction(first_number,second_number);
                    all_results.add(subtraction(first_number,second_number));
                    break;
                case 3:
                    System.out.println("Multiplication Result: " + multiplication(first_number,second_number));
                    lastResult = multiplication(first_number,second_number);
                    all_results.add(multiplication(first_number,second_number));
                    break;
                case 4:
                    try {
                        System.out.println("Division Result: " + division(first_number, second_number));
                        lastResult = division(first_number, second_number);
                        all_results.add(division(first_number, second_number));
                    }catch (ArithmeticException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Modulus Result: " +modulus(first_number, second_number));
                        lastResult = modulus(first_number, second_number);
                        all_results.add(modulus(first_number, second_number));
                    }catch (ArithmeticException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Minimum Number: " + minimum(first_number,second_number));
                    lastResult = minimum(first_number,second_number);
                    all_results.add(minimum(first_number,second_number));
                    break;
                case 7:
                    System.out.println("Maximum Number: " + maximum(first_number,second_number));
                    lastResult = maximum(first_number,second_number);
                    all_results.add(maximum(first_number,second_number));
                    break;
                case 8:
                    System.out.println("Average of Numbers: " + average(first_number,second_number));
                    lastResult = average(first_number,second_number);
                    all_results.add(average(first_number,second_number));
                    break;
                case 9:
                    System.out.println("Last Calculated Result: "+lastResult);
                    break;
                case 10:
                    System.out.println("List of All Results: "+all_results);
                    break;
                case 0:
                    System.out.println("Exiting Calculator.");
                    break;
                default:
                    System.out.println("The number out of rang, please enter number between 0 - 10");
            }
        }while(number_menu != 0);
    }
    public static void menu(){
        System.out.println("*********************************************************");
        System.out.println("Enter 1 to addition the numbers ");
        System.out.println("Enter 2 to subtraction the numbers ");
        System.out.println("Enter 3 to multiplication the numbers");
        System.out.println("Enter 4 to division the numbers");
        System.out.println("Enter 5 to modulus the numbers");
        System.out.println("Enter 6 to find minimum number");
        System.out.println("Enter 7 to find maximum number");
        System.out.println("Enter 8 to find the average of numbers");
        System.out.println("Enter 9 to print the last result in calculator");
        System.out.println("Enter 10 to print the list of all results in calculator");
        System.out.println("Enter 0 to quite calculator");
        System.out.println("*********************************************************");
    }
    public static double addition(double num1,double num2){
        return num1 + num2;
    }
    public static double subtraction(double num1,double num2){
        return num1 - num2;
    }

    public static double multiplication(double num1,double num2){
        return num1 * num2;
    }

    public static double division(double num1,double num2)throws ArithmeticException{
        if(num2 == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        return num1 / num2;
    }

    public static double modulus(double num1,double num2)throws ArithmeticException{
        if(num2 == 0){
            throw new ArithmeticException("Error: Modulus by zero is not allowed.");
        }
        return num1 % num2;
    }

    public static double minimum(double num1,double num2){
        if(num1 < num2) {
            return num1;
        }else{
            return num2;
        }
    }
    public static double maximum(double num1,double num2){
        if(num1 > num2) {
            return num1;
        }else{
            return num2;
        }
    }
    public static double average(double num1,double num2){
        return addition(num1,num2) /2;
    }



}