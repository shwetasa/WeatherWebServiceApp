package app.weather.service;

import gov.usda.nrcs.wcc.awdbWebService.*;      //The web service stubs
import javax.xml.namespace.QName;
import java.net.URL;

public class NRCSService {
	
	public  static void main(String args[]){
		AwdbWebService m_webService = null;
		try
		{
		    URL wsURL = new URL("https://wcc.sc.egov.usda.gov/awdbWebService/services?WSDL");
		    AwdbWebService_Service lookup = new AwdbWebService_Service(wsURL, new 
		    QName("http://www.wcc.nrcs.usda.gov/ns/awdbWebService", "AwdbWebService"));
		        m_webService = lookup.getAwdbWebServiceImplPort();
		        java.util.List<gov.usda.nrcs.wcc.awdbWebService.Element> elemnts= m_webService.getElements();
		        System.out.println(elemnts);
		}
		catch (Exception e)
		{
		    //On failure do...
		}
		
		
		
	}
}
