
package util3;

import java.util.Scanner;
import static util3.Util3.InitiateTableIntRandom;

/**
 * @author mathieu
 */
public class test {
    
    
    
    //--------------------------------------------------------------------------
//---------------------  Test               --------------------------------
//--------------------------------------------------------------------------


        public static void testScanner()
    {
    Scanner scan = new Scanner(System.in);

    System.out.println(" Saisir une ligne :");
    String text=scanner.scanLine(scan);
    System.out.println(text);

    System.out.println(" Saisir une mot :");
     text=scanner.scannext(scan);
    System.out.println(text);

    System.out.println(" Saisir un int :");
    int nb=scanner.scanINT(scan);
    System.out.println(nb);

    System.out.println(" Saisir un double :");
    double nb1=scanner.scanDOUBLE(scan);
    System.out.println(nb1);

    }

    /**
     *
     */
    public static void testInitiatetable()
    {
     int x=10,y=10;
     int[][] table=InitiateTableIntRandom(x, y);
     Util3. printTableInt(table,x,y);

    }
    
    
    
    
    
    
    
    
}