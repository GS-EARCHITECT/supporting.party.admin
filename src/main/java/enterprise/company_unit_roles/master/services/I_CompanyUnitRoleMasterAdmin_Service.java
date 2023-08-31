package enterprise.company_unit_roles.master.services;

import java.util.ArrayList;
import enterprise.company_unit_roles.master.model.dto.CompanyUnitRoleMaster_DTO;

public interface I_CompanyUnitRoleMasterAdmin_Service
{
    public CompanyUnitRoleMaster_DTO newCompanyUnitRole(CompanyUnitRoleMaster_DTO companyUnitRoleDTO);
    public ArrayList<CompanyUnitRoleMaster_DTO> getAllCompanyUnitRoles();
    public ArrayList<CompanyUnitRoleMaster_DTO> getSelectCompanyUnitRoles(ArrayList<Long> ids);
    public ArrayList<CompanyUnitRoleMaster_DTO> getSelectCompanyUnitRoleMastersForCompanyUnits( ArrayList<Long> ids);
    public ArrayList<CompanyUnitRoleMaster_DTO> getSelectCompanyUnitRoleMastersForMasters( ArrayList<Long> ids);
    public void updCompanyUnitRole(CompanyUnitRoleMaster_DTO companyUnitRoleDTO);
    public void delAllCompanyUnitRoles();
    public void delSelectCompanyUnitRoles(ArrayList<Long> ids);
    public void delSelectCompanyUnitRoleMastersForCompanyUnits( ArrayList<Long> ids);
    public void delSelectCompanyUnitRoleMastersForMasters( ArrayList<Long> ids);

}