import java.io.*;
class relations
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
        int res1=isRef(r);
        if(res1==1)
            System.out.println("Reflexive!");
        else
            System.out.println("Not Reflexive!");
        int res2=isSym(r);
        if(res2==1)
            System.out.println("Symmetric!");
        else
            System.out.println("Not Symmetric!");
        int res3=isTrans(r);
        if(res3==1)
            System.out.println("Transitive!");
        else
            System.out.println("Not Transitive!");
        if(res1==1&&res2==1&&res3==1)
            System.out.println("Equivalence Relation!");
            
    }
    public static int isRef(int r[][])
    {
        for(int i=0;i<r.length;i++)
        {
            for(int j=0;j<r.length;j++)
            {
                if(r[i][i]!=1)
                    return 0;
            }
        }
        return 1;
    }
    public static int isSym(int r[][])
    {
        for(int i=0;i<r.length;i++)
        {
            for(int j=0;j<r.length;j++)
            {
                if(r[i][j]==1)
                {
                    if(r[j][i]!=1)
                        return 0;
                }
            }
        }
        return 1;
    }
    public static int isTrans(int r[][])
    {
        for(int i=0;i<r.length;i++)
        {
            for(int j=0;j<r.length;j++)
            {
               if(r[i][j]==1)
                {
                    for(int k=0;k<r.length;k++)
                    {
                        if(r[j][k]==1)
                        {
                            if(r[i][k]==0)
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }
}