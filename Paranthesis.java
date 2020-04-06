import java.io.*;
import java.util.*;
import java.math.*;
public class Paranthesis 
{
    public static void main(String[] args) 
      {
         System.out.println("Enter the number of paranthesis:");
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        tests:
        for(int i=0;i< t;i++)
           {
            String s = in.next();
            Stack<Character> stack = new Stack<>();
            for(char c:s.toCharArray())
            {
                if(c == '(')
                    stack.push(')');
                else if(c == '{')
                    stack.push('}');
                else if(c == '[')
                    stack.push(']');   
                else
                    {
                    if( stack.isEmpty() || c != stack.peek())
                      {
                        System.out.println("0");
                        continue tests;    
                       }
                    else
                      {
                        stack.pop();
                       }
                    }
            }
            if(stack.isEmpty())
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}