package io.github.tview.hoppin;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="hoppin")
@Data
public class HoppinConfig {
	
	private String appKey;
	private String accessToken;
	
}
