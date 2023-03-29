package com.garden.coffee.coffeegarden.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductJPARepository extends JpaRepository<Product, String> {

}
