package enterprise.designations.services;

import java.util.ArrayList;

import enterprise.designations.model.dto.CompanyDesignationDTO;

public interface I_CompanyDesignationService 
{
	public CompanyDesignationDTO newDesignation(CompanyDesignationDTO designationDTO);
	public ArrayList<CompanyDesignationDTO> getAllDesignations();
	public ArrayList<CompanyDesignationDTO> getSelectDesignations(ArrayList<Long> designationSeqNos);
	public void updDesignation(CompanyDesignationDTO designationDTO);	
	public void delAllDesignations();
	public void delSelectDesignations(ArrayList<Long> designationSeqNos);
}