package enterprise.company.structure_details.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COMPANY_STRUCTURE_DETAILS database table.
 * 
 */
@Entity
@Table(name="COMPANY_STRUCTURE_DETAILS")
@NamedQuery(name="CompanyStructureDetail.findAll", query="SELECT c FROM CompanyStructureDetail c")
public class CompanyStructureDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyStructureDetailPK id;

	public CompanyStructureDetail() {
	}

	public CompanyStructureDetailPK getId() {
		return this.id;
	}

	public void setId(CompanyStructureDetailPK id) {
		this.id = id;
	}

}