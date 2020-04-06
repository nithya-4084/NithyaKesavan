import java.util.*;
public class Test
{
  	public static void main(String[] args)
	   {
		Scanner ip = new Scanner(System.in);
		int n;
		int iterNum = 0;
		n = ip.nextInt();
		System.out.println(n + " ");
		if (n > 0)
	 	{
			while (n != 1)
			 {
				n = test(n);
				System.out.println(n + " ");
				iterNum++;
			}
	 		System.out.println("");
		}
	}
	static int test(int n)
	{
		if (n % 2 == 0)
		{
			return n / 2;
	   	}
		else
		{
			return 3 * n + 1;
		   }
  	}
}