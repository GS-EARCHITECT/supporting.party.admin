package enterprise.company.structure_details.services;

import java.util.ArrayList;

import enterprise.company.structure_details.model.dto.CompanyDetailDTO;

public interface I_CompanyDetailsService
{
    abstract public CompanyDetailDTO newCompanyDetail(CompanyDetailDTO companyDetailDTO);
    abstract public ArrayList<CompanyDetailDTO> getAllCompanyDetails();
    abstract public ArrayList<CompanyDetailDTO> getSelectCompanyDetailsByParents(ArrayList<Long> ids);
    abstract public ArrayList<CompanyDetailDTO> getSelectCompanyDetails(ArrayList<Long> companySeqNos, ArrayList<Long> parCompanySeqNos);
    abstract public void updCompanyDetail(CompanyDetailDTO companyDTO);    
    abstract public void delAllCompanyDetails();
    abstract public void delSelectCompanyDetails(ArrayList<Long> companySeqNos, ArrayList<Long> parCompanySeqNos);
    abstract void delSelectCompanyDetailsByParents(ArrayList<Long> ids);

}