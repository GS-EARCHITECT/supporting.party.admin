package membership.membership_details.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import membership.membership_details.model.dto.PartyMembershipDetailDTO;
import membership.membership_details.model.master.PartyMembershipDetail;
import membership.membership_details.model.master.PartyMembershipDetailPK;
import membership.membership_details.model.repo.PartyMembershipDetailsRepo;
import party_locations.model.master.PartyLocation;
import party_locations.model.master.PartyLocationPK;

@Service("partyMembershipDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyMembershipDetailService implements I_PartyMembershipDetailsService 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyMembershipDetailService.clas);

	@Autowired
	private PartyMembershipDetailsRepo partyMembershipDetailsRepo;

	public PartyMembershipDetailDTO newPartyMembershipDetail(PartyMembershipDetailDTO cDTO) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:s");
		LocalDateTime onDateTime = LocalDateTime.parse(cDTO.getOnDttm(), formatter);		
		Timestamp onTS = Timestamp.valueOf(onDateTime);		
		PartyMembershipDetailPK partyMembershipDetailPK = new PartyMembershipDetailPK();
		partyMembershipDetailPK.setMembershipSeqNo(cDTO.getMembershipSeqNo());
		partyMembershipDetailPK.setOnDttm(onTS);		
		PartyMembershipDetail partyMembershipDetail = null;

		if (!partyMembershipDetailsRepo.existsById(partyMembershipDetailPK))
		{
			partyMembershipDetail = this.setPartyMembershipDetail((cDTO));			
			cDTO = getPartyMembershipDetailDTO(partyMembershipDetailsRepo.save(partyMembershipDetail));
		}

		return cDTO;
	}

	public ArrayList<PartyMembershipDetailDTO> getAllPartyMembershipDetails() {
		ArrayList<PartyMembershipDetail> partyMembershipList = (ArrayList<PartyMembershipDetail>) partyMembershipDetailsRepo
				.findAll();
		ArrayList<PartyMembershipDetailDTO> cDTOs = new ArrayList<PartyMembershipDetailDTO>();
		cDTOs = partyMembershipList != null ? this.getPartyMembershipDetailDtos(partyMembershipList) : null;
		return cDTOs;
	}

	public ArrayList<PartyMembershipDetailDTO> getSelectPartyMembershipDetails(ArrayList<Long> partyMembershipSeqNos) {

		ArrayList<PartyMembershipDetail> partyMembershipList = (ArrayList<PartyMembershipDetail>) partyMembershipDetailsRepo
				.getSelectPartyMembershipDetails(partyMembershipSeqNos);
		ArrayList<PartyMembershipDetailDTO> cDTOs = new ArrayList<PartyMembershipDetailDTO>();
		cDTOs = partyMembershipList != null ? this.getPartyMembershipDetailDtos(partyMembershipList) : null;
		return cDTOs;
	}

	public ArrayList<PartyMembershipDetailDTO> getSelectPartyMembershipDetailsBetweenTimes(ArrayList<Long> ids, String frDtTm,
			String toDtTm) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:s");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
		ArrayList<PartyMembershipDetail> partyMembershipDetails = partyMembershipDetailsRepo.getSelectPartyMembershipDetailsBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
		ArrayList<PartyMembershipDetailDTO> partyMembershipDTOs = partyMembershipDetails != null
				? this.getPartyMembershipDetailDtos(partyMembershipDetails)
				: null;
		return partyMembershipDTOs;

	}

	public void updPartyMembershipDetail(PartyMembershipDetailDTO cDTO) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime onDateTime = LocalDateTime.parse(cDTO.getOnDttm(), formatter);		
		Timestamp onTS = Timestamp.valueOf(onDateTime);		
		PartyMembershipDetailPK partyMembershipDetailPK = new PartyMembershipDetailPK();
		partyMembershipDetailPK.setMembershipSeqNo(cDTO.getMembershipSeqNo());		
		partyMembershipDetailPK.setOnDttm(onTS);		
		PartyLocation partyLocation = null;

		if (partyMembershipDetailsRepo.existsById(partyMembershipDetailPK)) 
		{
			partyMembershipDetailsRepo.save(this.setPartyMembershipDetail(cDTO));
		}

	}

	public void delAllPartyMembershipDetails() 
	{
		partyMembershipDetailsRepo.deleteAll();
	}

	
	public void delSelectPartyMembershipDetails(ArrayList<Long> partyMembershipSeqNos) 
	{
		partyMembershipDetailsRepo.delSelectPartyMembershipDetails(partyMembershipSeqNos);
	
	}
	
	public void delSelectPartyMembershipDetailsBetweenTimes(ArrayList<Long> ids, String frDtTm,String toDtTm) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:s");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
		partyMembershipDetailsRepo.delSelectPartyMembershipBetweenTimes(ids, frTsTimestamp, toTsTimestamp);	
	}
	
	private ArrayList<PartyMembershipDetailDTO> getPartyMembershipDetailDtos(
			ArrayList<PartyMembershipDetail> cMembershipDetails) {
		PartyMembershipDetailDTO cDTO = null;
		ArrayList<PartyMembershipDetailDTO> cDTOs = new ArrayList<PartyMembershipDetailDTO>();

		for (int i = 0; i < cMembershipDetails.size(); i++) {
			cDTO = this.getPartyMembershipDetailDTO(cMembershipDetails.get(i));			
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private PartyMembershipDetailDTO getPartyMembershipDetailDTO(PartyMembershipDetail cMembershipDetails) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:s");
		PartyMembershipDetailDTO lDTO = new PartyMembershipDetailDTO();
		lDTO.setOnDttm(formatter.format(cMembershipDetails.getId().getOnDttm().toLocalDateTime()));
		lDTO.setMembershipSeqNo(cMembershipDetails.getId().getMembershipSeqNo());
		lDTO.setRemark(cMembershipDetails.getRemark());
		lDTO.setStatus(cMembershipDetails.getStatus());
		return lDTO;
	}

	private PartyMembershipDetail setPartyMembershipDetail(PartyMembershipDetailDTO lDTO) 
	{
		PartyMembershipDetailPK partyMembershipDetailPK = new PartyMembershipDetailPK();
		partyMembershipDetailPK.setMembershipSeqNo(lDTO.getMembershipSeqNo());
		PartyMembershipDetail membershipDetails = new PartyMembershipDetail();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:s");
		LocalDateTime onDateTime = LocalDateTime.parse(lDTO.getOnDttm(), formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(onDateTime);				
		partyMembershipDetailPK.setOnDttm(frTsTimestamp);	
		membershipDetails.setId(partyMembershipDetailPK);
		membershipDetails.setRemark(lDTO.getRemark());
		membershipDetails.setStatus(lDTO.getStatus());
		return membershipDetails;
	}

}