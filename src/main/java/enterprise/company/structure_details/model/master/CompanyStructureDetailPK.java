package enterprise.company.structure_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COMPANY_STRUCTURE_DETAILS database table.
 * 
 */
@Embeddable
public class CompanyStructureDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "COMPANY_SEQ_NO")
	private Long companySeqNo;

	@Column(name = "PAR_COMPANY_SEQ_NO")
	private Long parCompanySeqNo;

	@Column(name = "COMPANY_CLASS_SEQ_NO")
	private Long companyClassSeqNo;

	@Column(name = "PAR_COMPANY_CLASS_SEQ_NO")
	private Long parCompanyClassSeqNo;

	public CompanyStructureDetailPK() {
	}

	public Long getCompanySeqNo() {
		return this.companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public Long getParCompanySeqNo() {
		return this.parCompanySeqNo;
	}

	public void setParCompanySeqNo(Long parCompanySeqNo) {
		this.parCompanySeqNo = parCompanySeqNo;
	}

	public Long getCompanyClassSeqNo() {
		return this.companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public Long getParCompanyClassSeqNo() {
		return this.parCompanyClassSeqNo;
	}

	public void setParCompanyClassSeqNo(Long parCompanyClassSeqNo) {
		this.parCompanyClassSeqNo = parCompanyClassSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanyStructureDetailPK)) {
			return false;
		}
		CompanyStructureDetailPK castOther = (CompanyStructureDetailPK) other;
		return (this.companySeqNo == castOther.companySeqNo) && (this.parCompanySeqNo == castOther.parCompanySeqNo)
				&& (this.companyClassSeqNo == castOther.companyClassSeqNo)
				&& (this.parCompanyClassSeqNo == castOther.parCompanyClassSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.companySeqNo ^ (this.companySeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parCompanySeqNo ^ (this.parCompanySeqNo >>> 32)));
		hash = hash * prime + ((int) (this.companyClassSeqNo ^ (this.companyClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parCompanyClassSeqNo ^ (this.parCompanyClassSeqNo >>> 32)));

		return hash;
	}

	public CompanyStructureDetailPK(Long companySeqNo, Long parCompanySeqNo, Long companyClassSeqNo,
			Long parCompanyClassSeqNo) {
		super();
		this.companySeqNo = companySeqNo;
		this.parCompanySeqNo = parCompanySeqNo;
		this.companyClassSeqNo = companyClassSeqNo;
		this.parCompanyClassSeqNo = parCompanyClassSeqNo;
	}

}