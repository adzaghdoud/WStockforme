package com.WSREST.service;

import java.util.List;

import com.WSREST.model.Commande;

public interface CommandeService {
	void ajouter( Commande commande) ;
	List<Commande> lister() ;
	Commande  searchbynumfacture (String numfacture);
	List<Commande>  searchbydatecommande (String datecommande);
	List<Commande> listergrouby(String datecommandes);
	 double cajournalier(String datecommande);
	 int nomberproduitvendu(String datecommande);
	 int numberpaiementtovalidate();
	 int numberpaiementrejet();
	 Commande getinfocommande (int numcommande);
	 List<Commande> searchcommandebetweentwodates(String date1 , String date2);
}