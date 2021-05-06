package com.WSREST.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WSREST.dao.PanierDao;
import com.WSREST.dao.ProduitDao;
import com.WSREST.model.Panier;

@Service("PanierService")
@Transactional
public class PanierServiceImpl  implements PanierService{
	@Autowired
    private PanierDao dao;
	public void addtopanier(int codeproduit, int quantite, double montant, String user,  int numclient,int numcommande,String libproduit,String numfacture) {
		// TODO Auto-generated method stub
		dao.addtopanier(codeproduit, quantite, montant, user, numclient, numcommande,libproduit,numfacture);
	}
	public List<Panier> getcontain(String user) {
		// TODO Auto-generated method stub
		return dao.getcontain(user);
	}
	public int countcontaint(String user) {
		// TODO Auto-generated method stub
		return dao.countcontaint(user);
	}
	public double sumcontaint(String user) {
		// TODO Auto-generated method stub
		return dao.sumcontaint(user);
	}
	public int numclientcontaint(String user) {
		// TODO Auto-generated method stub
		return dao.numclientcontaint(user);
	}
	public void updatenumfacture(String user, String numfacture) {
		// TODO Auto-generated method stub
		dao.updatenumfacture(user, numfacture);
		
	}
	public void updatelibproduit(int codeproduit, String libproduit) {
		// TODO Auto-generated method stub
		dao.updatelibproduit(codeproduit, libproduit);
	}
	public void deletepanierandaddtohistorique(String user) {
		// TODO Auto-generated method stub
		dao.deletepanierandaddtohistorique(user);
	}
	public List<Panier> searchbynumcommande(int numcommande) {
		// TODO Auto-generated method stub
		return dao.searchbynumcommande(numcommande);
	}
	

}