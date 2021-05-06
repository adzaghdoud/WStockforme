package com.WSREST.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="panier")
	public class Panier {
		@Id
		int id;
		@Column(name = "code_produit")
		private int code_produit;
		@Column(name = "quantite")
		private int quantite;
		@Column(name = "montant")
		private double montant;
		@Column(name = "user")
		private String user;
		@Column(name = "numclient")
		private int numclient;
		private int numcommande;
		private String libproduit;
		private String numfacture;
		
		
		
		
		public int getCode_produit() {
			return this.code_produit;
		}
		
		public void setCode_produit(int cp) {
			
			this.code_produit=cp;
		}
		
		
		public int getQuantite() {
			return this.quantite;
		}
		
		public void setQuantite(int Q) {
			
			this.quantite=Q;
		}
		
		
		public double getMontant() {
			return this.montant;
		}
		
		public void setMontant(double m) {
			
			this.montant=m;
		}

		public String getUser() {
			return this.user;
		}
		
		public void setUser(String u) {
			
			this.user=u;
		}
		

		
		public int getNumclient() {
			return this.numclient;
		}
		
		public void setNumclient(int numclient) {
			
			this.numclient=numclient;
		}
		
		public int getNumcommande() {
			return this.numcommande;
		}
		
		public void setNumcommande(int numcommande) {
			
			this.numcommande=numcommande;
		}

		public String getLibproduit() {
			return this.libproduit;
		}
		
		public void setLibproduit(String libproduit) {
			
			this.libproduit=libproduit;
		}
		
		public String getNumfacture() {
			return this.numfacture;
		}
		
		public void setNumfacture(String numfacture) {
			
			this.numfacture=numfacture;
		}


}
