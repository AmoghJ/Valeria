package Structure;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Scene {
	
	public String scene_name;
	public ArrayList<Scene> children;
	
	public Scene(String name) {
		scene_name = name;
		children = new ArrayList<Scene>();
	}
	
	public void OutputTravelOptions() {
		JOptionPane optionPane = new JOptionPane(null, JOptionPane.DEFAULT_OPTION,1);
	}
	
	public int currentScene;
	
	public Scene CurrentScene() {
		return children.get(currentScene);
	}
	
	public void setScene() {
		this.currentScene = currentScene;
	}
	
	
	
	
}