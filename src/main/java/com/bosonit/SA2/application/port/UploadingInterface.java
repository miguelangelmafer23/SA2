package com.bosonit.SA2.application.port;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadingInterface {
    public String uploadFile(MultipartFile file, String extension) throws IOException;
}
