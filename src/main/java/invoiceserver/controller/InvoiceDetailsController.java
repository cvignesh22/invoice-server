 package invoiceserver.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.PathEditor;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;  
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import invoiceserver.repository.InvoiceDetailsRepository;
import invoiceserver.repository.InvoiceItemsRepository;
import invoiceserver.response.Response;
import invoiceserver.model.InvoiceDetails;

@RestController
@RequestMapping("/api/v1/invoice")
@CrossOrigin
public class InvoiceDetailsController {
	private final InvoiceDetailsRepository invoiceDetailsRepository;
	private final InvoiceItemsRepository invoiceItemsRepository;
	
	public InvoiceDetailsController(InvoiceDetailsRepository invoiceDetailsRepository,
			InvoiceItemsRepository invoiceItemsRepository) {
		super();
		this.invoiceDetailsRepository = invoiceDetailsRepository;
		this.invoiceItemsRepository = invoiceItemsRepository;
	}
    @GetMapping("/all")
    public ResponseEntity<Page<InvoiceDetails>> getAllInvoices(Pageable pageable) {
        return ResponseEntity.ok(invoiceDetailsRepository.selectInvoiceDetailsList(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDetails> getById(@PathVariable Integer id) {
        Optional<InvoiceDetails> optionalinVoiceDetails = invoiceDetailsRepository.findById(id);
        if (!optionalinVoiceDetails.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalinVoiceDetails.get());
    }
	public InvoiceItemsRepository getInvoiceItemsRepository() {
		return invoiceItemsRepository;
	}

    @GetMapping
    public ResponseEntity<Page<InvoiceDetails>> getAll(Pageable pageable) {
//    	Pageable wholePage = Pageable.unpaged();
        return ResponseEntity.ok(invoiceDetailsRepository.findAll(pageable) );
    }
    @PostMapping
    public ResponseEntity<InvoiceDetails> create(@Valid @RequestBody InvoiceDetails invoiceDetails) {
        InvoiceDetails savedInvoiceDetails = invoiceDetailsRepository.save(invoiceDetails);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedInvoiceDetails.getId()).toUri();

        return ResponseEntity.created(location).body(savedInvoiceDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @Valid @RequestBody InvoiceDetails invoiceDetails) {
        Optional<InvoiceDetails> optionalInvoiceDetails = invoiceDetailsRepository.findById(id);
        if (!optionalInvoiceDetails.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        invoiceDetails.setId(optionalInvoiceDetails.get().getId());
        invoiceDetailsRepository.save(invoiceDetails);

        return Response.setResponse(HttpStatus.OK, "Data Succesfully", 200);
    }

	
}
