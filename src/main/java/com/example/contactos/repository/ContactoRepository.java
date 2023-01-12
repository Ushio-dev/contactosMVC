package com.example.contactos.repository;

import com.example.contactos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM contacto WHERE id_usuario=?1"
    )
    List<Contacto> findAllById(Long id);
}
