import java.io.*;
import java.util.*;

public class Warrior extends Character {

    public Warrior(String n) {
	
	hitPoints = 125;
	defense = 40;
	strength = 100;
	attack = .4;
	name = n;
    }
	    
    public void special() {
	attack = .75;
	defense = 20;
    }
    
    public void normal() {
	attack = .4;
	defense = 40;
    }

    public static String about() {

	return "The warrior is a master of the physical. He hasn't met a problem that can't be sloved through smashing.\nWarriors have increased strength and life. His special move forgoes a shield to mightily swing two swords into the heart of his enemy (attack is increased with a temporary penalty to defense)";

    }
}
