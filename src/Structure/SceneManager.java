package Structure;

class SceneManager {
	
	private static SceneManager instance;
	
	public Scene currentScene;
	
	private SceneManager() {}
	
	public static SceneManager getInstance() {
		if(instance == null)
			instance = new SceneManager();
		
		return instance;
	}
	
	
}
