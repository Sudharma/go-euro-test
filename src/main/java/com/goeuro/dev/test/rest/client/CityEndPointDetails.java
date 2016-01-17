package com.goeuro.dev.test.rest.client;

/**
 * Specific EndPoint Implementation
 * @author sudharma
 *
 */
public class CityEndPointDetails extends EndPointDetails {

	String QUERY_ON_CITY_ENDPOINT = "http://api.goeuro.com/api/v2/position/suggest/en/{cityName}";

	@Override
	StringBuilder getURI() {
		return new StringBuilder(QUERY_ON_CITY_ENDPOINT);
	}

	@Override
	APIQuery getQueryDetails() {
		return new CityEndPointQueryImpl();
	}

}
