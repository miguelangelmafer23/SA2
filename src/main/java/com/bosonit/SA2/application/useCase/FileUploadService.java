package com.bosonit.SA2.application.useCase;

import com.bosonit.SA2.application.port.UploadingInterface;
import com.bosonit.SA2.domain.FileEnt;
import com.bosonit.SA2.infraestructure.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileUploadService implements UploadingInterface {

    @Autowired
    FileRepository fileRepository;


    public String uploadFile(MultipartFile file,String extension) throws IOException {
        FileEnt fileEnt = new FileEnt();
        Date date = new Date();
        //asignamos los valores al objeto fileEnt creado
        fileEnt.setExtension(extension);
        fileEnt.setName(file.getOriginalFilename());
        fileEnt.setDate_uploaded(date);
        fileEnt.setPath("C:\\Users\\miguelangel.martin\\IdeaProjects\\EjercicioSA2\\UploadedFiles\\" + file.getOriginalFilename());
        fileRepository.save(fileEnt);
        file.transferTo(new File("C:\\Users\\miguelangel.martin\\IdeaProjects\\EjercicioSA2\\UploadedFiles\\" + file.getOriginalFilename()));
        return "File uploaded";
    }


}
