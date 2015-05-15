package io.github.tview.hoppin.controller;

import io.github.tview.hoppin.model.HoppinApiRequest;
import io.github.tview.hoppin.service.HoppinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/series")
public class HoppinController {
	
	@Autowired
	HoppinService hoppinService;
	
	@RequestMapping(value={"", "/"}, produces=MediaType.APPLICATION_JSON_VALUE)
	public String movies(HoppinApiRequest request) {
		return hoppinService.series(request);
	}
	
	@RequestMapping(value="/{seriesId}/episodes", produces=MediaType.APPLICATION_JSON_VALUE)
	public String seriesList(HoppinApiRequest request) {
		return hoppinService.episodes(request);
	}
	
}
