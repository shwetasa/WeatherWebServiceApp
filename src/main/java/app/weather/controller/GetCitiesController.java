package app.weather.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.weather.service.GobalWeatherService;
import app.weather.service.WeatherService;
import app.weather.service.bean.CountryCityGetResponse;
import app.weather.utilities.ParseXMLString;
import net.webservicex.GetCitiesByCountryResponse;
import net.webservicex.GetWeatherResponse;

@Controller
public class GetCitiesController {

    @Autowired
    WeatherService service;
    
    
    @RequestMapping(value = "/getcities", method = RequestMethod.GET)
    public @ResponseBody Object getCities(@RequestParam String country, HttpServletResponse response) throws Exception {
    		GobalWeatherService glo = new GobalWeatherService();
    		GetCitiesByCountryResponse response1 = glo.getCitiesByCountry(country);
    		List<String> cityList = ParseXMLString.getCityFromXML(response1.getGetCitiesByCountryResult());
			return cityList;
    }
    
    @RequestMapping(value = "/getWeatherbycities", method = RequestMethod.GET)
    public @ResponseBody Object getWeatherbycities(@RequestParam String country,@RequestParam String city, HttpServletResponse response) throws Exception {
    		GobalWeatherService gobalWeatherService = new GobalWeatherService();
    		GetWeatherResponse response1 = gobalWeatherService.getWeatherForCityAndCountry(country, city);
    		System.err.println(response1.getGetWeatherResult());
    		List<String> cityList = new ArrayList<String>();
    		cityList.add("MUMBAI");
			return cityList;
    }
    
}



