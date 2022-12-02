import java.io.*;
import java.util.*;

public class Monster extends Character {


    public Monster() {

	hitPoints = 150;
	defense = 20;
	strength = (int)(Math.random() * 45) + 20;
	attack = 1;
	name = "Gary";

	//	System.out.println("\t" + strength);
    }

    public static String about() {

	return "Generic monster goes grrrrr";
    }

    public void normal() {}
    public void special() {}
}