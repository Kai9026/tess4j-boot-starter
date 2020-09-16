package com.github.kai9026.tess4jstarter.configuration.bootstrap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.test.context.TestPropertySource;

import net.sourceforge.tess4j.Tesseract;

import static org.assertj.core.api.Assertions.*;


/**
 * Tests for {@link Tess4jAutoConfiguration}
 * 
 * @author Arkaitz Lázaro
 */
@TestPropertySource(locations = "classpath:properties")
public class Tess4jAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
                    .withConfiguration(AutoConfigurations.of(Tess4jAutoConfiguration.class));


    @Test
    public void testTesseractInstanceExists() {
        this.contextRunner.run((context) -> {
            assertThat(context).hasSingleBean(Tesseract.class);
        });
    }
    
    
}
