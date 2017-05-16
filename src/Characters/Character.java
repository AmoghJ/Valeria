package Characters;

import java.util.ArrayList;

public class Character {
	
	private int health = 20;
	private int max_damage = 5;
	private int min_damage = 2;
	private int max_speed = 12;
	private int min_speed = 0;
	private String weapon = "fist";
	private String name = "";
		
	public Character() {
			
	}
	
	
	public void setH(int health){
		this.health = this.health + health;
	}
	public void setW(String weapon) {
		this.weapon = weapon;
	}
	public void setN(String name) {
		this.name = name;
	}
	public void setmaxD(int max_damage) {
		this.max_damage = this.max_damage + max_damage;
	}
	public void setminD(int min_damage) {
		this.min_damage = this.min_damage + min_damage;
	}
	public void setmaxS(int max_speed) {
		this.max_speed = this.max_speed + max_speed;
	}
	public void setminS(int min_speed) {
		this.min_speed = this.min_speed + min_speed;
	}	
	
	
	public int getH() {
		return this.health;
	}
	public String getW() {
		return this.weapon;
	}	
	public int getmaxD() {
		return this.max_damage;
	}
	public int getminD() {
		return this.min_damage;
	}
	public int getmaxS() {
		return this.max_speed;
	}
	public int getminS() {
		return this.min_speed;
	}
	public String getN() {
		return this.name;
	}		
	
	
	public String characters_name;
	ArrayList<Character> characters;
	
	public Character(String name) {
		characters_name = name;
		characters = new ArrayList<Character>();
	}
	
}

