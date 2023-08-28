package enterprise.unit_classes.model.dto;

import java.io.Serializable;
import javax.persistence.*;

public class CompanyUnitClassDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7821836529331147808L;
	private Long unitClassSeqNo;
	private String remark;
	private String status;
	private String unitclass;

	public Long getUnitClassSeqNo() {
		return unitClassSeqNo;
	}

	public void setUnitClassSeqNo(Long unitClassSeqNo) {
		this.unitClassSeqNo = unitClassSeqNo;
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

	public String getUnitclass() {
		return unitclass;
	}

	public void setUnitclass(String unitclass) {
		this.unitclass = unitclass;
	}

	public CompanyUnitClassDTO(Long unitClassSeqNo, String remark, String status, String unitclass) {
		super();
		this.unitClassSeqNo = unitClassSeqNo;
		this.remark = remark;
		this.status = status;
		this.unitclass = unitclass;
	}

	public CompanyUnitClassDTO() {
		super();
	}

}