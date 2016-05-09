package org.kevinchen278.java.toxml;

import java.util.List;
import org.kevinchen278.java.toxml.MyUtil;

public class XMLConvertor {
//	private List<Policy> policies;
	private String text;
	private String fileName;
	private String xmlText;	
	private String splitString;
	
	
	public void setSplitString(String splitString){
		this.splitString = splitString;
	}
	
	XMLConvertor(String inFileName, String splitString) {
		this.fileName = inFileName;
		this.setSplitString(splitString);
		this.text = MyUtil.readFile(this.fileName);
	}

	XMLConvertor(String inFileName) {
		this.fileName = inFileName;
		this.setSplitString(",");
		this.text = MyUtil.readFile(this.fileName);
	}
	
	public String toXML(){
		List<String> lines = MyUtil.textToItems(text,"\n");
		this.xmlText = linesToXML(lines);
		return this.xmlText;
	}
	
	public String toXML(String outFileName){
		this.xmlText = toXML();
		MyUtil.writeFile(outFileName, this.xmlText);
		return this.xmlText;
	}
	
	private String forInsuredName(String item, int index){
		String xml = "";
		if (item.matches("[a-zA-Z]+")) {
			xml = "<INSURED NAME>"+item+"</INSURED NAME>";
		} else {
			xml = "<INSURED NAME type=\"Error\" Line =\"" + Integer.toString(index) + "\"></INSURED NAME>";
		}
		return xml;
	}
	
	private String forZip(String item, int index){
		String xml = "";
		if (item.matches("[0-9]{5}")) {
			xml = "<ZIP>"+item+"</ZIP>";
		} else {
			xml = "<ZIP type=\"Error\" Line =\"" + Integer.toString(index) + "\"></ZIP>";
		}
		return xml;
	}
	
	private String forCity(String item, int index){
		String xml = "";
		if (item.matches("[a-zA-Z0-9-() \\./%*!#$^&-+?]+")) {
			xml = "<CITY>"+item+"</CITY>";
		} else {
			xml = "<CITY type=\"Error\" Line =\"" + Integer.toString(index) + "\"></CITY>";
		}
		return xml;
	}
	
	private String forInsuredDate(String item, int index){
		String xml = "";
		if (item.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
			xml = "<INSURANCE DATE>"+item+"</INSURANCE DATE>";
		} else {
			xml = "<INSURANCE DATE> type=\"Error\" Line =\"" + Integer.toString(index) + "\"></INSURANCE DATE>";
		}
		return xml;
	}
	
	private String forPhoneNumber(String item, int index){
		String xml = "";
		if (item.matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")) {
			xml = "<PHONE NUMBER>"+item+"</PHONE NUMBER>";
		} else {
			xml = "<PHONE NUMBER type=\"Error\" Line =\"" + Integer.toString(index) + "\"></PHONE NUMBER>";
		}
		return xml;
	}
	
	
	private String itemsToXML(List<String> items, int index){
		String xml = "";
		if (items.size() != 5) {
			return "\t<POLICY type=\"Error\" Line =\"" + Integer.toString(index) + "\"></POLICY>\n";
		} else {
			xml += "\t\t" +forInsuredName(items.get(0).trim(), index) +"\n";
			xml += "\t\t" +forPhoneNumber(items.get(1).trim(), index)+"\n";
			xml += "\t\t" +forZip(items.get(2).trim(), index)+"\n";
			xml += "\t\t" +forCity(items.get(3).trim(), index)+"\n";
			xml += "\t\t" +forInsuredDate(items.get(4).trim(), index)+"\n";
		}
		return ("\t<POLICY>\n" + xml + "\t</POLICY>\n");
	}
	
	private String linesToXML(List<String> lines){
		String xml="<POLICIES>\n";
		List<String> items;

		for (int i=0; i< lines.size(); i++) {
			items = MyUtil.textToItems(lines.get(i), this.splitString);
			xml += this.itemsToXML(items,i+1);
		}
		return (xml+"</POLICIES>"); 
	}
	

}
