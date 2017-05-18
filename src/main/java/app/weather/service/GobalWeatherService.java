package app.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import net.webservicex.GetCitiesByCountry;
import net.webservicex.GetCitiesByCountryResponse;
import net.webservicex.GetWeather;
import net.webservicex.GetWeatherResponse;

@Service
public class GobalWeatherService extends WebServiceGatewaySupport {
	
	@Autowired
	WebServiceTemplate webServiceTemplate;
	
	
	public GetCitiesByCountryResponse getCitiesByCountry(String country) throws Exception {

		GetCitiesByCountry request = new GetCitiesByCountry();
		request.setCountryName(country);
		WebServiceTemplate webServiceTemplate= getWebServiceTemplate();
		webServiceTemplate.setDefaultUri("http://www.webservicex.net/globalweather.asmx");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("net.webservicex");
		webServiceTemplate.setMarshaller(marshaller);
		marshaller.afterPropertiesSet();
		webServiceTemplate.setUnmarshaller(marshaller);
		GetCitiesByCountryResponse response = (GetCitiesByCountryResponse) webServiceTemplate
				.marshalSendAndReceive("http://www.webservicex.com/globalweather.asmx?WSDL",
						request,
						new SoapActionCallback("http://www.webserviceX.NET/GetCitiesByCountry"));
		//getWeatherForCityAndCountry(null,null);
		return response;
	}
	
	public GetWeatherResponse getWeatherForCityAndCountry(String country,String city) throws Exception {
		GetWeather getWeatherRequest = new GetWeather();
		getWeatherRequest.setCountryName("United States");
		getWeatherRequest.setCityName("Detroit, Detroit City Airport");
		WebServiceTemplate webServiceTemplate= getWebServiceTemplate();
		webServiceTemplate.setDefaultUri("http://www.webservicex.net/globalweather.asmx");
		Jaxb2Marshaller marshallerNew = new Jaxb2Marshaller();
		marshallerNew.setContextPath("net.webservicex");
		webServiceTemplate.setMarshaller(marshallerNew);
		marshallerNew.afterPropertiesSet();
		webServiceTemplate.setUnmarshaller(marshallerNew);
		GetWeatherResponse getWeatherResponse = (GetWeatherResponse) webServiceTemplate
				.marshalSendAndReceive("http://www.webservicex.com/globalweather.asmx?WSDL",
						getWeatherRequest,
						new SoapActionCallback("http://www.webserviceX.NET/GetWeather"));
		return getWeatherResponse;
	}
	
//	public CountryCityGetResponse unMarshalingCities(String response) throws JAXBException 
//	{
//		JAXBContext jaxbContext = JAXBContext.newInstance(CountryCityGetResponse.class);
//		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//		String start = "<?xml version=\"1.0\"?>";
//		StringBuffer appendResponse = new StringBuffer();
//		appendResponse.append(start);
//		appendResponse.append(response);
////		String newDataSet = "<?xml version=\"1.0\"?><NewDataSet><Table> <Country>United Kingdom</Country> <City>Belfast / Aldergrove Airport</City>"+
////  "</Table><Table> <Country>United Kingdom</Country> <City>Belfast / Harbour</City></Table></NewDataSet>";
//		StringReader reader = new StringReader(appendResponse.toString());
//		//StringReader reader = new StringReader(newDataSet);
//		//CountryCityGetResponse countryCityGetResponse = new CountryCityGetResponse();
//		//List<CountryCity> countryCityList =countryCityGetResponse.getCountryCity();
//		CountryCityGetResponse countryCityGetResponse = (CountryCityGetResponse) unmarshaller.unmarshal(reader);
//		
//		//	    for(CountryCity countryCity : countryCityGetResponse.getCountryCity())
////	    {
//////	        System.out.println(countryCity.getCity());
//////	        System.out.println(countryCity.getCountry());
////	    }
//		
//	    return countryCityGetResponse;
//	}

}