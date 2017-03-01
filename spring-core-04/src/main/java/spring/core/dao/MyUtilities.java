package spring.core.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyUtilities {
	private static BufferedWriter bW =null;
	private static BufferedReader bR =null;
	
	public static boolean saveStringToFile(String csv, String pathFile) {
		File f = new File(pathFile);
		boolean sauve = false;
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				return false;
			}
		}
		if(csv == null){
			return false;
		}
		
			try{
				bW = new BufferedWriter(
						new FileWriter(f));
				try{
					bW.write(csv);
					sauve =  true;
				}
				finally{
					bW.close();
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		
		return sauve;
		
		/**
		try {
			if(csv!=null && !f.exists()){
				fW = new BufferedWriter(new FileWriter(new File(path)));
				fW.write(csv,0,csv.length());
				fW.close();
				return true;
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return false;
	**/
	}
	public static String getStringFromFile(String pathFile) throws IOException {
		
		StringBuilder sB = new StringBuilder();
		File f= new File(pathFile);
		if(!f.exists()){
			throw new IOException("Le fichier n'existe pas !");
		}
		
		try{
			bR = new BufferedReader(
					new FileReader(
							new File(pathFile)));
			
			try{
				String texte;
				
				while((texte = bR.readLine()) !=null){
					sB.append(texte);
					sB.append("\n");
					
				}
			}
			finally{
				bR.close();
				
			}
		}
		catch(IOException e){
			
		}
		return sB.toString();
		/**
		String result="";
		String tmp="";
		try {
			fR = new BufferedReader(new FileReader(new File(path)));
			while(tmp!=null){
				tmp=fR.readLine();
				if(tmp!=null){
				result=result+tmp+"\n";
				}
				
			}
			fR.close();
			System.out.println(result);
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
	}
	
}
