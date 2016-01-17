package com.goeuro.dev.test.csv.transform;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.goeuro.dev.test.domain.model.City;

/**
 * Transform input json to CSV
 * 
 * @author sudharma
 *
 */
public class CSVTransformer implements Transformer<List<City>> {

	private static Logger logger = LoggerFactory
			.getLogger(CSVTransformer.class);

	@Override
	public Path transform(List<City> cityList) {

		/** mapper function to convert City Domain model to City CSV model */
		Function<City, com.goeuro.dev.test.csv.model.City> function = new Function<City, com.goeuro.dev.test.csv.model.City>() {

			@Override
			public com.goeuro.dev.test.csv.model.City apply(City c) {
				com.goeuro.dev.test.csv.model.City csvCity = new com.goeuro.dev.test.csv.model.City();
				csvCity.setLatitude(c.getGeo_position().getLatitude());
				csvCity.setLongitude(c.getGeo_position().getLongitude());
				csvCity.set_id(c.get_id());
				csvCity.setName(c.getName());
				csvCity.setType(c.getType());
				return csvCity;
			}
		};
		List<Object> converted = cityList.stream().map(function)
				.collect(Collectors.toList());
		return writeToCSV(converted);
	}

	private Path writeToCSV(List<Object> converted) {
		if (converted != null && !converted.isEmpty()) {

			CsvMapper mapper = new CsvMapper();
			CsvSchema schema = mapper.schemaFor(
					com.goeuro.dev.test.csv.model.City.class).withHeader();
			try {
				String string = mapper.writer(schema).writeValueAsString(
						converted);
				String inputFile = System.getProperty("user.home")
						+ File.separator + "input.csv";
				Path path = Paths.get(inputFile);
				Files.deleteIfExists(path);
				path = Files.createFile(path);
				path = Files.write(path, string.getBytes(),
						StandardOpenOption.CREATE, StandardOpenOption.WRITE);
				logger.info("writing  to csv at location {} ", inputFile);
				return path;
			} catch (JsonProcessingException e) {
				logger.error("Unable to Process JSON ", e);
			} catch (IOException e) {
				logger.error("Unable to write to file ", e);
			}
		}
		return null;
	}
}
