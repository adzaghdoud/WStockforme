package com.WSREST.dao;


import java.text.ParseException;
import java.util.List;

import com.WSREST.model.Commande;


public interface CommandeDao {
	void ajouter( Commande commande) ;
	List<Commande> lister() ;
	Commande  searchbynumfacture (String numfacture);
	 List<Commande> listergrouby(String numfactures);
     List<Commande>  searchbydatecommande (String datecommande);
     double cajournalier(String datecommande);
     int nomberproduitvendu(String datecommande);
     int numberpaiementtovalidate();
     int numberpaiementrejet();
     Commande getinfocommande (int numcommande);
     List<Commande> searchcommandebetweentwodates(String date1 , String date2);
	}   
