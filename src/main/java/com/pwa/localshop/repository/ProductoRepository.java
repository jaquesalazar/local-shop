package com.pwa.localshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pwa.localshop.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
