package com.bosonit.SA2.application.useCase;

import com.bosonit.SA2.application.port.DownloadFilePort;
import com.bosonit.SA2.domain.FileEnt;
import com.bosonit.SA2.infraestructure.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.processing.Filer;
import java.util.List;

@Service
public class DownloadFileUseCase implements DownloadFilePort {

    @Autowired
    FileRepository fileRepository;

    public String getFileByID (Integer id){
       FileEnt fileEnt =  fileRepository.findById(id).orElseThrow(()-> new RuntimeException("Fichero" + id +  "no encontrado"));
        return fileEnt.getPath();
    }

    public String getFileByName (String name){
        FileEnt fileEnt =  fileRepository.findByName(name);
        return fileEnt.getPath();
        }
}
