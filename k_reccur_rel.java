import java.io.*;
class k_reccur_rel
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Recurrence Relation of Polynomial Type:");
        System.out.println("Enter order:");
        int k=Integer.parseInt(in.readLine());
        float cof[]=new float[100];
        float term[]=new float[100];
        float bound[][]=new float[k][2];
        float rhs[]=new float[100];
        for(int i=0;i<k+1;i++)
        {
            System.out.println("Enter coefficient of a(r-"+(k-i)+"):");
            cof[i]=Float.parseFloat(in.readLine());
        }
        for(int i=0;i<k+1;i++)
        {
            term[i]=0;
        }        
        System.out.println("For boundary conditions:");
        for(int i=0;i<k;i++)
        {
            System.out.println("Enter the term:");
            int pos=Integer.parseInt(in.readLine());
            bound[i][1]=pos;
            System.out.println("Enter the value of that term:");
            term[pos]=Float.parseFloat(in.readLine());
            bound[i][0]=term[pos];
        }
        for(int i=0;i<k-1;i++)
        {
            for(int j=0;j<k-1-i;j++)
            {
                if(bound[j][1]>bound[j+1][1])
                {
                    float t=bound[j][1];
                    bound[j][1]=bound[j+1][1];
                    bound[j+1][1]=t;
                }
            }
        }
        for(int i=0;i<k+1;i++)
        {
            System.out.println("Enter coefficient of RHS term for r^"+i+":");
            rhs[i]=Float.parseFloat(in.readLine());
        }
        System.out.println("Recurrence Relation elements before solving:");
        for(int i=k;i>=0;i--)
        {
            System.out.print(cof[i]+"a(r-"+(k-i)+")");
            if(i!=0)
                System.out.print("\t+\t");
        } 
        System.out.print("=");
        for(int i=0;i<k+1;i++)
        {
            System.out.print(rhs[i]+"r^"+i);
            if(i!=k)
                System.out.print("\t+\t");
        } 
        System.out.println("\nBoundary conditions:");
        for(int i=0;i<100;i++)
        {
            if(term[i]!=0)
                System.out.println("a"+i+"="+term[i]);
        }
        System.out.println("Enter term till which you want to find values:");
        int t=Integer.parseInt(in.readLine());
        int m=0;
        float lhs=0,rh=0;
        for(int i=(int)bound[m][1];i>0;i--)
        {
            for(int j=0;j<k;j++)
            {
                lhs=lhs+cof[k-j]*term[(int)bound[k-j-1][1]-m];
            }
              int n=1;
            for(int j=0;j<k+1;j++)
            {
               rh=rh+rhs[j]*pow(bound[k-1][1]-m,j);                        
            }
            term[i-1]=(rh-lhs)/cof[0];
            System.out.println("a"+(i-1)+"="+term[i-1]);
            lhs=0;
            rh=0;
            m++;
        }                
    }
    public static float pow(float a,float b)
    {
        float x=1;
        for(int i=1;i<=b;i++)
        {
            x*=a;
        }
        return x;
    }
}
        
        