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
package java2dscrollinguniverse.Model.universe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java2dscrollinguniverse.Model.PerimeterSide;
import java2dscrollinguniverse.Model.actors.Actor;
import java2dscrollinguniverse.Model.actors.ActorType;
import java2dscrollinguniverse.Model.actors.Wall;
import java2dscrollinguniverse.SettingsSingleton;

/**
 *
 * @author andrewnyhus
 */
public class MemberFactory {

    private Dimension universeBounds;
    private final int wallThickness = 10;
    public MemberFactory(Dimension universeBounds) {
        this.universeBounds = universeBounds;
    }
    
    public Actor getBackgroundRect(){
        return new Actor(ActorType.miscObject, new Point(0, 0),
                SettingsSingleton.getInstance().getUniverseBackgroundColor(),
                new Rectangle(0, 0, this.universeBounds.width, this.universeBounds.height));
    }
    
    public Wall[] generateWalls(){
        Wall[] walls = new Wall[4];
        
        Point topLeftLoc = new Point(0, 0);
        Point topRightLoc = new Point(this.universeBounds.width, 0);
        Point bottomLeftLoc = new Point(0, this.universeBounds.height);
        
        Point locWall0 = new Point(0, 0);
        Point locWall1 = new Point(0, 0);
        Point locWall2 = new Point(this.universeBounds.width - 10, 0);
        Point locWall3 = new Point(0, this.universeBounds.height - 10);


        walls[PerimeterSide.LEFT.getValue()] = new Wall(locWall0, new Rectangle(0, 0, wallThickness, this.universeBounds.height));
        walls[PerimeterSide.TOP.getValue()] = new Wall(locWall1, new Rectangle(0, 0, this.universeBounds.width, wallThickness));
        walls[PerimeterSide.RIGHT.getValue()] = new Wall(locWall2, new Rectangle(0, 0, 10, this.universeBounds.height));
        walls[PerimeterSide.BOTTOM.getValue()] = new Wall(locWall3, new Rectangle(0, 0, this.universeBounds.width, wallThickness));
        
        return walls;
    }
    
    public Actor[] generateMiscellaneousActorsRandomly(){
        int widthInset = (int)(this.universeBounds.getWidth() * .15);
        int heightInset = (int)(this.universeBounds.getHeight() * .15);
                
        int acceptableWidth = (this.universeBounds.width - (widthInset*2));
        int acceptableHeight = (this.universeBounds.height - (heightInset*2));
        
        int minimumX = widthInset;
        int maximumX = this.universeBounds.width - widthInset;
        
        int minimumY = heightInset;
        int maximumY = this.universeBounds.height - heightInset;
        
        int acceptableArea = acceptableWidth*acceptableHeight;
        
        int maxFrequencyOfActorPerSquareSize = 40000;//40000 = 200 x 200 pixels

        int maxNumActors = acceptableArea/maxFrequencyOfActorPerSquareSize;
        
        Random randomGen = new Random();
        
        int numActors = randomGen.nextInt(maxNumActors);
        
        Actor[] actors = new Actor[numActors];
        
        for(int i = 0; i < numActors; i++){
            //ActorType type, Point loc, Color color, Shape s
            
            //256 because the bound is exclusive and 255 is the largest number we want.
            int r = randomGen.nextInt(256);
            int g = randomGen.nextInt(256);
            int b = randomGen.nextInt(256);
            
            Color c = new Color(r,g,b);
            
            int x = minimumX + randomGen.nextInt(acceptableWidth);
            int y = minimumY + randomGen.nextInt(acceptableHeight);
            
            Point p = new Point(x, y);
            
            int numOfOptionsOfShapeType = 2;
            
            int shapeTypeNum = randomGen.nextInt(numOfOptionsOfShapeType);
            
            Shape s;
            
            int width = 40 + randomGen.nextInt(25);
            int height = 40 + randomGen.nextInt(25);
            
            if(shapeTypeNum == 0){
                //shape is ellipse2d.double
                s = new Ellipse2D.Double(0.0, 0.0, (double)width, (double)height);
            }else if(shapeTypeNum == 1){
                //shape is rectangle
                s = new Rectangle(0, 0, width, height);
            }else{
                s = null;
            }
            
            actors[i] = new Actor(ActorType.miscObject, p, c, s);
        
        }
        
        return actors;
    }
    
}
