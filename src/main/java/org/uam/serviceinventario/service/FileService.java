package org.uam.serviceinventario.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.uam.serviceinventario.config.FileStorageProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileService {

    private final Path fileStorageLocation;

    public FileService(FileStorageProperties properties) {
        this.fileStorageLocation = Paths
                .get(properties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        }
        catch (Exception ex) {
            throw new RuntimeException("No se pudo crear el directorio");
        }
    }

    public String saveImagen(MultipartFile file) throws Exception {
        String nombre = UUID.randomUUID() + "_" +
                StringUtils.cleanPath(file.getOriginalFilename());
        String tipo = file.getContentType();
        if (tipo == null || (!tipo.equals("image/jpeg") && !tipo.equals("image/png"))) {
            throw new Exception("El tipo de archivo no es valido,sole se permiten JPG o PNG");
        }
        if (nombre.contains("..")) {
            throw new Exception("El nombre del archivo es invalido");
        }
        Path destino = this.fileStorageLocation.resolve(nombre);
        Files.copy(file.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);
        return nombre;
    }

    public Resource loadImage(String nombre) throws Exception {
        Path path = this.fileStorageLocation.resolve(nombre).normalize();
        Resource resource = new UrlResource(path.toUri());
        if (!resource.exists()) {
            throw new Exception("El archivo no existe");
        }
        return resource;
    }
}
