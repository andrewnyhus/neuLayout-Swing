Intro:
This application uses Java Swing, and does not use any third party libraries.  This application is essentially a 2-dimensional "universe" containing members, all of which extend from the Actor class.  The point of this application was to create something where you could visually represent something, anything, in a space larger than your screen or window, and scroll/move around in all four directions to explore the contents of the "universe" outside of what your window currently displays.  There is a HUD Map which represents the entirety of the universe, and displays it on a much smaller scale, and it also shows your view with respect to the rest of the universe.


Possible uses:

1) Simple 2d game engine.
2) Summarizing events within a sports game based on the location they occurred within the field or court (i.e. Basketball game shot summary, Football game tackle/injury summary, etc.)
3) Mapping out an area such as a home, building, or even community or city on a basic level.  This comes with the ability to store data within individual objects or entities, and also with the ability to draw connections from one actor to another.


Still to implement:
1) Implementing Data Object Array within Actor
2) Inspector pop-up 
3) Adding an actor menu on double click (registering double clicks)
4) Implement a Connection object which extends Actor and is visually represented as a line between the two actors.  
4) Support for Polygons 
5) Implementing basic physics
6) Have ContainerUniverse extend Actor
7) Doors- optional addons to an actor that act as a portal from the current universe container to a new one that is within that specific actor.  Doors are two-sided, so whenever you enter into an actor 


Known bugs:

Future Hopes:
1) To port this to Android.
2) To provide network capabilities.
3) To port this to Python using Tk.
4) To come up with a cool name for this project.

