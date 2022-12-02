import java.io.*;
import java.util.*;

public class Warrior {

    private String name;
    private int hitPoints;
    private int strength;
    private int defense;
    private double attack;

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

    public String getName() {
	return name;
    }

    public boolean isAlive() {
	return hitPoints > 0;
    }

    public int getDefense() {
	return defense;
    }

    public void lowerHitPoints( int damage ) {
	hitPoints = hitPoints - damage;
    }

    public int attack( Monster opponent ) {
	
	int damage;		
	damage = (int)((strength * attack) - opponent.getDefense());	
	//System.out.println("\t\t" + damage);
	if ( damage < 0 )
	    damage = 0;
	opponent.lowerHitPoints( damage );
	
	return damage;
    }


}
