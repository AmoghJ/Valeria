import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SceneManager {
	
	private static SceneManager instance;
	
	Scene currentScene;
	JFrame frame;
	
	private SceneManager() 
	{
		frame = new JFrame();
		frame.setTitle("Simple example");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static SceneManager getInstance() {
		if(instance == null)
			instance = new SceneManager();
		
		return instance;
	}
	
	public void update() {
		
		if(currentScene != null)
			frame.setTitle(currentScene.scene_name);
	}
	
}