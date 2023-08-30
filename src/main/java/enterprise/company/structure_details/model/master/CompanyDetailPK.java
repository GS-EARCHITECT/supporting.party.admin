package enterprise.company.structure_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COMPANY_STRUCTURE database table.
 * 
 */
@Embeddable
public class CompanyDetailPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3898797433106329429L;

	@Column(name = "COMPANY_SEQ_NO")
	private Long companySeqNo;

	@Column(name = "PAR_COMPANY_SEQ_NO")
	private Long parCompanySeqNo;

	public CompanyDetailPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanyDetailPK)) {
			return false;
		}
		CompanyDetailPK castOther = (CompanyDetailPK) other;
		return (this.companySeqNo == castOther.companySeqNo) && (this.parCompanySeqNo == castOther.parCompanySeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.companySeqNo ^ (this.companySeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parCompanySeqNo ^ (this.parCompanySeqNo >>> 32)));

		return hash;
	}

	public CompanyDetailPK(Long companySeqNo, Long parCompanySeqNo) {
		super();
		this.companySeqNo = companySeqNo;
		this.parCompanySeqNo = parCompanySeqNo;
	}

}