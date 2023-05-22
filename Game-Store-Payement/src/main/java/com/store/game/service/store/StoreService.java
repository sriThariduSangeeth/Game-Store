package com.store.game.service.store;

import com.store.game.dto.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

public interface StoreService {

    ResponseEntity<?> getProducts(@Nullable String type);
    ResponseEntity<?> getProduct(@Nullable int id);
    ResponseEntity<?> addProducts(@Nullable ProductRequest type);

}
