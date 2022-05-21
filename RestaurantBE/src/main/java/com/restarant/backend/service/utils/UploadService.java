package com.restarant.backend.service.utils;

import com.restarant.backend.config.Settings;
import com.restarant.backend.model.ContentType;
import com.restarant.backend.model.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class UploadService {
    // TODO upload ảnh
    public static String upload(MultipartFile file) throws IOException {
        String uploadDir = Settings.UPLOAD_DIR; // folder lưu ảnh
        String fileName = UUID.randomUUID().toString(); // random tên file

        // nếu là ảnh jpg thì tên file sẽ là "fileName" + ".jpg"
        if (file.getContentType().equals(ContentType.JPG.getValue())) {
            fileName += MediaType.ImageType.JPG.getType();
        }
        // nếu là png
        if (file.getContentType().equals(ContentType.PNG.getValue())) {
            fileName += MediaType.ImageType.PNG.getType();
        }
        // néu là mp4
        if (file.getContentType().contains(ContentType.MP4.getValue())) {
            fileName += MediaType.VideoType.MP4.getType();
        }

        // start upload ảnh
        Path root = Paths.get(uploadDir); // lấy ra thư mục lưu
        Path resolve = root.resolve(fileName);
        Files.createDirectories(root); // tạo folder lưu
        Files.copy(file.getInputStream(), resolve); // lưu ảnh vào folder
        // end upload ảnh

        // trả về link ảnh path web + folder lưu ảnh + tên file + đuôi định dạng
        return String.format("%s/%s/%s",
                Settings.WEB_PATH, Settings.UPLOAD_DIR, fileName);
    }
}
