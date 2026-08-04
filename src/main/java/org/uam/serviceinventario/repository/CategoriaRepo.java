package org.uam.serviceinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uam.serviceinventario.model.Categoria;

import java.util.UUID;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, UUID> {
}
