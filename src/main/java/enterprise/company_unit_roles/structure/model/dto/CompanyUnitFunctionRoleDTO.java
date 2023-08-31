package enterprise.company_unit_roles.structure.model.dto;

import java.io.Serializable;

public class CompanyUnitFunctionRoleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3198153523333747752L;
	private long companyRoleSeqNo;
	private long companyFunctionSeqNo;
	private String remark;
	private String status;

	public long getCompanyRoleSeqNo() {
		return companyRoleSeqNo;
	}

	public void setCompanyRoleSeqNo(long companyRoleSeqNo) {
		this.companyRoleSeqNo = companyRoleSeqNo;
	}

	public long getCompanyFunctionSeqNo() {
		return companyFunctionSeqNo;
	}

	public void setCompanyFunctionSeqNo(long companyFunctionSeqNo) {
		this.companyFunctionSeqNo = companyFunctionSeqNo;
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

	public CompanyUnitFunctionRoleDTO(long companyRoleSeqNo, long companyFunctionSeqNo, String remark, String status) {
		super();
		this.companyRoleSeqNo = companyRoleSeqNo;
		this.companyFunctionSeqNo = companyFunctionSeqNo;
		this.remark = remark;
		this.status = status;
	}

	public CompanyUnitFunctionRoleDTO() {
		super();
	}

}