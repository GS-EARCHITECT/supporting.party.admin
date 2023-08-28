package enterprise.roles.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.roles.model.dto.CompanyRoleDTO;
import enterprise.roles.model.master.CompanyRole;
import enterprise.roles.model.repo.CompanyRoleRepo;

@Service("roleServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyRoleService implements I_CompanyRoleService 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyRoleService.class);

	@Autowired
	private CompanyRoleRepo roleRepo;

	public CompanyRoleDTO newRole(CompanyRoleDTO cDTO) {
		if (!roleRepo.existsById(cDTO.getRoleSeqNo())) {
			CompanyRole roleMaster = roleRepo.save(this.setCompanyRole(cDTO));
			cDTO = getCompanyRoleDTO(roleMaster);
		}
		return cDTO;
	}

	public ArrayList<CompanyRoleDTO> getAllRoles() {
		ArrayList<CompanyRole> roleList = (ArrayList<CompanyRole>) roleRepo.findAll();
		ArrayList<CompanyRoleDTO> cDTOs = new ArrayList<CompanyRoleDTO>();
		cDTOs = roleList != null ? this.getCompanyRoleDtos(roleList) : null;
		return cDTOs;
	}

	public ArrayList<CompanyRoleDTO> getSelectRoles(ArrayList<Long> roleSeqNos) {
		ArrayList<CompanyRoleDTO> cDTOs = new ArrayList<CompanyRoleDTO>();
		CompanyRoleDTO roleMasterDTO = null;
		ArrayList<CompanyRole> roleMasters = (ArrayList<CompanyRole>) roleRepo.findAll();
		cDTOs = roleMasters != null ? this.getCompanyRoleDtos(roleMasters) : null;
		return cDTOs;
	}

	public void updRole(CompanyRoleDTO cDTO) {
		if (roleRepo.existsById(cDTO.getRoleSeqNo())) {
			roleRepo.save(this.setCompanyRole(cDTO));
		}
		return;
	}

	public void delAllRoles() {
		roleRepo.deleteAll();
	}

	public void delSelectRoles(ArrayList<Long> roleSeqNos) 
	{
		roleRepo.delSelectRoles(roleSeqNos);

	}

	private ArrayList<CompanyRoleDTO> getCompanyRoleDtos(ArrayList<CompanyRole> cMasters) {
		CompanyRoleDTO cDTO = null;
		ArrayList<CompanyRoleDTO> cDTOs = new ArrayList<CompanyRoleDTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getCompanyRoleDTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private CompanyRoleDTO getCompanyRoleDTO(CompanyRole cMaster) {
		CompanyRoleDTO cDTO = null;
		cDTO = new CompanyRoleDTO();
		cDTO.setRoleSeqNo(cMaster.getRoleSeqNo());
		cDTO.setRole(cMaster.getRole());		
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setStatus(cMaster.getStatus());
		return cDTO;
	}

	private CompanyRole setCompanyRole(CompanyRoleDTO cDTO) {
		CompanyRole cMaster = new CompanyRole();
		cMaster.setRole(cDTO.getRole());
		cMaster.setRemark(cMaster.getRemark());
		cMaster.setStatus(cMaster.getStatus());
		return cMaster;
	}

}