package enterprise.company_unit_roles.structure.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.company_unit_roles.structure.model.dto.CompanyUnitFunctionRoleDTO;
import enterprise.company_unit_roles.structure.model.master.CompanyUnitFunctionRole;
import enterprise.company_unit_roles.structure.model.master.CompanyUnitFunctionRolePK;
import enterprise.company_unit_roles.structure.model.repo.CompanyUnitFunctionsRolesRepo;

@Service("companyUnitFunctionsRolesServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitFunctionsRolesService implements I_CompanyUnitFunctionsRolesService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyUnitFunctionRoleService.class);
	
	@Autowired
    private CompanyUnitFunctionsRolesRepo companyUnitFunctionsRolesRepo;
		
	public CompanyUnitFunctionRoleDTO newCompanyUnitFunctionRole(CompanyUnitFunctionRoleDTO companyUnitFunctionsRoleDTO) 
	{
		CompanyUnitFunctionRolePK companyUnitFunctionsRolePK = new CompanyUnitFunctionRolePK();
		companyUnitFunctionsRolePK.setCompanyFunctionSeqNo(companyUnitFunctionsRoleDTO.getCompanyFunctionSeqNo());
		companyUnitFunctionsRolePK.setCompanyRoleSeqNo(companyUnitFunctionsRoleDTO.getCompanyRoleSeqNo());
		
		if(!companyUnitFunctionsRolesRepo.existsById(companyUnitFunctionsRolePK))
		{
		CompanyUnitFunctionRole companyFunctionRole = companyUnitFunctionsRolesRepo.save(this.setCompanyUnitFunctionRole(companyUnitFunctionsRoleDTO));
		companyUnitFunctionsRoleDTO = getCompanyUnitFunctionRoleDTO(companyFunctionRole);
		}
		return companyUnitFunctionsRoleDTO;
	}

	public ArrayList<CompanyUnitFunctionRoleDTO> getAllCompanyUnitFunctionsRoles() 
	{
		ArrayList<CompanyUnitFunctionRole> companyList = (ArrayList<CompanyUnitFunctionRole>) companyUnitFunctionsRolesRepo.findAll();
		ArrayList<CompanyUnitFunctionRoleDTO> companyFunctionRoleDTOs = new ArrayList<CompanyUnitFunctionRoleDTO>();
		companyFunctionRoleDTOs = companyList != null ? this.getCompanyUnitFunctionRoleDtos(companyList) : null;
		return companyFunctionRoleDTOs;
	}

	public ArrayList<CompanyUnitFunctionRoleDTO> getSelectCompanyRolesFunctions(ArrayList<Long> rids, ArrayList<Long> fids) 
	{
		ArrayList<CompanyUnitFunctionRole> companyList = companyUnitFunctionsRolesRepo.getSelectCompanyRolesFunctions(rids, fids);
		ArrayList<CompanyUnitFunctionRoleDTO> companyFunctionRoleDTOs = new ArrayList<CompanyUnitFunctionRoleDTO>();
		companyFunctionRoleDTOs = companyList != null ? this.getCompanyUnitFunctionRoleDtos(companyList) : null;		
		return companyFunctionRoleDTOs;
	}

	public ArrayList<CompanyUnitFunctionRoleDTO> getSelectCompanyRolesByFunctions(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnitFunctionRole> companyList = companyUnitFunctionsRolesRepo.getSelectCompanyRolesByFunctions(ids);
		ArrayList<CompanyUnitFunctionRoleDTO> companyFunctionRoleDTOs = new ArrayList<CompanyUnitFunctionRoleDTO>();
		companyFunctionRoleDTOs = companyList != null ? this.getCompanyUnitFunctionRoleDtos(companyList) : null;		
		return companyFunctionRoleDTOs;
	}
	
	public ArrayList<CompanyUnitFunctionRoleDTO> getSelectCompanyFunctionsByRoles(ArrayList<Long> ids) 
	{
		ArrayList<CompanyUnitFunctionRole> companyList = companyUnitFunctionsRolesRepo.getSelectCompanyFunctionsByRoles(ids);
		ArrayList<CompanyUnitFunctionRoleDTO> companyFunctionRoleDTOs = new ArrayList<CompanyUnitFunctionRoleDTO>();
		companyFunctionRoleDTOs = companyList != null ? this.getCompanyUnitFunctionRoleDtos(companyList) : null;		
		return companyFunctionRoleDTOs;
	}

	public void updCompanyUnitFunctionRole(CompanyUnitFunctionRoleDTO companyUnitFunctionsRoleDTO) 
	{		
		CompanyUnitFunctionRolePK companyUnitFunctionsRolePK = new CompanyUnitFunctionRolePK();
		companyUnitFunctionsRolePK.setCompanyFunctionSeqNo(companyUnitFunctionsRoleDTO.getCompanyFunctionSeqNo());
		companyUnitFunctionsRolePK.setCompanyRoleSeqNo(companyUnitFunctionsRoleDTO.getCompanyRoleSeqNo());
				
		if (companyUnitFunctionsRolesRepo.existsById(companyUnitFunctionsRolePK)) 
		{
			CompanyUnitFunctionRole companyFunctionRole = this.setCompanyUnitFunctionRole(companyUnitFunctionsRoleDTO);			
			companyUnitFunctionsRolesRepo.save(companyFunctionRole);
		}
	}

	public void delAllCompanyUnitFunctionRoles() 
	{
		companyUnitFunctionsRolesRepo.deleteAll();
	}

	public void delSelectCompanyRolesFunctions(ArrayList<Long> rids, ArrayList<Long> fids) 
	{
	companyUnitFunctionsRolesRepo.delSelectCompanyRolesFunctions(rids, fids);		
	}
	
	public void delSelectCompanyRolesByFunctions(ArrayList<Long> ids) 
	{
	companyUnitFunctionsRolesRepo.delSelectCompanyRolesByFunctions(ids);		
	}
	
	public void delSelectCompanyFunctionsByRoles(ArrayList<Long> ids) 
	{
	companyUnitFunctionsRolesRepo.delSelectCompanyFunctionsByRoles(ids);		
	}

	private ArrayList<CompanyUnitFunctionRoleDTO> getCompanyUnitFunctionRoleDtos(ArrayList<CompanyUnitFunctionRole> compRoles) {
		CompanyUnitFunctionRoleDTO companyFunctionRoleDTO = null;
		ArrayList<CompanyUnitFunctionRoleDTO> companyFunctionRoleDTOs = new ArrayList<CompanyUnitFunctionRoleDTO>();

		for (int i = 0; i < compRoles.size(); i++) {
			companyFunctionRoleDTO = this.getCompanyUnitFunctionRoleDTO(compRoles.get(i));			
			companyFunctionRoleDTOs.add(companyFunctionRoleDTO);
		}
		return companyFunctionRoleDTOs;
	}

	private CompanyUnitFunctionRoleDTO getCompanyUnitFunctionRoleDTO(CompanyUnitFunctionRole compuCompanyUnitFunctionRole) 
	{
		CompanyUnitFunctionRoleDTO companyUnitFunctionsRoleDTO = null;
		companyUnitFunctionsRoleDTO = new CompanyUnitFunctionRoleDTO();
		companyUnitFunctionsRoleDTO.setRemark(compuCompanyUnitFunctionRole.getRemark());
		companyUnitFunctionsRoleDTO.setStatus(compuCompanyUnitFunctionRole.getStatus());
		companyUnitFunctionsRoleDTO.setCompanyFunctionSeqNo(compuCompanyUnitFunctionRole.getId().getCompanyFunctionSeqNo());
		companyUnitFunctionsRoleDTO.setCompanyRoleSeqNo(compuCompanyUnitFunctionRole.getId().getCompanyRoleSeqNo());
		return companyUnitFunctionsRoleDTO;
	}

	private CompanyUnitFunctionRole setCompanyUnitFunctionRole(CompanyUnitFunctionRoleDTO cDTO) 
	{
		CompanyUnitFunctionRolePK companyUnitFunctionsRolePK = new CompanyUnitFunctionRolePK();
		companyUnitFunctionsRolePK.setCompanyFunctionSeqNo(cDTO.getCompanyFunctionSeqNo());
		companyUnitFunctionsRolePK.setCompanyRoleSeqNo(cDTO.getCompanyRoleSeqNo());			
		CompanyUnitFunctionRole cfRole = new CompanyUnitFunctionRole();
		cfRole.setId(companyUnitFunctionsRolePK);
		cfRole.setRemark(cDTO.getRemark());
		cfRole.setStatus(cDTO.getStatus());
		return cfRole;
	}
	
}