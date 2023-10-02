reversing and basuc functions of stack
import java.io.*;
public class Main
{
    public static void main (String[] args)
    {
        //stack1 is for string reversal amd stack is intger pushing and poping
        Stack1 stack1 = new Stack1(100);
        String str= "VITAP";
        int b=str.length();
        System.out.println("before reversing");
        for(int i=0;i<b;i++)
        {
            System.out.println(str.charAt(i));
            stack1.push(str.charAt(i));
        }
        System.out.println("after reversing");
        for(int i=0;i<b;i++)
        {
            System.out.println(stack1.pop());
        }
        Stack stack = new Stack(100);
 
        stack.push(12);      
        stack.push(45);     
 
        stack.pop();      
        stack.pop();       
 
        stack.push(27);    
 
        System.out.println("The top element is " + stack.peek());
        System.out.println("The stack size is " + stack.size());
 
        stack.pop();       
 
       
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}
class Stack
{
    private int arr[];
    private int top;
    private int capacity;

    Stack(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    public void push(int x)
    {
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(1);
        }
 
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }
    public int pop()
    {
        
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }
 
        System.out.println("Removing " + peek());
 
        return arr[top--];
    }
 
    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(1);
        }
 
        return -1;
    }
 
    public int size() {
        return top + 1;
        }
     
        public Boolean isEmpty()
    {
        return top == -1;               
    }
 
    public Boolean isFull() {
        return top == capacity - 1;  
    }
}

class Stack1
{
    private char arr[];
    private int top;
    private int capacity;

    Stack1(int size)
    {
        
        arr = new char[size];
        capacity = size;
        top = -1;
    }
    public void push(char x)
    {
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(1);
        }
        arr[++top] = x;
    }
    public char pop()
    {
        
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }
 
        return arr[top--];
    }
 
    public char peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(1);
        }
 
        return '\0';
    }
 
    public int size() 
    {
        return top + 1;
    }
     
        public Boolean isEmpty()
    {
        return top == -1;               
    }
 
    public Boolean isFull() {
        return top == capacity - 1;  
}
}