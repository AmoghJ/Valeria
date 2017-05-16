import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


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
			String[] sList= new String[1000];
			int i = 0;
			//br = new BufferedReader(new FileReader(FileName));

			while ((sCurrentLine = br.readLine()) != null) {
				
				//System.out.println(sCurrentLine);
				sList[i] = sCurrentLine;
				System.out.println(i+" "+sList[i]);
				i += 1;
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
}
