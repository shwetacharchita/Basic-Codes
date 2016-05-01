import java.io.*;
class merge_sort
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
        System.out.println("Unsorted Numbers are:");
        for(int i=0;i<size;i++)
        {
            System.out.print(a[i]+"\t");
        }    
        partition(a,0,size-1,size);
        System.out.println("\nNumbers after Merge sort are:");
        for(int i=0;i<size;i++)
        {
            System.out.print(a[i]+"\t");
        }    
    }
    public static void partition(int a[],int start,int end,int size)
    {
        if(size>2)
        {
            int mid=(start+end)/2;
            size=size/2;
            partition(a,start,mid,size);
            partition(a,mid,end,size);
        }
        sort(a,start,end,size);
    }
    public static void sort(int a[],int start,int end,int n)
    {
        for(int i=start;i<end;i++)
        {
            for(int j=start;j<end-i+start;j++)
            {
                if(a[j]>a[j+1])
                {
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }
}
        