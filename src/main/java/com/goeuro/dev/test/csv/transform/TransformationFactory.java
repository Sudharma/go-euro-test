package com.goeuro.dev.test.csv.transform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.dev.test.csv.transform.Transformer.TYPE;

public class TransformationFactory {

	private static Logger logger = LoggerFactory.getLogger(TransformationFactory.class);
	
	private static TransformationFactory factory;

	private TransformationFactory() {
	}

	public static TransformationFactory getInstance() {
		if (factory == null) {
			factory = new TransformationFactory();
		}
		return factory;
	}

	public Transformer newTransformer(TYPE type) {
		Transformer transformer = null;
		switch (type) {
		case CSV:
			transformer = new CSVTransformer();
			break;

		default:
			logger.warn(" {} file format not supported!!!!",type);
			break;
		}

		return transformer;

	}

}
