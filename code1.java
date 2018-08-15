package code;

import java.util.Scanner;

public class code1 {
public static void main(String args[])
{
    try {
    int c=0;
     Scanner sc = new Scanner(System.in);
    // System.out.println("Enter");
     int N = sc.nextInt();
     if(N>40) return;
     int a[]=new int[361*2];
     for (int i = 0; i <=360*2; i++)
     {
         a[i]=0;
     }
     String line=sc.next();
     String[] ang=line.split(",");
     for (int i = 0; i < N; i++) {       
         int x = Integer.parseInt(ang[i]); // read input
         if(!(x>(-89) && x<=90)) return;
         if(x>=0)
             a[x+360]++;       
         else
             a[Math.abs(x)]++;
     }
     for (int i = 1; i <= 360*2; i++) {
         if(a[i]>=2)
         {
             for(int j=1;j<=360*2;j++)
             {
                 if(a[j]>=2 && i!=j)
                 {
                     c+=(a[i]-1)*(a[j]-1);
                     //System.out.println(i+"-"+j);
                 }
             }
         }
                 
     }
     System.out.println(c/2);
    }
    catch (Exception e) {
        // TODO: handle exception
    }
}
    
}
