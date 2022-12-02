import java.io.*;
import java.util.*;

public class StuyabloBeta {

    public final static int MAX_MOVES = 5;

    private Warrior bob;
    private Monster sherman;
    
    private int moveCount;
    private boolean gameOver;
    private int difficulty;


    private InputStreamReader isr;
    private BufferedReader in;

    public StuyabloBeta() {

	moveCount = 0;
	gameOver = false;
	
	isr = new InputStreamReader(System.in);
	in = new BufferedReader(isr);
	newGame();
    }

    public void newGame() {

	String s;
	String name = "";
	difficulty = 0;

	s = "\nWelcome to Stuyablo, the lastest installment of the hack-and-slash classic game, Diablo! (Blizzard has nothing to do with this game, any references to the Diablo franchise are used without permission, so please don't tell anyone).\n";

	s+= "\nPlease select your difficulty level:\n";
	s+= "\t1: Easy\n";
	s+= "\t2: Not as Easy\n";
	s+= "\t3: Why do you hate yourself?\n";
	s+= "Selection: ";

	while ( difficulty < 1 || difficulty > 3 ) {

	    System.out.println(s);	
	
	    try {
		difficulty = Integer.parseInt( in.readLine() );
	    }
	    catch (IOException e) {}
	}	

	s = "What will you name your mighty warrior?";
	System.out.println(s);
	try {
	    name = in.readLine();
	}
	catch (IOException e) {}

	bob = new Warrior(name);
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

	StuyabloBeta game = new StuyabloBeta();
	int moves = 0;
	
	System.out.println("\nYou enter a long hallway, with each step forward a greater chance of peril awaits you!\n");

	while ( moves < MAX_MOVES ) {

	    System.out.print("Step " + moves + ": ");

	    if ( !game.playTurn() )
		break;
	    moves++;
	    System.out.println();
	}
	
	System.out.println("Game Over.\nWiners don't choose drugs.");
    }

}