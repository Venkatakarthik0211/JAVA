import java.util.Scanner;

class Main { 
    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);    
        double num1 = sc.nextDouble();       
        double num2 = sc.nextDouble();  
        char operation = sc.next().charAt(0); 
        double result = 0.0; 
        switch(operation) {   
            case '+': 
                switch(operation) {   
                    case '+': 
                        result = num1+num2;             
                        break;           
                    case '-': 
                        result = num1-num2;             
                        break;          
                    case '*': 
                        result = num1*num2;             
                        break;      
                    case '/': 
                        result = num1/num2;             
                        break;      
                    default: 
                        System.out.println("Wrong Operator"); 
                        return; 
                } 
        } 
        System.out.println(result); 
    } 
} 
