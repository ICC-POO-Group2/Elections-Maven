package spring.core.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import spring.core.dao.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ElectionsDaoFile implements IElectionsDao {
	@Autowired
	@Qualifier("daoFile")
	private String inFileName = null;
	private String outFileName = null;
	private String logFileName = null;
	private double seuilElectoral;
	private int nbSiegesAPourvoir;
	private ListeElectorale[] listesElectorales =  null;
	
	// Cosntructeurs
	public ElectionsDaoFile(String inFileName, String outFileName, String logFileName) throws ElectionsException, IOException{
		this.inFileName = inFileName;
		this.outFileName = outFileName;
		this.logFileName = logFileName;
		File f = new File(inFileName);
		BufferedReader  bR =null;
		StringBuilder sB= new StringBuilder();
		if(!f.exists()){
			throw new IOException("Le fichier n'existe pas");
		}else{
			try {
				bR = new BufferedReader(
						new FileReader(f));
				try{
					
				}
				finally{
					bR.close();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		
		
		
	}
	private int setNbSiegesAPourvoir(int nbSAPourvoir) {
		int sap = 0;	
		try{
					sap= nbSAPourvoir;
				}catch(InputMismatchException e){
					System.out.println("Erreur: Le chiffres des sieges à pourvoir doit etre strictement positif");
					System.exit(1);
				}
			
		
		return sap;
	}
	private double setSeuilElectoral(int seuil) {
		
		return 0;
	}
	// Getters et Setters
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
		
 
	}

}
