import java.io.*;
class hash
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of data elements to be stored:");
        int n=Integer.parseInt(in.readLine());
        System.out.println("Enter size of memory:");
        int size=Integer.parseInt(in.readLine());
        int num[]=new int[n];
        int h[]=new int[size];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter number:");
            num[i]=Integer.parseInt(in.readLine());
        }
        for(int i=0;i<size;i++)
        {
           h[i]=0;
        }
        int k=1;
        for(int i=0;i<n;i++)
        {
            int ad=num[i]%size;
            if(h[ad]==0)
                h[ad]=num[i];
            else
            {
                while(h[ad]!=0)
                {
                    ad=(ad+k)%size;
                    k++;
                }
                h[ad]=num[i];
                k=1;
            }
        }
        System.out.println("Hash Addresses according to Division Method:");
        for(int i=0;i<size;i++)
        {
            if(h[i]!=0)
            {
                System.out.println("Address of "+h[i]+" is="+i);
            }
        }
        for(int i=0;i<size;i++)
        {
           h[i]=0;
        }
        int l=1;
        for(int i=0;i<n;i++)
        {
            int sq1=num[i]*num[i],sq2=sq1,c=0;
            while(sq2!=0)
            {
                sq2=sq2/10;
                c++;
            }
            int m;
            if(c%2==0)
            {
                m=c/2-1;
            }
            else
            {
                m=c/2;
            }
            int x=c-m*2;
            double z=Math.pow(10.0,(double)m);
            sq1=sq1/(int)z;
            z=Math.pow(10.0,(double)x);
            int ad=sq1%(int)z;        
            if(h[ad]==0)
                h[ad]=num[i];
            else
            {
                while(h[ad]!=0)
                {
                    ad=(ad+l)%size;
                    l++;
                }
                h[ad]=num[i];
                l=1;
            }
        }
        System.out.println("Hash Addresses according to Mid-Square Method:");
        for(int i=0;i<size;i++)
        {
            if(h[i]!=0)
            {
                System.out.println("Address of "+h[i]+" is="+i);
            }
        }
         for(int i=0;i<size;i++)
        {
           h[i]=0;
        }
        int b=1;
        for(int i=0;i<n;i++)
        {
            int s1=num[i],s2=num[i],c=0;
            while(s1!=0)
            {
                s1=s1/10;
                c++;
            }
            int m=c/2,sum=0;
            double z=Math.pow(10.0,(double)m);
            while(s2>(int)z)
            {
                sum+=s2%(int)z;
                s2=s2/(int)z;
            }    
            sum+=s2;
            int ad=sum;
            if(h[ad]==0)
                h[ad]=num[i];
            else
            {
                while(h[ad]!=0)
                {
                    ad=(ad+b)%size;
                    b++;
                }
                h[ad]=num[i];
                b=1;
            }
        }
        System.out.println("Hash Addresses according to Folding Method:");
        for(int i=0;i<size;i++)
        {
            if(h[i]!=0)
            {
                System.out.println("Address of "+h[i]+" is="+i);
            }
        }
    }
}
        
           