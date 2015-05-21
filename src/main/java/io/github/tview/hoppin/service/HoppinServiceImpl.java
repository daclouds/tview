package io.github.tview.hoppin.service;

import io.github.tview.hoppin.HoppinConfig;
import io.github.tview.hoppin.model.HoppinApiRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class HoppinServiceImpl implements HoppinService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HoppinConfig hoppinConfig;
	
	@Override
	public String series(HoppinApiRequest request) {
		request.setUri("http://apis.skplanetx.com/hoppin/tvseries");
		UriComponentsBuilder builder = uriComponentsBuilder(request).queryParam("genreId", request.getGenreId());
		return body(builder);
	}
	
	@Override
	public String episodes(HoppinApiRequest request, @RequestParam(required=true) String seriesId) {
		request.setUri("http://apis.skplanetx.com/hoppin/tvseries/"+ seriesId +"/episodes");
		return body(uriComponentsBuilder(request));
	}

	private String body(UriComponentsBuilder builder) {
		HttpEntity<?> entity = new HttpEntity<>(headers());
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
		} catch (HttpStatusCodeException e) {
			log.debug(e.getResponseBodyAsString());
			return e.getResponseBodyAsString();
		}
		String body = null;
		if (response != null) {
			body = response.getBody();
		}
		return body;
	}
	
	private UriComponentsBuilder uriComponentsBuilder(HoppinApiRequest request) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(request.getUri())
				.queryParam("version", request.getVersion())
				.queryParam("page", request.getPage())
				.queryParam("count", request.getCount())
				.queryParam("order", request.getOrder());
		return builder;
	}
	
	private HttpHeaders headers() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("access_token", hoppinConfig.getAccessToken());
		headers.set("appKey", hoppinConfig.getAppKey());
		return headers;
	}

	@Deprecated
	private String readTextfile(Resource resource) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(resource.getInputStream()), 1024);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return sb.toString();
	}

}
