package edu.columbia.stat.wood.hslda.ICD9.service.converter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import edu.columbia.stat.wood.hslda.ICD9.service.model.ICD9Code;

@XmlRootElement(name = "icd9code")
public class ICD9CodeConverter {
 private ICD9Code entity = null;

 public ICD9CodeConverter() {
		this.entity = new ICD9Code();
	}
 
public ICD9CodeConverter(ICD9Code entity) {
	super();
	this.entity = entity;
}
 
@XmlElement
 public String getCode() {
	return entity.getCode();
 }

@XmlElement
public String getText() {
	return entity.getText();
}

 public void setCode(String code) {
	 entity.setCode(code);
 }

 public void setText(String text) {
	 entity.setText(text);
 }
 
}
