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
	
	public String[] getChildrenNames() {
		String[] names = new String[children.size()];
		
		for(int i = 0; i < children.size(); i++) {
			names[i] = children.get(i).scene_name;
		}
		
		return names;
	}
	
	public Scene getScene(String name) {
		
		for(int i = 0; i < children.size(); i++) {
			if(children.get(i).scene_name.equals(name))
				return children.get(i);
		}
		
		return null;
	}
	
}
//