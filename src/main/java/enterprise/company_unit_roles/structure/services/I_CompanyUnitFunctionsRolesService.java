package enterprise.company_unit_roles.structure.services;

import java.util.ArrayList;

import enterprise.company_unit_roles.structure.model.dto.CompanyUnitFunctionRoleDTO;

public interface I_CompanyUnitFunctionsRolesService
{
    abstract public CompanyUnitFunctionRoleDTO newCompanyUnitFunctionRole(CompanyUnitFunctionRoleDTO companyUnitFunctionRoleRoleDTO);
    abstract public ArrayList<CompanyUnitFunctionRoleDTO> getAllCompanyUnitFunctionsRoles();
    abstract public ArrayList<CompanyUnitFunctionRoleDTO> getSelectCompanyRolesFunctions(ArrayList<Long> rids, ArrayList<Long> fids);
    abstract public ArrayList<CompanyUnitFunctionRoleDTO> getSelectCompanyRolesByFunctions(ArrayList<Long> ids);
    abstract public ArrayList<CompanyUnitFunctionRoleDTO> getSelectCompanyFunctionsByRoles(ArrayList<Long> ids);	    
    abstract public void updCompanyUnitFunctionRole(CompanyUnitFunctionRoleDTO companyUnitFunctionsRoleDTO);    
    abstract public void delAllCompanyUnitFunctionRoles();
    abstract public void delSelectCompanyRolesFunctions(ArrayList<Long> rids, ArrayList<Long> fids);
    abstract public void delSelectCompanyRolesByFunctions(ArrayList<Long> ids);
    abstract public void delSelectCompanyFunctionsByRoles(ArrayList<Long> ids);
}