package com.WSREST.control;

import java.text.DecimalFormat;
import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.WSREST.config.AppConfig;
import com.WSREST.model.Commande;
import com.WSREST.model.Produit;
import com.WSREST.service.CommandeService;
import com.WSREST.model.Panier;
import com.WSREST.service.PanierService;
import com.WSREST.service.ProduitService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/commandes")
public class CommandeController {
	@RequestMapping(value = "/date/{datec}", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody List<Commande> getfacturewithdate(@PathVariable("datec") String datecmd) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	List<Commande>listc = srvcommande.listergrouby(datecmd);
    	context.close();
    	return listc;
    }
	
	@RequestMapping(value = "/CA/{datec}", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody double getCAfordate(@PathVariable("datec") String datecmd) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");	
    	double ca = srvcommande.cajournalier(datecmd);
    	context.close();
    	return ca;
    }
	@RequestMapping(value = "/nbproduit/{datec}", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody double getnbproduitvendufordate(@PathVariable("datec") String datecmd) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	int nb = srvcommande.nomberproduitvendu(datecmd);
    	context.close();
    	return nb;
    }
	
	@RequestMapping(value = "/benef/{datec}", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody double getbeneffordate(@PathVariable("datec") String datecmd) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
	    ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");
	    PanierService srvpanier = (PanierService) context.getBean("PanierService");
		List<Commande> c = srvcommande.searchbydatecommande(datecmd);
		 
	    double benef=0;
		for(int i=0; i<c.size(); i++) {
	         Commande element=c.get(i);
	         //recherche nombre de produit dans la commande
	         List<Panier> listp=srvpanier.searchbynumcommande(element.getNumcommande());
	         for(int j=0;j<listp.size() ; j++) {            	 
	        	
	        	 benef=benef+(listp.get(j).getMontant() - (listp.get(j).getQuantite()*srvproduit.getuntitpriceachat(listp.get(j).getCode_produit())));
	             
	         }
	        
	   }
		context.close();
    	return (double)Math.round(benef * 100) / 100 ;
    }
	
	
	@RequestMapping(value = "/nbpaiementtovalidate", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody int getallpaiementtovalidate() {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	int nb = srvcommande.numberpaiementtovalidate();
    	context.close();
    	return nb;
    	
    }
	
	
	@RequestMapping(value = "/nbpaiementrejet", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody int getallrejectedpaiement() {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	int nb = srvcommande.numberpaiementrejet();
    	context.close();
    	return nb;
    	
    }
	
	
	@RequestMapping(value = "/{numc}", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody Commande getinfocommande(@PathVariable("numc") String numc) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	Commande c = srvcommande.getinfocommande(Integer.parseInt(numc));
    	context.close();
    	return c;
    }
	
	
	@RequestMapping(value = "/between/{date1}/{date2}", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody List<Commande> getcmds(@PathVariable("date1") String date1 ,@PathVariable("date2") String date2 ) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	List<Commande> listc= srvcommande.searchcommandebetweentwodates(date1, date2);
    	context.close();
    	return listc;
    }
	
	
	
	
	
	

}
