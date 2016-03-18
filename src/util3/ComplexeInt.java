/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util3;

/**
 *
 * @author mathieu
 */
public class ComplexeInt {
    
    
      private int _im;
      private int _re;  
    
 //***************************************************************************************   
    
    public  ComplexeInt()
    {_im=0;
     _re=0;   
    }
    public  ComplexeInt(int im,int re)
    {_im=im;
     _re=re;   
    }
   //***************************************************************************************
   //*************************************************************************************** 
   //*************************************************************************************** 

    /**
     *
     * @param size
     * @return
     */
    public static ComplexeInt[] newTableComplexeInt(int size)
   {
       if(size>0)
       {ComplexeInt[] table=new ComplexeInt[size];
         for(int i=0;i<size;i++)
             { table[i]=new ComplexeInt(); }
               
         return table; 
       }
       ComplexeInt[] table=new ComplexeInt[1];
      return table;
   
   }
    
   public int getIm()            {return _im;}
   public void   setIm(int im)   {_im=im;}
   
   public int getRe()            {return _re;}    
   public void   setRe(int re)   {_re=re;} 
    
   public void set(int re,int im){_re=re;_im=im;}
    
    public ComplexeInt addition (ComplexeInt c2){
    ComplexeInt c3 = new ComplexeInt() ;
    c3._re = this._re + c2._re ;
    c3._im = this._im + c2._im ;
    return c3 ;
    }
    
    
   
    
    
    
    
    
    
    
}
