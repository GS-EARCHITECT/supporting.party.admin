package enterprise.company_unit_roles.master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_ROLE_MASTER database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_ROLE_MASTER")
public class CompanyUnitRoleMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3026743915836973453L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_UNIT_ROLE_SEQUENCE")
	@SequenceGenerator(name = "COMPANY_UNIT_ROLE_SEQUENCE", sequenceName = "COMPANY_UNIT_ROLE_SEQUENCE", allocationSize = 1)
	@Column(name = "ROLE_SEQ_NO")
	private Long roleSeqNo;

	@Column(name = "COMPANY_UNIT_SEQ_NO")
	private Long companyUnitSeqNo;

	@Column(name = "MASTER_ROLE_SEQ_NO")
	private Long masterRoleSeqNo;

	public CompanyUnitRoleMaster() {
	}

	public Long getRoleSeqNo() {
		return this.roleSeqNo;
	}

	public void setRoleSeqNo(Long roleSeqNo) {
		this.roleSeqNo = roleSeqNo;
	}

	public Long getCompanyUnitSeqNo() {
		return this.companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public Long getMasterRoleSeqNo() {
		return this.masterRoleSeqNo;
	}

	public void setMasterRoleSeqNo(Long masterRoleSeqNo) {
		this.masterRoleSeqNo = masterRoleSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyUnitSeqNo == null) ? 0 : companyUnitSeqNo.hashCode());
		result = prime * result + ((masterRoleSeqNo == null) ? 0 : masterRoleSeqNo.hashCode());
		result = prime * result + ((roleSeqNo == null) ? 0 : roleSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyUnitRoleMaster other = (CompanyUnitRoleMaster) obj;
		if (companyUnitSeqNo == null) {
			if (other.companyUnitSeqNo != null)
				return false;
		} else if (!companyUnitSeqNo.equals(other.companyUnitSeqNo))
			return false;
		if (masterRoleSeqNo == null) {
			if (other.masterRoleSeqNo != null)
				return false;
		} else if (!masterRoleSeqNo.equals(other.masterRoleSeqNo))
			return false;
		if (roleSeqNo == null) {
			if (other.roleSeqNo != null)
				return false;
		} else if (!roleSeqNo.equals(other.roleSeqNo))
			return false;
		return true;
	}

	public CompanyUnitRoleMaster(Long roleSeqNo, Long companyUnitSeqNo, Long masterRoleSeqNo) {
		super();
		this.roleSeqNo = roleSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.masterRoleSeqNo = masterRoleSeqNo;
	}

}