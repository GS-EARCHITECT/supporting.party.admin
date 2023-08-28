package enterprise.company_class.model.master;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_CLASS_MASTER database table.
 * 
 */
@Entity
@Table(name = "COMPANY_CLASS_MASTER")
public class CompanyClassMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_class_sequence")
	@SequenceGenerator(name = "company_class_sequence", sequenceName = "company_class_sequence", allocationSize = 1)
	@Column(name = "COMPANY_CLASS_SEQ_NO")
	private Long companyClassSeqNo;

	@NotBlank(message = "-Company Class Mandatory-")
	@Column(name = "COMPANY_CLASS")
	private String companyClass;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "STATUS")
	private String status;

	public CompanyClassMaster() {
	}

	public Long getCompanyClassSeqNo() {
		return this.companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public String getCompanyClass() {
		return this.companyClass;
	}

	public void setCompanyClass(String companyClass) {
		this.companyClass = companyClass;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyClass == null) ? 0 : companyClass.hashCode());
		result = prime * result + ((companyClassSeqNo == null) ? 0 : companyClassSeqNo.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((specificationSeqNo == null) ? 0 : specificationSeqNo.hashCode());
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
		CompanyClassMaster other = (CompanyClassMaster) obj;
		if (companyClass == null) {
			if (other.companyClass != null)
				return false;
		} else if (!companyClass.equals(other.companyClass))
			return false;
		if (companyClassSeqNo == null) {
			if (other.companyClassSeqNo != null)
				return false;
		} else if (!companyClassSeqNo.equals(other.companyClassSeqNo))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (specificationSeqNo == null) {
			if (other.specificationSeqNo != null)
				return false;
		} else if (!specificationSeqNo.equals(other.specificationSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public CompanyClassMaster(Long companyClassSeqNo, String companyClass, String description, String remark,
			Long specificationSeqNo, String status) {
		super();
		this.companyClassSeqNo = companyClassSeqNo;
		this.companyClass = companyClass;
		this.description = description;
		this.remark = remark;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
	}

}