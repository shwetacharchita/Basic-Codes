import java.io.*; 
class Transitive_Closure
{
    int tr_m[][];
    int n;
    public static final int INFINITY = 999;
     public Transitive_Closure(int n)
    {
        tr_m= new int[n + 1][n + 1];
        this.n = n;
    } 
    public void tr_cl(int ad_m[][])
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                tr_m[i][j] =ad_m[i][j];
            }
        } 
        for(int k=1;k<=n;k++)
        {
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if (tr_m[i][k]+tr_m[k][j]<tr_m[i][j])
                            tr_m[i][j] = tr_m[i][k]+tr_m[k][j];                                
                }
            }
        } 
        for(int i =1; i<= n; i++)
            System.out.print("\t" + i); 
        System.out.println();
        for (int i = 1; i <= n; i++)
        {
            System.out.print(i + "\t");
            for (int j = 1; j <= n; j++)
            {
                System.out.print(tr_m[i][j] + "\t");
            }
            System.out.println();
        }
    } 
    public static void main(String[]args)throws IOException
    {
        int ad_m[][];
        int n; 
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of vertices");
        n = Integer.parseInt(in.readLine());
        ad_m = new int[n + 1][n + 1]; 
        System.out.println("Enter the Weighted Matrix for the graph");
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                ad_m[i][j] = Integer.parseInt(in.readLine());
                if (i == j)
                {
                    ad_m[i][j] = 0;
                    continue;
                }
                if (ad_m[i][j] == 0)
                {
                    ad_m[i][j] = INFINITY;
                }
            }
        } 
        System.out.println("The Transitive Closure of the Graph"); 
        Transitive_Closure tr_cl = new Transitive_Closure(n);
        tr_cl.tr_cl(ad_m);
    }
}