package util3;
import java.util.*;


public class Scan {
    public Scanner scan= new Scanner(System.in);;
    public Scan(){}

 //---------------------------------------------------------------------------------------------------------------------
 //----------------Scanner with Scan clear included---------------------------------------------------------------------
 //---------------------------------------------------------------------------------------------------------------------
/**  - integer 0 2 = No other yes<br/>
 * -string Yes True y Y T t <br/>
 * -string No False n N f F <br/>
 * @return the value true/false 
 */
  public  boolean scanBoolean()
  {
      int integer;
      String character;
  while(true)
    {if (scan.hasNextInt())
           {
            integer = scan.nextInt();
            scan.nextLine();
            if(integer==0 || integer==2){return false;}
            else if(integer==1 )        {return true; }
           }
    else if(scan.hasNextLine())
            {
            character=scan.nextLine();
            scan.nextLine();
            char first_character = character.charAt(0);
             
             if(first_character=='f' || first_character=='F' ||first_character=='o' ||
                first_character=='O' || first_character=='n' || first_character=='N')
                {return false;}
             else if(first_character=='y' || first_character=='Y' ||first_character=='t' || first_character=='T')
                {return true;}
             else if(first_character=='h' || first_character=='H'|| first_character=='?')
                {  System.out.println("You wanted answer :");
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

  /** @return the value integer selected
   * */
  public  int scanINT()
  {int returned=0;
  while(true)
    {if (scan.hasNextInt())
           {returned = scan.nextInt();
            scan.nextLine();
            return returned;}
      else
           {System.out.println("Invalid input. Please try again.");
           scan.nextLine();}
    }
  }

/** @param min the minimum point (useless with type 0 or 3)
 * @param max the maximum point (useless with type 0 or 3)
         * @param type choose the type          <br/>
         *  type 0 = without less or more       <br/>
         *  type 1 = with less and  more        <br/>
         *  type 2 = with less no more          <br/>
         *  type 3 = no less but with more      <br/>
 * @return the value integer selected
 */
public  int scanINT(int min,int max,int type)
  { int returned=scanINT();// la version a finir et copier coller pour double

    switch(type)
        {case 1:while(returned<min || returned>max)
                    {System.out.print("Invalid input need between :"+min+" and "+max+". Please try again.");
                    returned=scanINT();}
                break;
         case 2: while(returned<min )
                    {System.out.print("Invalid input need minimum :"+min+". Please try again.");
                    returned=scanINT();}
                break;
         case 3:while(returned>max)
                    {System.out.print("Invalid input need maximum :"+max+". Please try again.");
                    returned=scanINT(); }
                break;
         default:break;
        }
      return returned;
  }

  /** @return the value DOUBLE selected
   * */
 public  double scanDOUBLE()
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

  /** @param min the minimum point (useless with type 0 or 3)
    * @param max the maximum point (useless with type 0 or 3)
         * @param type choose the type          <br/>
         *  type 0 = without less or more       <br/>
         *  type 1 = with less and  more        <br/>
         *  type 2 = with less no more          <br/>
         *  type 3 = no less but with more      <br/>
 * @return the value integer selected */
public  double scanDOUBLE(double min,double max,int type)
  {double returned=scanDOUBLE();

    switch(type)
    {   case 1:while(returned<min || returned>max)
            {System.out.print("Invalid input need between :");
            System.out.println(min+" and "+max+". Please try again."); 
            returned=scanDOUBLE();}
            break;
        case 2:while(returned<min )
            {System.out.print("Invalid input need minimum :"+min+". Please try again.");returned=scanDOUBLE();}
            break;    
        case 3:while(returned>max)
            {System.out.print("Invalid input need maximum :"+max+". Please try again.");
            returned=scanDOUBLE();}
            break;
        default: break;
    }
      return returned;      
  }
//---------------------------------------------------------------------------------------------------------------------
//-------------------------       Scanner basic   ---------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------

    /** scanner next with a clear after
     * */
public  String scannext()
  {String returned;
   while(true)
     {if (scan.hasNext())
        {returned=scan.next();
         scan.nextLine();
         return returned;}
     else
        {System.out.println("Invalid input . Please try again.");
         scan.nextLine();}
      }
  }

    /**  */
public  String scanLine()
  {String returned;
      while(true)
     {if (scan.hasNextLine())
             {returned=scan.nextLine();
              return returned;}
        else
             {System.out.println("Invalid input . Please try again.");
              scan.nextLine();}
      }
  }

    
}