package com.nmerris.basicinvoiceaddition.repositories;

import com.nmerris.basicinvoiceaddition.models.Product;
import org.springframework.data.repository.CrudRepository;

// think of this interface as a pipeline bw out db and MainController.java
public interface ProductRepository extends CrudRepository<Product, Long> {



}
