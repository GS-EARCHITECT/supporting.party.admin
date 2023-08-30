package paarty_class_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PARTY_CLASS_DETAILS database table.
 * 
 */
@Entity
@Table(name = "PARTY_CLASS_DETAILS")
public class PartyClassDetail implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7456445299318322847L;
	@EmbeddedId
	private PartyClassDetailPK id;

	public PartyClassDetail() {
	}

	public PartyClassDetailPK getId() {
		return this.id;
	}

	public void setId(PartyClassDetailPK id) {
		this.id = id;
	}

	public PartyClassDetail(PartyClassDetailPK id) {
		super();
		this.id = id;
	}

}