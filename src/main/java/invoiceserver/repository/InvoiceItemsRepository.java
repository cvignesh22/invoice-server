package invoiceserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import invoiceserver.model.InvoiceItems;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItems , Integer> {

}
