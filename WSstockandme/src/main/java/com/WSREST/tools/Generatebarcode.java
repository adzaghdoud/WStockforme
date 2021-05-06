package com.WSREST.tools;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class Generatebarcode {
	

	public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
	    Barcode barcode = BarcodeFactory.createCodabar(barcodeText);
	    barcode.setBarHeight(40);
	    barcode.setBarWidth(2);
	    //barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
	    try {
	        BufferedImage bi = BarcodeImageHandler.getImage(barcode);  // retrieve image
	        File outputfile = new File("C://saved.png");
	        ImageIO.write(bi, "png", outputfile);
	    } catch (IOException e) {
	        // handle exception
	    }
	    
	    return BarcodeImageHandler.getImage(barcode);
	}

}
