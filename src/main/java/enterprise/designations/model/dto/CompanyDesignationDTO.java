package enterprise.designations.model.dto;

import java.io.Serializable;

public class CompanyDesignationDTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7352468920287593583L;
	private Long designationSeqNo;
	private String designation;
	private String remark;
	private String status;

	public Long getDesignationSeqNo() {
		return designationSeqNo;
	}

	public void setDesignationSeqNo(Long designationSeqNo) {
		this.designationSeqNo = designationSeqNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public CompanyDesignationDTO(Long designationSeqNo, String designation, String remark, String status) {
		super();
		this.designationSeqNo = designationSeqNo;
		this.designation = designation;
		this.remark = remark;
		this.status = status;
	}

	public CompanyDesignationDTO() {
		super();
	}

}