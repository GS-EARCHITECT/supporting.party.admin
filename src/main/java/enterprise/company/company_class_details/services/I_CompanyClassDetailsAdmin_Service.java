package enterprise.company.company_class_details.services;

import java.util.ArrayList;
import enterprise.company.company_class_details.model.dto.CompanyClassDetail_DTO;
import enterprise.company.company_class_details.model.master.CompanyClassDetailPK;

public interface I_CompanyClassDetailsAdmin_Service
{
    public CompanyClassDetail_DTO newCompanyClassDetail(CompanyClassDetail_DTO companyDetailDTO);
    public ArrayList<CompanyClassDetail_DTO> getAllCompanyClassDetails();
    public ArrayList<CompanyClassDetail_DTO> getSelectCompanyClassDetailsByClasses(ArrayList<Long> ids);
    public ArrayList<CompanyClassDetail_DTO> getSelectCompanyClassDetails(ArrayList<CompanyClassDetailPK> companyClassDetailPKs);
    public ArrayList<CompanyClassDetail_DTO> getSelectCompanyClassDetailsByCompanies(ArrayList<Long> ids);
    public void updCompanyClassDetail(CompanyClassDetail_DTO companyDTO);    
    public void delAllCompanyClassDetails();
    public void delSelectCompanyClassDetails(ArrayList<CompanyClassDetailPK> companyClassDetailPKs);    
    public void delSelectCompanyClassDetailsByClasses(ArrayList<Long> ids);
    public void delSelectCompanyClassDetailsByCompanies(ArrayList<Long> ids);

}