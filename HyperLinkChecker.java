/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.JDBCType;
import static java.sql.JDBCType.NULL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Node;


/**
 *
 * @author LENOVO
 */
public class HyperLinkChecker {
    static ExecutorService ex;
      
         static      public   int invalidno=0 ;
            static  public    int validno=0;
            static public boolean check=false;
            static public int depthcheck;
            static public int cdepthcheck;
            
              
    
    public static boolean validate(String link) {
  boolean  valid = false;
      
 
        try {
        Document    doc = Jsoup.connect(link).get();
            valid = true;
        } catch (IOException ex) {
            valid =false;
        }
        return valid;}
        
   
    public static void printlinks(String link,int currentdepth,  String depth,String noofthreads) throws MalformedURLException
    {
       URL link1=new URL(link);
            String host1=(link1.getHost());
            String protocol1=(link1.getProtocol());
                int  depth1 = Integer.parseInt(depth.trim());
                depthcheck=depth1;
                cdepthcheck=currentdepth;
                int  noofthreads1 = Integer.parseInt(noofthreads.trim());
                
ex=Executors.newFixedThreadPool(noofthreads1); 
              threads t1=null;
          
                 if(validate(link))
        { 
            if(currentdepth==depth1&&depth1!=0)
            { 
             
            return;}
            
            
            
            
             if(validate(link))
        { 
            if(currentdepth==depth1&&depth1==0)
            { 
              {System.out.println("valid:"+link );
            validno++;
              
             return;}}
            
           
                
        try {
           Document   doc = Jsoup.connect(link).get();
           org.jsoup.select.Elements e = doc.select("a[href]");
           
           
          
          System.out.println(e.size());
        for (int i = 0; i < e.size(); i++) {
            String y = e.get(i).attr("href");
                    if(y.startsWith("http")==false)
                        y=(protocol1+"://"+host1+y);
                        
                                   t1=new threads(y,currentdepth+1,depth,noofthreads)    ;
                                   
                    ex.execute(t1);
                    
            if (validate(y)==true) 
            {System.out.println("valid:"+y );
            validno++;
             
                }
            else 
            {System.err.println("invalid:"+y);
        invalidno++;
       }}
        
    
        } catch (IOException ex) {
       System.err.print("error");
        }
       
        
        }
    
     }
    
    
   
    }}


    



        
        
        
        
    
    
