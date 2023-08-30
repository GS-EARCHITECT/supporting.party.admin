package paarty_class_details.service;

import java.util.ArrayList;

import paarty_class_details.model.dto.PartyClassDetail_DTO;

public interface I_PartyClassDetails_Service
{
    abstract public PartyClassDetail_DTO newPartyClassDetail(PartyClassDetail_DTO partyClassDetailsDTO);
    abstract public ArrayList<PartyClassDetail_DTO> getAllPartyClassDetails();
    abstract public ArrayList<PartyClassDetail_DTO> getSelectPartyClassDetails(ArrayList<Long> ids);
    abstract public ArrayList<PartyClassDetail_DTO> getSelectPartysForClasses(ArrayList<Long> ids);    
    abstract public void updPartyClassDetail(PartyClassDetail_DTO partyClassDetailsDTO);
    abstract public void delAllPartyClassDetails();
    abstract public void delSelectPartyClassDetails(ArrayList<Long> ids);
    abstract public void delSelectPartysForClasses(ArrayList<Long> ids);    
}