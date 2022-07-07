package com.bosonit.SA2.infraestructure.controller;

import com.bosonit.SA2.application.port.DownloadFilePort;
import com.bosonit.SA2.application.port.UploadingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileController {

@Autowired
UploadingInterface uploadingInterface;


    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file, @RequestParam(required = false) String extension) throws IOException {
        return uploadingInterface.uploadFile(file,extension);
    }

    @Autowired
    DownloadFilePort downloadFilePort;

    @GetMapping("/file/{id}")
    public String findByID(@PathVariable Integer id){
        return downloadFilePort.getFileByID(id);
    }

    @GetMapping("/find/{name}")
    public String findByName(@PathVariable String name){
        return downloadFilePort.getFileByName(name);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Object> downloadFile(@PathVariable Integer id) throws IOException {
        String filename = downloadFilePort.getFileByID(id);
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

    @GetMapping("/downloadfile/{name}")
    public ResponseEntity<Object> downloadFileByName(@PathVariable String name) throws IOException {
        String filename = downloadFilePort.getFileByName(name);
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

}
