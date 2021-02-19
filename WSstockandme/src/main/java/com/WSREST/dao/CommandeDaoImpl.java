package com.WSREST.dao;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.WSREST.model.Commande;
@Repository("CommandeDao")
public class CommandeDaoImpl extends AbstractDao implements CommandeDao {


	public Commande searchbynumfacture(String numfacture) {
		// TODO Auto-generated method stu
		Criteria criteria = getSession().createCriteria(Commande.class);
        criteria.add(Restrictions.eq("numfacture",numfacture));
        System.out.println("*********OK");
        return (Commande) criteria.uniqueResult();
	}

	public List<Commande> lister() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Commande.class);
     
		return (List<Commande>) criteria.list();
	}

	public List<Commande> searchbydatecommande(String datecommande) {
		// TODO Auto-generated method stub
		String expr=datecommande+"%";
		Criteria criteria = getSession().createCriteria(Commande.class);
		criteria.add(Restrictions.sqlRestriction("date_commande like '"+expr+"'"));
	    return criteria.list();
	}

	public void ajouter(Commande commande) {
		// TODO Auto-generated method stub
		 this.persist(commande);
	}

	
	}
	


