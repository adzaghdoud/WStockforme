package com.WSREST.service;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WSREST.dao.CommandeDao;
import com.WSREST.model.Commande;
@Service("commandeservice")
@Transactional
public class CommandeServiceImpl implements CommandeService{
	@Autowired
    private CommandeDao dao;
	public Commande searchbynumfacture(String numfacture) {
		// TODO Auto-generated method stub
		return dao.searchbynumfacture(numfacture);
	}
	public List<Commande> lister() {
		// TODO Auto-generated method stub
		return dao.lister();
	}
	public List<Commande> searchbydatecommande(String datecommande) {
		// TODO Auto-generated method stub
		return dao.searchbydatecommande(datecommande);
	}
	public void ajouter(Commande commande) {
		// TODO Auto-generated method stub
		dao.ajouter(commande);
		
	}
	public List<Commande> listergrouby(String datecommandes) {
		// TODO Auto-generated method stub
		return dao.listergrouby(datecommandes);
	}
	public double cajournalier(String datecommande) {
		// TODO Auto-generated method stub
		return dao.cajournalier(datecommande);
	}
	public int nomberproduitvendu(String datecommande) {
		// TODO Auto-generated method stub
		return dao.nomberproduitvendu(datecommande);
	}
	public int numberpaiementtovalidate() {
		// TODO Auto-generated method stub
		return dao.numberpaiementtovalidate();
	}
	public int numberpaiementrejet() {
		// TODO Auto-generated method stub
		return dao.numberpaiementrejet();
	}
	public Commande getinfocommande(int numcommande) {
		// TODO Auto-generated method stub
		return dao.getinfocommande(numcommande);
	}
	public List<Commande> searchcommandebetweentwodates(String date1, String date2) {
		// TODO Auto-generated method stub
		return dao.searchcommandebetweentwodates(date1, date2);
	}

	
}