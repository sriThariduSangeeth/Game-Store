package com.store.game.repository;

import com.store.game.models.BuyProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BuyProductsRepository extends JpaRepository<BuyProducts,Integer> {

    @Override
    List<BuyProducts> findAll();

    BuyProducts findByProductIdAndInvoiceId(int id, UUID uuid);

    List<BuyProducts> findAllByProductId(int id);

    List<BuyProducts> findAllByInvoiceId(UUID uuid);

    BuyProducts findByInvoiceId(UUID uuid);
}
