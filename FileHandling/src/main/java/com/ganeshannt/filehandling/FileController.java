package com.ganeshannt.filehandling;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * @author Ganeshan Nagarajan
 * @since 12-03-2022
 */

@RestController
@RequestMapping("/api/v1/file")
public class FileController {


    private final static String uploadDir = System.getProperty("user.dir") + "/media/thumbnail/";


    //    Helper function to save image
    protected static void saveFile(String fileName,
                                   MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        System.out.println("upload path : " + uploadPath);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

    // helper function to delete image
    protected static void deleteFile(String fileName) throws IOException {
        String filePath = uploadDir + "/" + fileName;
        Path uploadedPath = Paths.get(filePath);
        File file = uploadedPath.toFile();
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        if (!file.delete()) {
            throw new IOException("Could not delete image file: " + fileName);
        }
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        String filename = UUID.randomUUID().toString() + "." + multipartFile.getContentType().split("/")[1];
        System.out.println(filename);
        try {
            saveFile(filename, multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file upload failed");
        }
        return filename;
    }
}
