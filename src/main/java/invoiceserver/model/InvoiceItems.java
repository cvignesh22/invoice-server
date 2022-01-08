package invoiceserver.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "invoice_items")
public class InvoiceItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(name = "invoice_id")
//	private int invoiceDate;
	@Column(name = "item_name")
	String itemName;
	@Column(name = "quantity")
	String quantity;
	@Column(name = "price")
	String price;
	@Column(name = "item_total")
	String itemTotal;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoice_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private InvoiceDetails invoiceDetails;
	public InvoiceItems() {
		super();
	}
	public InvoiceItems(int id, String itemName, String quantity, String price, String itemTotal,
			InvoiceDetails invoiceDetails) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.itemTotal = itemTotal;
		this.invoiceDetails = invoiceDetails;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(String itemTotal) {
		this.itemTotal = itemTotal;
	}
	public InvoiceDetails getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	
    
}
