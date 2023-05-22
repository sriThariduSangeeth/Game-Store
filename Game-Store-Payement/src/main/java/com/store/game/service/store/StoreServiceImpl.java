package com.store.game.service.store;

import com.store.game.dto.ProductRequest;
import com.store.game.models.Product;
import com.store.game.repository.ProductRepository;
import io.micrometer.common.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StoreServiceImpl implements StoreService {

    private final ProductRepository productRepository;

    @Autowired
    public StoreServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<?> getProducts(@Nullable String type) {
        if (Objects.nonNull(type))
            return new ResponseEntity<>(this.productRepository.findAll(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> getProduct(int id) {
        return new ResponseEntity<>(this.productRepository.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addProducts(ProductRequest product) {
        return new ResponseEntity<Product>(this.productRepository.save(new Product(product)), HttpStatus.OK);
    }

}
