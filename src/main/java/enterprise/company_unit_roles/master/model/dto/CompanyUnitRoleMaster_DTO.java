package enterprise.company_unit_roles.master.model.dto;

import java.io.Serializable;

public class CompanyUnitRoleMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1225676212335288348L;
	private Long roleSeqNo;
	private Long companyUnitSeqNo;
	private Long masterRoleSeqNo;

	public Long getRoleSeqNo() {
		return roleSeqNo;
	}

	public void setRoleSeqNo(Long roleSeqNo) {
		this.roleSeqNo = roleSeqNo;
	}

	public Long getCompanyUnitSeqNo() {
		return companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public Long getMasterRoleSeqNo() {
		return masterRoleSeqNo;
	}

	public void setMasterRoleSeqNo(Long masterRoleSeqNo) {
		this.masterRoleSeqNo = masterRoleSeqNo;
	}

	public CompanyUnitRoleMaster_DTO(Long roleSeqNo, Long companyUnitSeqNo, Long masterRoleSeqNo) {
		super();
		this.roleSeqNo = roleSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.masterRoleSeqNo = masterRoleSeqNo;
	}

	public CompanyUnitRoleMaster_DTO() {
		super();
	}

}