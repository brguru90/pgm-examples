package code;

import java.util.Scanner;

public class code2 {
public static void main(String args[])
{
	
	 Scanner sc = new Scanner(System.in);
	 System.out.println("Enter");
     long sum = 0;

     int N = sc.nextInt();
     if(N>=1 && N<=Math.pow(10,7))
     for (int i = 0; i < N; i++) {

    	 
         long x = sc.nextLong(); // read input
         while(!(x>=1 && x<=Math.pow(10,18)))
        	 x = sc.nextLong();
         String str = Long.toString((long) Math.pow(1 << 1, x));
        // System.out.println(str);

         str = str.length() > 2 ? str.substring(str.length() - 2) : str;

         sum += Integer.parseInt(str);

     }

     System.out.println(sum%100);
}
	
}
