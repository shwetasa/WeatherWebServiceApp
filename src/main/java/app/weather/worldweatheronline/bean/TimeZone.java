
package app.weather.worldweatheronline.bean;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "localtime",
    "utcOffset"
})
public class TimeZone implements Serializable
{

    @JsonProperty("localtime")
    private String localtime;
    @JsonProperty("utcOffset")
    private String utcOffset;
    private final static long serialVersionUID = -5143152435262968414L;

    @JsonProperty("localtime")
    public String getLocaltime() {
        return localtime;
    }

    @JsonProperty("localtime")
    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    @JsonProperty("utcOffset")
    public String getUtcOffset() {
        return utcOffset;
    }

    @JsonProperty("utcOffset")
    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

}
