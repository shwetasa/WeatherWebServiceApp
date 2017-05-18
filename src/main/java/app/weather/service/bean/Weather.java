package app.weather.service.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable{
    
	public Response response;
    
    @JsonProperty("current_observation")
    private CurrentObservation CurrentObservation;

	public CurrentObservation getCurrentObservation() {
		return CurrentObservation;
	}

	public void setCurrentObservation(CurrentObservation currentObservation) {
		CurrentObservation = currentObservation;
	}
    
	      
    
    
}
