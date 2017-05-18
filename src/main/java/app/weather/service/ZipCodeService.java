package app.weather.service;

import app.weather.service.bean.Weather;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipCodeService {
    
    private static final String KEY = "3327b5fa2ab0035f";
    
    public Weather getWeather(String zip) {
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        
        Weather weather = template.getForObject("http://api.wunderground.com/api/"+KEY+
                "/conditions/q/"+zip+".json", 
                Weather.class);        
        return weather;
    }    
}
