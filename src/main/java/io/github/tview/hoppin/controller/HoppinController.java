package io.github.tview.hoppin.controller;

import io.github.tview.hoppin.model.HoppinApiRequest;
import io.github.tview.hoppin.service.HoppinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

@RestController
@RequestMapping(value="/series")
public class HoppinController {
	
	@Autowired
	HoppinService hoppinService;
	
	@RequestMapping(value={"", "/"}, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> series(HoppinApiRequest request) {
		String series = hoppinService.series(request);
		HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		Object error = null;
		try {
			error = JsonPath.parse(series).read("$.error");
		} catch (PathNotFoundException e) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		if (error == null) {
			statusCode = HttpStatus.OK;
		}
		return new ResponseEntity<String>(series, statusCode);
	}
	
	@RequestMapping(value="/{seriesId}/episodes", produces=MediaType.APPLICATION_JSON_VALUE)
	public String seriesList(HoppinApiRequest request, String seriesId) {
		return hoppinService.episodes(request, seriesId);
	}
	
}
