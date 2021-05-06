package com.WSREST.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mysql.cj.jdbc.Blob;


@Entity
@Table(name="produit")
public class Produit {
	@Id
	@Column(name = "code_produit")
	private int codeproduit;
	@Column(name = "lib_produit")
	private String lib_produit;
	@Column(name = "stock")
	private int stock;
	@Column(name = "pua")
	private double pua ;
	@Column(name = "puv")
	private double puv ;
	@Column(name = "fournisseur")
	private int fournisseur;
	@Column(name = "seuil")
	private int seuil;
	@Column(name = "image")
	private byte[]  image;
	@Column(name = "qrcode")
	private byte[]  qrcode;
	
	public void setQrcode(byte[]  b) {
		
		this.qrcode=b;
	}
	
	public byte[] getQrcode() {
		
		return this.qrcode;
	}
	public void setImage(byte[] image) {
		this.image=image;
	}
	
	public byte[] getImage() {
		
		return this.image;
	}
	
	
	public void setSeuil(int s) {
		seuil=s;
	}
	public int getSeuil() {
		
		return this.seuil;
	}
	
	
	public void setCodeproduit(int code) {
		
	this.codeproduit=code;	
		
	}

	public void set_libproduit(String libproduit) {
		
	this.lib_produit=libproduit;	
		
	}

	public void setStock(int stock) {
		
	this.stock=stock;	
		
	}


	public void setPua (double pua) {
		
	this.pua=pua;	
		
	}


	public void setPuv (double puv) {
		
	this.puv=puv;	
		
	}


	public void setFournisseur (int  fournisseur) {
		
	this.fournisseur=fournisseur;	
		
	}

	public double getPua() {
		return pua;
		
	}


	public double getPuv() {
		return puv;
		
	}


	public int getFournisseur() {
		return fournisseur;
		
	}




	public int getCodeproduit() {
		return codeproduit;
		
	}

	public int getStock() {
		return stock;
		
	}

	public String getlib_produit() {
		
		return lib_produit;
	}
 

}
