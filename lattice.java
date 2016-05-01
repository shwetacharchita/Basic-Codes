import java.io.*;
class lattice
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int size;
        System.out.println("Enter number of elements:");
        size=Integer.parseInt(in.readLine());
        int a[][]=new int[size][size];
        char c[]=new char[size];
        char d[]=new char[size];
        for(int i=0;i<size;i++)
        {
            System.out.println("Enter element:");
            c[i]=(char)in.read();
            d[i]=(char)in.read();
        }        
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.println("Is there relation between "+c[i]+" and "+c[j]+" ?\n1.Yes\n0.No");
                a[i][j]=Integer.parseInt(in.readLine());
            }
        }
        System.out.print("Set:\nA={ ");
        for(int i=0;i<size;i++)
        {
            System.out.print(c[i]+",\t");
        }
        System.out.println(" }");
        System.out.println("Relational Matrix is as follows:");
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        int flag=0,pos;
       outer1: for(int i=0;i<size-1;i++)
        {
           outer2: for(int j=i+1;j<size;j++)
            {
                if(a[i][j]==0)
                {
                   inner: for(int k=j+1;k<size;k++)
                    {
                        if(a[j][k]==1)
                        {
                            if(a[i][k]==1)
                            {
                                if(flag==0)
                                {
                                    flag=1;
                                
                                }
                                else
                                {
                                    System.out.println("Not a lattice as there is no unique Least Upper Bound for "+c[i]+" and "+ c[j]);
                                    flag=2;
                                    break outer1;
                                }
                            }
                        }
                    }
                }
                 flag=0;
            }
        }
       int fl=0;
       outer3: for(int i=size-1;i>=0;i--)
        {
           outer4: for(int j=i-1;j>=0;j--)
            {
                if(a[i][j]==0)
                {
                   inner: for(int k=j-1;k>=0;k--)
                    {
                        if(a[j][k]==1)
                        {
                            if(a[i][k]==1)
                            {
                                if(fl==0)
                                {
                                    fl=1;
                                
                                }
                                else
                                {
                                    System.out.println("Not a lattice as there is no unique Greatest Lower Bound for "+c[i]+" and "+ c[j]);
                                    fl=2;
                                    break outer3;
                                }
                            }
                        }
                    }
                }
                 fl=0;
            }
        }
        if(flag!=2&&fl!=2)
            System.out.println("It is a Lattice!");
    }       
}
            
        
                