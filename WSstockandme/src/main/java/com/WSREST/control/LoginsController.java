package com.WSREST.control;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.WSREST.config.AppConfig;
import com.WSREST.model.Commande;
import com.WSREST.model.Fournisseur;
import com.WSREST.service.CommandeService;
import com.WSREST.service.FournisseurService;
import com.WSREST.service.LoginsService;
import com.WSREST.tools.RandomString;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/login")
public class LoginsController {
	private static final org.apache.logging.log4j.Logger LOG =  LogManager.getLogger(LoginsController.class);
	@PutMapping(value = "/reset/{login}/{newpassword}")            
    public @ResponseBody boolean resetpassword(@PathVariable("login") String login,@PathVariable("newpassword") String newpassword) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
		LoginsService srvlogins = (LoginsService) context.getBean("LoginsService");	
		LOG.info("WS :reset password for user "+login);
		return srvlogins.updatepassword(newpassword, login);
        
}
	
	@RequestMapping(value = "/gettempocode/{email}/", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody void getnewcode(@PathVariable("email") String email) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	LoginsService srvlogin = (LoginsService) context.getBean("LoginsService");
        if (srvlogin.checkexistancemail(email)) {
        //génération code temporaire de 5 chiffres
        	RandomString r = new RandomString();
        	String generatedcode= r.getAlphaNumericString(12);        
            srvlogin.insertgeneratedcode(generatedcode, srvlogin.getloginfromemail(email));
            //send generated code by mail
            InputStream input = LoginsController.class.getClassLoader().getResourceAsStream("application.properties");
            Properties prop = new Properties();
            try {
    			prop.load(input);
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    		
    		}
    		final String username = prop.getProperty("smtp.username");
    		final String password = prop.getProperty("smtp.password");
    		
    		// Etape 1 : Création de la session
    		Properties props = new Properties();
    		props.put("mail.smtp.auth", "true");
    		props.put("mail.smtp.starttls.enable","true");
    		props.put("mail.smtp.host","smtp-relay.sendinblue.com");
    		props.put("mail.smtp.port","587");
    		Session session = Session.getInstance(props,
    		new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    		return new PasswordAuthentication(username, password);
    		}
    		});
    		try {
    		// Etape 2 : Création de l'objet Message
    		Message message = new MimeMessage(session);
    		message.setFrom(new InternetAddress("adem_zaghdoud@hotmail.com"));
    		message.setRecipients(Message.RecipientType.TO,
    		InternetAddress.parse(email));
    		message.setSubject("Code Provisoire de Connexion");
    		message.setContent("<!DOCTYPE html><html> <head>"+
    				" <style><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>  </style></head> <body> Bonjour ,<br/> ci-dessous le code provisoire pour accéder à stockforme : <br/> <b>"+generatedcode+"</b> <br/><a href='http://localhost:8082/stockforme/login'><button class='btn btn-success float-right' type='button'>Login</button></a> </body>", "text/html; charset=UTF-8");	
    		// Etape 3 : Envoyer le message
    		Transport.send(message);
    		} catch (MessagingException e) {
    		System.out.println(e.getStackTrace());
    		} }
        }
    }
	
	
	
