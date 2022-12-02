import java.io.*;
import java.util.*;

public class Monster {

    private String name;
    private int hitPoints;
    private int strength;
    private int defense;
    private double attack;

    public Monster() {

	hitPoints = 150;
	defense = 20;
	strength = (int)(Math.random() * 45) + 20;
	attack = 1;
	name = "Gary";

	//	System.out.println("\t" + strength);
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

    public int attack( Warrior opponent ) {
	
	int damage;		
	damage = (int)((strength * attack) - opponent.getDefense());	
	//System.out.println("\t\t" + damage);
	if ( damage < 0 )
	    damage = 0;
	opponent.lowerHitPoints( damage );
	
	return damage;
    }
}