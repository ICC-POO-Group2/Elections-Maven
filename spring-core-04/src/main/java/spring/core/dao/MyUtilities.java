package spring.core.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

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
	}
	

}
