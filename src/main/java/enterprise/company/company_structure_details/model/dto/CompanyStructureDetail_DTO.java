package enterprise.company.company_structure_details.model.dto;

import java.io.Serializable;

public class CompanyStructureDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8383832131045667678L;
	private Long companySeqNo;
	private Long parCompanySeqNo;
	private Long companyClassSeqNo;
	private Long parCompanyClassSeqNo;

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public Long getParCompanySeqNo() {
		return parCompanySeqNo;
	}

	public void setParCompanySeqNo(Long parCompanySeqNo) {
		this.parCompanySeqNo = parCompanySeqNo;
	}

	public Long getCompanyClassSeqNo() {
		return companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public Long getParCompanyClassSeqNo() {
		return parCompanyClassSeqNo;
	}

	public void setParCompanyClassSeqNo(Long parCompanyClassSeqNo) {
		this.parCompanyClassSeqNo = parCompanyClassSeqNo;
	}

	public CompanyStructureDetail_DTO(Long companySeqNo, Long parCompanySeqNo, Long companyClassSeqNo,
			Long parCompanyClassSeqNo) {
		super();
		this.companySeqNo = companySeqNo;
		this.parCompanySeqNo = parCompanySeqNo;
		this.companyClassSeqNo = companyClassSeqNo;
		this.parCompanyClassSeqNo = parCompanyClassSeqNo;
	}

	public CompanyStructureDetail_DTO() {
		super();
	}

}