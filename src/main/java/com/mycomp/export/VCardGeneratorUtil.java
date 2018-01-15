package com.mycomp.export;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.mycomp.data.structure.UserPersonalDataDto;

import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.io.text.VCardWriter;
import ezvcard.parameter.EmailType;
import ezvcard.property.StructuredName;

@Component
public class VCardGeneratorUtil {

	public File createVCard(UserPersonalDataDto user) throws Exception {
		//System.out.println(user.getFirstname() + " " + user.getLastname());
		
		//create vCard
		VCard vc= new VCard();

		StructuredName n= new StructuredName();
		n.setFamily(user.getLastname());
		n.setGiven(user.getFirstname());
		vc.setStructuredName(n);
		vc.setFormattedName(user.getFullname());
		vc.addEmail(user.getEmail(), EmailType.WORK);
		
		/* Creates extended property with json formatted user.companies
		ObjectMapper mapper= new ObjectMapper();
		vc.setExtendedProperty("SSH", user.getSshKey());
		vc.setExtendedProperty("COMPANIES", mapper.writeValueAsString(user.getCompanies()));

		//For writing data in xml instead of json
		//String xml= "";
		//vc.addXml(new Xml(xml));
		*/
		
		//TODO: omit using temp file
		//creates temporary vCard file
    	File tmpFile= File.createTempFile(UUID.randomUUID().toString(), ".vcf");
		VCardWriter writer = new VCardWriter(tmpFile, VCardVersion.V4_0);
		
		try {
			writer.write(vc);
		} finally {
			writer.close();
		}
		return tmpFile;
	}
}
