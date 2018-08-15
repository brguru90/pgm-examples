using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace c2
{
    class Program
    {

        public static String[] number = new String[] { "","one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "therteen", "fourteen", "fifteen", "sixtenn", "seventeen", "eighteen", "ninteen", "twenty" };
        public static String[] pos2 = new String[] {"","", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy","eighty", "ninty" };

        static void Main(string[] args)
        {
           
            try
            {
                Console.WriteLine("a: ");
                int a = Int32.Parse(Console.ReadLine().ToString());
                Console.WriteLine("b: ");
                int b = Int32.Parse(Console.ReadLine().ToString());
                doit(a, b);
            }
            catch (Exception e) { }
           
            
            Console.ReadLine();
        }
        public static void spell(int n)
        {
            String num = n.ToString() ;
            char[] arr = num.ToCharArray();
            Array.Reverse(arr);
            num = string.Join("", arr);
            for (int i = num.Length-1; i >= 0; i--)
            {
                if(i==0)
                    Console.Write(number[Int32.Parse(num[i]+"")]);
                if(i==4)
                    Console.Write(pos2[Int32.Parse(num[i]+"")]);
                if(i==3)
                    Console.Write(number[Int32.Parse(num[i]+"")]+" Thousand");
                if(i==2 && Int32.Parse(num[i]+"")!=0)
                    Console.Write(number[Int32.Parse(num[i]+"")] + " Hundred");
                if (i == 1)
                    if(Int32.Parse(num[i] + "" + num[i - 1]) < 20)
                        Console.Write(number[Int32.Parse(num[i--] + "" + num[i])]);
                    else
                        Console.Write(pos2[Int32.Parse(num[i] + "")]);
                Console.Write(" ");
            }
        }
        public static void doit(int a, int b)
        {
            if (a > 99999 || b > 99999)
                return;
            Console.Write(a+"\t");
            spell(a);
            Console.WriteLine();
            Console.Write(b+"\t");
            spell(b);
            Console.WriteLine("\n");
            doit(a*2, b*2);
        }
    }
    
}
