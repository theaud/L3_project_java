
package util3;
import java.util.*;

/**
 *
 * @author mathieu
 */
public class scanner {
    
    
     //--------------------------------------------------------------------------
 //----------------Scanner with scan clear included-----------------------
 //--------------------------------------------------------------------------



    /**
 *  scanBoolean 
 * @param scan need:
 "import java.util.*" at the begining and
 "Scanner scan = new Scanner(System.in);" to define the scan. <br/>
 * - integer 0 2 = No other yes<br/>
 * -string Yes True y Y T t <br/>
 * -string No False n N f F <br/>
 * 
 *  @see
  *  scanBoolean(Scanner scan);<br/>
  *  scanINT(Scanner scan); <br/>
  *  scanDOUBLE(Scanner scan);<br/>
  *  Scanner DefineScanner();<br/>
  *  String scannext(Scanner scan);<br/>
  *  String scanLine(Scanner scan);<br/>
  *  scanINT(Scanner scan,int min,int max,int type);<br/>
  *  scanDOUBLE(Scanner scan,double less,double more,int type);<br/>
  *  scanINT(Scanner scan,int min,int max,int type);<br/>
  *  scanDOUBLE(Scanner scan,double less,double more,int type);
 * @return the value true/false 
 */
  public static boolean scanBoolean(Scanner scan)
  {

      int integer;
      String character;
  while(true)
    {if (scan.hasNextInt())
           {
            integer = scan.nextInt();
            scan.nextLine();
            if(integer==0 || integer==2)//false
                {
                   return false;
                }     
            else if(integer==1 )//true
                {
                   return true;
                }                  
           }
    else if(scan.hasNextLine())
            {
              character=scan.nextLine();
              scan.nextLine();
             char first_character = character.charAt(0);
             
             if(first_character=='f' || first_character=='F' ||
                first_character=='o' || first_character=='O' ||
                first_character=='n' || first_character=='N'
                )
                {
                   return false;
                }  
             else if(first_character=='y' || first_character=='Y' ||
                first_character=='t' || first_character=='T')
                {
                   return true;
                }
               else if(first_character=='h' || first_character=='H'|| first_character=='?')
                {
                   System.out.println("You wanted answer :");
                   System.out.println("True = 1   T t True  true  Yes yes Oui oui");
                   System.out.println("false= 0 2 F f False false No  no"); 
                }
             else
               {System.out.println("Invalid input. Please try again.");} 
            }
      else
           {
               System.out.println("Invalid input. Please try again.");
               scan.nextLine();
           }
    }
  }

  /**
 *  scanINT 
 * @param scan need:
 "import java.util.*" at the begining and
 "Scanner scan = new Scanner(System.in);" to define the scan. 
  *  @see
  *  scanBoolean(Scanner scan);<br/>
  *  scanINT(Scanner scan); <br/>
  *  scanDOUBLE(Scanner scan);<br/>
  *  Scanner DefineScanner();<br/>
  *  String scannext(Scanner scan);<br/>
  *  String scanLine(Scanner scan);<br/>
  *  scanINT(Scanner scan,int min,int max,int type);<br/>
  *  scanDOUBLE(Scanner scan,double less,double more,int type);<br/>
  *  scanINT(Scanner scan,int min,int max,int type);<br/>
  *  scanDOUBLE(Scanner scan,double less,double more,int type);
 * @return the value integer selected
 */
  public static int scanINT(Scanner scan)
  {
  int returned;
  while(true)
    {if (scan.hasNextInt())
           {
               returned = scan.nextInt();
                scan.nextLine();
               return returned;
           }
      else
           {
               System.out.println("Invalid input. Please try again.");
               scan.nextLine();
           }
    }
  }

/**
 *  scanINT 
 * @param scan NEED:
 "import java.util.*" at the begining and
 "Scanner scan = new Scanner(System.in);" to define the scan. 
 * @param min the minimum point (useless with type 0 or 3)
 * @param max the maximum point (useless with type 0 or 3)
         * @param type choose the type          <br/>
         *  type 0 = without less or more       <br/>
         *  type 1 = with less and  more        <br/>
         *  type 2 = with less no more          <br/>
         *  type 3 = no less but with more      <br/>

  *  @see
  *  scanBoolean(Scanner scan);<br/>
 
  *  scanINT(Scanner scan); <br/>
  *  scanDOUBLE(Scanner scan);<br/>
  *  Scanner DefineScanner();<br/>
  *  String scannext(Scanner scan);<br/>
  *  String scanLine(Scanner scan);<br/>
  *  scanINT(Scanner scan,int min,int max,int type);<br/>
  *  scanDOUBLE(Scanner scan,double less,double more,int type);<br/>

  *  scanINT(Scanner scan,int min,int max,int type);<br/>
  *  scanDOUBLE(Scanner scan,double less,double more,int type);
 * @return the value integer selected
 */
    public static int scanINT(Scanner scan,int min,int max,int type)
  {
    
     
     int returned;// la version a finir et copier coller pour double
     
   returned=scanINT(scan);
   
    switch(type)
    {
        case 1:  
         while(returned<min || returned>max)
            {
            System.out.print("Invalid input need between :");  
            System.out.println(min+" and "+max+". Please try again."); 
            returned=scanINT(scan);
            }
            break;
        case 2:
            while(returned<min )
            {
            System.out.print("Invalid input need minimum :"+min+". Please try again.");  
            returned=scanINT(scan);
            }
            break;    
        case 3:
              while(returned>max)
            {
            System.out.print("Invalid input need maximum :"+max+". Please try again.");  
            returned=scanINT(scan);
            }
            break; 
            
        default: break;
              
    }
      return returned;      
  }
    
    
  /**
 *  scanDOUBLE 
 * @param scan NEED:
 "import java.util.*" at the begining and
 "Scanner scan = new Scanner(System.in);" to define the scan. 
 
 @see
 *  scanBoolean(Scanner scan);<br/>
 *  scanINT(Scanner scan); <br/>
 *  scanDOUBLE(Scanner scan);<br/>
 *  Scanner DefineScanner();<br/>
 *  String scannext(Scanner scan);<br/>
 *  String scanLine(Scanner scan);<br/>
 *  scanINT(Scanner scan,int min,int max,int type);<br/>
 *  scanDOUBLE(Scanner scan,double less,double more,int type);<br/>

 *  scanINT(Scanner scan,int min,int max,int type);<br/>
 *  scanDOUBLE(Scanner scan,double less,double more,int type);
 * @return the value DOUBLE selected
 */
 public static double scanDOUBLE(Scanner scan)
  {
  double returned;
  while(true)
    {if (scan.hasNextDouble())
           {
               returned=scan.nextDouble();

              scan.nextLine();
               return returned;
           }
      else
           {
               System.out.println("Invalid input . Please try again.");
               scan.nextLine();
           }
    }
  }

