import java.util.*;

interface data{
	final int left=0,middle=2,right=4;
}

class stack_left implements data{
	int pos,start,end;
	Random r = new Random();
	stack_left(){
		pos=start=left;
		end=middle;
	}
	synchronized public void push() {
		if(pos==end) {
			System.out.println("Stack_left Overflow");
		}
		else {
			int val=r.nextInt(10000);
			System.out.println("stack_left pushing: "+val);
			stack_thread.stack[pos++]=val;
		}
	}
	synchronized public void pop() {
		if(pos==start) {
			System.out.println("Stack_left Underflow");
		}
		else {
			System.out.println("stack_left popping: "+stack_thread.stack[--pos]);
		}
	}
}
class stack_right implements data{
	int pos,start,end;
	Random r = new Random();
	stack_right(){
		pos=start=right;
		end=middle;
	}
	synchronized public void push() {
		if(pos==end) {
			System.out.println(" Stack_right Overflow");
		}
		else {
			int val=r.nextInt(10000);
			System.out.println(" stack_right pushing: "+val);
			stack_thread.stack[--pos]=val;
		}
	}
	synchronized public void pop() {
		if(pos==start) {
			System.out.println(" Stack_right Underflow");
		}
		else {
			System.out.println(" stack_right popping: "+stack_thread.stack[pos++]);
		}
	}
}

class stack_left_push implements Runnable{
	stack_left sl;
	stack_left_push(stack_left sl){
		this.sl=sl;
		Thread th=new Thread(this,"stack_left_push");
		th.start();
		th.setPriority(Thread.MAX_PRIORITY);
	}
	public void run() {
		while(true) {
			sl.push();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class stack_left_pop implements Runnable{
	stack_left sl;
	stack_left_pop(stack_left sl){
		this.sl=sl;
		Thread th=new Thread(this,"stack_left_pop");
		th.start();
		th.setPriority(Thread.MIN_PRIORITY);
	}
	public void run() {
		while(true) {
			sl.pop();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class stack_right_push implements Runnable{
	stack_right sr;
	stack_right_push(stack_right sr){
		this.sr=sr;
		new Thread(this,"stack_right_push").start();
	}
	public void run() {
		while(true) {
			sr.push();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class stack_right_pop implements Runnable{
	stack_right sr;
	stack_right_pop(stack_right sr){
		this.sr=sr;
		new Thread(this,"stack_right_pop").start();
	}
	public void run() {
		while(true) {
			sr.pop();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class stack_thread {
	static int[] stack=new int[22];
	public static void main(String[] args) {
		stack_left sl=new stack_left();
		stack_right sr=new stack_right();
		new stack_left_push(sl);
		new stack_left_pop(sl);
		new stack_right_push(sr);
		new stack_right_pop(sr);
	}
}