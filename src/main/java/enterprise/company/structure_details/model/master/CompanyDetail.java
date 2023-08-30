package enterprise.company.structure_details.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COMPANY_STRUCTURE database table.
 * 
 */
@Entity
@Table(name="COMPANY_DETAILS")
public class CompanyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyDetailPK id;

	public CompanyDetail() {
	}

	public CompanyDetailPK getId() {
		return this.id;
	}

	public void setId(CompanyDetailPK id) {
		this.id = id;
	}

	public CompanyDetail(CompanyDetailPK id) {
		super();
		this.id = id;
	}
	
	

}