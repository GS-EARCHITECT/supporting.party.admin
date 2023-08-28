package party_locations.model.master;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The primary key class for the PARTY_LOCATIONS database table.
 * 
 */
@Embeddable
public class PartyLocationPK implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6819805001810858036L;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "LOCATION_SQ_NO")
	private Long locationSqNo;

	@Column(name = "ON_DTTM")
	private Timestamp onDttm;

	public PartyLocationPK() {
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Long getLocationSqNo() {
		return locationSqNo;
	}

	public void setLocationSqNo(Long locationSqNo) {
		this.locationSqNo = locationSqNo;
	}

	public Timestamp getOnDttm() {
		return onDttm;
	}

	public void setOnDttm(Timestamp onDttm) {
		this.onDttm = onDttm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationSqNo == null) ? 0 : locationSqNo.hashCode());
		result = prime * result + ((onDttm == null) ? 0 : onDttm.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
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
		PartyLocationPK other = (PartyLocationPK) obj;
		if (locationSqNo == null) {
			if (other.locationSqNo != null)
				return false;
		} else if (!locationSqNo.equals(other.locationSqNo))
			return false;
		if (onDttm == null) {
			if (other.onDttm != null)
				return false;
		} else if (!onDttm.equals(other.onDttm))
			return false;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		return true;
	}

	public PartyLocationPK(Long partySeqNo, Long locationSqNo, Timestamp onDttm) {
		super();
		this.partySeqNo = partySeqNo;
		this.locationSqNo = locationSqNo;
		this.onDttm = onDttm;
	}

}