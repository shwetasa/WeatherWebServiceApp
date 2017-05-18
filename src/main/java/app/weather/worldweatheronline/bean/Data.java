
package app.weather.worldweatheronline.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "time_zone",
    "current_condition",
    "ClimateAverages"
})
public class Data implements Serializable
{

    @JsonProperty("request")
    private List<Request> request = null;
    @JsonProperty("time_zone")
    private List<TimeZone> timeZone = null;
    @JsonProperty("current_condition")
    private List<CurrentCondition> currentCondition = null;
    @JsonProperty("ClimateAverages")
    private List<ClimateAverage> climateAverages = null;
    private final static long serialVersionUID = 3089152463060578990L;

    @JsonProperty("request")
    public List<Request> getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(List<Request> request) {
        this.request = request;
    }

    @JsonProperty("time_zone")
    public List<TimeZone> getTimeZone() {
        return timeZone;
    }

    @JsonProperty("time_zone")
    public void setTimeZone(List<TimeZone> timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("current_condition")
    public List<CurrentCondition> getCurrentCondition() {
        return currentCondition;
    }

    @JsonProperty("current_condition")
    public void setCurrentCondition(List<CurrentCondition> currentCondition) {
        this.currentCondition = currentCondition;
    }

    @JsonProperty("ClimateAverages")
    public List<ClimateAverage> getClimateAverages() {
        return climateAverages;
    }

    @JsonProperty("ClimateAverages")
    public void setClimateAverages(List<ClimateAverage> climateAverages) {
        this.climateAverages = climateAverages;
    }

}
