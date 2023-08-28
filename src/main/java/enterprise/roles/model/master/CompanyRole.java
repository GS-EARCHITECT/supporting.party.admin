package enterprise.roles.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_ROLE_MASTER database table.
 * 
 */
@Entity
@Table(name = "COMPANY_ROLE_MASTER")
public class CompanyRole implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1506445063307479632L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_role_sequence")
	@SequenceGenerator(name = "company_role_sequence", allocationSize = 1)
	@Column(name = "ROLE_SEQ_NO")
	private Long roleSeqNo;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public CompanyRole() {
	}

	public Long getRoleSeqNo() {
		return roleSeqNo;
	}

	public void setRoleSeqNo(Long roleSeqNo) {
		this.roleSeqNo = roleSeqNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((roleSeqNo == null) ? 0 : roleSeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		CompanyRole other = (CompanyRole) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (roleSeqNo == null) {
			if (other.roleSeqNo != null)
				return false;
		} else if (!roleSeqNo.equals(other.roleSeqNo))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public CompanyRole(Long roleSeqNo, String role, String remark, String status) {
		super();
		this.roleSeqNo = roleSeqNo;
		this.role = role;
		this.remark = remark;
		this.status = status;
	}

}