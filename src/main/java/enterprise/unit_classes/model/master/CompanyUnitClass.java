package enterprise.unit_classes.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_CLASS database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_CLASS_MASTER")
public class CompanyUnitClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7060393658151874527L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_unit_class_sequence")
	@SequenceGenerator(name = "company_unit_class_sequence", sequenceName = "company_unit_class_sequence", allocationSize = 1)
	@Column(name = "UNIT_CLASS_SEQ_NO")
	private Long unitClassSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UNITCLASS")
	private String unitclass;

	public CompanyUnitClass() {
	}

	public Long getUnitClassSeqNo() {
		return this.unitClassSeqNo;
	}

	public void setUnitClassSeqNo(Long unitClassSeqNo) {
		this.unitClassSeqNo = unitClassSeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUnitclass() {
		return this.unitclass;
	}

	public void setUnitclass(String unitclass) {
		this.unitclass = unitclass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((unitClassSeqNo == null) ? 0 : unitClassSeqNo.hashCode());
		result = prime * result + ((unitclass == null) ? 0 : unitclass.hashCode());
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
		CompanyUnitClass other = (CompanyUnitClass) obj;
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
		if (unitClassSeqNo == null) {
			if (other.unitClassSeqNo != null)
				return false;
		} else if (!unitClassSeqNo.equals(other.unitClassSeqNo))
			return false;
		if (unitclass == null) {
			if (other.unitclass != null)
				return false;
		} else if (!unitclass.equals(other.unitclass))
			return false;
		return true;
	}

	public CompanyUnitClass(Long unitClassSeqNo, String remark, String status, String unitclass) {
		super();
		this.unitClassSeqNo = unitClassSeqNo;
		this.remark = remark;
		this.status = status;
		this.unitclass = unitclass;
	}

}