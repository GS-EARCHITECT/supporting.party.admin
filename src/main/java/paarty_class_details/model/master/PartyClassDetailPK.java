package paarty_class_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PARTY_CLASS_DETAILS database table.
 * 
 */
@Embeddable
public class PartyClassDetailPK implements Serializable 
{
	// default serial version id, required for serializable classes.

	/**
	 * 
	 */
	private static final long serialVersionUID = -1848595031937363218L;

	@Column(name = "PARTY_CLASS_SEQ_NO")
	private Long partyClassSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	public PartyClassDetailPK() {
	}

	public Long getPartyClassSeqNo() {
		return this.partyClassSeqNo;
	}

	public void setPartyClassSeqNo(Long partyClassSeqNo) {
		this.partyClassSeqNo = partyClassSeqNo;
	}

	public Long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PartyClassDetailPK)) {
			return false;
		}
		PartyClassDetailPK castOther = (PartyClassDetailPK) other;
		return (this.partyClassSeqNo == castOther.partyClassSeqNo)
				&& (this.partySeqNo == castOther.partySeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.partyClassSeqNo ^ (this.partyClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.partySeqNo ^ (this.partySeqNo >>> 32)));

		return hash;
	}

	public PartyClassDetailPK(Long partyClassSeqNo, Long partySeqNo) {
		super();
		this.partyClassSeqNo = partyClassSeqNo;
		this.partySeqNo = partySeqNo;
	}

}