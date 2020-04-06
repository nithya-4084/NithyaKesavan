import java.util.*;
public class SpiralMatrix
{
    private static int row,col,first[][],i,j;
    private static boolean isClockwise = true;   
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        row = sc.nextInt();
        col=row;
        first = new int[row][col]; 
         
            for (i= 0; i < row; i++) 
               {
                  for (j = 0; j < col; j++) 
                { 
                   first[i][j] = sc.nextInt(); 

                 } 
               } 
              
        printSpiralElements();
    }
    private static void printSpiralElements()
    {     
        int i = row%2 == 0 ? row/2-1 : row/2;
        int j = isClockwise ? col%2 == 0 ? col/2-1 : col/2 : col/2;
        int direction=0, steps=1, currentStep=0, change=0; 
         
        for (int a = 0; a < row*col; a++)
        {
            if (i<0 || i>=row || j<0 || j>=col) break; 
            System.out.print(first[i][j]+" ");
            if (currentStep < steps) 
                currentStep++;
            else 
            {
                currentStep = 1;
                if (change == 1) steps++;
                change = (change+1) % 2;
                direction = (direction+1) % 4;
            }           
            switch (direction)
            {
            	case 0: i--; break;
                case 1: if(isClockwise) j++; else j--;                             break;
                case 2: i++; break;
                case 3: if(isClockwise) j--; else j++;                                break;
                case 4: i--; break;
            }
        }
    }
}
 