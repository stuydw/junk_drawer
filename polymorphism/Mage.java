import java.io.*;
import java.util.*;

public class Mage extends Character {

    public Mage(String n) {
	
	hitPoints = 75;
	defense = 55;
	strength = 100;
	attack = .5;
	name = n;
    }
	    
    public void special() {
	attack = .90;
	defense = 35;
    }
    
    public void normal() {
	attack = .5;
	defense = 55;
    }

    public static String about() {

	return "The Mage is a master of the ephemeral. While the Warrior was in the gym pumping iron, the Mage spent his time in the archives studying.\nMagi have decreased strength and life but increased defense (since they attack from afar). The mage's special move launches the fury of the heavens at his enemy (attack is increased with a penalty to defense)";
    }

}
