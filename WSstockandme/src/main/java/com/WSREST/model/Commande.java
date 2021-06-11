package com.WSREST.model;
import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name="Commande")
public class Commande {
	@Id
	private int numcommande;
	@Column(name = "date_commande")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Paris")
	private Timestamp date;

	@Column(name = "numclient")
	private int numclient;

	@Column(name = "montant")
	private Double montant;

	@Column(name = "modePaiement")
	private String modePaiement;

	@Column(name = "statutPaiement")
	private String statutPaiement;

	@Column(name = "modeLivraison")
	private String modeLivraison;

	@Column(name = "statutLivraison")
	private String statutLivraison;

	@Column(name = "numfacture")
	private String numfacture;
	@Column(name = "date_validation")
	private String date_validation;
	@Column(name = "date_rejet")
	private String date_rejet;

	

		public Timestamp getDate() {
			return date;
			}
			public void setDate( Timestamp date ) {
			this.date = date;
			}
			
			public Double getMontant() {
				return montant;
				}
				public void setMontant( Double montant ) {
				this.montant = montant;
				}
				
public String getModePaiement() {
return modePaiement;
}
public void setModePaiement( String modePaiement ) {
this.modePaiement = modePaiement;
}
public String getStatutPaiement() {
return statutPaiement;
}
public void setStatutPaiement( String statutPaiement ) {
this.statutPaiement = statutPaiement;
}
public String getModeLivraison() {
return modeLivraison;
}
public void setModeLivraison( String modeLivraison ) {
this.modeLivraison = modeLivraison;
}
public String getStatutLivraison() {
return statutLivraison;
}

public String getNumfacture() {
return numfacture;
}

public void setNumfacture( String num ) {
this.numfacture = num;
}

public void setStatutLivraison( String statutLivraison ) {
this.statutLivraison = statutLivraison;
}


public void setnumcommande( int numcommande ) {
this.numcommande = numcommande;
}


public int getNumcommande() {
return numcommande;
}



public void setNumclient( int numclient ) {
this.numclient = numclient;
}


public int getNumclient() {
return numclient;
}




}
	
