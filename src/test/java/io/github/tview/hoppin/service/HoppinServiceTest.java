package io.github.tview.hoppin.service;

import static org.junit.Assert.assertNotNull;
import io.github.tview.TviewApplication;
import io.github.tview.hoppin.model.HoppinApiRequest;

import java.util.LinkedHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.jsonpath.JsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TviewApplication.class)
@WebAppConfiguration
public class HoppinServiceTest {

	@Autowired
	HoppinService hoppinService;
	
	@Test
	public void testMovies() throws Exception {
		HoppinApiRequest request = new HoppinApiRequest();
		String response = hoppinService.series(request);
		LinkedHashMap<String, JsonPath> movies = JsonPath.parse(response).read("$.hoppin.movies");
		assertNotNull(movies);
	}
	
	@Test
	public void testSeriesList() throws Exception {
		HoppinApiRequest request = new HoppinApiRequest();
		String response = hoppinService.episodes(request, "GL0000234016");
		LinkedHashMap<String, JsonPath> seriesList = JsonPath.parse(response).read("$.hoppin.seriesList");
		assertNotNull(seriesList);
	}

}
