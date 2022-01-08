package invoiceserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_count_view")
public class InvoiceCountView {
	@Id 
	@Column(name = "accepted_count")
	int acceptedCount;
	@Column(name = "rejected_count")
	int rejectedCount;
	@Column(name = "pending_count")
	int pendingCount;
	@Column(name = "total_count")
	int totalCount;
	public InvoiceCountView() {
		super();
	}
	public InvoiceCountView(int acceptedCount, int rejectedCount, int pendingCount, int totalCount) {
		super();
		this.acceptedCount = acceptedCount;
		this.rejectedCount = rejectedCount;
		this.pendingCount = pendingCount;
		this.totalCount = totalCount;
	}
	public int getAcceptedCount() {
		return acceptedCount;
	}
	public void setAcceptedCount(int acceptedCount) {
		this.acceptedCount = acceptedCount;
	}
	public int getRejectedCount() {
		return rejectedCount;
	}
	public void setRejectedCount(int rejectedCount) {
		this.rejectedCount = rejectedCount;
	}
	public int getPendingCount() {
		return pendingCount;
	}
	public void setPendingCount(int pendingCount) {
		this.pendingCount = pendingCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	

}
