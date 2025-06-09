package com.data.session20.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService() {
        // Khởi tạo Cloudinary với thông tin cấu hình
        // Thay thế các giá trị này bằng thông tin thực tế từ Cloudinary account của bạn
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "your_cloud_name_here",
                "api_key", "your_api_key_here",
                "api_secret", "your_api_secret_here"
        ));
    }

    /**
     * Upload image to Cloudinary and return the URL
     * @param file MultipartFile to upload
     * @return URL of uploaded image
     * @throws IOException if upload fails
     */
    public String uploadImage(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File cannot be null or empty");
        }

        try {
            // Upload file to Cloudinary
            Map<String, Object> uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap(
                            "resource_type", "image",
                            "folder", "seeds" // Tạo folder để tổ chức ảnh
                    )
            );

            // Trả về URL của ảnh đã upload
            return uploadResult.get("secure_url").toString();

        } catch (IOException e) {
            throw new IOException("Failed to upload image to Cloudinary: " + e.getMessage(), e);
        }
    }

    /**
     * Delete image from Cloudinary
     * @param publicId Public ID of the image to delete
     * @return true if deletion successful
     */
    public boolean deleteImage(String publicId) {
        try {
            Map<String, Object> result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            return "ok".equals(result.get("result"));
        } catch (IOException e) {
            return false;
        }
    }
}