package com.WSREST.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.WSREST.dao.CommandeDao;
import com.WSREST.dao.ProduitDao;
import com.WSREST.model.Produit;

@Service("ProduitService")
@Transactional
public class ProduitServiceImpl implements ProduitService{
	@Autowired
    private ProduitDao dao;
	public void ajouter(Produit p,MultipartFile file) {
		// TODO Auto-generated method stub
		
			dao.ajouter(p,file);
		
	}
	public List<Produit> getallstock() {
		// TODO Auto-generated method stub
		return dao.getallstock();
	}
	public double getuntitpriceachat(int id) {
		// TODO Auto-generated method stub
		return dao.getuntitpriceachat(id);
	}
	public Produit getinfoproduit(String libproduit) {
		// TODO Auto-generated method stub
		return dao.getinfoproduit(libproduit);
	}
	public boolean checkexistanceimage(byte[] b) {
		// TODO Auto-generated method stub
		return dao.checkexistanceimage(b);
	}
	public int getstockproduct(int codeproduit) {
		// TODO Auto-generated method stub
		return dao.getstockproduct(codeproduit);
	}

}
