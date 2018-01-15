package com.mycomp.export;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.mycomp.data.structure.UserPersonalDataDto;

import freemarker.template.TemplateException;

@RestController
public class ExportController {
	
	@Autowired
	private PdfGeneratorUtil pdfGeneratorUtil;
	
	@Autowired
	private VCardGeneratorUtil vCardGeneratorUtil;
	
	@RequestMapping(value="/export", method= RequestMethod.POST)
	public ResponseEntity<byte[]> export(@RequestBody UserPersonalDataDto user,
			@RequestParam(value="type", required=false, defaultValue="pdf") String fileType) {
		switch(fileType) {
		case "pdf":
			return toPdf(user);
		case "vcard":
			return toVCard(user);
		default:
			return null;
		}
	}

	//converting file to byte[] and wrapping it in responseEntity
	private ResponseEntity<byte[]> createResponseEntity(byte[] b, String name, MediaType t) throws IOException {
		//http header
		HttpHeaders header= new HttpHeaders();
		header.setContentType(t);
		header.add("content-disposition",  "inline-filename=" + name);
		header.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		return new ResponseEntity<>(b, header, HttpStatus.OK);
	}
	
	//not working yet
	private ResponseEntity<byte[]> toVCard(UserPersonalDataDto user) {
		//System.out.format("------%nExporting to VCard%n");
		
		//TODO: use logger instead of System.out & .err
		
		ResponseEntity<byte[]> r= null;
		File vcFile= null;
		
		try {
			vcFile= vCardGeneratorUtil.createVCard(user);
			r= createResponseEntity(Files.readAllBytes(vcFile.toPath()), vcFile.getName(), MediaType.parseMediaType("text/vcard"));
			//System.out.println("VCard tmp file location: " + vcFile.getAbsolutePath());
	        System.out.format("ExportVCard: Success%n------%n");
			
		} catch(IOException e) {
			System.err.println("VCardConversion: " + e.getMessage());
		} catch(Exception e) {
			System.err.println("ExportVCard: Something went wrong");
		}
		return r;
	}
	
	//generate PDF file
	private ResponseEntity<byte[]> toPdf(UserPersonalDataDto user) {
		System.out.format("------%nExporting to PDF%n");
		
		ResponseEntity<byte[]> r= null;
		try {
			byte[] b= pdfGeneratorUtil.createPdf(user);
			r= createResponseEntity(b, "tmpPdf", MediaType.parseMediaType("application/pdf"));

			/* For export with temp files (.hmtl, .pdf)
			File pdfFile= pdfGeneratorUtil.createPdf_withTmp(user);
			r= createResponseEntity(Files.readAllBytes(pdfFile.toPath()), pdfFile.getName(), MediaType.parseMediaType("application/pdf"));
			System.out.println("PDF tmp file location: " + pdfFile.getAbsolutePath());*/
			
			System.out.format("Export to PDF succeeded%n------%n");
			
		} catch(IOException e) {
			System.err.println("ExportPDF Failed- IOEx");
		} catch(DocumentException e) {
			System.err.println("ExportPDF Failed- DocumentEx");
		} catch(TemplateException e) {
			System.err.println("ExportPDF Failed- TemplateEx");
		}
		return r;
	}
}
