/*========== Stuyablo.java ==========
  This is the engine for Stuyablo. 

  Almost all of this code should be left alone.
  In order to add your won custom class, go to
  LINE 66
  and read the instructions.

  If you do not follow the instructions exactly,
  or change any other lines in this file, you are
  very likely to break the program.

jdyrlandweaver
=========================*/
import java.io.*;
import java.util.*;

public class Stuyablo {

    /*===========================
      Change this number to set the number of
      moves in a game.
      =========================*/
    public final static int MAX_MOVES = 5;

    private Character bob;
    private Monster sherman;
    
    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;

    public Stuyablo() {

	moveCount = 0;
	gameOver = false;
	
	isr = new InputStreamReader(System.in);
	in = new BufferedReader(isr);
	newGame();
    }

    public void newGame() {

	String s;
	String name = "";

	s = "Welcome to Stuyablo, the lastest installment of the hack-and-slash classic game, Diablo! (Blizzard has nothing to do with this game, any references to the Diablo franchise are used without permission, so please don't tell anyone).\n";

	s+= "\nPlease select your difficulty level:\n";
	s+= "\t1: Easy\n";
	s+= "\t2: Not as Easy\n";
	s+= "\t3: Unpleasant\n";
	s+= "Selection: ";
	
	System.out.println(s);
	
	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch (IOException e) {}

	/*===========================
	  To add your own character class:
	  1. Change the value for choices to equal
	  the number of classes you have added.

	  2. Add a line to the following string
	  that includes a numeric choice and a
	  call to that class' about() method
	  For example:
	  s+= "\n\n\t2: " + Mage.about();

	  Make sure to insert this code before
	  s+= "\n\nSelection: ";
	  or the output will look strange
	  =========================*/
	int choices = 1;
	s = "\nPlease select your character type:";
	s+= "\n\t1: " + Warrior.about();
	s+= "\n\nSelection: ";
	
	int p = 0;
	try {
	    while ( p <= 0 || p > choices ) {
		System.out.println(s);
		p = Integer.parseInt( in.readLine() );
	    }
	}
	catch (IOException e) {}
	System.out.println(p);
	
	s = "And what will you name your mighty character?";
	System.out.println(s);
	try {
	    name = in.readLine();
	}
	catch (IOException e) {}

	if ( p == 1 )
	    bob = new Warrior(name);
	else
	    bob = new Mage(name);

    }

    public boolean playTurn() {
	int i = 1;
	int d1;
	int d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println("Nothing to see here, carry on");
	else { 

	    System.out.println("A big bad monster has appeared!");
	    sherman = new Monster();
	    while ( sherman.isAlive() && bob.isAlive() ) {
		
		try {
		    System.out.println("What kind of attack will you use?\n\t1: Normal\n\t2: Special");
		    i = Integer.parseInt( in.readLine() );
		}
		catch (IOException e) {}
		if ( i == 2 )
		    bob.special();
		else
		    bob.normal();
		
		d1 = bob.attack( sherman );
		d2 = sherman.attack( bob );
		
		System.out.println( bob.getName() + " dealt " + d1 + " points of damage.");
		System.out.println( "The Monster swung back for " + d2 + " points of damage.");
	    }
	    
	    if ( !sherman.isAlive() && !bob.isAlive() ) {
		System.out.println("You have defeated the evil monster. Unfortunately, with it's last dying effort, the monster has killed you");
		return false;
	    }
	    else if ( !sherman.isAlive() )  {
		System.out.println("The monster is no more.");
		return true;
	    }
	    else if ( !bob.isAlive() ) {
		System.out.println("You have been slain");
		return false;
	    }
	}
	return true;
    }


    public static void main(String[] args) {

	Stuyablo game = new Stuyablo();
	int moves = 0;

	while ( moves < MAX_MOVES ) {

	    if ( !game.playTurn() )
		break;
	    moves++;
	    System.out.println();
	}	
	System.out.println("Game Over.\nWinners don't choose drugs.");
    }
}