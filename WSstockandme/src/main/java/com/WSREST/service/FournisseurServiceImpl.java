package com.WSREST.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WSREST.dao.CommandeDao;
import com.WSREST.dao.FournisseurDao;
import com.WSREST.model.Fournisseur;
@Service("FournisseurService")
@Transactional
public class FournisseurServiceImpl implements FournisseurService{
	@Autowired
    private FournisseurDao dao;
	public void addfournisseur(Fournisseur f) {
		dao.addfournisseur(f);
		
	}

}
