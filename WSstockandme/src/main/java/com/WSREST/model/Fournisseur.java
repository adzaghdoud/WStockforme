package com.WSREST.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="fournisseur")
public class Fournisseur {
	@Id
	private int id;
	@Column
	private String nom;
	@Column
	private String adresse;
	@Column
	private String tel;
	@Column
	private String siret;
	@Column
	private String iban;
	
	
	public void setid(int id) {
		
		this.id=id;
	}
	
    public int getid() {
		
		return this.id;
	}
	
    
    
    public void setnom(String nom) {
		
		this.nom=nom;
	}
	
    public String getnom() {
		
		return this.nom;
	}
    
	
  public void setadresse(String adresse) {
		
		this.adresse=adresse;
	}
	
    public String getadresse() {
		
		return this.adresse;
	}
    
    
    
    public void settel(String tel) {
		
  		this.tel=tel;
  	}
  	
      public String gettel() {
  		
  		return this.tel;
  	}
    
    
      public void setsiret(String siret) {
  		
    		this.siret=siret;
    	}
    	
        public String getsiret() {
    		
    		return this.siret;
    	}
      
      
        
        
        public void setiban(String iban) {
      		
    		this.iban=iban;
    	}
    	
        public String getiban() {
    		
    		return this.iban;
    				
    	}
      
	

}
