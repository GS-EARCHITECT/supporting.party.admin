package paarty_class_details.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import paarty_class_details.model.dto.PartyClassDetail_DTO;
import paarty_class_details.model.master.PartyClassDetail;
import paarty_class_details.model.master.PartyClassDetailPK;
import paarty_class_details.model.repo.PartyClassDetails_Repo;

@Service("partyClassDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyClassDetail_Service implements I_PartyClassDetails_Service 
{

	@Autowired
	private PartyClassDetails_Repo partyClassDetailsRepo;

	public PartyClassDetail_DTO newPartyClassDetail(PartyClassDetail_DTO lDetails) 
	{
		Optional<PartyClassDetail> partyClassDetails = null;
		PartyClassDetail_DTO partyClassDetailsDTO = null;
		PartyClassDetailPK partyClassDetailsPK = new PartyClassDetailPK();
		partyClassDetailsPK.setPartySeqNo(lDetails.getPartySeqNo());
		partyClassDetailsPK.setPartyClassSeqNo(lDetails.getPartyClassSeqNo());
		partyClassDetails = partyClassDetailsRepo.findById(partyClassDetailsPK);
		
		if(!partyClassDetails.isPresent())
		{
		partyClassDetails.get().setId(partyClassDetailsPK);	
		partyClassDetailsDTO = 	getPartyClassDetail_DTO(partyClassDetailsRepo.save(partyClassDetails.get()));
		}
		return partyClassDetailsDTO;
	}

	public ArrayList<PartyClassDetail_DTO> getAllPartyClassDetails() {
		ArrayList<PartyClassDetail> partyList = (ArrayList<PartyClassDetail>) partyClassDetailsRepo.findAll();
		ArrayList<PartyClassDetail_DTO> lDetails = new ArrayList<PartyClassDetail_DTO>();
		lDetails = partyList != null ? this.getPartyClassDetail_DTOs(partyList) : null;
		return lDetails;
	}

    
	public ArrayList<PartyClassDetail_DTO> getSelectPartysForClasses(ArrayList<Long> ids)
    {
		ArrayList<PartyClassDetail> lDetails = partyClassDetailsRepo.getSelectPartysForClasses(ids);
		ArrayList<PartyClassDetail_DTO> partyClassDetailsDTOs = null;
		partyClassDetailsDTOs = lDetails != null ? this.getPartyClassDetail_DTOs(lDetails) : null;
		return partyClassDetailsDTOs;
	}

	public ArrayList<PartyClassDetail_DTO> getSelectPartyClassDetails(ArrayList<Long> ids)
    {
		ArrayList<PartyClassDetail> lDetails = partyClassDetailsRepo.getSelectPartyClassDetails(ids);
		ArrayList<PartyClassDetail_DTO> partyClassDetailsDTOs = null;
		partyClassDetailsDTOs = lDetails != null ? this.getPartyClassDetail_DTOs(lDetails) : null;
		return partyClassDetailsDTOs;
	}
		
	public void updPartyClassDetail(PartyClassDetail_DTO lDetails) 
	{
		PartyClassDetailPK partyClassDetailsPK = new PartyClassDetailPK();
		partyClassDetailsPK.setPartySeqNo(lDetails.getPartySeqNo());
		partyClassDetailsPK.setPartyClassSeqNo(lDetails.getPartyClassSeqNo());	
		
		if (partyClassDetailsRepo.existsById(partyClassDetailsPK)) 
			{			
			partyClassDetailsRepo.save(this.setPartyClassDetail(lDetails));			
		}
		return;
	}

	
	public void delAllPartyClassDetails() {
		partyClassDetailsRepo.deleteAll();
	}

	public void delSelectPartyClassDetails(ArrayList<Long> ids) 
	{
		if (ids != null) 
		{
			partyClassDetailsRepo.delSelectPartyClassDetails(ids);
		}
	}
	
	public void delSelectPartysForClasses(ArrayList<Long> ids) 
	{
		if (ids != null) 
		{
			partyClassDetailsRepo.delSelectPartysForClasses(ids);
		}
	}

	private ArrayList<PartyClassDetail_DTO> getPartyClassDetail_DTOs(ArrayList<PartyClassDetail> lDetails) {
		PartyClassDetail_DTO lDTO = null;
		ArrayList<PartyClassDetail_DTO> lDetailsDTOs = new ArrayList<PartyClassDetail_DTO>();		
		for (int i = 0; i < lDetails.size(); i++) {
			lDTO = getPartyClassDetail_DTO(lDetails.get(i));			
			lDetailsDTOs.add(lDTO);
		}
		return lDetailsDTOs;
	}

	private PartyClassDetail_DTO getPartyClassDetail_DTO(PartyClassDetail lDetails) 
	{		
		PartyClassDetail_DTO lDTO = new PartyClassDetail_DTO();		
		lDTO.setPartySeqNo(lDetails.getId().getPartySeqNo());
		lDTO.setPartyClassSeqNo(lDetails.getId().getPartyClassSeqNo());
		return lDTO;
	}

	private PartyClassDetail setPartyClassDetail(PartyClassDetail_DTO lDTO) 
	{
		PartyClassDetail lDetails = new PartyClassDetail();
		PartyClassDetailPK partyClassDetailsPK = new PartyClassDetailPK();
		partyClassDetailsPK.setPartySeqNo(lDTO.getPartySeqNo());
		partyClassDetailsPK.setPartyClassSeqNo(lDTO.getPartyClassSeqNo());
		lDetails.setId(partyClassDetailsPK);
		return lDetails;
	}
}