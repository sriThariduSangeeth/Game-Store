package com.store.game.repository;

import com.store.game.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {

    @Override
    List<Invoice> findAll();

    @Override
    <S extends Invoice> S save(S entity);

    Invoice findPaymentByInvoiceId(UUID id);
    List<Invoice> findAllByCustomerId(int id);

}
