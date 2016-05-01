import java.io.*;
class decoding
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of encoded word:");
        int n=Integer.parseInt(in.readLine());
        System.out.println("Enter received word:");
        int r=Integer.parseInt(in.readLine());
        int y=r;
        int w[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            w[i]=r%10;
            r=r/10;
        }
        int z=(int)Math.pow(2.0,(double)n);
        int x[][]=new int[z][n];
        for(int i=0;i<z;i++)
        {
            int a=i;
           for(int j=n-1;j>=0;j--)
           {
               x[i][j]=a%2;
               a=a/2;
            }
        }
        int s;
        if(n%2==0)
            s=n;
        else
            s=n-1;
        int small=1,a=0,val[]=new int[n],b[]=new int[n],q=4;
        int leaders[][]=new int[s][4];
        int gc[][]={{0,0,0,0},{0,0,1,1},{1,1,0,1},{1,1,1,0}};
        int coset[][]={{0,0,0,0},{0,0,1,1},{1,1,0,1},{1,1,1,0}};
        System.out.println("Group Code:");
        for(int l=0;l<4;l++)
        {
                for(int j=0;j<n;j++)
                                System.out.print(gc[l][j]);
                System.out.println();
        }
        for(int i=0;i<s;i++)
        {
             if(i!=0)           
             {
                small=1;  
                for(int j=0;j<4;j++)
                {
                   for(int k=0;k<n;k++)
                   {
                       if(x[q][k]!=gc[j][k])
                            coset[j][k]=1;
                        else
                            coset[j][k]=0;
                    }
                }
                q=q+4;
             }
             System.out.println("Coset "+(i+1)+"=");
             for(int l=0;l<4;l++)
             {
                    for(int k=0;k<n;k++)
                                System.out.print(coset[l][k]);
                    System.out.println();
             }
             int p=0;
            for(int j=0;j<4;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a+=coset[j][k];
                    b[p]=coset[j][k];   
                    p=p+1;
                }
                if(a<=small)
                {
                    small=a;
                   for(int o=0;o<n;o++)
                   {
                       val[o]=b[o];
                    }
                }              
                a=0;
                p=0;
            }
            for(int o=0;o<n;o++)
            {
                  leaders[i][o]=val[o];
            }
        }
        System.out.println("Leaders of each coset:");
        for(int i=0;i<s;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(leaders[i][j]);
                System.out.println();
        }
        int trans[]=new int[n];
        small=1;
        a=0;int c=0;
        for(int i=0;i<s;i++)
        {  
            for(int j=0;j<n;j++)
            {
                   if(w[n-1-j]!=leaders[i][j])
                       trans[j]=1;
                    else
                        trans[j]=0;
            }
             System.out.print("Transmitted word according to Coset "+(i+1)+" is:");
             for(int p=0;p<n;p++)
             {
                  System.out.print(trans[p]);
            }          
          System.out.println();
        }
       
    }
}
