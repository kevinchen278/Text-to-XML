package org.kevinchen278.java.toxml;
import java.util.List;

import org.kevinchen278.java.toxml.MyUtil;
import org.kevinchen278.java.toxml.XMLConvertor;

public class App 
{
    public static void main( String[] args )
    {
    	String fileName = "policies.txt";    	
    	XMLConvertor xmlCovertor = new XMLConvertor(fileName);
    	String xml = xmlCovertor.toXML("policies.xml");   	
		System.out.println(xml);

//    	System.out.println ("stafdsa.   lous".matches("[a-zA-Z0-9-() \\./%*!#$^&-+?]+"));    	
    	
    }
}
