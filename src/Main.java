
import java.util.ArrayList;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Scene> scenes = new SceneParser().parseScene();
		SceneManager sceneManager = SceneManager.getInstance();
		
		sceneManager.currentScene = scenes.get(0);
		
	}
}
