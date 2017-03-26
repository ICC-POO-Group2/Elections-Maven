package spring.core.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import spring.core.dao.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ElectionsDaoFile implements IElectionsDao {
	/**
	 * le nom du fichier qui contient les données nécessaires au calcul des sièges
	 * 
	 */
	private String inFileName = null;
	
	/**
	* le nom du fichier qui contiendra les résultats
	*/
	private String outFileName = null;
	
	/**
	* le nom du fichier de logs
	*/
	private String logFileName = null;
	
	/**
	* le seuil électoral
	*/
	private double seuilElectoral;
	
	
	 /**
	 * le nombre de sièges à pourvoir
	 */
	private int nbSiegesAPourvoir;
	
	
	/**
	* les listes en compétition
	*/
	private ListeElectorale[] listesElectorales = null;
	
	/**
	 * constructeur avec paramètres
	 * @param inFileFileName String : le nom du fichier qui contient les données nécessaires au calcul des sièges
	 * @param outFileName String : le nom du fichier qui contiendra les résultats
	 * @param logFileName String : le nom du fichier qui contiendra les messages d'erreurs éventuels 
	 * @throws ElectionsException si problème quelconque
	 *
	 */
	public ElectionsDaoFile(String inFileName, String outFileName, String logFileName) throws ElectionsException {
		this.inFileName = inFileName;
		this.outFileName = outFileName;
		this.logFileName = logFileName;
		BufferedReader bR = null;
		
		//TODO Initialiser seuilElectoral, nbSiegesAPourvoir et les listesElectorales
		//		Lire le fichier infileName
		File f = new File(inFileName);
		if(!f.exists()){
			throw new ElectionsException("Le fichier n'existe pas !");
		}else{
			try {
				bR= new BufferedReader(
						new FileReader(
								new File(inFileName)));
				try{
					String texte;
					nbSiegesAPourvoir= ((texte=bR.readLine())!=null)?Integer.parseInt(texte):0;
					seuilElectoral= ((texte=bR.readLine())!=null)?Double.parseDouble(texte):0;
					listesElectorales[7] = new ListeElectorale();
					int i=0;
					while((texte = bR.readLine()) !=null){
						listesElectorales[i].setId(i);
						listesElectorales[i].setNom(texte);
						listesElectorales[i].setElimine(false);
						i++;
					}
					
				}
				finally{
					bR.close();
				}
				
				
			} catch (IOException e) {
				MyUtilities.saveStringToFile("Erreur lors de la lecture dans le fichier !", logFileName);
				e.printStackTrace();
			}
		}
		
		
	}

	public double getSeuilElectoral() {
		return seuilElectoral;
	}

	public int getNbSiegesAPourvoir() {
		return nbSiegesAPourvoir;
	}

	public ListeElectorale[] getListesElectorales() {
		return listesElectorales;
	}

	public void setListesElectorales(ListeElectorale[] listesElectorales) {
		// TODO Ecrire dans outFileName le résultat des élections
		File f = new File(outFileName);
		BufferedWriter bW = null;
		
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			bW= new BufferedWriter(new FileWriter(f));
			for(int i =0; i<listesElectorales.length; i++){
				bW.write(listesElectorales[i].getNom());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getInFileName() {
		return inFileName;
	}

	public String getOutFileName() {
		return outFileName;
	}

	public String getLogFileName() {
		return logFileName;
	}

}
