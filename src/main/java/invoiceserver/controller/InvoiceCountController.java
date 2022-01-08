package invoiceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import invoiceserver.model.InvoiceCountView;
import invoiceserver.repository.InvoiceCountRepository;

@RestController
@RequestMapping("/api/v1/invoice-count")
public class InvoiceCountController {
	@Autowired
	private InvoiceCountRepository  invoiceCountRepository;
	@GetMapping
	public Iterable<InvoiceCountView> findCount() {
		return invoiceCountRepository.findAll();
	}

}
