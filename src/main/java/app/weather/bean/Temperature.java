package app.weather.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.weather.service.bean.Weather;
import app.weather.worldweatheronline.bean.ClimateAverage;
import app.weather.worldweatheronline.bean.CurrentCondition;
import app.weather.worldweatheronline.bean.Month;
import app.weather.worldweatheronline.bean.WWeatherOnline;

public final class Temperature implements Serializable {

	private String city;
	private String state;
	private String country;
	private String temperature;
	private String latitude;
	private String longitude;
	private String elevation;
	private String windMph;
	private String uv;
	private String localTime;
	private String visibility;
	private String windSpeedKmph;
	private String humidity;
	private List<MonthClimateAverage> monthsClimateAverage;

	public Temperature(Weather weather, WWeatherOnline wWeatherOnline) {
		if (weather != null) {
			city = weather.getCurrentObservation().getDisplayLocation().getCity();
			state = weather.getCurrentObservation().getDisplayLocation().getStateName();
			country = weather.getCurrentObservation().getDisplayLocation().getCountry();
			temperature = weather.getCurrentObservation().getTempF();
			latitude = weather.getCurrentObservation().getDisplayLocation().getLatitude();
			longitude = weather.getCurrentObservation().getDisplayLocation().getLongitude();
			elevation = weather.getCurrentObservation().getDisplayLocation().getElevation();
			windMph = weather.getCurrentObservation().getWindKph();
			uv = weather.getCurrentObservation().getUV();
		}
		if (wWeatherOnline != null) {
			localTime = wWeatherOnline.getData().getTimeZone().get(0).getLocaltime();
			List<ClimateAverage> climateAverages = wWeatherOnline.getData().getClimateAverages();
			monthsClimateAverage = new ArrayList<MonthClimateAverage>();
			MonthClimateAverage monthClimateAverage;
			for (ClimateAverage climateAverage : climateAverages) {
				List<Month> months = climateAverage.getMonth();
				for (Month month : months) {
					monthClimateAverage = new MonthClimateAverage();
					monthClimateAverage.setMinAvgTempF(month.getAvgMinTempF());
					monthClimateAverage.setName(month.getName());
					monthClimateAverage.setMaxAbsAvgTempF(month.getAbsMaxTempF());
					monthsClimateAverage.add(monthClimateAverage);
				}

			}
		}
		if(weather==null){
			List<CurrentCondition> currentCondition = wWeatherOnline.getData().getCurrentCondition();
			temperature = currentCondition.get(0).getTempF();
			windSpeedKmph=currentCondition.get(0).getWindspeedKmph();
			visibility=currentCondition.get(0).getVisibility();
			humidity = currentCondition.get(0).getHumidity();
		}
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getTemperature() {
		return temperature;
	}

	public String getCountry() {
		return country;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getElevation() {
		return elevation;
	}

	public String getLocalTime() {
		return localTime;
	}

	public List<MonthClimateAverage> getMonthsClimateAverage() {
		return monthsClimateAverage;
	}

	public String getWindMph() {
		return windMph;
	}

	public String getUv() {
		return uv;
	}

	public String getVisibility() {
		return visibility;
	}

	public String getWindSpeedKmph() {
		return windSpeedKmph;
	}

	public void setWindMph(String windMph) {
		this.windMph = windMph;
	}

	public String getHumidity() {
		return humidity;
	}
	
	

}
