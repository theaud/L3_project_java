
package util3;

/**
 *
 * @author mathieu
 */
public class Complexe {
    
    
      private Double _im;
      private Double _re;  
    
 //***************************************************************************************   
    
    public  Complexe()
    {_im=0.0;
     _re=0.0;   
    }
    public  Complexe(Double im,Double re)
    {_im=im;
     _re=re;   
    }
   //***************************************************************************************
   //*************************************************************************************** 
   //*************************************************************************************** 
    
   public Double getIm()            {return _im;}
   public void   setIm(Double im)   {_im=im;}
   
   public Double getRe()            {return _re;}    
   public void   setRe(Double re)   {_re=re;} 
    
    
    public Complexe addition (Complexe c2){
    Complexe c3 = new Complexe() ;
    c3._re = this._re + c2._re ;
    c3._im = this._im + c2._im ;
    return c3 ;
    }
    
    
    
    
    
    
    
    
    
}