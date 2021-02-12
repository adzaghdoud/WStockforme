package com.WSREST.dao;


import java.text.ParseException;
import java.util.List;

import com.WSREST.model.Commande;


public interface CommandeDao {
	//boolean ajouter( Commande commande) ;
	List<Commande> lister() ;
	//List<Commande>  searchbynumclient (int numclient);
	Commande  searchbynumfacture (String numfacture);
	//List<Commande>  searchbynumcommande (int numcommande);
	//List<Commande>  searchbynumcommandeandnumclient ( int numclient,int numcommande );
	//List<Commande>  searchbydatecommande (String datecommande);
	//List<Commande>  searchbydateandnumcommande (String datecommande , int numcommande );
	//List<Commande>  searchbydateandnumclient (String datecommande , int numclient );
	//List<Commande>  searchbydateandnumclientandnumcommande (String datecommande , int numclient  , int numcommande);
	//int getlastnumcommande();
	//List<Commande>  searchbynumfacture (String numfacture);
    //boolean updatecommande (String numcommmande ,String montant , String modepaiement , String statuspaiement , String modelivraison , String statuslivraison);
    //List<Commande>  searchbetweentwodate (String datedeb, String datefin ) ;
}   
