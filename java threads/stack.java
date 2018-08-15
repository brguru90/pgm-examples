import java.util.*;
// Java program to implement two stacks in a

// single array

class TwoStacks

{

    int size;

    int top1, top2;

    int arr[];

 

    // Constructor

    TwoStacks(int n)

    {

        arr = new int[n];

        size = n;

        top1 = -1;

        top2 = size;

    }

 

    // Method to push an element x to stack1

    void push1(int x)

    {

        // There is at least one empty space for

        // new element

        if (top1 < top2 - 1)

        {

            top1++;
			System.out.println("pushed_1: "+x);
            arr[top1] = x;

        }

        else

        {

            System.out.println("Stack Overflow");

            //System.exit(1);

        }

    }

 

    // Method to push an element x to stack2

    void push2(int x)

    {

        // There is at least one empty space for

        // new element

        if (top1 < top2 -1)

        {

            top2--;
			System.out.println("pushed_2: "+x);
            arr[top2] = x;

        }

        else

        {

            System.out.println("Stack Overflow");

            //System.exit(1);

        }

    }

 

    // Method to pop an element from first stack

    int pop1()

    {

        if (top1 >= 0)

        {

            int x = arr[top1];

            top1--;

            return x;

        }

        else

        {

            System.out.println("Stack Underflow");

            //System.exit(1);

        }
		
		return -1;
    }

 

    // Method to pop an element from second stack

    int pop2()

    {

        if(top2 < size)

        {

            int x =arr[top2];

            top2++;

            return x;

        }

        else

        {

            System.out.println("Stack Underflow");

           // System.exit(1);

  

        }

		return -1;

    }

 

    // Driver program to test twoStack class


}
class stack implements Runnable{
	
	TwoStacks ts=new TwoStacks(5);
	
	stack(){
		new Thread(this,"stack").start();
	}
	
	public void run(){
		Random r = new Random();
		while(true){
			System.out.println("----------------------------------------------------");
			switch(r.nextInt(4))
			{
				case 1:ts.push1(r.nextInt(100));
						break;
				case 2:ts.push2(r.nextInt(100));
						break;
				case 3:System.out.println("popped_1: "+ts.pop1());
						break;
				case 4:System.out.println("popped_2: "+ts.pop2());
						break;
			}
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){}
		}
	}
	public static void main(String args[]){
		new stack();
	}
}
