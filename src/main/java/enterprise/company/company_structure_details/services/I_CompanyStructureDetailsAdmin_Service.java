package enterprise.company.company_structure_details.services;

import java.util.ArrayList;

import enterprise.company.company_structure_details.model.dto.CompanyStructureDetail_DTO;
import enterprise.company.company_structure_details.model.master.CompanyStructureDetailPK;

public interface I_CompanyStructureDetailsAdmin_Service
{
    public CompanyStructureDetail_DTO newCompanyStructureDetail(CompanyStructureDetail_DTO companyDetailDTO);
    public ArrayList<CompanyStructureDetail_DTO> getAllCompanyStructureDetails(); 
    public ArrayList<CompanyStructureDetail_DTO> getSelectCompanyStructureDetails(ArrayList<CompanyStructureDetailPK> companyStructureDetailPKs);
    public void updCompanyStructureDetail(CompanyStructureDetail_DTO companyDTO);    
    public void delAllCompanyStructureDetails();
    public void delSelectCompanyStructureDetails(ArrayList<CompanyStructureDetailPK> companyStructureDetailPKs);    
}