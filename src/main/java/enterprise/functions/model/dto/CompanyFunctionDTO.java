package enterprise.functions.model.dto;

import java.io.Serializable;

public class CompanyFunctionDTO implements Serializable 
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6491122560527696653L;
	private Long functionSeqNo;
	private String function;
	private String remark;
	private String status;

	public Long getFunctionSeqNo() {
		return functionSeqNo;
	}

	public void setFunctionSeqNo(Long functionSeqNo) {
		this.functionSeqNo = functionSeqNo;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
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

	public CompanyFunctionDTO(Long functionSeqNo, String function, String remark, String status) {
		super();
		this.functionSeqNo = functionSeqNo;
		this.function = function;
		this.remark = remark;
		this.status = status;
	}

	public CompanyFunctionDTO() {
		super();
	}

}