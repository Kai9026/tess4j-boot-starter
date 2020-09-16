package com.github.kai9026.tess4jstarter.configuration.bootstrap;

import com.github.kai9026.tess4jstarter.configuration.property.Tess4jConfigProperties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sourceforge.tess4j.Tesseract;

@Configuration
@ConditionalOnClass(Tesseract.class)
@EnableConfigurationProperties(Tess4jConfigProperties.class)
public class Tess4jAutoConfiguration {
    
    @Bean
    @ConditionalOnMissingBean
    public Tesseract tesseractInstance(Tess4jConfigProperties configProperties) {
        Tesseract instance = new Tesseract();
        instance.setDatapath(configProperties.getDataPath());
        instance.setLanguage(configProperties.getLanguage());
        instance.setHocr(configProperties.isHOcr());
        return instance;
    }
    
}