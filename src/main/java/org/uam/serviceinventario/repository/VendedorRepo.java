package org.uam.serviceinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uam.serviceinventario.model.Vendedor;

import java.util.UUID;

@Repository
public interface VendedorRepo extends JpaRepository<Vendedor, UUID> {
}
