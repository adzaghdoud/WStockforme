package com.WSREST.control;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.WSREST.config.AppConfig;
import com.WSREST.model.Produit;
import com.WSREST.service.ProduitService;
import com.WSREST.tools.Generatebarcode;
import com.google.gson.Gson;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/products",headers="Accept=*/*")
public class ProductController {

	@PostMapping(value = "/create",produces = { MediaType.APPLICATION_JSON_VALUE })            
	
	public @ResponseBody void createproduct(@RequestParam("fileimage") MultipartFile file, @RequestParam("myjson") String  json) {
		Produit prd = new Gson().fromJson(json, Produit.class);
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
		ProduitService srvprd = (ProduitService) context.getBean("ProduitService");	
		try {
			byte[] array = file.getBytes();
			if (srvprd.checkexistanceimage(array)) {		
			System.out.println("********************image existe deja en base");	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		srvprd.ajouter(prd,file);
		context.close();
    }
	
	
	@GetMapping(value = "/stock",produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody List<Produit> getallstock() {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
		ProduitService srvprd = (ProduitService) context.getBean("ProduitService");
		List<Produit> listp= srvprd.getallstock();
		context.close();
		return  listp;
    }
	
	@RequestMapping(value = "/getinfoproduct/{lib}", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE })            
    public @ResponseBody Produit getinfoproduit(@PathVariable("lib") String lib) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
    	ProduitService srvproduit = (ProduitService) context.getBean("ProduitService");
    	Produit p =srvproduit.getinfoproduit(lib);
    	context.close();
    	return p;
    }
	

	@RequestMapping(value = "/getbar/{barcode}", headers="Accept=image/*",method = RequestMethod.GET,produces = { MediaType.IMAGE_PNG_VALUE})            
    public BufferedImage getbar(@PathVariable("barcode") String barcode) throws Exception {
	return Generatebarcode.generateEAN13BarcodeImage(barcode); 		
    }
	@RequestMapping(value = "/checkstock/{codeproduit}/{quantite}", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.TEXT_PLAIN_VALUE })           
    public @ResponseBody String checkstock(@PathVariable("codeproduit") String cp,@PathVariable("quantite") String quantite) {  		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
		ProduitService srvprd = (ProduitService) context.getBean("ProduitService");
		if (srvprd.getstockproduct(Integer.parseInt(cp)) - Integer.parseInt(quantite) > 0) {
			context.close();
			return Boolean.TRUE.toString();	
		}	
		else {
			context.close();
		return  Boolean.FALSE.toString();
		}
		}
	
	@SuppressWarnings("resource")
	@RequestMapping(value = "/getimageasstring/{libproduit}", headers="Accept=*/*",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})            
    public @ResponseBody  String getstringbase64(@PathVariable("libproduit") String libproduit) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProduitService srvprd = (ProduitService) context.getBean("ProduitService");
		Produit p = srvprd.getinfoproduit(libproduit);
		try {
		String encodedimage = Base64Utils.encodeToString(p.getImage());
		String encodedqrcode = Base64Utils.encodeToString(p.getQrcode());
		JSONObject json = new JSONObject();
		json.put("encodedimage", encodedimage);
		json.put("encodedqrcode", encodedqrcode);
		return json.toString();
		} catch (Exception e) {
		}
		context.close();
		return null;
    }
	
	
}
