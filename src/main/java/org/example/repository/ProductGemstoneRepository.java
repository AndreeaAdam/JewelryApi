package org.example.repository;

import org.example.model.ProductGemstone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGemstoneRepository extends JpaRepository<ProductGemstone, Long> {
}
