package app.weather.service;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.weather.worldweatheronline.bean.WWeatherOnline;

@Service
public class WorldWeatherOnlineService {
    
    //private static final String KEY = "3327b5fa2ab0035f";
	private static final String KEY = "e2402af8d1124766b2835951170602";
    
    public WWeatherOnline getWorldWeatherOp(String zipOrCity) {
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        WWeatherOnline wWeatherOnline = template.getForObject(
        		"http://api.worldweatheronline.com/premium/v1/weather.ashx?key=e2402af8d1124766b2835951170602&q="+
        zipOrCity+"&format=json&num_of_days=2&extra=yes&fx=yes&show_comments=no&tp=12&showlocaltime=yes", 
                WWeatherOnline.class);        
        
  //      http://api.worldweatheronline.com/premium/v1/weather.ashx?key=e2402af8d1124766b2835951170602&q=Madurai&format=json&num_of_days=2&extra=yes&fx=no&show_comments=no&showlocaltime=yes
//        WWeatherOnline wWeatherOnline = template.getForObject("http://api.worldweatheronline.com/premium/v1/weather.ashx?key="+KEY+
//                "&q="+zip+"&format=json&num_of_days=2&extra=yes&fx=no&show_comments=no&showlocaltime=yes", 
//                WWeatherOnline.class);        
        return wWeatherOnline;
    }    
}
