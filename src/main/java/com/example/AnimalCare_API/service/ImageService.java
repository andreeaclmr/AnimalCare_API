package com.example.AnimalCare_API.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Service
public class ImageService {

    private static final Logger logger = LoggerFactory.getLogger(ImageService.class);


    private static final String IMAGE_DIRECTORY = System.getProperty("user.dir") + "/uploads/images/";

    public String saveImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalStateException("Image file is empty");
        }
        logger.info("Saving image: {}", file.getOriginalFilename());


        Path uploadPath = Paths.get(IMAGE_DIRECTORY);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
            logger.info("Created directory: {}", uploadPath.toAbsolutePath());
        }


        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);


        file.transferTo(filePath.toFile());
        logger.info("Image successfully saved: {}", filePath.toAbsolutePath());

        return "/uploads/images/" + fileName;
    }
}

