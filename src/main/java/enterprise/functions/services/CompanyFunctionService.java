package enterprise.functions.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.functions.model.dto.CompanyFunctionDTO;
import enterprise.functions.model.master.CompanyFunction;
import enterprise.functions.model.repo.CompanyFunctionRepo;

@Service("functionServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyFunctionService implements I_CompanyFunctionService {
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyFunctionService.class);

	@Autowired
	private CompanyFunctionRepo functionRepo;

	public CompanyFunctionDTO newFunction(CompanyFunctionDTO cDTO) {
		if (!functionRepo.existsById(cDTO.getFunctionSeqNo())) {
			CompanyFunction functionMaster = functionRepo.save(this.setCompanyFunction(cDTO));
			cDTO = getCompanyFunctionDTO(functionMaster);
		}
		return cDTO;
	}

	public ArrayList<CompanyFunctionDTO> getAllFunctions() {
		ArrayList<CompanyFunction> functionList = (ArrayList<CompanyFunction>) functionRepo.findAll();
		ArrayList<CompanyFunctionDTO> cDTOs = new ArrayList<CompanyFunctionDTO>();
		cDTOs = functionList != null ? this.getCompanyFunctionDtos(functionList) : null;
		return cDTOs;
	}

	public ArrayList<CompanyFunctionDTO> getSelectFunctions(ArrayList<Long> functionSeqNos) {
		ArrayList<CompanyFunctionDTO> cDTOs = new ArrayList<CompanyFunctionDTO>();
		CompanyFunctionDTO functionMasterDTO = null;
		ArrayList<CompanyFunction> functionMasters = (ArrayList<CompanyFunction>) functionRepo.findAll();
		cDTOs = functionMasters != null ? this.getCompanyFunctionDtos(functionMasters) : null;
		return cDTOs;
	}

	public void updFunction(CompanyFunctionDTO cDTO) {
		if (functionRepo.existsById(cDTO.getFunctionSeqNo())) {
			functionRepo.save(this.setCompanyFunction(cDTO));
		}
		return;
	}

	public void delAllFunctions() {
		functionRepo.deleteAll();
	}

	public void delSelectFunctions(ArrayList<Long> functionSeqNos) 
	{
		functionRepo.delSelectFunctions(functionSeqNos);

	}

	private ArrayList<CompanyFunctionDTO> getCompanyFunctionDtos(ArrayList<CompanyFunction> cMasters) {
		CompanyFunctionDTO cDTO = null;
		ArrayList<CompanyFunctionDTO> cDTOs = new ArrayList<CompanyFunctionDTO>();

		for (int i = 0; i < cMasters.size(); i++) 
		{
			cDTO = this.getCompanyFunctionDTO(cMasters.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private CompanyFunctionDTO getCompanyFunctionDTO(CompanyFunction cMaster) {
		CompanyFunctionDTO cDTO = null;
		cDTO = new CompanyFunctionDTO();
		cDTO.setFunctionSeqNo(cMaster.getFunctionSeqNo());
		cDTO.setFunction(cMaster.getFunction());		
		cDTO.setRemark(cMaster.getRemark());
		cDTO.setStatus(cMaster.getStatus());
		return cDTO;
	}

	private CompanyFunction setCompanyFunction(CompanyFunctionDTO cDTO) {
		CompanyFunction cMaster = new CompanyFunction();
		cMaster.setFunction(cDTO.getFunction());
		cMaster.setRemark(cMaster.getRemark());
		cMaster.setStatus(cMaster.getStatus());
		return cMaster;
	}

}