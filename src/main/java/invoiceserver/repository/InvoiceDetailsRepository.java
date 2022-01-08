package invoiceserver.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import invoiceserver.model.InvoiceDetails;

public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Integer> {

	//  ignore filedata to make qry exe faster
	@Query(value = "SELECT id, invoice_status, invoice_no, invoice_date, company_name, company_address, total_amount, file_name ,  'NULL' as file_data  FROM invoice_details", 
	countQuery = "SELECT count(*) FROM invoice_details", nativeQuery = true)
	Page<InvoiceDetails> selectInvoiceDetailsList(Pageable pageable);
}
