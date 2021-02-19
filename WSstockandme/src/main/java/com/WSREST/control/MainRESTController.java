package com.WSREST.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.WSREST.config.AppConfig;
import com.WSREST.model.*;
import com.WSREST.service.CommandeService;
import com.WSREST.service.ProduitService;

@Controller
@RequestMapping(value="/factures")
public class MainRESTController {
@RequestMapping(value = "/listefactures", headers="Accept=*/*",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)            
public @ResponseBody List<Commande> getall() {  	
	System.out.println("***********fetching all commande");
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
	return srvcommande.lister();
}
 	
	@RequestMapping(value = "/{numf}", headers="Accept=*/*",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)            
    public @ResponseBody Commande getfacture(@PathVariable("numf") String numfacture) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	return srvcommande.searchbynumfacture(numfacture);
    }	
	
	
	@RequestMapping(value = "/date/{datef}", headers="Accept=*/*",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)            
    public @ResponseBody List<Commande> getfacturewithdate(@PathVariable("datef") String datefacture) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	CommandeService srvcommande = (CommandeService) context.getBean("commandeservice");
    	return srvcommande.searchbydatecommande(datefacture);
    }
	
}
