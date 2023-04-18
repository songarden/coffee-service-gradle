package com.garden.coffee.coffeegarden.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ProductJPARepository extends JpaRepository<Product,String> {
    Optional<Product> findByProductName(String productName);
}
