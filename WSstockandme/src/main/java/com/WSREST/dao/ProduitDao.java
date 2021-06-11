package com.WSREST.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.WSREST.model.Produit;

public interface ProduitDao {
	
	void ajouter(Produit p,MultipartFile file) ;
	
	List<Produit> getallstock();
	double getuntitpriceachat (int id);
	Produit getinfoproduit(String libproduit);
	boolean checkexistanceimage (byte [] b);
	int getstockproduct(int codeproduit);
	
	

}
