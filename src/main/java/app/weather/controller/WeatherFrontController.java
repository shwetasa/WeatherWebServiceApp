package app.weather.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.weather.bean.Temperature;
import app.weather.service.WeatherService;
import app.weather.service.WorldWeatherOnlineService;
import app.weather.service.bean.Weather;
import app.weather.validator.ZipValidator;
import app.weather.worldweatheronline.bean.WWeatherOnline;

@Controller
public class WeatherFrontController {

	@Autowired
	WeatherService service;

	@Autowired
	WorldWeatherOnlineService worldWeatherOnlineService;

	@Autowired
	ZipValidator validator;

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public String showQueryForm(Model model) {
		return "weather";
	}

	@RequestMapping(value = "/weather", method = RequestMethod.POST)
	public @ResponseBody Object processInput(@RequestParam String zip, HttpServletResponse response) throws Exception {
		Weather weather = service.getWeather(zip);
		WWeatherOnline wWeatherOnline = worldWeatherOnlineService.getWorldWeatherOp(zip);
		return new Temperature(weather, wWeatherOnline);

	}

	@RequestMapping(value = "/weatherbyCity", method = RequestMethod.POST)
	public @ResponseBody Object processCityName(@RequestParam String city, HttpServletResponse response)
			throws Exception {
		WWeatherOnline wWeatherOnline = worldWeatherOnlineService.getWorldWeatherOp(city);
		return new Temperature(null, wWeatherOnline);

	}

	private String getErrorMsg(HttpServletResponse response, String errorMsg) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return errorMsg;
	}
}
