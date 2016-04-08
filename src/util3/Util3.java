
package util3;
import java.util.*;

/**
 * this class is a class with utility fonction.
 * @version Util 3.1
 * @author  Brion Mathieu

 */
public class Util3 {

 
 //--------------------------------------------------------------------------
 //--------------     Independante fonction           -----------------------
 //--------------------------------------------------------------------------
    /**@param min : the minimum
     * @param max : the maximim
     * @return a random integer between min and max
     */
    public static int rand(int min,int max)
    {Random r = new Random();
     return  min + r.nextInt(max - min);
    }

 //--------------------------------------------------------------------------
 //--------------   Help to initiate a table at 0     -----------------------
 //--------------------------------------------------------------------------

    /**
     * @param  x integer
     * @param  y integer
     * @return a array interger [x][y] with only 0
     */
public static  int[][] InitiateTableInt(int x,int y)
  {int table[][]=new int[x][y];
      for(int i=0;i<y;i++)
      {for(int j=0;j<y;j++)
        {table[i][j]=0;}
      }
      return table;
  }

    /**
     * @param x int
     * @param y int
     * @return a array interger [x][y] with random interger in each case
     */
    public static  int[][] InitiateTableIntRandom(int x,int y)
  {int table[][]=new int[x][y];
      for(int i=0;i<y;i++)
      { for(int j=0;j<y;j++)
        {table[i][j]=rand(0,9);}
      }
      return table;
  }

    /**
     * @param  x int
     * @param  y int
     * @return a array Double [x][y] with only 0
     */
    public static double[][] InitiateTableDouble(int x,int y)
  {
      double table[][]=new double[x][y];
      for(int i=0;i<y;i++)
          {for(int j=0;j<y;j++)
            {table[i][j]=0.0;}
          }
      return table;
  }
 //--------------------------------------------------------------------------
 //----------------    Help to print     ------------------------------------
 //--------------------------------------------------------------------------

    /**
     * @param x int
     * @param y int
     * @return
     */
     public static int dividemore(double x,double y)
    {if((x/y)-(int)(x/y)!=0)
        {return (int)(x/y)+1;}
          return (int)(x/y);
    }

  /**
     * @param table
     * @param x int
     * @param y int
     */
    public static void printTableInt(int table[][],int x,int y)
  {for(int i=0;i<y;i++)
      {for(int j=0;j<y;j++)
        {System.out.print(table[i][j]+" ");}
       System.out.println();
      }
  }

    /**
     * @param table
     * @param x
     * @param y
     */
    public static void printTableDouble(double table[][],int x,int y)
  {for(int i=0;i<y;i++)
      {for(int j=0;j<y;j++)
        {System.out.print(table[i][j]+" ");}
       System.out.println();
      }
  }

    /** @param x */
    public static void line(int x){for(int i=0;i<x;i++) {System.out.println();}}


    public static void afficher(LinkedList<String> texte)
    {for (int i=0;i<texte.size();i++) {System.out.println(texte.get(i));}}
    
//---------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------
}