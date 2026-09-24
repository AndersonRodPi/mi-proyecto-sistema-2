package com.umg.api_ventas.repositories;

import com.umg.api_ventas.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, String> {
    List<Venta> findByVendedorUsuarioId(String vendedorId);
}