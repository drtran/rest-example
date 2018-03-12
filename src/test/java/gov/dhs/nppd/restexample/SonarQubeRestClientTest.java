package gov.dhs.nppd.restexample;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class SonarQubeRestClientTest {

	@Test
	public void shouldGetCodeCoverage() throws JsonParseException, JsonMappingException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, IOException {
		SonarQubeClient sqClient = new SonarQubeClient("http://localhost:9000");
		int codeCoverage = sqClient.getCoverage();
		assertEquals("", 84, codeCoverage);
	}
}
