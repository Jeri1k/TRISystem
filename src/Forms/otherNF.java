/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.io.InputStream;


/**
 *
 * @author christopher
 */
public class otherNF {
    InputStream in;
   
    
    //timer
    String timeleft;
    int timeok;
    
    
         
    
    
    public void timer()throws InterruptedException{
        int timet= 3 * 60; // Convert to seconds
    long delay = timet * 1000;

    do
    {
      int minutes = timet / 60;
      int seconds = timet % 60;
      timeleft=minutes +" minute(s), " + seconds + " second(s)";
      Thread.sleep(1000);
      timet = timet - 1;
      delay = delay - 1000;

    }
    while (delay != 0);
    timeok=1;
    }
    

}
