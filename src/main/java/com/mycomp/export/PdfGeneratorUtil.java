package com.mycomp.export;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.mycomp.data.structure.UserPersonalDataDto;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class PdfGeneratorUtil {
	
	@Autowired
	private Configuration freeMarkerConfig;
	/* auto-configurovane
	 * pro specificke vytvorit tridu: PDFConfiguration extends Configuration
	 * dat ji @Component, a na constructor dat @Autowired a tady ho smazat (@Autowired, ne promennou)
	 */
	
	private String imgInB64(String path) {
		try {
			byte[] img= Files.readAllBytes(new ClassPathResource(path).getFile().toPath()); 
			return Base64.getEncoder().encodeToString(img);
		} catch(IOException e) {
			return "";
		}
	}
	
	//pdf export method
	public byte[] createPdf(UserPersonalDataDto user) throws IOException,TemplateException,DocumentException {
		Template temp= freeMarkerConfig.getTemplate("test.ftl");
		Assert.notNull(temp, "The templateName can not be null");

		Map<String, Object> model= new HashMap<>();
		model.put("user", user);
		model.put("logo", new ClassPathResource("images/logo.png").getFile().toPath());
		System.out.println(model.get("logo"));
		
		//html generation
		ByteArrayOutputStream htmlBytes= new ByteArrayOutputStream();
    	temp.process(model, new OutputStreamWriter(htmlBytes));		//connecting data with html template

    	//converting html to pdf
    	ByteArrayOutputStream pdfStream= new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.getSharedContext().setReplacedElementFactory(
        		new MediaReplacedElementFactory(renderer.getSharedContext().getReplacedElementFactory()));
        String htmlStr= new String(htmlBytes.toByteArray(), StandardCharsets.UTF_8);
        renderer.setDocumentFromString(htmlStr, "");
        renderer.layout();
        renderer.createPDF(pdfStream, false);
        renderer.finishPDF();
        return pdfStream.toByteArray();
	}
	

	//PDF conversion with temp. files generated in temp system folder
	public File createPdf_withTmp(UserPersonalDataDto user) throws IOException,TemplateException,DocumentException {
		Template temp= freeMarkerConfig.getTemplate("test.ftl");
		Assert.notNull(temp, "The templateName can not be null");

		Map<String, Object> model= new HashMap<>();
		model.put("user", user);
		model.put("logoBase64", new ClassPathResource("images/logo.png").getFile().toPath());//imgInB64("images/logo.png"));
		
		File pdfFile= null;
		OutputStreamWriter htmlStream= null;
		FileOutputStream pdfStream= null;
    	try {
    		File htmlFile= File.createTempFile(UUID.randomUUID().toString(), ".html");
        	htmlStream= new OutputStreamWriter( new FileOutputStream(htmlFile));
        	temp.process(model, htmlStream);

        	pdfFile= File.createTempFile(UUID.randomUUID().toString(),".pdf");
            pdfStream= new FileOutputStream(pdfFile);

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(htmlFile);
            renderer.layout();
            renderer.createPDF(pdfStream, false);
            renderer.finishPDF();
        } finally {
        	if(htmlStream != null) {
        		htmlStream.close();
        	}
        	if(pdfStream != null) {
        		pdfStream.close();
        	}
        }
        return pdfFile;
	}
}
