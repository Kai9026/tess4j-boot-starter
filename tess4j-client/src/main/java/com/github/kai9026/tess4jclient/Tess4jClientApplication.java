package com.github.kai9026.tess4jclient;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import net.sourceforge.tess4j.Tesseract;

@SpringBootApplication
public class Tess4jClientApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Tess4jClientApplication.class);
	private static final String OUTPUT_FILE = "src/main/resources/output/output.html";

	public static void main(String[] args) {
		SpringApplication.run(Tess4jClientApplication.class, args);
	}

	@Autowired
	private Tesseract ocrInstance;

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Starting Tess4j client application ...");
		
		LOGGER.info("Doing OCR for test image file ...");
		Resource imageResource = new ClassPathResource("images/texto.png");
		File imageFile = imageResource.getFile();
		String extractedText = ocrInstance.doOCR(imageFile);
		LOGGER.info("Dumping extracted content to an output file ... ");

		Path outputFilePath = Paths.get(OUTPUT_FILE);
		LOGGER.info("Output file path: {}", outputFilePath.toAbsolutePath());
		Files.writeString(outputFilePath, extractedText, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
	}

}
