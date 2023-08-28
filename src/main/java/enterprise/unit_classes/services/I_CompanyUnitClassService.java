package enterprise.unit_classes.services;

import java.util.ArrayList;

import enterprise.unit_classes.model.dto.CompanyUnitClassDTO;

public interface I_CompanyUnitClassService 
{
	public CompanyUnitClassDTO newCompanyUnitClass(CompanyUnitClassDTO companyUnitClassDTO);
	public ArrayList<CompanyUnitClassDTO> getAllCompanyUnitClasses();
	public ArrayList<CompanyUnitClassDTO> getSelectCompanyUnitClasses(ArrayList<Long> companyUnitClassSeqNos);
	public void updCompanyUnitClass(CompanyUnitClassDTO companyUnitClassDTO);	
	public void delAllCompanyUnitClasses();
	public void delSelectCompanyUnitClasses(ArrayList<Long> unitClassSeqNos);
}