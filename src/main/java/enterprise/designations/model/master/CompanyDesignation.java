package enterprise.designations.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_DESIGNATION_MASTER database table.
 * 
 */
@Entity
@Table(name = "COMPANY_DESIGNATION_MASTER")
public class CompanyDesignation implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5978283835839553489L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_designation_sequence")
	@SequenceGenerator(name = "company_designation_sequence", allocationSize = 1)
	@Column(name = "DESIGNATION_SEQ_NO")
	private Long designationSeqNo;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public CompanyDesignation() {
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((designationSeqNo == null) ? 0 : designationSeqNo.hashCode());
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
		CompanyDesignation other = (CompanyDesignation) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (designationSeqNo == null) {
			if (other.designationSeqNo != null)
				return false;
		} else if (!designationSeqNo.equals(other.designationSeqNo))
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

	public CompanyDesignation(Long designationSeqNo, String designation, String remark, String status) {
		super();
		this.designationSeqNo = designationSeqNo;
		this.designation = designation;
		this.remark = remark;
		this.status = status;
	}

}