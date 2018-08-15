import java.util.*;

interface q_data{
	final int front=0,rare=-1,size=4;;
}
class Que implements q_data{
	int count=0,f,r,max;
	Random ran = new Random();
	Que(){
		f=front;
		r=rare;
		max=size;
	}
	synchronized public void insert() {
		if(count==max)
		{
			System.out.println("Q is full");
		}
		else {
			r=(r+1)%max;
			int val=ran.nextInt(1000);
			System.out.println("Inserting value: "+val);
			circuler_q.Q[r]=val;
			count++;
		}
	}
	synchronized public void delete() {
		int item;
		if(count==0)
		{
			System.out.println("Q is empty");
		}
		else {
			System.out.println("Deleting :"+circuler_q.Q[f]);
			f=(f+1)%max;
			count--;
		}
	}
	
}
class Q_ins implements Runnable{
	Que queue;
	public Q_ins(Que queue) {
		this.queue=queue;
		Thread th=new Thread(this,"Q_ins");
		th.start();
	}
	public void run() {
		while(true) {
			queue.insert();
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
class Q_del implements Runnable{
	Que queue;
	public Q_del(Que queue) {
		this.queue=queue;
		Thread th=new Thread(this,"Q_del");
		th.start();
	}
	public void run() {
		while(true) {
			queue.delete();
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class circuler_q {
	static int[] Q=new int[22];
	public static void main(String[] args) {
		Que queue=new Que();
		new Q_ins(queue);
		new Q_del(queue);
	}
}
