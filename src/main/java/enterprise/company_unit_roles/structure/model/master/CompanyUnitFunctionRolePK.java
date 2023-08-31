package enterprise.company_unit_roles.structure.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COMPANY_UNIT_FUNCTIONS_ROLES database table.
 * 
 */
@Embeddable
public class CompanyUnitFunctionRolePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4079335061462154432L;

	@Column(name = "COMPANY_ROLE_SEQ_NO")
	private long companyRoleSeqNo;

	@Column(name = "COMPANY_FUNCTION_SEQ_NO")
	private long companyFunctionSeqNo;

	public CompanyUnitFunctionRolePK() {
	}

	public long getCompanyRoleSeqNo() {
		return this.companyRoleSeqNo;
	}

	public void setCompanyRoleSeqNo(long companyRoleSeqNo) {
		this.companyRoleSeqNo = companyRoleSeqNo;
	}

	public long getCompanyFunctionSeqNo() {
		return this.companyFunctionSeqNo;
	}

	public void setCompanyFunctionSeqNo(long companyFunctionSeqNo) {
		this.companyFunctionSeqNo = companyFunctionSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanyUnitFunctionRolePK)) {
			return false;
		}
		CompanyUnitFunctionRolePK castOther = (CompanyUnitFunctionRolePK) other;
		return (this.companyRoleSeqNo == castOther.companyRoleSeqNo)
				&& (this.companyFunctionSeqNo == castOther.companyFunctionSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.companyRoleSeqNo ^ (this.companyRoleSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.companyFunctionSeqNo ^ (this.companyFunctionSeqNo >>> 32)));

		return hash;
	}

	public CompanyUnitFunctionRolePK(long companyRoleSeqNo, long companyFunctionSeqNo) {
		super();
		this.companyRoleSeqNo = companyRoleSeqNo;
		this.companyFunctionSeqNo = companyFunctionSeqNo;
	}

}