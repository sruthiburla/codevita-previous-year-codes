import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        try
        {
            int low=0,up=0,n=0;
            boolean flag=false;
            try
            { low=Integer.parseInt(s.nextLine().trim()); }
            catch(Exception e)
            { flag=true; }
            try
            { up=Integer.parseInt(s.nextLine().trim()); }
            catch(Exception e)
            { flag=true; }
            try
            { n=Integer.parseInt(s.nextLine().trim()); }
            catch(Exception e)
            { flag=true; }
            if(flag)
                throw new Exception();
            if(low>up || low<=0 || n<=0)
                throw new Exception();
            int count=0,i=low;
            for(;i<=up;i++)
            {
                if(pri(i) && get(i)==1)
                {
                    count++;
                    if(count==n)
                    {
                        System.out.println(i);
                        break;
                    }
                }
            }
            if(i>up)
                System.out.println("No number is present at this index");
        }
        catch(Exception e)
        { System.out.println("Invalid Input"); }
    }
    public static boolean pri(int n)
    {
        boolean flag=false;
        if(n<2)
            return flag;
        if(n==2)
            return true;
        if(n%2==0)
            return flag;
        int i=3;
        int root=(int)Math.sqrt(n);
        for(;i<=root;i+=2)
        {
            if(n%i==0)
                break;
        }
        if(i>root)
            flag=true;
        return flag;
    }
    static int get(int y)
    {
        if(y<=4)
            return y;
        if(y==10)
            return 1;
        String st=y+"";
        char[] c=st.trim().toCharArray();
        int sum=0;
        for(int i=0;i<c.length;i++)
            sum+=Math.pow(Integer.parseInt(c[i]+"".trim()),2);
        sum=get(sum);
        return sum;
    }
}