/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShootingGame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Adeesha
 */
public abstract class GameObject {
        
    protected int x, y;
    protected float velX = 0, velY = 0;
    protected ID id;
    
    
    public GameObject(int x, int y, ID id){
        this.x =x;
        this.y =y;
        this.id = id;
        
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    
    
    
    
    
    public ID getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }
    
    
}
