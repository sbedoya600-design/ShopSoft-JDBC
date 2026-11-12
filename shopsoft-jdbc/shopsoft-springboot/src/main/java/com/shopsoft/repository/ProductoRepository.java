package com.shopsoft.repository;
import com.shopsoft.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Acceso CRUD a la tabla productos mediante Spring Data JPA. */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
