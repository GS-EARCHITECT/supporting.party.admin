package enterprise.company_unit_roles.master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_unit_roles.master.model.dto.CompanyUnitRoleMaster_DTO;
import enterprise.company_unit_roles.master.model.master.CompanyUnitRoleMaster;
import enterprise.company_unit_roles.master.model.repo.CompanyUnitRoleMastersAdmin_Repo;

@Service("companyUnitRolesAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitRoleMasterAdmin_Service implements I_CompanyUnitRoleMasterAdmin_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyUnitRoleMasterService.class);

	@Autowired
	private CompanyUnitRoleMastersAdmin_Repo companyUnitRoleMasterAdminRepo;

	public CompanyUnitRoleMaster_DTO newCompanyUnitRole(CompanyUnitRoleMaster_DTO companyRoleDTO) {
		if (!companyUnitRoleMasterAdminRepo.existsById(companyRoleDTO.getRoleSeqNo())) {
			CompanyUnitRoleMaster companyUnitRole = companyUnitRoleMasterAdminRepo
					.save(this.setCompanyUnitRoleMaster(companyRoleDTO));
			companyRoleDTO = getCompanyUnitRoleMaster_DTO(companyUnitRole);
		}
		return companyRoleDTO;
	}

	public ArrayList<CompanyUnitRoleMaster_DTO> getAllCompanyUnitRoles() 
	{
		ArrayList<CompanyUnitRoleMaster> companyList = (ArrayList<CompanyUnitRoleMaster>) companyUnitRoleMasterAdminRepo.findAll();
		ArrayList<CompanyUnitRoleMaster_DTO> companyDTOs = new ArrayList<CompanyUnitRoleMaster_DTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitRoleMasterDtos(companyList) : null;
		return companyDTOs;
	}

	public ArrayList<CompanyUnitRoleMaster_DTO> getSelectCompanyUnitRoles(ArrayList<Long> companySeqNos) {
		ArrayList<CompanyUnitRoleMaster> companyList = (ArrayList<CompanyUnitRoleMaster>) companyUnitRoleMasterAdminRepo
				.findAllById(companySeqNos);
		ArrayList<CompanyUnitRoleMaster_DTO> companyDTOs = new ArrayList<CompanyUnitRoleMaster_DTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitRoleMasterDtos(companyList) : null;
		return companyDTOs;
	}

	public ArrayList<CompanyUnitRoleMaster_DTO> getSelectCompanyUnitRoleMastersForCompanyUnits(ArrayList<Long> ids) {
		ArrayList<CompanyUnitRoleMaster> companyList = companyUnitRoleMasterAdminRepo
				.getSelectCompanyUnitRoleMastersForCompanyUnits(ids);
		ArrayList<CompanyUnitRoleMaster_DTO> companyDTOs = new ArrayList<CompanyUnitRoleMaster_DTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitRoleMasterDtos(companyList) : null;
		return companyDTOs;
	}

	public ArrayList<CompanyUnitRoleMaster_DTO> getSelectCompanyUnitRoleMastersForMasters(ArrayList<Long> ids) {
		ArrayList<CompanyUnitRoleMaster> companyList = companyUnitRoleMasterAdminRepo
				.getSelectCompanyUnitRoleMastersForMasters(ids);
		ArrayList<CompanyUnitRoleMaster_DTO> companyDTOs = new ArrayList<CompanyUnitRoleMaster_DTO>();
		companyDTOs = companyList != null ? this.getCompanyUnitRoleMasterDtos(companyList) : null;
		return companyDTOs;
	}

	public void updCompanyUnitRole(CompanyUnitRoleMaster_DTO companyUnitRoleDTO) {

		CompanyUnitRoleMaster companyUnitRole = this.setCompanyUnitRoleMaster(companyUnitRoleDTO);

		if (companyUnitRoleMasterAdminRepo.existsById(companyUnitRoleDTO.getRoleSeqNo())) {
			companyUnitRole.setRoleSeqNo(companyUnitRoleDTO.getRoleSeqNo());
			companyUnitRoleMasterAdminRepo.save(companyUnitRole);
		}
	}

	public void delCompanyUnitRoleMaster(Long companySeqNo) {
		if (companyUnitRoleMasterAdminRepo.existsById(companySeqNo)) {
			companyUnitRoleMasterAdminRepo.deleteById(companySeqNo);
		}
	}

	public void delAllCompanyUnitRoles() {
		companyUnitRoleMasterAdminRepo.deleteAll();
	}

	public void delSelectCompanyUnitRoles(ArrayList<Long> companySeqNos) {
		companyUnitRoleMasterAdminRepo.deleteAllById(companySeqNos);
		;
	}

	public void delSelectCompanyUnitRoleMastersForCompanyUnits( ArrayList<Long> ids) 
	{
		companyUnitRoleMasterAdminRepo.delSelectCompanyUnitRoleMastersForCompanyUnits(ids);
	}

	public void delSelectCompanyUnitRoleMastersForMasters(ArrayList<Long> ids) {
		companyUnitRoleMasterAdminRepo.delSelectCompanyUnitRoleMastersForMasters(ids);
	}

	private ArrayList<CompanyUnitRoleMaster_DTO> getCompanyUnitRoleMasterDtos(
			ArrayList<CompanyUnitRoleMaster> compUnits) {
		CompanyUnitRoleMaster_DTO companyDTO = null;
		ArrayList<CompanyUnitRoleMaster_DTO> companyDTOs = new ArrayList<CompanyUnitRoleMaster_DTO>();

		for (int i = 0; i < compUnits.size(); i++) {
			companyDTO = this.getCompanyUnitRoleMaster_DTO(compUnits.get(i));
			companyDTOs.add(companyDTO);
		}
		return companyDTOs;
	}

	private CompanyUnitRoleMaster_DTO getCompanyUnitRoleMaster_DTO(CompanyUnitRoleMaster compUnitRole) {
		CompanyUnitRoleMaster_DTO companyDTO = null;
		companyDTO = new CompanyUnitRoleMaster_DTO();
		companyDTO.setRoleSeqNo(compUnitRole.getRoleSeqNo());
		companyDTO.setCompanyUnitSeqNo(compUnitRole.getCompanyUnitSeqNo());
		companyDTO.setMasterRoleSeqNo(compUnitRole.getMasterRoleSeqNo());
		return companyDTO;
	}

	private CompanyUnitRoleMaster setCompanyUnitRoleMaster(CompanyUnitRoleMaster_DTO cDTO) {
		CompanyUnitRoleMaster cUnit = new CompanyUnitRoleMaster();
		cUnit.setCompanyUnitSeqNo(cDTO.getCompanyUnitSeqNo());
		cUnit.setMasterRoleSeqNo(cDTO.getMasterRoleSeqNo());
		return cUnit;
	}

}