import java.io.*;
class strassen
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int a[][]=new int[2][2],b[][]=new int[2][2],c[][]=new int[2][2],i,j;
        int m1,m2,m3,m4,m5,m6,m7;
        System.out.println("Enter the 4 elements of first matrix: ");
        for(i=0;i<2;i++)
            for(j=0;j<2;j++)
                a[i][j]=Integer.parseInt(in.readLine());
        System.out.println("Enter the 4 elements of second matrix: ");
        for(i=0;i<2;i++)
            for(j=0;j<2;j++)
                b[i][j]=Integer.parseInt(in.readLine());
        System.out.println("\nThe first matrix is");
        for(i=0;i<2;i++)
        {
           for(j=0;j<2;j++)
                System.out.print(a[i][j]+"\t");
           System.out.println();
        }
        System.out.println("\nThe second matrix is");
        for(i=0;i<2;i++)
        {
           for(j=0;j<2;j++)
                System.out.print(b[i][j]+"\t");
           System.out.println();
        }
        m1= (a[0][0] + a[1][1])*(b[0][0]+b[1][1]);
        m2= (a[1][0]+a[1][1])*b[0][0];
        m3= a[0][0]*(b[0][1]-b[1][1]);
        m4= a[1][1]*(b[1][0]-b[0][0]);
        m5= (a[0][0]+a[0][1])*b[1][1];
        m6= (a[1][0]-a[0][0])*(b[0][0]+b[0][1]);
        m7= (a[0][1]-a[1][1])*(b[1][0]+b[1][1]);
        c[0][0]=m1+m4-m5+m7;
        c[0][1]=m3+m5;
        c[1][0]=m2+m4;
        c[1][1]=m1-m2+m3+m6;  
        System.out.println("\nAfter multiplication using Strassen's Algorithm:");
        for(i=0;i<2;i++)
        {
           for(j=0;j<2;j++)
                System.out.print(c[i][j]+"\t");
           System.out.println();
        }
    }
}