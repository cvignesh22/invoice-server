package invoiceserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import invoiceserver.model.InvoiceCountView;


public interface InvoiceCountRepository extends JpaRepository<InvoiceCountView, Integer> {

}
