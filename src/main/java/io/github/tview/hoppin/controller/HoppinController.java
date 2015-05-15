package io.github.tview.hoppin.controller;

import io.github.tview.hoppin.model.HoppinApiRequest;
import io.github.tview.hoppin.service.HoppinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/movies")
public class HoppinController {

	@Autowired
	HoppinService hoppinService;
	
	@RequestMapping(value={"", "/"}, produces=MediaType.APPLICATION_JSON_VALUE)
	public String movies() {
		HoppinApiRequest request = new HoppinApiRequest();
		return hoppinService.movies(request);
	}
	
	@RequestMapping(value="/{movieId}/seriesList", produces=MediaType.APPLICATION_JSON_VALUE)
	public String seriesList() {
		HoppinApiRequest request = new HoppinApiRequest();
		return hoppinService.seriesList(request);
	}
	
}
