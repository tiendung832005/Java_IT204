package com.data.demo_hackathon_02.util;


import java.io.File;
import java.io.IOException;

public class FileUploadUtil {
    public static void saveFile(String uploadDir, String fileName, byte[] fileData) throws IOException {
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        File file = new File(uploadPath, fileName);
        java.nio.file.Files.write(file.toPath(), fileData);
    }
}
