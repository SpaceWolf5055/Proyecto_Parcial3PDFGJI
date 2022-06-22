package com.autentia.itext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Texto 
{

	public static void main(String[] args)
    {
        writePDF();
    }
    
    private static void writePDF() {

        Document document = new Document();

        try {
        	String path = new File(".").getCanonicalPath();
        	String FILE_NAME = path + "/Mi Texto PDF-Java.pdf";
        	
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            document.open();

            Paragraph paragraphHello = new Paragraph();
            paragraphHello.add("AURA");
            paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);

            document.add(paragraphHello);

            Paragraph paragraphLorem = new Paragraph();
            paragraphLorem.add("Las fechas se te confundirán, porque ya la señora esta hablando, "
            		+ "con ese murmullo agudo, leve, ese chirreo de pájaro, "
            		+ "le esta hablando a Aura y tu escuchas, atento a la comida, "
            		+ "esa enumeración plana de quejas, dolores,sospechas de enfermedades, mas quejas sobre el precio de las medicinas, la humedad de la casa. "
            		+ "Quisieras intervenir en la conversación domestica, "
            		+ "preguntando por el criado que recogió ayer tus cosas pero al que nunca has visto... . ");
            
            java.util.List<Element> paragraphList = new ArrayList<>();
            
            paragraphList = paragraphLorem.breakUp();

            Font f = new Font();
            f.setFamily(FontFamily.COURIER.name());
            f.setStyle(Font.BOLDITALIC);
            f.setSize(8);
            
            Paragraph p3 = new Paragraph();
            p3.setFont(f);
            p3.addAll(paragraphList);
            p3.add("Fragmento, Carlos Fuentes, Aura");

            document.add(paragraphLorem);
            document.add(p3);
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}

    }
}
