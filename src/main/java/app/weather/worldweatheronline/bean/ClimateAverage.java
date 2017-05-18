
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
    "month"
})
public class ClimateAverage implements Serializable
{

    @JsonProperty("month")
    private List<Month> month = null;
    private final static long serialVersionUID = -6434255026606782471L;

    @JsonProperty("month")
    public List<Month> getMonth() {
        return month;
    }

    @JsonProperty("month")
    public void setMonth(List<Month> month) {
        this.month = month;
    }

}
