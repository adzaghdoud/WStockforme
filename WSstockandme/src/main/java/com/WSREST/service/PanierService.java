package com.WSREST.service;

import java.util.List;

import com.WSREST.model.Panier;

public interface PanierService {
	void addtopanier(int codeproduit , int quantite , double montant , String user, int numclient ,int numcommande,String libproduit,String numfacture);
	List <Panier> getcontain(String user);
	int countcontaint(String user);
	double sumcontaint(String user);
	int numclientcontaint(String user);
	void updatenumfacture(String user, String numfacture);
	void updatelibproduit ( int codeproduit,String libproduit);
	void deletepanierandaddtohistorique(String user);
	List <Panier> searchbynumcommande(int numcommande);
}
