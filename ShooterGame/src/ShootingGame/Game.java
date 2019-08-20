/*
 * Date 7 / 28 /2019
 * Authour Adeesha
 * Description : A random shooter Game learning Basics Game dev
 * Version 1.0.0
 */
package ShootingGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adeesha
 */
public class Game extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 1L;
    
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    
    
    public  Game()
    {
        new Window(1000,500,"Wiz Game",this);
        start();
        
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        
        handler.addObject(new Wizard(100, 100, ID.Player, handler));
    }
    
    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks  = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta =0;
        long timer = System.currentTimeMillis();
        int frames =0;
        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                //updates++
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames =0;
                //updates =0;
            }
        }
        stop(); 
        
    }
    
    public void tick(){
        handler.tick();
    }
    
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        ////////////////////////////////////
        g.setColor(Color.red);
        g.fillRect(WIDTH, WIDTH, 1000, 600);
        
        handler.render(g);
        ////////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    public static void main(String[] args) {
        new Game();
    }
}
