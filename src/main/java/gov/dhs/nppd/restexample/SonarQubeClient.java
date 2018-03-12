package gov.dhs.nppd.restexample;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SonarQubeClient {

	public SonarQubeClient(String string) {
		// TODO Auto-generated constructor stub
	}

	public int getCoverage() throws JsonParseException, JsonMappingException, IOException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9000/api/measures/component"
				+ "?componentKey=org.springframework.samples:spring-petclinic"
				+ "&metricKeys=ncloc,line_coverage,new_line_coverage,new_coverage"
				+ "&additionalFields=metrics,periods";

		String json = restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		Object jsonObj = objectMapper.readValue(json, Object.class);

		Object hello = PropertyUtils.getProperty(jsonObj, "component.id");
		System.out.println(hello);
		return 0;
	}

}
