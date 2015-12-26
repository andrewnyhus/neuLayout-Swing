/* 
 * The MIT License
 *
 * Copyright 2015 andrewnyhus.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package java2dscrollinguniverse.Model.actors;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;

/**
 *
 * @author andrewnyhus
 */
public class Actor {
    private ActorType type;
    //private Location topLeftLocation;
    private Point topLeftLocation;
    Color color;
    private Shape shape;
    
    public Actor(ActorType type, Point loc, Color color){
        this.type = type;
        this.topLeftLocation = loc;
        this.color = color;
    }
    
    public Actor(ActorType type, Point loc, Color color, Shape s){
        this.type = type;
        this.topLeftLocation = loc;
        this.color = color;
        this.shape = s;        
    }
    
    
    public void updateShape(Shape s){
        this.shape = s;
    }
    
    public Shape getShape(){
        return this.shape;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    /**
     * Gives access to the topLeftLocation object of this actor.
     * @return this.topLeftLocation
     */
    public Point getTopLeftLocation(){
        return this.topLeftLocation;
    }
    
    /**
     * Takes in the newLoc topLeftLocation object and updates the topLeftLocation 
 of this Actor, with respect to the world (The World object), not with respect to 
 the currently drawn portion of the world (Java Swing stuff).
     * @param newLoc 
     */
    public void setTopLeftLocation(Point newLoc){
        this.topLeftLocation = newLoc;

        //int width = (int) this.getShape().getBounds().getWidth();
        //int height = (int) this.getShape().getBounds().getHeight();
        
        //this.shape = new Rectangle(this.topLeftLocation.getX(), this.topLeftLocation.getY(), width, height);
        
    }
    
    
}
