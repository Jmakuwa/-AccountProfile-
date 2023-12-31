package com.djamware.springmvc.repositories;

import com.djamware.springmvc.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountRepository extends JpaRepository<Product, Long> {
    
    Product findByProdName(final String prodName);
    
}
