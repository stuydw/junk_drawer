import java.io.*;
import java.util.*;

public abstract class Character {

    protected String name;
    protected int hitPoints;
    protected int strength;
    protected int defense;
    protected double attack;

    public static String about() {

	return "You failed to provide a description of your character class";
    }

    public abstract void normal();
    public abstract void special();

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

    public int attack( Character opponent ) {
	
	int damage;		
	damage = (int)((strength * attack) - opponent.getDefense());	
	//System.out.println("\t\t" + damage);
	if ( damage < 0 )
	    damage = 0;
	opponent.lowerHitPoints( damage );
	
	return damage;
    }
    
    
}