
package app.weather.worldweatheronline.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "index",
    "name",
    "avgMinTemp",
    "avgMinTemp_F",
    "absMaxTemp",
    "absMaxTemp_F"
})
public class Month implements Serializable
{

    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("avgMinTemp")
    private String avgMinTemp;
    @JsonProperty("avgMinTemp_F")
    private String avgMinTempF;
    @JsonProperty("absMaxTemp")
    private String absMaxTemp;
    @JsonProperty("absMaxTemp_F")
    private String absMaxTempF;
    private final static long serialVersionUID = 7214307814982422188L;

    @JsonProperty("index")
    public String getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(String index) {
        this.index = index;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("avgMinTemp")
    public String getAvgMinTemp() {
        return avgMinTemp;
    }

    @JsonProperty("avgMinTemp")
    public void setAvgMinTemp(String avgMinTemp) {
        this.avgMinTemp = avgMinTemp;
    }

    @JsonProperty("avgMinTemp_F")
    public String getAvgMinTempF() {
        return avgMinTempF;
    }

    @JsonProperty("avgMinTemp_F")
    public void setAvgMinTempF(String avgMinTempF) {
        this.avgMinTempF = avgMinTempF;
    }

    @JsonProperty("absMaxTemp")
    public String getAbsMaxTemp() {
        return absMaxTemp;
    }

    @JsonProperty("absMaxTemp")
    public void setAbsMaxTemp(String absMaxTemp) {
        this.absMaxTemp = absMaxTemp;
    }

    @JsonProperty("absMaxTemp_F")
    public String getAbsMaxTempF() {
        return absMaxTempF;
    }

    @JsonProperty("absMaxTemp_F")
    public void setAbsMaxTempF(String absMaxTempF) {
        this.absMaxTempF = absMaxTempF;
    }

}
