package com.WSREST.service;

import java.util.List;

import com.WSREST.model.Commande;

public interface CommandeService {
	//boolean ajouter( Commande commande) ;
	List<Commande> lister() ;
	//List<Commande>  searchbynumclient (int numclient);
	Commande  searchbynumfacture (String numfacture);
	//List<Commande>  searchbynumcommande (int numclient);
	//List<Commande>  searchbynumcommandeandnumclient (int numclient, int nummcommande);
	//List<Commande>  searchbydatecommande (String datecommande);
	//List<Commande> searchbydateandnumclientandnumcommande (String datecommande , int numclient  , int numcommande);
	//List<Commande> searchbydateandnumcommande(String datecommande, int numcommande) ;
	//List<Commande>  searchbydateandnumclient (String datecommande , int numclient );
	//List<Commande> searchbetweentwodate(String datedeb, String datefin);
	//boolean updatecommande (String numcommmande ,String montant , String modepaiement , String statuspaiement , String modelivraison , String statuslivraison);

}