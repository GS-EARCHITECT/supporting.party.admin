package enterprise.functions.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_FUNCTION_MASTER database table.
 * 
 */
@Entity
@Table(name = "COMPANY_FUNCTION_MASTER")
public class CompanyFunction implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5775076748407563195L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_function_sequence")
	@SequenceGenerator(name = "company_function_sequence", allocationSize = 1)
	@Column(name = "FUNCTION_SEQ_NO")
	private Long functionSeqNo;

	@Column(name = "FUNCTION")
	private String function;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public CompanyFunction() {
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		result = prime * result + ((functionSeqNo == null) ? 0 : functionSeqNo.hashCode());
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
		CompanyFunction other = (CompanyFunction) obj;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (functionSeqNo == null) {
			if (other.functionSeqNo != null)
				return false;
		} else if (!functionSeqNo.equals(other.functionSeqNo))
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

	public CompanyFunction(Long functionSeqNo, String function, String remark, String status) {
		super();
		this.functionSeqNo = functionSeqNo;
		this.function = function;
		this.remark = remark;
		this.status = status;
	}

}