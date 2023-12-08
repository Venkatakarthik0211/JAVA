import java.util.Scanner;
public class Main 
{ 
public static void main(String angt[])
{
Scanner data = new Scanner(System.in);
double num,num1,num2; 
System.out.println("Enter a number"); num1=data.nextDouble();
num=Math.toRadians(num1); 
System.out.println("Answer:"+num);
System.out.println("Enter a number"); num2=data.nextDouble(); 
num=Math.toDegrees(num2); 
System.out.println("Answer:"+num); 
} 
}