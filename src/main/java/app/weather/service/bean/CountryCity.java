package app.weather.service.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "country", "city" })


public class CountryCity {
	@XmlElement(name = "Country")
	private String country;
	@XmlElement(name = "City")
	private String city;

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

}
