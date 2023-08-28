package party_locations.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PARTY_LOCATIONS database table.
 * 
 */
@Entity
@Table(name = "PARTY_LOCATIONS")
public class PartyLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartyLocationPK id;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public PartyLocation() {
	}

	public PartyLocationPK getId() {
		return this.id;
	}

	public void setId(PartyLocationPK id) {
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

	public PartyLocation(PartyLocationPK id, String remark, String status) {
		super();
		this.id = id;
		this.remark = remark;
		this.status = status;
	}

}