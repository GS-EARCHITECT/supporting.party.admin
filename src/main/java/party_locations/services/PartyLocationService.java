package party_locations.services;

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

import party_locations.model.dto.PartyLocationDTO;
import party_locations.model.master.PartyLocation;
import party_locations.model.master.PartyLocationPK;
import party_locations.model.repo.PartyLocationRepo;

@Service("partyLocationServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PartyLocationService implements I_PartyLocationService {

	@Autowired
	private PartyLocationRepo partyLocationRepo;

	public PartyLocationDTO newPartyLocation(PartyLocationDTO lPartyLocation) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime onDateTime = LocalDateTime.parse(lPartyLocation.getOnDttm(), formatter);		
		Timestamp onTS = Timestamp.valueOf(onDateTime);		
		PartyLocationPK partyLocationPK = new PartyLocationPK();
		partyLocationPK.setPartySeqNo(lPartyLocation.getPartySeqNo());
		partyLocationPK.setLocationSqNo(lPartyLocation.getLocationSqNo());
		partyLocationPK.setOnDttm(onTS);		
		PartyLocation partyLocation = null;

		if (!partyLocationRepo.existsById(partyLocationPK)) {
			partyLocation = this.setPartyLocation(lPartyLocation);
			partyLocation.setId(partyLocationPK);
			lPartyLocation = getPartyLocationDTO(partyLocationRepo.save(partyLocation));
		}
		return lPartyLocation;
	}

	public ArrayList<PartyLocationDTO> getAllPartyLocations() {
		ArrayList<PartyLocation> supplierList = (ArrayList<PartyLocation>) partyLocationRepo.findAll();
		ArrayList<PartyLocationDTO> lPartyLocations = new ArrayList<PartyLocationDTO>();
		lPartyLocations = supplierList != null ? this.getPartyLocationDTOs(supplierList) : null;
		return lPartyLocations;
	}

	public ArrayList<PartyLocationDTO> getSelectPartyLocationsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
		ArrayList<PartyLocation> partyLocations = partyLocationRepo.getSelectPartyLocationsBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
		ArrayList<PartyLocationDTO> partyLocationDTOs = partyLocations != null	? this.getPartyLocationDTOs(partyLocations) : null;
		return partyLocationDTOs;

	}
	
	public ArrayList<PartyLocationDTO> getSelectPartyLocations(ArrayList<Long> ids) 
	{
		ArrayList<PartyLocation> lPartyLocation = partyLocationRepo.getSelectPartyLocations(ids);				
		ArrayList<PartyLocationDTO> partyLocationDTOs = lPartyLocation != null	? this.getPartyLocationDTOs(lPartyLocation): null;
		return partyLocationDTOs;
	}

	public ArrayList<PartyLocationDTO> getSelectPartiesByLocations(ArrayList<Long> ids)
	{
		ArrayList<PartyLocation> lPartyLocation = partyLocationRepo.getSelectPartiesByLocations(ids);
		ArrayList<PartyLocationDTO> partyLocationDTOs = lPartyLocation != null	? this.getPartyLocationDTOs(lPartyLocation): null;
		return partyLocationDTOs;
	}

	public void updPartyLocation(PartyLocationDTO lPartyLocation) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime onDateTime = LocalDateTime.parse(lPartyLocation.getOnDttm(), formatter);		
		Timestamp onTS = Timestamp.valueOf(onDateTime);		
		PartyLocationPK partyLocationPK = new PartyLocationPK();
		partyLocationPK.setPartySeqNo(lPartyLocation.getPartySeqNo());
		partyLocationPK.setLocationSqNo(lPartyLocation.getLocationSqNo());
		partyLocationPK.setOnDttm(onTS);		
		PartyLocation partyLocation = null;

		if (partyLocationRepo.existsById(partyLocationPK)) {
			partyLocationRepo.save(this.setPartyLocation(lPartyLocation));
		}
		return;
	}

	public void delSelectPartyLocationsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);		
		partyLocationRepo.delSelectPartyLocationsBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
		return;
	}

	
	public void delSelectPartyLocations(ArrayList<Long> ids)
	{
		partyLocationRepo.delSelectPartyLocations(ids);		
		return;
	}

	public void delSelectPartiesByLocations(ArrayList<Long> ids) 
	{
		partyLocationRepo.delSelectPartiesByLocations(ids);		
		return;
	}

	public void delAllPartyLocations() {
		partyLocationRepo.deleteAll();
	}

	private ArrayList<PartyLocationDTO> getPartyLocationDTOs(
			ArrayList<PartyLocation> lPartyLocation) {
		PartyLocationDTO lDTO = null;
		ArrayList<PartyLocationDTO> lPartyLocationDTOs = new ArrayList<PartyLocationDTO>();
		for (int i = 0; i < lPartyLocation.size(); i++) {
			lDTO = getPartyLocationDTO(lPartyLocation.get(i));
			lPartyLocationDTOs.add(lDTO);
		}
		return lPartyLocationDTOs;
	}

	private PartyLocationDTO getPartyLocationDTO(PartyLocation lPartyLocation) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		PartyLocationDTO lDTO = new PartyLocationDTO();
		lDTO.setOnDttm(formatter.format(lPartyLocation.getId().getOnDttm().toLocalDateTime()));
		lDTO.setPartySeqNo(lPartyLocation.getId().getPartySeqNo());
		lDTO.setLocationSqNo(lPartyLocation.getId().getLocationSqNo());
		lDTO.setStatus(lPartyLocation.getStatus());
		lDTO.setRemark(lPartyLocation.getRemark());		
		return lDTO;
	}

	private PartyLocation setPartyLocation(PartyLocationDTO lDTO) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime onDateTime = LocalDateTime.parse(lDTO.getOnDttm(), formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(onDateTime);
		PartyLocationPK partyLocationPK = new PartyLocationPK();
		partyLocationPK.setPartySeqNo(lDTO.getPartySeqNo());
		partyLocationPK.setLocationSqNo(lDTO.getLocationSqNo());
		partyLocationPK.setOnDttm(frTsTimestamp);
		PartyLocation lPartyLocation = new PartyLocation();
		lPartyLocation.setId(partyLocationPK);
		lPartyLocation.setStatus(lDTO.getStatus());
		lPartyLocation.setRemark(lDTO.getRemark());		
		return lPartyLocation;
	}
}