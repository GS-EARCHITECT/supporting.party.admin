package enterprise.roles.model.dto;

import java.io.Serializable;

public class CompanyRoleDTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3765310249553703209L;
	private Long roleSeqNo;
	private String role;
	private String remark;
	private String status;

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

	public CompanyRoleDTO(Long roleSeqNo, String role, String remark, String status) {
		super();
		this.roleSeqNo = roleSeqNo;
		this.role = role;
		this.remark = remark;
		this.status = status;
	}

	public CompanyRoleDTO() {
		super();
	}

}