
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
    "observation_time",
    "temp_C",
    "temp_F",
    "weatherCode",
    "weatherIconUrl",
    "weatherDesc",
    "windspeedMiles",
    "windspeedKmph",
    "winddirDegree",
    "winddir16Point",
    "precipMM",
    "humidity",
    "visibility",
    "pressure",
    "cloudcover",
    "FeelsLikeC",
    "FeelsLikeF"
})
public class CurrentCondition implements Serializable
{

    @JsonProperty("observation_time")
    private String observationTime;
    @JsonProperty("temp_C")
    private String tempC;
    @JsonProperty("temp_F")
    private String tempF;
    @JsonProperty("weatherCode")
    private String weatherCode;
    @JsonProperty("weatherIconUrl")
    private List<WeatherIconUrl> weatherIconUrl = null;
    @JsonProperty("weatherDesc")
    private List<WeatherDesc> weatherDesc = null;
    @JsonProperty("windspeedMiles")
    private String windspeedMiles;
    @JsonProperty("windspeedKmph")
    private String windspeedKmph;
    @JsonProperty("winddirDegree")
    private String winddirDegree;
    @JsonProperty("winddir16Point")
    private String winddir16Point;
    @JsonProperty("precipMM")
    private String precipMM;
    @JsonProperty("humidity")
    private String humidity;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("pressure")
    private String pressure;
    @JsonProperty("cloudcover")
    private String cloudcover;
    @JsonProperty("FeelsLikeC")
    private String feelsLikeC;
    @JsonProperty("FeelsLikeF")
    private String feelsLikeF;
    private final static long serialVersionUID = -2819675735889024608L;

    @JsonProperty("observation_time")
    public String getObservationTime() {
        return observationTime;
    }

    @JsonProperty("observation_time")
    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    @JsonProperty("temp_C")
    public String getTempC() {
        return tempC;
    }

    @JsonProperty("temp_C")
    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    @JsonProperty("temp_F")
    public String getTempF() {
        return tempF;
    }

    @JsonProperty("temp_F")
    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    @JsonProperty("weatherCode")
    public String getWeatherCode() {
        return weatherCode;
    }

    @JsonProperty("weatherCode")
    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    @JsonProperty("weatherIconUrl")
    public List<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    @JsonProperty("weatherIconUrl")
    public void setWeatherIconUrl(List<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    @JsonProperty("weatherDesc")
    public List<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    @JsonProperty("weatherDesc")
    public void setWeatherDesc(List<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    @JsonProperty("windspeedMiles")
    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    @JsonProperty("windspeedMiles")
    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

    @JsonProperty("windspeedKmph")
    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    @JsonProperty("windspeedKmph")
    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    @JsonProperty("winddirDegree")
    public String getWinddirDegree() {
        return winddirDegree;
    }

    @JsonProperty("winddirDegree")
    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    @JsonProperty("winddir16Point")
    public String getWinddir16Point() {
        return winddir16Point;
    }

    @JsonProperty("winddir16Point")
    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    @JsonProperty("precipMM")
    public String getPrecipMM() {
        return precipMM;
    }

    @JsonProperty("precipMM")
    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    @JsonProperty("humidity")
    public String getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("pressure")
    public String getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("cloudcover")
    public String getCloudcover() {
        return cloudcover;
    }

    @JsonProperty("cloudcover")
    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    @JsonProperty("FeelsLikeC")
    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    @JsonProperty("FeelsLikeC")
    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    @JsonProperty("FeelsLikeF")
    public String getFeelsLikeF() {
        return feelsLikeF;
    }

    @JsonProperty("FeelsLikeF")
    public void setFeelsLikeF(String feelsLikeF) {
        this.feelsLikeF = feelsLikeF;
    }

}
