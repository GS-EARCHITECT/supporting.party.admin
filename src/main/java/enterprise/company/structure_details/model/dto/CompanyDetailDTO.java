package enterprise.company.structure_details.model.dto;

import java.io.Serializable;

public class CompanyDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1755359272696650091L;
	private Long companySeqNo;
	private Long parCompanySeqNo;

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

	public CompanyDetailDTO(Long companySeqNo, Long parCompanySeqNo) {
		super();
		this.companySeqNo = companySeqNo;
		this.parCompanySeqNo = parCompanySeqNo;
	}

	public CompanyDetailDTO() {
		super();
	}

}