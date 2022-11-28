package br.com.rafaelnicolei.education.investment.infrastructure.repository;

import br.com.rafaelnicolei.education.investment.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
