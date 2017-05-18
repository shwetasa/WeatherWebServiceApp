//package app.weather.controller;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import app.weather.service.GobalWeatherService;
//import app.weather.utilities.GetCityConfiguration;
//import net.webservicex.GetCitiesByCountryResponse;
//
//@SpringBootApplication
//public class Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class);
//	}
//
//	@Bean
//	CommandLineRunner lookup(GobalWeatherService glo) {
//		String country = "INDIA";
//
//	
//		GetCitiesByCountryResponse response = glo.getCitiesByCountry(country);
//		System.err.println(response.getGetCitiesByCountryResult());
//		return null;
//	}
//
//}
