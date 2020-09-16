package com.github.kai9026.tess4jstarter.configuration.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "tess4j")
@Getter
@Setter
public class Tess4jConfigProperties {

	private String dataPath;
	private String language;
	private boolean hOcr;
    
}