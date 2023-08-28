package enterprise.roles.services;

import java.util.ArrayList;

import enterprise.roles.model.dto.CompanyRoleDTO;

public interface I_CompanyRoleService 
{
	public CompanyRoleDTO newRole(CompanyRoleDTO roleDTO);
	public ArrayList<CompanyRoleDTO> getAllRoles();
	public ArrayList<CompanyRoleDTO> getSelectRoles(ArrayList<Long> roleSeqNos);
	public void updRole(CompanyRoleDTO roleDTO);	
	public void delAllRoles();
	public void delSelectRoles(ArrayList<Long> roleSeqNos);
}