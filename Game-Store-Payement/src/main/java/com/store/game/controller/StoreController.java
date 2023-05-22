package com.store.game.controller;

import com.store.game.dto.ProductRequest;
import com.store.game.enums.PaymentsTypes;
import com.store.game.service.store.StoreService;
import com.store.game.service.store.StoreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreServiceImpl storeServiceImpl) {
        this.storeService = storeServiceImpl;
    }

    @GetMapping("/game/store/products/{type}")
    public ResponseEntity<?> getProducts(@PathVariable String type){
        return this.storeService.getProducts(type);
    }

    @RequestMapping(value = "/game/store/{id}/product", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable Integer id){
        return this.storeService.getProduct(id.intValue());
    }

    @PostMapping("/game/store/products")
    public ResponseEntity<?> addProducts(@RequestBody ProductRequest requestBody){
        return this.storeService.addProducts(requestBody);
    }


}
