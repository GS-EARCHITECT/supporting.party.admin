package enterprise.company.company_class_details.model.dto;

import java.io.Serializable;

public class CompanyClassDetail_DTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3002675626154336831L;
	private Long companySeqNo;
	private Long companyClassSeqNo;

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public Long getCompanyClassSeqNo() {
		return companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public CompanyClassDetail_DTO(Long companySeqNo, Long companyClassSeqNo) {
		super();
		this.companySeqNo = companySeqNo;
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public CompanyClassDetail_DTO() {
		super();
	}

}