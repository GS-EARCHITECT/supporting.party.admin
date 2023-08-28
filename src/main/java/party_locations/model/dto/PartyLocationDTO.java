package party_locations.model.dto;

import java.io.Serializable;

public class PartyLocationDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -448062718908815245L;
	private Long partySeqNo;
	private Long locationSqNo;
	private String onDttm;
	private String remark;
	private String status;

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

	public String getOnDttm() {
		return onDttm;
	}

	public void setOnDttm(String onDttm) {
		this.onDttm = onDttm;
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

	public PartyLocationDTO(Long partySeqNo, Long locationSqNo, String onDttm, String remark, String status) {
		super();
		this.partySeqNo = partySeqNo;
		this.locationSqNo = locationSqNo;
		this.onDttm = onDttm;
		this.remark = remark;
		this.status = status;
	}

	public PartyLocationDTO() {
		super();
	}

}