package enterprise.company.company_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.company.company_master.model.dto.CompanyMasterDTO;
import enterprise.company.company_master.model.master.CompanyMaster;
import enterprise.company.company_master.model.repo.CompanyMasterRepo;

@Service("companyMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyMasterService implements I_CompanyMasterService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyMasterService.class);
	
	@Autowired
    private CompanyMasterRepo companyRepo;
		
	public CompanyMasterDTO newCompany(CompanyMasterDTO companyDTO) 
	{
		if(!companyRepo.existsById(companyDTO.getCompanySeqNo()))
		{
		CompanyMaster companyMaster = companyRepo.save(this.setCompanyMaster(companyDTO));
		companyDTO = getCompanyMasterDTO(companyMaster);
		}
		return companyDTO;
	}

	public ArrayList<CompanyMasterDTO> getAllCompanies() 
	{
		ArrayList<CompanyMaster> companyList = (ArrayList<CompanyMaster>) companyRepo.findAll();
		ArrayList<CompanyMasterDTO> companyDTOs = new ArrayList<CompanyMasterDTO>();
		companyDTOs = companyList != null ? this.getCompanyMasterDtos(companyList) : null;
		return companyDTOs;
	}

	public ArrayList<CompanyMasterDTO> getSelectCompanies(ArrayList<Long> companySeqNos) 
	{
		ArrayList<CompanyMaster> companyList = companyRepo.getSelectCompanies(companySeqNos);
		ArrayList<CompanyMasterDTO> companyDTOs = new ArrayList<CompanyMasterDTO>();
		CompanyMasterDTO companyMasterDTO = null;

		for (int i = 0; i < companySeqNos.size(); i++) 
		{
			companyMasterDTO = this.getCompanyMasterDTO(companyList.get(i));			
			companyDTOs.add(companyMasterDTO);
		}
		
		return companyDTOs;
	}

	public ArrayList<CompanyMasterDTO> getSelectCompaniesForParties(ArrayList<Long> ids) 
	{
		ArrayList<CompanyMaster> companyList = companyRepo.getSelectCompanies(ids);
		ArrayList<CompanyMasterDTO> companyDTOs = new ArrayList<CompanyMasterDTO>();
		CompanyMasterDTO companyMasterDTO = null;

		for (int i = 0; i < companyList.size(); i++) 
		{
			companyMasterDTO = this.getCompanyMasterDTO(companyList.get(i));			
			companyDTOs.add(companyMasterDTO);
		}
		
		return companyDTOs;
	}
	

	public void updCompany(CompanyMasterDTO companyDTO) {

		CompanyMaster companyMaster = this.setCompanyMaster(companyDTO);
		if (companyRepo.existsById(companyDTO.getCompanySeqNo())) {
			companyMaster.setCompanySeqNo(companyDTO.getCompanySeqNo());
			companyRepo.save(companyMaster);
		}
	}

	public void delCompany(Long companySeqNo) {
		if (companyRepo.existsById(companySeqNo)) {
			companyRepo.deleteById(companySeqNo);
		}
	}
	
	public void delAllCompanies() {
		companyRepo.deleteAll();
	}

	public void delSelectCompanies(ArrayList<Long> companySeqNos) 
	{
	companyRepo.delSelectCompanies(companySeqNos);		
	}
	
	public void delSelectCompaniesForParties(ArrayList<Long> ids) 
	{
	companyRepo.delSelectCompaniesForParties(ids);		
	}

	private ArrayList<CompanyMasterDTO> getCompanyMasterDtos(ArrayList<CompanyMaster> compMasters) {
		CompanyMasterDTO companyDTO = null;
		ArrayList<CompanyMasterDTO> companyDTOs = new ArrayList<CompanyMasterDTO>();

		for (int i = 0; i < compMasters.size(); i++) {
			companyDTO = this.getCompanyMasterDTO(compMasters.get(i));			
			companyDTOs.add(companyDTO);
		}
		return companyDTOs;
	}

	private CompanyMasterDTO getCompanyMasterDTO(CompanyMaster compMaster) 
	{
		CompanyMasterDTO companyDTO = null;
		companyDTO = new CompanyMasterDTO();
		companyDTO.setPartySeqNo(compMaster.getPartySeqNo());
		companyDTO.setCompanySeqNo(compMaster.getCompanySeqNo());
		companyDTO.setCompany(compMaster.getCompany());
		companyDTO.setCompanyId(compMaster.getCompanyId());
		companyDTO.setRemark(compMaster.getRemark());
		companyDTO.setStatus(compMaster.getStatus());
		companyDTO.setDescription(compMaster.getDescription());
		return companyDTO;
	}

	private CompanyMaster setCompanyMaster(CompanyMasterDTO cDTO) {
		CompanyMaster cMaster = new CompanyMaster();		
		cMaster.setPartySeqNo(cDTO.getPartySeqNo());
		cMaster.setCompany(cDTO.getCompany());
		cMaster.setCompanyId(cDTO.getCompanyId());
		cMaster.setRemark(cDTO.getRemark());
		cMaster.setStatus(cDTO.getStatus());
		cMaster.setDescription(cDTO.getDescription());
		return cMaster;
	}
	
}