package com.goeuro.dev.test.rest.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract implementation of query independent of {@link EndPointDetails}
 * @author sudharma
 *
 * @param <T>
 */
public abstract class APIQuery<T> {
	
	private static Logger logger = LoggerFactory.getLogger(APIQuery.class);

	protected EndPointDetails endPoint;
	
	protected String parameter;
	
	public abstract List<T> executeQuery();
	

	public static class Builder {
		
		@SuppressWarnings("rawtypes")
		private APIQuery apiQuery;
		
		
		public Builder(EndPointDetails apiEndPoint) {
			logger.info("building Query for {} ",apiEndPoint.getURI());
			apiQuery = apiEndPoint.getQueryDetails();
			apiQuery.endPoint=apiEndPoint;
		}
		

		public Builder withQueryParam(String input){
			apiQuery.parameter=input;
			return this;
		}
		
		public APIQuery build(){
		  apiQuery.endPoint.getURI().append(apiQuery.parameter);	
		  return apiQuery;
		}

	}


	

}
