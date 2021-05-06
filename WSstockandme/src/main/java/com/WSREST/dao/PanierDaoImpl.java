package com.WSREST.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.WSREST.model.Fournisseur;
import com.WSREST.model.Panier;
@Repository("PanierDao")
public class PanierDaoImpl extends AbstractDao implements PanierDao {

	public void addtopanier(int codeproduit, int quantite, double montant, String user, int numclient,int numcommande,String libproduit,String numfacture) {
		    Panier p = new Panier();
		    p.setCode_produit(codeproduit);
		    p.setQuantite(quantite);
		    p.setMontant(montant);
		    p.setUser(user);
		    p.setNumclient(numclient);
		    p.setNumcommande(numcommande);
		    persist(p);
		
	}

	public List<Panier> getcontain(String user) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Panier.class);
		criteria.add(Restrictions.eq("user",user));
		return   (List<Panier>)criteria.list();
	}

	public int countcontaint(String user) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("select count(*) from panier where user = '"+user+"';");
		//return (Integer) query.uniqueResult();
		return ((Number) query.uniqueResult()).intValue();
	}

	public double sumcontaint(String user) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("select sum(montant) from panier where user = '"+user+"';");
		return (Double) query.uniqueResult();
	}

	public int numclientcontaint(String user) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("select numclient from panier where user = '"+user+"' LIMIT 1;");
		return (Integer) query.uniqueResult();
	}

	public void updatenumfacture(String user,String numfacture) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("update panier set numfacture = '"+numfacture+"'  where user = '"+user+"' ;");
		query.executeUpdate();
	}

	public void updatelibproduit(int codeproduit, String libproduit) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("update panier set libproduit = '"+libproduit+"'  where code_produit = '"+codeproduit+"' ;");
		query.executeUpdate();
		
	}

	public void deletepanierandaddtohistorique(String user) {
		Query query1 = getSession().createSQLQuery("insert into historique_commande select * from panier where user = '"+user+"' ;");	
		Query query2 = getSession().createSQLQuery("delete from panier where user = '"+user+"' ;");	
		query1.executeUpdate();
		query2.executeUpdate();	
	}

	public List<Panier> searchbynumcommande(int numcommande) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("select * from historique_commande  where numcommande = '"+numcommande+"';").addScalar("code_produit",new IntegerType()).addScalar("montant", new DoubleType()).addScalar("quantite", new IntegerType()).setResultTransformer(Transformers.aliasToBean(Panier.class));
		return  query.list();
	}

}
