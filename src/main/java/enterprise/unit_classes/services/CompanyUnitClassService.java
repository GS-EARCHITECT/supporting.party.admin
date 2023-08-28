package enterprise.unit_classes.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.unit_classes.model.dto.CompanyUnitClassDTO;
import enterprise.unit_classes.model.master.CompanyUnitClass;
import enterprise.unit_classes.model.repo.CompanyUnitClassRepo;

@Service("companyUnitServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitClassService implements I_CompanyUnitClassService 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyUnitClassService.class);

	@Autowired
	private CompanyUnitClassRepo companyUnitClassRepo;

	public CompanyUnitClassDTO newCompanyUnitClass(CompanyUnitClassDTO cDTO) {
		if (!companyUnitClassRepo.existsById(cDTO.getUnitClassSeqNo())) {
			CompanyUnitClass companyUnitClass = companyUnitClassRepo.save(this.setCompanyUnitClass(cDTO));
			cDTO = getCompanyUnitClassDTO(companyUnitClass);
		}
		return cDTO;
	}

	public ArrayList<CompanyUnitClassDTO> getAllCompanyUnitClasses() {
		ArrayList<CompanyUnitClass> companyUnitList = (ArrayList<CompanyUnitClass>) companyUnitClassRepo.findAll();
		ArrayList<CompanyUnitClassDTO> cDTOs = new ArrayList<CompanyUnitClassDTO>();
		cDTOs = companyUnitList != null ? this.getCompanyUnitClassDtos(companyUnitList) : null;
		return cDTOs;
	}

	public ArrayList<CompanyUnitClassDTO> getSelectCompanyUnitClasses(ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitClassDTO> cDTOs = new ArrayList<CompanyUnitClassDTO>();
		CompanyUnitClassDTO companyUnitClassDTO = null;
		ArrayList<CompanyUnitClass> companyUnitClasss = (ArrayList<CompanyUnitClass>) companyUnitClassRepo.findAll();
		cDTOs = companyUnitClasss != null ? this.getCompanyUnitClassDtos(companyUnitClasss) : null;
		return cDTOs;
	}

	public void updCompanyUnitClass(CompanyUnitClassDTO cDTO) 
	{
		if (companyUnitClassRepo.existsById(cDTO.getUnitClassSeqNo())) {
			companyUnitClassRepo.save(this.setCompanyUnitClass(cDTO));
		}
		return;
	}

	public void delAllCompanyUnitClasses() 
	{
		companyUnitClassRepo.deleteAll();
	}

	public void delSelectCompanyUnitClasses(ArrayList<Long> companyUnitSeqNos) 
	{
		companyUnitClassRepo.delSelectCompanyUnitClasses(companyUnitSeqNos);

	}

	private ArrayList<CompanyUnitClassDTO> getCompanyUnitClassDtos(ArrayList<CompanyUnitClass> cClasss) {
		CompanyUnitClassDTO cDTO = null;
		ArrayList<CompanyUnitClassDTO> cDTOs = new ArrayList<CompanyUnitClassDTO>();

		for (int i = 0; i < cClasss.size(); i++) 
		{
			cDTO = this.getCompanyUnitClassDTO(cClasss.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private CompanyUnitClassDTO getCompanyUnitClassDTO(CompanyUnitClass cClass) {
		CompanyUnitClassDTO cDTO = null;
		cDTO = new CompanyUnitClassDTO();
		cDTO.setUnitClassSeqNo(cClass.getUnitClassSeqNo());
		cDTO.setUnitclass(cClass.getUnitclass());		
		cDTO.setRemark(cClass.getRemark());
		cDTO.setStatus(cClass.getStatus());
		return cDTO;
	}

	private CompanyUnitClass setCompanyUnitClass(CompanyUnitClassDTO cDTO) {
		CompanyUnitClass cClass = new CompanyUnitClass();
		cClass.setUnitclass(cDTO.getUnitclass());
		cClass.setRemark(cClass.getRemark());
		cClass.setStatus(cClass.getStatus());
		return cClass;
	}

}