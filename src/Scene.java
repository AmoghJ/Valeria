import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Scene {
	
	public String scene_name;
	ArrayList<Scene> children;
	
	public Scene(String name) {
		scene_name = name;
		children = new ArrayList<Scene>();
	}
	
	public void OutputTravelOptions() {
		JOptionPane optionPane = new JOptionPane(null, JOptionPane.DEFAULT_OPTION,1);
	}
	
}
//