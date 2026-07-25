package org.uam.serviceinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uam.serviceinventario.model.Inventario;

@Repository
public interface InventarioRepo extends JpaRepository<Inventario,String> {
}
