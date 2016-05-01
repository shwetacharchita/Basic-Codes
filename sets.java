import java.io.*;
class sets
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of elements in first set:");
        int x1=Integer.parseInt(in.readLine());
        System.out.println("Enter the number of elements in second set:");
        int x2=Integer.parseInt(in.readLine());
        String a[]=new String[x1];
        String b[]=new String[x2];
        System.out.println("Enter elements for the first set:");
        for(int i=0;i<x1;i++)                                                       //entering first set
        {
            System.out.println("Enter element:");
            a[i]=in.readLine();
        }
        System.out.println("\nEnter elements for the second set:");
        for(int i=0;i<x2;i++)                                                       //entering second set
        {
            System.out.println("Enter element:");
            b[i]=in.readLine();
        }
        System.out.println("\nFirst Set:");
        System.out.print("A={");                                                //displaying first set
        display(a);
        System.out.println("}");
        String c[][]=new String[x1][2];
        int k=0;
        for(int i=0;i<x1;i++)
        {
            String s=a[i];
            int cnt=1;
            if(!(s.equals("*")))                                        //counting multiplicity of the unique elements for first set
            {
               for(int j=i+1;j<x1;j++)
               {
                   if(a[j].equals(s))
                   {
                       a[j]="*";
                       cnt++;
                    }                    
                }
                c[k][0]=s;
                c[k][1]=s.valueOf(cnt);                                 //storing them in an array 'c'
                k++;
            }
        }
       /* System.out.println();
        display(a);
        System.out.println();
        display(c,k,2);*/
        System.out.println();
        System.out.println("\nSecond set:");                        //displaying second set
        System.out.print("B={");
        display(b);
        System.out.println("}");
        String d[][]=new String[x2][2];
        int m=0;
        for(int i=0;i<x2;i++)                                              //counting multiplicity of the unique elements for second set
        {
            String s=b[i];
            int cnt=1;
            if(!(s.equals("#")))
            {
               for(int j=i+1;j<x2;j++)
               {
                   if(b[j].equals(s))
                   {
                       b[j]="#";
                       cnt++;
                    }                    
                }
                d[m][0]=s;                                                  //storing them in an array 'd'
                d[m][1]=s.valueOf(cnt);
                m++;
            }
        }
        /*System.out.println();
        display(b);
        System.out.println();
        display(d,m,2);*/
        int op=0,u=0,v=0;
        String union[][]=new String[k+m][2];
        String intrs[][]=new String[k+m][2];
        for(int i=0;i<k+m;i++)
        {
            for(int j=0;j<2;j++)
            {
                union[i][j]="";
                intrs[i][j]="";
            }
        }
        while(op!=6)
        {
            System.out.println("\nMenu:\n1.Union\n2.Intersection\n3.Difference\n4.Symmeteric Difference\n5.Sum\n6.Exit");
            op=Integer.parseInt(in.readLine());
            switch(op)
            {
                case 1:
                         String s="";
                         for(int i=0;i<k;i++)
                         {
                             int flag=0;
                             union[u][0]=c[i][0];
                             for(int j=0;j<m;j++)
                             {
                                 if(c[i][0].equals(d[j][0]))
                                 {
                                    int x=Integer.parseInt(c[i][1]);
                                    int y=Integer.parseInt(d[i][1]);
                                    int z=x>y?x:y;
                                    union[u][1]=s.valueOf(z);
                                    flag=1;
                                    break;
                                 }
                             }
                             if(flag==0)
                             {
                                union[u][1]=c[i][1];
                             }
                             u++;
                         }
                         for(int i=0;i<m;i++)
                         {
                             int j,flag=0;
                             for(j=0;j<u;j++)
                             {
                                if(d[i][0].equals(union[j][0]))
                                {
                                    int x=Integer.parseInt(d[i][1]);
                                    int y=Integer.parseInt(union[j][1]);
                                    if(x<y)
                                    {
                                        flag=1;
                                        break;
                                    }
                                    else
                                    {
                                        union[j][1]=d[i][1];
                                    }
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0)
                            {
                                union[u][0]=d[i][0];
                                union[u][1]=d[i][1];
                                u++;
                            }
                        }
                       // display(union,u,2);
                        int size=0,l=0;
                        for(int i=0;i<u;i++)
                        {
                            size=size+Integer.parseInt(union[i][1]);
                        }
                        String Union[]=new String[size];                            
                        for(int i=0;i<u;i++)
                        {
                            int x=Integer.parseInt(union[i][1]);
                            for(int j=0;j<x;j++)
                            {
                                Union[l++]=union[i][0];
                            }
                        }
                        System.out.print("\nUnion={");                              //displaying union
                        display(Union);
                        System.out.println("}");
                        break;
                case 2:
                        String ss="";
                        for(int i=0;i<k;i++)
                        {
                             for(int j=0;j<m;j++)
                             {
                                 if(c[i][0].equals(d[j][0]))
                                 {
                                    intrs[v][0]=c[i][0];
                                    int x=Integer.parseInt(c[i][1]);
                                    int y=Integer.parseInt(d[j][1]);
                                    int z=x<y?x:y;
                                    intrs[v++][1]=ss.valueOf(z);
                                    break;
                                 }
                             }
                        }
                        int size1=0,l1=0;
                        for(int i=0;i<v;i++)
                        {
                            size1=size1+Integer.parseInt(intrs[i][1]);
                        }
                        String Intersection[]=new String[size1];
                         for(int i=0;i<v;i++)
                        {
                            int x=Integer.parseInt(intrs[i][1]);
                            for(int j=0;j<x;j++)
                            {
                                Intersection[l1++]=intrs[i][0];
                            }
                        }                        
                        System.out.print("\nIntersection={");
                        display(Intersection);
                        System.out.println("}");
                        break;
                case 3:
                        int v1=0,size2=0,l2=0,f=0;
                        String s1="";
                        String diff[][]=new String[50][2];
                        for(int i=0;i<k;i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                if(c[i][0].equals(d[j][0]))
                                {
                                    int x=Integer.parseInt(c[i][1]);
                                    int y=Integer.parseInt(d[j][1]);
                                    int z=x-y;
                                    if(z>0)
                                    {
                                        diff[v1][0]=c[i][0];
                                        diff[v1++][1]=s1.valueOf(z);
                                        f=1;
                                        break;
                                    }
                                    f=1;
                                    break;
                                }
                            }
                            if(f==0)
                            {
                                diff[v1][0]=c[i][0];
                                diff[v1++][1]=c[i][1];
                            }
                            f=0;
                        }
                        for(int i=0;i<v1;i++)
                        {
                            size2=size2+Integer.parseInt(diff[i][1]);
                        }
                        String Difference[]=new String[size2];
                         for(int i=0;i<v1;i++)
                        {
                            int x=Integer.parseInt(diff[i][1]);
                            for(int j=0;j<x;j++)
                            {
                                Difference[l2++]=diff[i][0];
                            }
                        }
                        System.out.print("\nDifference={");
                        display(Difference);
                        System.out.println("}");
                        break;
                case 4:
                        int h=0,size4=0,l4=0,f1=0;
                        String sss="";
                        String sym[][]=new String[u][2];
                        for(int i=0;i<u;i++)
                        {
                            for(int j=0;j<v;j++)
                            {
                               if(union[i][0].equals(intrs[j][0]))
                               {
                                   int x=Integer.parseInt(union[i][1])-Integer.parseInt(intrs[j][1]);
                                   sym[h][0]=union[i][0];
                                   sym[h++][1]=sss.valueOf(x);
                                   f1=1;
                                   break;
                               }                  
                            }
                            if(f1==0)
                            {
                                sym[h][0]=union[i][0];
                                sym[h++][1]=union[i][1];
                            }
                            f1=0;
                        }
                         for(int i=0;i<h;i++)
                        {
                            size4=size4+Integer.parseInt(sym[i][1]);
                        }
                        String Sym_Diff[]=new String[size4];
                         for(int i=0;i<h;i++)
                        {
                            int x=Integer.parseInt(sym[i][1]);
                            for(int j=0;j<x;j++)
                            {
                                Sym_Diff[l4++]=sym[i][0];
                            }
                        }
                        System.out.print("\nSymmetric Difference={");
                        display(Sym_Diff);
                        System.out.println("}");
                        break;                                 
                        
                case 5:
                        int v2=0,u1,size3=0,l3=0,flag=0;
                        String s2="";
                        String sum[][]=new String[k+m][2];
                        for(int i=0;i<k;i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                if(c[i][0].equals(d[j][0]))
                                {
                                    int x=Integer.parseInt(c[i][1]);
                                    int y=Integer.parseInt(d[j][1]);
                                    int z=x+y;
                                    sum[v2][0]=c[i][0];
                                    sum[v2++][1]=s2.valueOf(z);
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0)
                            {
                                sum[v2][0]=c[i][0];
                                sum[v2++][1]=c[i][1];
                            }
                            flag=0;
                        }
                        u1=v2;
                         for(int i=0;i<m;i++)
                        {
                            for(int j=0;j<u1;j++)
                            {
                                if(d[i][0].equals(sum[j][0]))
                                {
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0)
                            {
                                sum[v2][0]=d[i][0];
                                sum[v2++][1]=d[i][1];
                            }
                            flag=0;
                        }
                        for(int i=0;i<v2;i++)
                        {
                            size3=size3+Integer.parseInt(sum[i][1]);
                        }
                        String Sum[]=new String[size3];
                         for(int i=0;i<v2;i++)
                        {
                            int x=Integer.parseInt(sum[i][1]);
                            for(int j=0;j<x;j++)
                            {
                                Sum[l3++]=sum[i][0];
                            }
                        }
                        System.out.print("\nSum={");
                        display(Sum);
                        System.out.println("}");
                        break;
                case 6:
                        break;
                default: System.out.println("Invalid choice");
                            break;
            }                                   
                                    
        }                           
                             
    }
    public static void display(String a[])
    {
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+",\t");
        }
    }
     public static void display(String a[][],int r,int c)
    {
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.print(a[i][j]+",\t");
            }
            System.out.println();
        }
    }
    
                    
}

        