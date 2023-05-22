

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class threads implements Runnable{
    private String link;
    private int currentdepth;
    private String depth;
    private String noofthreads;

    public threads(String link, int currentdepth, String depth, String noofthreads) {
        this.link = link;
        this.currentdepth = currentdepth;
        this.depth = depth;
        this.noofthreads = noofthreads;
    }
    
    
    @Override
    public void run()
    {
        try {
            HyperLinkChecker.printlinks(link, currentdepth, depth, noofthreads);
        } catch ( Exception ex) {
            Logger.getLogger(threads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
