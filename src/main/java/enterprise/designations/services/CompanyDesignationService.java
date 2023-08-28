package enterprise.designations.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.designations.model.dto.CompanyDesignationDTO;
import enterprise.designations.model.master.CompanyDesignation;
import enterprise.designations.model.repo.CompanyDesignationRepo;

@Service("designationServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyDesignationService implements I_CompanyDesignationService {
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyDesignationService.class);

	@Autowired
	private CompanyDesignationRepo designationRepo;

	public CompanyDesignationDTO newDesignation(CompanyDesignationDTO cDTO) {
		if (!designationRepo.existsById(cDTO.getDesignationSeqNo())) {
			CompanyDesignation designationMaster = designationRepo.save(this.setCompanyDesignation(cDTO));
			cDTO = getCompanyDesignationDTO(designationMaster);
		}
		return cDTO;
	}

	public ArrayList<CompanyDesignationDTO> getAllDesignations() {
		ArrayList<CompanyDesignation> designationList = (ArrayList<CompanyDesignation>) designationRepo.findAll();
		ArrayList<CompanyDesignationDTO> cDTOs = new ArrayList<CompanyDesignationDTO>();
		cDTOs = designationList != null ? this.getCompanyDesignationDtos(designationList) : null;
		return cDTOs;
	}

	public ArrayList<CompanyDesignationDTO> getSelectDesignations(ArrayList<Long> designationSeqNos) {
		ArrayList<CompanyDesignationDTO> cDTOs = new ArrayList<CompanyDesignationDTO>();
		CompanyDesignationDTO designationMasterDTO = null;
		ArrayList<CompanyDesignation> designationMasters = (ArrayList<CompanyDesignation>) designationRepo.findAll();
		cDTOs = designationMasters != null ? this.getCompanyDesignationDtos(designationMasters) : null;
		return cDTOs;
	}

	public void updDesignation(CompanyDesignationDTO cDTO) {
		if (designationRepo.existsById(cDTO.getDesignationSeqNo())) {
			designationRepo.save(this.setCompanyDesignation(cDTO));
		}
		return;
	}

	public void delAllDesignations() {
		designationRepo.deleteAll();
	}

	public void delSelectDesignations(ArrayList<Long> designationSeqNos) 
	{
		designationRepo.delSelectDesignations(designationSeqNos);

	}

	private ArrayList<CompanyDesignationDTO> getCompanyDesignationDtos(ArrayList<CompanyDesignation> cMasters) {
		CompanyDesignationDTO cDTO = null;
		ArrayList<CompanyDesignationDTO> cDTOs = new ArrayList<CompanyDesignationDTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getCompanyDesignationDTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private CompanyDesignationDTO getCompanyDesignationDTO(CompanyDesignation cMaster) {
		CompanyDesignationDTO cDTO = null;
		cDTO = new CompanyDesignationDTO();
		cDTO.setDesignationSeqNo(cMaster.getDesignationSeqNo());
		cDTO.setDesignation(cMaster.getDesignation());		
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setStatus(cMaster.getStatus());
		return cDTO;
	}

	private CompanyDesignation setCompanyDesignation(CompanyDesignationDTO cDTO) {
		CompanyDesignation cMaster = new CompanyDesignation();
		cMaster.setDesignation(cDTO.getDesignation());
		cMaster.setRemark(cMaster.getRemark());
		cMaster.setStatus(cMaster.getStatus());
		return cMaster;
	}

}