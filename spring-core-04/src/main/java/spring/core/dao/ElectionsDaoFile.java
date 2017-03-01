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
	/**
	 * le nom du fichier qui contient les données nécessaires au calcul des sièges
	 * 
	 */
	private String inFileName = null;
	
	/**
	* le nom du fichier qui contiendra les résultats
	*/
	String outFileName = null;
	
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
	public ElectionsDaoFile(String inFileName, String outFileName, String logFileName) {
		this.inFileName = inFileName;
		this.outFileName = outFileName;
		this.logFileName = logFileName;
		
		//TODO Initialiser seuilElectoral, nbSiegesAPourvoir et les listesElectorales
		//		Lire le fichier infileName
		
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
