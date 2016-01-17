package com.goeuro.dev.test.rest.client;

import java.util.List;

import com.goeuro.dev.test.csv.transform.TransformationFactory;
import com.goeuro.dev.test.csv.transform.Transformer;
import com.goeuro.dev.test.csv.transform.Transformer.TYPE;
import com.goeuro.dev.test.domain.model.City;

public class GoEuroTest {
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		validateArgument(args);

		CityEndPointDetails cityApiEndPoint = new CityEndPointDetails();
		APIQuery<City> query = new APIQuery.Builder(cityApiEndPoint)
				.withQueryParam(args[0]).build();
		List<City> output = query.executeQuery();

		TransformationFactory factory = TransformationFactory.getInstance();
		Transformer<List<City>> transformer = factory.newTransformer(TYPE.CSV);
		transformer.transform(output);

	}

	private static void validateArgument(String[] args) {
		if (args.length >=1) {
			String queryParam = args[0];
			switch (queryParam) {
			case "--h":

			case "-help":
				System.err.println("Java-8 needed");
				System.err.println("run on commandline with java -jar GoEuroTest.jar <input>");
				System.exit(0);
				break;
				
			default:
				break;
			}
		}else {
			System.err.println("Please enter arguments to command line, only first argument is considered");
			System.exit(0);
		}
	}
}
