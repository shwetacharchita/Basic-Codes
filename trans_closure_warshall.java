import java.io.*;
class trans_closure_warshall
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of elements in the set:");
        int size=Integer.parseInt(in.readLine());
        int r[][]=new int[size][size];
        char c[]=new char[size];
        char a='a';
        for(int i=0;i<size;i++)
        {
            c[i]=(char)a++;
        }
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.println("Is there a relation between "+c[i]+" and "+c[j]+" ?:");
                r[i][j]=Integer.parseInt(in.readLine());
            }
        }
        System.out.println("Relational Matrix:\n");
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(r[i][j]+"\t");
            }
            System.out.println();
        }
        for(int m=0;m<size;m++)
        {
            for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++)
                {
                    if(r[j][i]==1)
                    {
                        for(int k=0;k<size;k++)
                        {
                            if(r[i][k]==1)
                            {
                                if(r[j][k]==0)
                                    r[j][k]=1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Relational Matrix with Transitive closure using Warshall's Algorithm:\n");
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(r[i][j]+"\t");
            }
            System.out.println();
        }
        
    }
}