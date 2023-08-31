package enterprise.company_unit_roles.structure.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_FUNCTIONS_ROLES database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_FUNCTIONS_ROLES")
public class CompanyUnitFunctionRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyUnitFunctionRolePK id;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public CompanyUnitFunctionRole() {
	}

	public CompanyUnitFunctionRolePK getId() {
		return this.id;
	}

	public void setId(CompanyUnitFunctionRolePK id) {
		this.id = id;
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

	public CompanyUnitFunctionRole(CompanyUnitFunctionRolePK id, String remark, String status) {
		super();
		this.id = id;
		this.remark = remark;
		this.status = status;
	}

}