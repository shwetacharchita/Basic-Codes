import java.io.*;
class convolution
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Convolution of Numeric Functions of type x^r, i.e\na^r*b^r");
        System.out.println("Enter value of a:");
        int a=Integer.parseInt(in.readLine());
        System.out.println("Enter value of b:");
        int b=Integer.parseInt(in.readLine());
        System.out.println("Enter value of r:");
        int r=Integer.parseInt(in.readLine());
        int c,sum=0;
        for(int i=0;i<=r;i++)
        {
            c=afn(a,i)*bfn(b,r-i);
            sum+=c;
        }
        System.out.println("Convolution of a^r and b^r for r:"+r+"="+sum);
    }
    public static int afn(int a,int i)
    {
        int val=1;
        for(int j=0;j<i;j++)
        {
            val*=a;
        }
        return val;
    }
    public static int bfn(int b,int i)
    {
        int val=1;
        for(int j=0;j<i;j++)
        {
            val*=b;
        }
        return val;
    }
}
         
        