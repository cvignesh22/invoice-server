package invoiceserver.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "invoice_details")
public class InvoiceDetails {
	public static enum InvoiceStatus {accepted, pending, rejected};
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "invoice_date")
	@JsonFormat(pattern="yyyy-MM-dd" , timezone = "GMT+05:30")
	private Date invoiceDate;
	@Column(name = "invoice_no")
	String invoiceNo;
	@Column(name = "company_name")
	String companyName;
	@Column(name = "company_address")
	String companyAddress;
	@Column(name = "total_amount")
	String totalAmount;
	@Column(name = "file_name")
	String fileName;
	@Column(name = "file_data")
	@Basic(optional=true)
	String fileData;
	@Column(name = "invoice_status")
	@Enumerated(EnumType.STRING)
	InvoiceStatus invoiceStatus;
	
   @OneToMany(mappedBy = "invoiceDetails", cascade = CascadeType.ALL)
    private Set<InvoiceItems> invoiceItems = new HashSet<>();

	public InvoiceDetails() {
		super();
	}

	public Set<InvoiceItems> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(Set<InvoiceItems> invoiceItems) {
		
		this.invoiceItems = invoiceItems;
        for(InvoiceItems i : invoiceItems) {
            i.setInvoiceDetails(this);
        }
	}



	public InvoiceDetails(int id, Date invoiceDate, String invoiceNo, String companyName, String companyAddress,
			String totalAmount, String fileName, String fileData, InvoiceStatus invoiceStatus,
			Set<InvoiceItems> invoiceItems) {
		super();
		this.id = id;
		this.invoiceDate = invoiceDate;
		this.invoiceNo = invoiceNo;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.totalAmount = totalAmount;
		this.fileName = fileName;
		this.fileData = fileData;
		this.invoiceStatus = invoiceStatus;
		this.invoiceItems = invoiceItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileData() {
		return fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}


	public InvoiceStatus getInvoiceStatus() {
		return invoiceStatus;
	}


	public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	
	

}
