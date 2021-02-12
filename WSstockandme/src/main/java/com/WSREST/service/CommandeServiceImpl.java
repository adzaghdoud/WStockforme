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

	
}