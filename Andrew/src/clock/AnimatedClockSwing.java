/*
 * Copyright Brian Ricks, PhD, 2016. bricks at unomaha.edu
 */
package clock;

import java.awt.HeadlessException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 *
 * @author bricks
 */
public class AnimatedClockSwing extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       
        ///Get us into a non-static context
        AnimatedClockSwing andrew = new AnimatedClockSwing();
    }

    public AnimatedClockSwing()  {
        
        
        Clock clock = new Clock();
        ClockPanel clockPanel = new ClockPanel(clock);
        
        ///Set up a timer to allow for constant repaints
        ///From: http://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {
                clock.update();
                clockPanel.repaint();
            }
            
        }, 0, 1000);
        
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Andrew");
        this.add(clockPanel);
        this.setMinimumSize(clockPanel.getMinimumSize());
        this.pack();
        
    }
    
    
    
}
