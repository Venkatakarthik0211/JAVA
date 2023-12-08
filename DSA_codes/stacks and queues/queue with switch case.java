import java.util.*;
public class queue1
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        ArrayQueue queue = new ArrayQueue(100);

        for(int i=1;i<=10;i++)
            queue.add(i);

        queue.remove();      
        queue.remove();       

        queue.add(27);    

        System.out.println("The top element is " + queue.peek());
        System.out.println("The queue size is " + queue.size());

        queue.remove();       
        if (queue.isEmpty()) 
        {
            System.out.println("The queue is empty");
        }
        else 
        {
            System.out.println("The queue is not empty");
        }

        int choice = in.nextInt();
        switch(choice)
        {
            // Add comments to what is being done in this case "1" to understand the code more easily
            case 1:
            {
                for(int i=1;i<=10;i++)
                    queue.add(i);

                break;
            }

            // Add comments to what is being done in this case "2"
            case 2:
            {
                queue.add(27);
                queue.remove();      
                queue.remove(); 
                queue.remove();  
                break;
            }

            case 3:
            {
                queue.count();
                break;
            }

            case 4:
            {
                queue.printQueue();
                break;
            }  

            case 5:
            {
                System.out.println("The top element is " + queue.peek());
                break;
            }   

            case 6:
            {
                n=in.nextInt();
                queue.search(n);
                break;
            }

            default:
            System.out.println("The queue size is " + queue.size());
            System.out.println("search element is");
            if (queue.isEmpty()) 
            {
                System.out.println("The queue is empty");
            }
            else 
            {
                System.out.println("The queue is not empty");
            }
        }
    }
}

class ArrayQueue
{
    //private int arr[];
    private int front;
    private int back;
    private int capacity;
    private int queue[];

    ArrayQueue(int size)
    {
        queue = new int[size];
        capacity = size;
        front = -1;
        back = -1;
    }

    public void add(int x)
    {
        if (isFull() && front==-1)
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(1);
        }
        else
        if(front>-1 && isFull())
        {
            for(int i=front, j=0;i<back;i++,j++)
            {
                queue[j] = queue[i];  
            }
        }
        else
        {
            if(isEmpty())
                front = 0;

            System.out.println("Inserting " + x);
            queue[++back] = x;
        }

    }

    public int remove()
    {

        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        int temp=queue[front]; 
        System.out.println("Removed "+temp);

        for(int i=front;i<back;i++)
        {
            queue[i] = queue[i+1];
        }
        back--;
        return temp;
    }

    public int peek()
    {
        if (!isEmpty()) {
            return queue[back];
        }
        else {
            System.exit(1);
        }

        return -1;
    }

    public int size() 
    {
        return back - front + 1;
    }

    public Boolean isEmpty()
    {
        return front == -1;               
    }

    public Boolean isFull() 
    {
        return front == capacity - 1;  
    }

    public void printQueue() 
    {
        for (int i = front; i < back; i++) 
        {
            System.out.println(queue[i]);
        }
    }

    public void search(int x) 
    {
        for (int i = front; i < back; i++) 
        {
            if(queue[i]==x)
                System.out.println("the element exist");
        } 
        System.out.println("the element does not exist");
    }

    public void count() 
    {
        int count = 0;
        for (int i = front; i < back; i++) 
        {

            count = count+1;
        }
        System.out.println("count="+count);

    }
}
