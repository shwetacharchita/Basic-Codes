import java.io.*;
class func
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of elements in domain:");
        int x=Integer.parseInt(in.readLine());
        System.out.println("Enter the number of elements in range:");
        int y=Integer.parseInt(in.readLine());
        int r[][]=new int[x][y];
        char c[]=new char[x];
        char d[]=new char[y];
        char a='a';
        for(int i=0;i<x;i++)
        {
            c[i]=(char)a++;
        }
         for(int i=0;i<y;i++)
        {
            d[i]=(char)a++;
        }
        System.out.print("Domain:\naD={");
         for(int i=0;i<x;i++)
        {
            System.out.print(c[i]+", ");
        }
        System.out.println(" }");
        System.out.print("Range:\nR={");
         for(int i=0;i<y;i++)
        {
            System.out.print(d[i]+", ");
        }
        System.out.println(" }");    
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                System.out.println("Is "+d[j]+" an image of "+c[i]+" ?:");
                r[i][j]=Integer.parseInt(in.readLine());
            }
        }
        System.out.println("Functional Matrix:\n");
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                System.out.print(r[i][j]+"\t");
            }
            System.out.println();
        }
       int sum=0,flag=0;
        if(x>=y)
        {
             for(int i=0;i<x;i++)
            {
                 for(int j=0;j<y;j++)
                {
                    sum+=r[i][j];
                }
                if(sum<1)
                {
                    flag=1;
                    break;
                }
                sum=0;
            }
            if(flag==0)
            System.out.println("It is an onto-function!");
        }
        sum=0;flag=0;
        if(x<=y)
        {
            for(int i=0;i<y;i++)
            {
                 for(int j=0;j<x;j++)
                {
                    sum+=r[j][i];
                }
                if(sum!=1&&sum!=0)
                {
                    flag=1;
                    break;
                }
                sum=0;
            }
            if(flag==0)
                System.out.println("It is a one-one function!");
        }
    }
}