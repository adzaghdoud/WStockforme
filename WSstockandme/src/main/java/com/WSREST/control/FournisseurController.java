package com.WSREST.control;

import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.WSREST.config.AppConfig;
import com.WSREST.model.Fournisseur;
import com.WSREST.service.FournisseurService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/fournisseurs")
public class FournisseurController {
	private static final org.apache.logging.log4j.Logger LOG =  LogManager.getLogger(FournisseurController.class);
	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody boolean createproduct(@RequestBody Fournisseur f) {  		
		Boolean result=true;
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
		FournisseurService srvfournisseur = (FournisseurService) context.getBean("FournisseurService");
		try {
			srvfournisseur.addfournisseur(f);
		}
		catch (HibernateException e ) {	
		LOG.error("error"+e);
		result=false;	
		}
		LOG.info("WS :rajout nouveau fournisseur : "+f.getnom());
		context.close();
		return result;
    }
	

}
