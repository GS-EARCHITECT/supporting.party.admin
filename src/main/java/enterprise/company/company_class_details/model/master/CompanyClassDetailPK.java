package enterprise.company.company_class_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COMPANY_CLASS_DETAILS database table.
 * 
 */
@Embeddable
public class CompanyClassDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "COMPANY_SEQ_NO")
	private Long companySeqNo;

	@Column(name = "COMPANY_CLASS_SEQ_NO")
	private Long companyClassSeqNo;

	public CompanyClassDetailPK() {
	}

	public Long getCompanySeqNo() {
		return this.companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public Long getCompanyClassSeqNo() {
		return this.companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanyClassDetailPK)) {
			return false;
		}
		CompanyClassDetailPK castOther = (CompanyClassDetailPK) other;
		return (this.companySeqNo == castOther.companySeqNo) && (this.companyClassSeqNo == castOther.companyClassSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.companySeqNo ^ (this.companySeqNo >>> 32)));
		hash = hash * prime + ((int) (this.companyClassSeqNo ^ (this.companyClassSeqNo >>> 32)));

		return hash;
	}

	public CompanyClassDetailPK(Long companySeqNo, Long companyClassSeqNo) {
		super();
		this.companySeqNo = companySeqNo;
		this.companyClassSeqNo = companyClassSeqNo;
	}

}