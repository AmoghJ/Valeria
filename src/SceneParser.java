import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*Scene Parser Format is as follows:
 * The parent scene starts by the notation : /<
 * The name of the scene is contained within : <  >
 * The child scene starts by the notation : -<
 * 
 * An example would be :
 * 
 * /<Home>
 * -<Forest>
 * 
 * Where Home is the parent scene and Forest is the child scene
 * 
 * Note: This parser builds reverse relationship i.e. in the above example,
 * Forest also has Home as its child.
 */

class SceneParser {
	
	public static String FileName = System.getProperty("user.dir") + "/Resources/SceneLayout.txt";
			
	public SceneParser() {}
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(FileName);
			br = new BufferedReader(fr);
			String sCurrentLine;
			
			ArrayList<Scene> scenes = new ArrayList<Scene>();
			
			//Adding new scenes to the array
			while ((sCurrentLine = br.readLine()) != null) {
				parseSceneToArray(scenes, sCurrentLine);
			}
			
			fr = new FileReader(FileName);
			br = new BufferedReader(fr);
			int lineNumber = 0;
			
			Scene rootScene = null;
			
			//Build Scene Relationships
			while ((sCurrentLine = br.readLine()) != null) {
				
				String command = sCurrentLine.substring(0, 2);
				
				if(command.equals("/<")) {
					
					String name = parseName(sCurrentLine);
					rootScene = getSceneObj(name,scenes);
					
				}
				else if(command.equals("-<")) {
					
					String name = parseName(sCurrentLine);
					Scene childScene = getSceneObj(name, scenes);
					
					if(rootScene != null) {
						
						if(!rootScene.children.contains(childScene))
							rootScene.children.add(childScene);
						
						if(!childScene.children.contains(rootScene))
							childScene.children.add(rootScene);
					}
					else
						System.out.println("Error:(" + lineNumber + ") Child does not have parent:" + name);
				}
				
				lineNumber++;
			}
			
		} catch(IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {

				if (br != null)  
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		
	}
	
//---------------Helper Methods-----------------------
	
	private static String parseName(String input) {
		String output = "";
		int length = 0;
		char[] concated = input.substring(2).toCharArray();
		for(int i = 0; i < concated.length; i++) {
			if(concated[i] == '>') {
				length = i;
				output = input.substring(2, length+2);
			}
		}
		
		return output;
	}
	
	private static void parseSceneToArray(ArrayList<Scene> array, String input) {
		String name = parseName(input);
		
		if(!name.equals("")) {
		boolean unique = true;
		
		for(int j = 0; j < array.size(); j++) {
			if(array.get(j).scene_name.equals(name)) {
				unique = false;
			}
		}
		
		if(unique)
			array.add(new Scene(name));
		}
		else
			System.out.println("Error: All scenes do not have names");
	}
	
	private static Scene getSceneObj(String name, ArrayList<Scene> array) {
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).scene_name.equals(name))
				return array.get(i);
		}
		
		return null;
	}
	
	private static void testKeith() {}
}
