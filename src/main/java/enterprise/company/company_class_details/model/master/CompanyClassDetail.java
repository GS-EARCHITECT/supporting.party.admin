package enterprise.company.company_class_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_CLASS_DETAILS database table.
 * 
 */
@Entity
@Table(name = "COMPANY_CLASS_DETAILS")
public class CompanyClassDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyClassDetailPK id;

	public CompanyClassDetail() {
	}

	public CompanyClassDetailPK getId() {
		return this.id;
	}

	public void setId(CompanyClassDetailPK id) {
		this.id = id;
	}

	public CompanyClassDetail(CompanyClassDetailPK id) {
		super();
		this.id = id;
	}

}