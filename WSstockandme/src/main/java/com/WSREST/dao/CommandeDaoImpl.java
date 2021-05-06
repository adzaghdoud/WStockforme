package com.WSREST.dao;
import java.text.DateFormat;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.WSREST.model.Commande;
@Repository("CommandeDao")
public class CommandeDaoImpl extends AbstractDao implements CommandeDao {


	public Commande searchbynumfacture(String numfacture) {
		// TODO Auto-generated method stu
		Criteria criteria = getSession().createCriteria(Commande.class);
        criteria.add(Restrictions.eq("numfacture",numfacture));
        return (Commande) criteria.uniqueResult();
	}

	public List<Commande> lister() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Commande.class);
     
		return (List<Commande>) criteria.list();
	}

	public List<Commande> listergrouby(String datecommandes) {
		// TODO Auto-generated method stub
		String expr=datecommandes+"%";
		Query query = getSession().createSQLQuery("select numclient , sum(montant) as montant from historique_commande where date_commande like'"+expr+"' group by numfacture;").addScalar("numclient",new IntegerType()).addScalar("montant", new DoubleType()).setResultTransformer(Transformers.aliasToBean(Commande.class));;	
		//Query query = getSession().createSQLQuery("select numclient , sum(montant) as montant from historique_commande h Commande c where h.numfacture=c.numfacture and c.date_commande like'"+expr+"' group by numfacture;");
		return  (List<Commande>) query.list();
     
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

	public double cajournalier(String datecommande) {
		// TODO Auto-generated method stub
		String expr=datecommande+"%";
		Query query = getSession().createSQLQuery("select sum(montant) from Commande where date_commande like  '"+expr+"';");
		double res =0;
		if (query.uniqueResult() == null) {
			res=0;
			 
		}else {
		res = ((Double) query.uniqueResult()).doubleValue();
		res=(double)Math.round(res * 100) / 100 ;
		}
	   
		return res;
	}

	public int nomberproduitvendu(String datecommande) {
		// TODO Auto-generated method stub
		String expr=datecommande+"%";
		Query query = getSession().createSQLQuery("select count(*) from Commande c join historique_commande h on c.numcommande=h.numcommande and c.date_commande like  '"+expr+"';");
		if (query.list().size()==0) {
			return 0;
		}else {
			
		
		return ((Number) query.uniqueResult()).intValue();}
	}

	public int numberpaiementtovalidate() {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("select count(*) from Commande where statutPaiement='validation en cours';");
		if (query.list().size()==0) {
			return 0;
		}else {
			
		
		return ((Number) query.uniqueResult()).intValue();}
	}

	public int numberpaiementrejet() {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("select count(*) from Commande where statutPaiement='rejete';");
		if (query.list().size()==0) {
			return 0;
		}else {
			
		
		return ((Number) query.uniqueResult()).intValue();}
	}

	public Commande getinfocommande(int numcommande) {
	
		Criteria criteria = getSession().createCriteria(Commande.class);
        criteria.add(Restrictions.eq("numcommande",numcommande));
        return (Commande) criteria.uniqueResult();
	}

	public List<Commande> searchcommandebetweentwodates(String date1, String date2) {
	
		Criteria criteria = getSession().createCriteria(Commande.class);
		criteria.add(Restrictions.sqlRestriction("DATE_FORMAT(date_commande, '%y-%m-%d') BETWEEN DATE_FORMAT('" + date1 +"', '%y-%m-%d')  AND  DATE_FORMAT('" + date2 +"', '%y-%m-%d');"));			
		 return  criteria.list();
	}
	

	
	}
	


