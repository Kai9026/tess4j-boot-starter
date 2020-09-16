package com.github.kai9026.tess4jstarter.configuration.property;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test for {@link Tess4jConfigProperties}
 * 
 * @author Arkaitz Lázaro
 */
@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = Tess4jConfigProperties.class)
@TestPropertySource(locations = "classpath:application.properties")
public class Tess4jConfigPropertiesTest {
    
    private static final String TESS4J_DATA_URI = "/path/to/tess4j/data";
    private static final String TESS4J_LANG = "spa";
    private static final boolean TESS4J_HOCR = false;

    @Autowired
    private Tess4jConfigProperties configProperties;

    @Test
    void givenUserDefinedPOJO_whenBindingPropertiesFile_thenAllFieldsAreSet() {
        assertEquals(TESS4J_DATA_URI, configProperties.getDataPath());
        assertEquals(TESS4J_LANG, configProperties.getLanguage());
        assertEquals(TESS4J_HOCR, configProperties.isHOcr());
    }
}
