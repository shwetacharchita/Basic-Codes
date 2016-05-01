import java.io.*;
class generating_func
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Generating Function of Numeric Functions of type:\n1.Exponential: x^r\n2.Polynomial:Cor^0+C1r^1+C2r^2+...");
        int op=Integer.parseInt(in.readLine());
        switch(op)
        {
            case 1:
                     System.out.println("Enter value of x:");
                     int x=Integer.parseInt(in.readLine());
                     System.out.println("Enter value of r till which function is to be generated:");
                     int r=Integer.parseInt(in.readLine());
                     System.out.println("Generating function:");
                     for(int i=0;i<=r;i++)
                     {
                         int a=xfn(x,i);
                         System.out.print(a+"z^"+i);
                         if(i!=r)
                            System.out.print("\t+\t");
                     }
                     break;
            case 2:
                    System.out.println("Enter value of degree till which function is to be generated:");
                    int d=Integer.parseInt(in.readLine());
                    float rhs[]=new float[d+1];
                    for(int i=0;i<=d;i++)
                    {
                        System.out.println("Enter coefficient for r^"+i+":");
                        rhs[i]=Float.parseFloat(in.readLine());
                    }
                    float z=0;
                    System.out.println("Generating function:");
                    for(int i=0;i<=d;i++)
                    {
                        for(int j=0;j<=d;j++)
                        {
                            z+=rhs[j]*xfn(i,j);
                        }
                        System.out.print(z+"z^"+i);
                        if(i!=d)
                           System.out.print("\t+\t");
                        z=0;
                    }
                    break;
            default:System.out.println("Invalid choice!");
        }
    }
    public static int xfn(int a,int i)
    {
        int val=1;
        for(int j=0;j<i;j++)
        {
            val*=a;
        }
        return val;
    }
}