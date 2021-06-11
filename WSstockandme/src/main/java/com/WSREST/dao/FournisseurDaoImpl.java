package com.WSREST.dao;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.WSREST.model.Fournisseur;
@Repository("FournisseuDao")
public class FournisseurDaoImpl extends AbstractDao implements FournisseurDao {

	public void addfournisseur(Fournisseur f) throws  HibernateException{
	this.persist(f);
	}

}
