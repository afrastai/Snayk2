# Snayk2
A remake of the popular game Snake. 

To play the game, either open the SNAYK2.jar file or run the Game.java file.

####################################################################################
Instructions: 

Use the up, down, left and right keys on your keyboard to controll the movement of the Snayk. Eat as many Fuud objects as you
can. Red Fuud are stationary and are worth 1 point, while Blue Fuud jump around and are worth 2 points. The Snayk can travel
through the walls of the board. If the Snayk runs into itself, YOU LOSE!

####################################################################################
Implementation:

My implementation of this game utilizes an object oriented programming technique.
Firstly, the abstract class, SnyakObject, contains the default fields and methods for every other game component implemented.

Fuud.java, which is a subclass of the SnaykObject class, represents the fuud objects which are meant to be eaten by the Snayk.
This class contains methods for drawing itself as well as a method that randomly repositions the fuud after it is eaten.

The BodyPart.java class is another subclass of SnaykObject and also contains its own method for drawing itself.

Snayk.java is my implementation of the actual Snayk object in the game. It is comprised of a LinkedList of BodyParts and keeps
track of head and tail pointers as well as a direction that the Snayk is moving in. This class also includes a method for adding  BodyParts to the head of the Snayk in the appropriate location based on the direction that the Snayk is moving in. Additionally, this class holds the logic for the move() function that basically removes the tail BodyPart and adds it to the head of the Snayk in the appropriate location.

The Board.java class contains a representation of the game board as a 2D boolean array. The array is set to true at the locations of the BodyParts and the Fuud objects and false otherwise. It also contains an advance() method, which calls the snayk to move one step in the current direction and updates the 2D array for the new location of the Snayk. It also contains a draw function that calls the appropriate draw function for each BodyPart and Fuud object noted in the array.

The GamCourt.java class contains the majority of the game logic. It contains instances of all the different objects represented in the game and keeps track of time elapsed (based on a specified time interval) as well as the current score. This class contains the key listener that keeps track of the keys pressed. At first, my implementation of the key listener changed the direction of the Snayk the moment the key was pressed. This caused a bug that resulted in the Snayk ceasing to move when two keys were pressed within the same time step. To fix this, I used a LinkedList to keep track of the keys pressed. Every time step elapsed, a move is polled from the front of the LinkedList and the appropriate direction change is executed. Every time step, the method tick() is called, which checks the game end condition (when the snayk intersects itself), the point condition (the snayk intersects a fuud object), advances the board based on the movement of the snayk, and repaints the board accordingly.

The Game.java class is the runnable main class that contains the Java Swing front-end organization of the game.

####################################################################################

Enjoy!


