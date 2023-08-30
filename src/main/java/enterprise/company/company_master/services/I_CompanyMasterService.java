package enterprise.company.company_master.services;

import java.util.ArrayList;

import enterprise.company.company_master.model.dto.CompanyMasterDTO;

public interface I_CompanyMasterService
{
    abstract public CompanyMasterDTO newCompany(CompanyMasterDTO companyDTO);
    abstract public ArrayList<CompanyMasterDTO> getAllCompanies();
    abstract public ArrayList<CompanyMasterDTO> getSelectCompaniesForParties(ArrayList<Long> ids);
    abstract public ArrayList<CompanyMasterDTO> getSelectCompanies(ArrayList<Long> companySeqNos);
    abstract public void updCompany(CompanyMasterDTO companyDTO);
    abstract public void delCompany(Long companySeqNo);
    abstract public void delAllCompanies();
    abstract public void delSelectCompanies(ArrayList<Long> companySeqNos);
    abstract void delSelectCompaniesForParties(ArrayList<Long> ids);

}