package Characters;

import javax.swing.JOptionPane;

public class Hero extends Character{
	
	private int coin = 20;
	private int exp = 0;
	private int l_exp = 100;
	private int level = 1;
	
	public void setC(int coin) {
		this.coin = this.coin + coin;
	}
	public void setE(int exp) {
		this.exp = this.exp + exp;
	}
	
	public int getC() {
		return this.coin;
	}
	public int getE() {
		return this.exp;
	}
	public int getL() {
		return this.level;
	}
	
	public void levelup() {
		if(exp >= l_exp) {
			exp = l_exp - exp;
			l_exp = (int)(1.5 * l_exp);
			Object[] options = { "Continue"};
			JOptionPane.showOptionDialog(null, "You leveled up! "+(level++)+" to "+level,"RPG", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
		}
			
		else {
			Object[] options = { "Continue"};
			JOptionPane.showOptionDialog(null, "You are "+Math.abs(l_exp - exp)+" exp to leveling up!","RPG", JOptionPane.DEFAULT_OPTION, 1, null, options, options[0]);
		}
	}
	
}
