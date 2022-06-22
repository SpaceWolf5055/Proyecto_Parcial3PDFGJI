package autentia.itext;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Unit test for simple App.
 */
public class Texto 
{
    
    @Test
    public void writePDF() throws DocumentException, IOException {
    	String path = new File(".").getCanonicalPath();
    	String FILE_NAME = path + "/Mi Texto PDF-Java.pdf";

    	Document document = new Document(PageSize.LETTER.rotate());
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("AURA"));
        // step 5
        document.close();
    }
}
