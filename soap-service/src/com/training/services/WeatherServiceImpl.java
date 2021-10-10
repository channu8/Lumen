package com.training.services;

import javax.jws.WebService;

import com.training.ifaces.WeatherService;

@WebService(endpointInterface = "com.training.ifaces.WeatherService")
public class WeatherServiceImpl implements WeatherService {

	@Override
	public String getWeather(String city) {
	
		String currentWeather = "29C- HAZE";
		if(city.equals("CHN")) {
			currentWeather = "32c -sunny";
		}
		return currentWeather;
	}

}

