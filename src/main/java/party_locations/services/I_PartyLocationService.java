package party_locations.services;

import java.util.ArrayList;

import party_locations.model.dto.PartyLocationDTO;

public interface I_PartyLocationService 
{
	public PartyLocationDTO newPartyLocation(PartyLocationDTO partyLocationDTO);
	public ArrayList<PartyLocationDTO> getAllPartyLocations();
	public ArrayList<PartyLocationDTO> getSelectPartyLocationsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
	public ArrayList<PartyLocationDTO> getSelectPartyLocations(ArrayList<Long> ids);
	public ArrayList<PartyLocationDTO> getSelectPartiesByLocations(ArrayList<Long> ids);	
	public void updPartyLocation(PartyLocationDTO partyLocationDTO);
	public void delSelectPartyLocationsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
	public void delSelectPartyLocations(ArrayList<Long> ids);
	public void delSelectPartiesByLocations(ArrayList<Long> ids);
	public void delAllPartyLocations();	
}
