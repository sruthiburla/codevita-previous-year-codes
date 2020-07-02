/*Game of Primes
In a global Mathematics contest, the contestants are told to invent some special numbers which can be built by adding the squares of its digits. Doing this perpetually, the numbers will end up to 1 or 4.
If a positive integer ends with 1, then it is called the Number of Game.

An example from above is:

13 = 1^2 + 3^2 = 1+9 = 10 (Step:1)
10 = 1^2 + 0^2 = 1+0 = 1 (Step:2), iteration ends in Step 2 since number ends with 1
Then in next round, the contestants are asked to combine their newly invented number, i.e. Number of Game with prime number.

Now, being a smart programmer, write a program to help the contestants to find out the Nth combined number within any given range, where N can be any integer.

Input Format:
Input consists of 3 integers X, Y, N, one on each line. X and Y are upper and lower limits of the range. The range is inclusive of both X and Y. Find Nth number in range [X,Y].

Line 1: X, where X is the upper limit of the range
Line 2: Y, where Y is the lower limit of the range
Line 3: N, where Nth element of the series is required

Constraints
X <= Y
X > 0
N > 0
Output Format:
Output will show the Nth element of the combined series lying in the range between X and Y.

Line 1

For Valid Input,print

U, where U is the Nth element of the combined number series lying in the range between X and Y.

Or

No number is present at this index

For Invalid Input, print

Invalid Input

Sample Input / Output
Input

1
30
3

Output

19

Input

12
33
5

Output

No number is present at this index

Input

-5
@
4

Output

Invalid Input*/
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