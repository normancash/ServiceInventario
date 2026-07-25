package org.uam.serviceinventario.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.uam.serviceinventario.model.Inventario;
import org.uam.serviceinventario.repository.InventarioRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceInventario {

    private final InventarioRepo inventarioRepo;


    public ServiceInventario(InventarioRepo inventarioRepo) {
        this.inventarioRepo = inventarioRepo;
    }

    public List<Inventario> findAll() {
        return inventarioRepo.findAll();
    }

    public Inventario save(Inventario inventario) {
        return inventarioRepo.save(inventario);
    }

    public List<Inventario> importar(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        List<Inventario> inventarios = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Inventario inventario = new Inventario();
            String producto = row.getCell(0).getStringCellValue();
            double cantidad = row.getCell(1).getNumericCellValue();
            inventario.setCantidad(cantidad);
            inventario.setProducto(producto);
            inventarios.add(inventario);
        }
        return inventarioRepo.saveAll(inventarios);
    }
}
