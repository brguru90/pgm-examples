import java.awt.*;
import java.applet.*;

public class moving_banner2 extends Applet implements Runnable  {
	int x1,y1,x2,y2;
	public void init() {
		x1=40;
		y1=80;
		x2=180;
		y2=80;
		this.setSize(650,200);
		this.setPreferredSize(new Dimension(650, 200));
		this.setMinimumSize(getPreferredSize());
		this.setMaximumSize(getPreferredSize());
	}
	
	public void start() {
		new Thread(this).start();
		//showStatus("guru");
	}
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(x1,y1,x2,y2);
		g.setColor(Color.green);
		g.fillRect(x1+1,y1+1,x2-1,y2-1);
		g.setColor(Color.blue);
		String msg="x1="+x1+" y1="+y1+" x2="+x2+" y2="+y2;
		g.drawString(msg, x1+15, y1+45);
		showStatus("guru");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=50,flag=0;;
		while(true) {
			if(i==400) 
				flag=1;
			if(i==50)
				flag=0;
			x1=i;
			if(flag==0)
				i++;
			else i--;
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
