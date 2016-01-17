package com.goeuro.dev.test.rest.client;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.goeuro.dev.test.domain.model.City;
/**
 * EndPointQuery for {@link EndPointDetails} 
 * @author sudharma
 *
 */
public class CityEndPointQueryImpl extends APIQuery {
	
	private static Logger logger = LoggerFactory.getLogger(CityEndPointQueryImpl.class);

	public List<City> executeQuery() {
		RestTemplate restTemplate = new RestTemplate();
		City[] cityArray = restTemplate.getForObject(endPoint.getURI().toString(), City[].class, parameter);
		if (cityArray.length == 0) {
			logger.warn("No valid response  for input {} ", parameter);
		}
		return Arrays.asList(cityArray);

	}

}
