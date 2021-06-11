package com.WSREST.dao;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.WSREST.model.Produit;
import com.WSREST.tools.Generateqrcode;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
@Repository("ProduitDao")
public class ProduitDaoImpl  extends AbstractDao implements ProduitDao{

	public void ajouter(Produit p,MultipartFile file) {
	
		
		Query query1 = getSession().createSQLQuery("SELECT DISTINCT seuil from produit;");
		int valseuil=(Integer) query1.uniqueResult();
		p.setSeuil(valseuil);
		byte[] byteArr;
		try {
			byteArr = file.getBytes();
			p.setImage( byteArr);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		//genereate qr code 
		try {
			BitMatrix b =Generateqrcode.generateMatrix(p.getlib_produit(), 300);
		    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        try {
				MatrixToImageWriter.writeToStream(b, "png", bos);
				p.setQrcode(bos.toByteArray());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		    
		} catch (WriterException e) {
		
			e.printStackTrace();
		}
		this.persist(p);
	}

	public List<Produit> getallstock() {

		Criteria criteria = getSession().createCriteria(Produit.class);	    
	return criteria.list();
	}

	public double getuntitpriceachat(int id) {

				Criteria criteria = getSession().createCriteria(Produit.class);
		        criteria.add(Restrictions.eq("id",id));
		        Produit res=(Produit) criteria.uniqueResult();
		        return res.getPua();
	}

	public Produit getinfoproduit(String  libproduit) {
		Criteria criteria = getSession().createCriteria(Produit.class);
		  criteria.add(Restrictions.eq("lib_produit",libproduit));
	      return  (Produit) criteria.uniqueResult();
	}

	public boolean checkexistanceimage(byte[] b) {
		boolean flag=false;
		Query query1 = getSession().createSQLQuery("SELECT HEX(image)  from produit where HEX(image) =  HEX('"+b+"');");
		
		if (query1.uniqueResult() != null)  {
		flag = true;	
		}
		else {
			flag =false;
		}
	return flag;
	}

	public int getstockproduct(int codeproduit) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("SELECT stock  from produit where code_produit = '"+codeproduit+"';");
		return (Integer) query.uniqueResult();
	}


}
