package com.WSREST.dao;

import java.util.List;

import com.WSREST.model.Panier;

public interface PanierDao {
	
	void addtopanier(int codeproduit , int quantite , double montant , String user, int numclient ,int nummcommande,String libproduit,String numfacture);
	List <Panier> getcontain(String user);
	int countcontaint(String user);
	double sumcontaint(String user);
	int numclientcontaint(String user);
	void updatenumfacture(String user, String numfacture);
	void updatelibproduit ( int codeproduit,String libproduit);
	void deletepanierandaddtohistorique(String user);
	List <Panier> searchbynumcommande(int numcommande);
	

}
