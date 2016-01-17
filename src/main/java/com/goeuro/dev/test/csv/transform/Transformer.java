package com.goeuro.dev.test.csv.transform;

import java.nio.file.Path;

/**
 * new format specific transformers need to implement this .
 * 
 * @author sudharma
 *
 * @param <Input>
 */
public interface Transformer<Input> {

	public enum TYPE {
		CSV, JSON, EXCEL
	}

	Path transform(Input input);

}