  /**
 *  scanDOUBLE 
 * @param scan NEED:
 "import java.util.*" at the begining and
 "Scanner scan = new Scanner(System.in);" to define the scan. 
 * @param min the minimum point (useless with type 0 or 3)
 * @param max the maximum point (useless with type 0 or 3)
         * @param type choose the type          <br/>
         *  type 0 = without less or more       <br/>
         *  type 1 = with less and  more        <br/>
         *  type 2 = with less no more          <br/>
         *  type 3 = no less but with more      <br/>
  @see
  *  scanBoolean(Scanner scan);<br/>
  *  scanINT(Scanner scan); <br/>
  *  scanDOUBLE(Scanner scan);<br/>
  *  Scanner DefineScanner();<br/>
  *  String scannext(Scanner scan);<br/>
  *  String scanLine(Scanner scan);<br/>
  *  scanINT(Scanner scan,int min,int max,int type);<br/>
  *  scanDOUBLE(Scanner scan,double less,double more,int type);<br/>
  *  scanINT(Scanner scan,int min,int max,int type);<br/>
  *  scanDOUBLE(Scanner scan,double less,double more,int type);
 * @return the value integer selected
     */
    public static double scanDOUBLE(Scanner scan,double min,double max,int type)
  {
      
     
     double returned;// la version a finir et copier coller pour double
     
   returned=scanDOUBLE(scan);
   
    switch(type)
    {
        case 1:  
         while(returned<min || returned>max)
            {
            System.out.print("Invalid input need between :");  
            System.out.println(min+" and "+max+". Please try again."); 
            returned=scanINT(scan);
            }
            break;
        case 2:
            while(returned<min )
            {
            System.out.print("Invalid input need minimum :"+min+". Please try again.");  
            returned=scanINT(scan);
            }
            break;    
        case 3:
              while(returned>max)
            {
            System.out.print("Invalid input need maximum :"+max+". Please try again.");  
            returned=scanINT(scan);
            }
            break; 
            
        default: break;
              
    }
      return returned;      
  }

    /**
     *Scanner scan = new Scanner(System.in);
     * @param scan
     @see
     *  scanBoolean(Scanner scan);<br/>
     *  scanINT(Scanner scan); <br/>
     *  scanDOUBLE(Scanner scan);<br/>
     *  Scanner DefineScanner();<br/>
     *  String scannext(Scanner scan);<br/>
     *  String scanLine(Scanner scan);<br/>
     *  scanINT(Scanner scan,int min,int max,int type);<br/>
     *  scanDOUBLE(Scanner scan,double less,double more,int type);<br/>

     *  scanINT(Scanner scan,int min,int max,int type);<br/>
     *  scanDOUBLE(Scanner scan,double less,double more,int type);
     * @return
     */
    public static String scannext(Scanner scan)
  {
      String returned;
   while(true)
     {
        if (scan.hasNext())
             {
                 returned=scan.next();
                 scan.nextLine();    
                 return returned;
             }
        else
             {
                 System.out.println("Invalid input . Please try again.");
                 scan.nextLine();
             }
      }

  }

    /**
    *Scanner scan = new Scanner(System.in);
    * @param scan
    @see
    *  scanBoolean(Scanner scan);<br/>
    *  scanINT(Scanner scan); <br/>
    *  scanDOUBLE(Scanner scan);<br/>
    *  Scanner DefineScanner();<br/>
    *  String scannext(Scanner scan);<br/>
    *  String scanLine(Scanner scan);<br/>
    *  scanINT(Scanner scan,int min,int max,int type);<br/>
    *  scanDOUBLE(Scanner scan,double less,double more,int type);<br/>

    *  scanINT(Scanner scan,int min,int max,int type);<br/>
    *  scanDOUBLE(Scanner scan,double less,double more,int type);
     * @return
     */
    public static String scanLine(Scanner scan)
  {
    String returned;
   while(true)
     {
        if (scan.hasNextLine())
             {
                 returned=scan.nextLine();

                 return returned;
             }
        else
             {
                 System.out.println("Invalid input . Please try again.");
                 scan.nextLine();
             }
      }

  }



    
    
    
    
    
}