import java.io.*;
class binary_search
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of elements:");
        int size=Integer.parseInt(in.readLine());
        int a[]=new int[size];
        for(int i=0;i<size;i++)
        {
            System.out.println("Enter number:");
            a[i]=Integer.parseInt(in.readLine());
        }
        for(int i=0;i<size-1;i++)
        {
            for(int j=0;j<size-1-i;j++)
            {
                if(a[j]>a[j+1])
                {
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
        System.out.println("Numbers are:");
        for(int i=0;i<size;i++)
        {
            System.out.print(a[i]+"\t");
        }
        System.out.println();
        System.out.println("Enter number to be searched for:");
        int val=Integer.parseInt(in.readLine());
        int mid,lb=0,ub=size-1,pos=-1;
        while(pos==-1&&lb<=ub)
        {
            mid=(lb+ub)/2;
            if(a[mid]==val)
            {
                pos=mid;
                break;
            }
            else if(a[mid]>val)
            {
                ub=mid-1;
            }
            else if(a[mid]<val)
            {
                lb=mid+1;
            }
        }
        if(pos!=-1)
            System.out.println("Number found at position:"+(pos+1));
        else
            System.out.println("Number not found");
        }
    }
        