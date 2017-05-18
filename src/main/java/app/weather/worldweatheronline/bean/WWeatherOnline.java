
package app.weather.worldweatheronline.bean;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import app.weather.service.bean.Response;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data"
})
public class WWeatherOnline implements Serializable
{
	public Response response;
	
    @JsonProperty("data")
    private Data data;
    private final static long serialVersionUID = -3590288008269820049L;

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

}
