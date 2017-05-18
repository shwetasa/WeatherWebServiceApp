package app.weather.utilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import app.weather.service.GobalWeatherService;

@Configuration
public class GetCityConfiguration {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("net.webservicex");
		return marshaller;
	}

	@Bean
	public GobalWeatherService getCitiesByCountry(Jaxb2Marshaller marshaller) {
		GobalWeatherService client = new GobalWeatherService();
		client.setDefaultUri("http://www.webservicex.net/globalweather.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
