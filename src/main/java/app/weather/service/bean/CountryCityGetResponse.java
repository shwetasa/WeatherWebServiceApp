package app.weather.service.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "NewDataSet")
public class CountryCityGetResponse {
	// @XmlElement(name = "NewDataSet")
	// private List<CountryCity> countryCity = new ArrayList<CountryCity>();
	//
	// public List<CountryCity> getCountryCity() {
	// return countryCity;
	// }

	private NewDataSet NewDataSet;

	public NewDataSet getNewDataSet() {
		return NewDataSet;
	}

	public void setNewDataSet(NewDataSet NewDataSet) {
		this.NewDataSet = NewDataSet;
	}

}