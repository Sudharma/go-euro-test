package com.goeuro.dev.test.rest.client;
/**
 * Spec for any new EndPoint
 * @author sudharma
 *
 */
public abstract class EndPointDetails {

	abstract StringBuilder getURI();
	
	abstract APIQuery getQueryDetails();
}
