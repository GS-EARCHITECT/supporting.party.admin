package paarty_class_details.model.dto;

import java.io.Serializable;

public class PartyClassDetail_DTO implements Serializable 
{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4180422824976729180L;
	private Long partyClassSeqNo;
	private Long partySeqNo;

	public Long getPartyClassSeqNo() {
		return partyClassSeqNo;
	}

	public void setPartyClassSeqNo(Long partyClassSeqNo) {
		this.partyClassSeqNo = partyClassSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public PartyClassDetail_DTO(Long partyClassSeqNo, Long partySeqNo) {
		super();
		this.partyClassSeqNo = partyClassSeqNo;
		this.partySeqNo = partySeqNo;
	}

	public PartyClassDetail_DTO() {
		super();
	}

}