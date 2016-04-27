package util3;


import java.util.Calendar;

public class Temp {


    public static int Miseformat(int Anner,int mois,int jour)
    {return Anner+mois*10000+jour*1000000;}

    public static int[] Reverseformat(int date)
    {int []reverse=new int[3];
        reverse[0]=date%100;
        date=(date-reverse[0])/100;
        reverse[1]=date%100;
            date=(date-reverse[1])/100;
        reverse[2]=date;
        return reverse;
    }

    public static String datetoString(int date)
    {return ""+getday(date)+"/"+getMois(date)+"/"+getAnnee(date);}


    public static int Stringtodate(String date)
    { String[] parts = date.split("/");

    int anne=Integer.parseInt(parts[0]);
    int mois=Integer.parseInt(parts[1]);
    int jour=Integer.parseInt(parts[2]);
        return jour+mois*10000+anne*1000000;
    }


    public static int getday(int date)
    {return date/1000000;}
    public static int getMois(int date)
    {return (date/10000)%100;}
    public static int getAnnee(int date)
    {return date%10000;}




}
