package com.WSREST.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.WSREST.model.Produit;

public interface ProduitService {
	void ajouter(Produit p,MultipartFile file);
	List<Produit> getallstock();
	double getuntitpriceachat (int id);
	Produit getinfoproduit(String libproduit);
	boolean checkexistanceimage (byte [] b);
	int getstockproduct(int codeproduit);

}
