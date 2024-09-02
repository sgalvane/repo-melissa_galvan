package com.proyecto.proveedores.repository;

import com.proyecto.proveedores.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductosRepository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findByIdProveedor(Long idProveedor);

    List<ProductoEntity> findByNombre(String nombre);

    List<ProductoEntity> findByPrecio(Double precio);

    List<ProductoEntity> findByStock(Integer stock);

    ProductoEntity findByIdAndFechaEliminacionIsNull(long id);
}
