package app.weather.service.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Observation {
    public DisplayLocation display_location;
    public String temp_f;
}
