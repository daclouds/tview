package io.github.tview.hoppin.service;

import io.github.tview.AppConfig;
import io.github.tview.hoppin.model.HoppinApiRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class HoppinServiceTest {

	@Autowired
	HoppinService hoppinService;
	
	@Test
	public void testMovies() throws Exception {
		HoppinApiRequest request = new HoppinApiRequest();
		String movies = hoppinService.movies(request);
		System.out.println(movies);
	}

}
