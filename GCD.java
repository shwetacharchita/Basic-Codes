import java.io.*;
class GCD
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first number:");
        int x=Integer.parseInt(in.readLine());
        System.out.println("Enter secong number:");
        int y=Integer.parseInt(in.readLine());
        int gcd;
        if(x>y)
        {
            gcd=Gcd(y,x);
        }
        else
        {
            gcd=Gcd(x,y);
        }
        System.out.println("Greatest Common Divisor="+gcd);
        int lcm=(x*y)/gcd;
        System.out.println("Least Common Multiple is="+lcm);
    }
    public static int Gcd(int x,int y)
    {
        if(y==0)
            return x;
        else
            return Gcd(y,x%y);
    }
}