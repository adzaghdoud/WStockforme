package com.WSREST.control;


import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.WSREST.config.AppConfig;
import com.WSREST.model.*;
import com.WSREST.service.CommandeService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value="/factures")
public class MainRESTController {
@RequestMapping(value = "/listefactures", headers="Accept=*/*",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)            
public @ResponseBody List<Commande> getall() {  	
	System.out.println("***********fetching all commande");
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
	List<Commande>listp = srvcommande.lister();
	context.close();
	return listp;
}
 	
	@RequestMapping(value = "/{numf}", headers="Accept=*/*",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)            
    public @ResponseBody Commande getfacture(@PathVariable("numf") String numfacture) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	Commande c = srvcommande.searchbynumfacture(numfacture);
    	context.close();
    	return c;
    }	
	
	
	@RequestMapping(value = "/date/{datef}", headers="Accept=*/*",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)            
    public @ResponseBody List<Commande> getfacturewithdate(@PathVariable("datef") String datefacture) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	List<Commande>listp = srvcommande.searchbydatecommande(datefacture);
    	context.close();
    	return listp;
    }
	
}
