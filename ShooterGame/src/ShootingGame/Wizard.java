/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShootingGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Adeesha
 */
public class Wizard extends GameObject{

    Handler handler;
    
    public Wizard(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler=handler;
    }

    @Override
    public void tick() {
        x+= velX;
        y+= velY;
        if(handler.isUp()) velY =-5;
        else if (!handler.isDown()) velY =0;
        
        if(handler.isDown()) velY =5;
        else if (!handler.isUp()) velY =0;
        
        if(handler.isRight()) velX =5;
        else if (!handler.isLeft()) velX =0;
        
        if(handler.isLeft()) velX =-5;
        else if (!handler.isRight()) velX =0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
       return new Rectangle(x, y, 32, 32);
    }
    
    
}
//part 4 didnt work