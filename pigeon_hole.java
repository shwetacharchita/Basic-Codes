import java.io.*;
class pigeon_hole
{
    public static void main(String[]args)throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of elements in domain:");
        int x=Integer.parseInt(in.readLine());
        System.out.println("Enter the number of elements in range:");
        int y=Integer.parseInt(in.readLine());
        int z=(x-1)/y;
        z+=1;
        System.out.println("Each element in the range will be an image to at least "+z+" elements in the domain");
    }
}