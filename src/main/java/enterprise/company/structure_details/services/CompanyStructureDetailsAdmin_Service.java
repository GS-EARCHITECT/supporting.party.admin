package enterprise.company.structure_details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company.structure_details.model.dto.CompanyStructureDetail_DTO;
import enterprise.company.structure_details.model.master.CompanyStructureDetail;
import enterprise.company.structure_details.model.master.CompanyStructureDetailPK;
import enterprise.company.structure_details.model.repo.CompanyStructureDetailsAdmin_Repo;

@Service("companyStructureDetailsAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyStructureDetailsAdmin_Service implements I_CompanyStructureDetailsAdmin_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyStructureDetailService.class);
	
	@Autowired
    private CompanyStructureDetailsAdmin_Repo companyStructureDetailsAdminRepo;
		
	public CompanyStructureDetail_DTO newCompanyStructureDetail(CompanyStructureDetail_DTO companyDetailDTO) 
	{
		CompanyStructureDetailPK companyDetailPK = new CompanyStructureDetailPK();
		companyDetailPK.setCompanySeqNo(companyDetailDTO.getCompanySeqNo());
		companyDetailPK.setParCompanySeqNo(companyDetailDTO.getParCompanySeqNo());
		
		if(!companyStructureDetailsAdminRepo.existsById(companyDetailPK))
		{
		CompanyStructureDetail companyDetail = companyStructureDetailsAdminRepo.save(this.setCompanyStructureDetail(companyDetailDTO));
		companyDetailDTO = getCompanyStructureDetail_DTO(companyDetail);
		}
		return companyDetailDTO;
	}

	public ArrayList<CompanyStructureDetail_DTO> getAllCompanyStructureDetails() 
	{
		ArrayList<CompanyStructureDetail> companyList = (ArrayList<CompanyStructureDetail>) companyStructureDetailsAdminRepo.findAll();
		ArrayList<CompanyStructureDetail_DTO> companyDetailDTOs = new ArrayList<CompanyStructureDetail_DTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyStructureDetailDtos(companyList) : null;
		return companyDetailDTOs;
	}

	public ArrayList<CompanyStructureDetail_DTO> getSelectCompanyStructureDetails(ArrayList<CompanyStructureDetailPK> companyStructureDetailPKs) 
	{
		ArrayList<CompanyStructureDetail> companyList = (ArrayList<CompanyStructureDetail>) companyStructureDetailsAdminRepo.findAllById(companyStructureDetailPKs);
		ArrayList<CompanyStructureDetail_DTO> companyDetailDTOs = new ArrayList<CompanyStructureDetail_DTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyStructureDetailDtos(companyList) : null;
		return companyDetailDTOs;
	}

	public void updCompanyStructureDetail(CompanyStructureDetail_DTO companyDetailDTO) 
	{		
		CompanyStructureDetailPK companyDetailPK = new CompanyStructureDetailPK();
		companyDetailPK.setCompanySeqNo(companyDetailDTO.getCompanySeqNo());
		companyDetailPK.setCompanyClassSeqNo(companyDetailDTO.getCompanyClassSeqNo());
		companyDetailPK.setParCompanyClassSeqNo(companyDetailDTO.getParCompanyClassSeqNo());
		companyDetailPK.setParCompanySeqNo(companyDetailDTO.getParCompanySeqNo());
		companyDetailPK.setParCompanySeqNo(companyDetailDTO.getParCompanySeqNo());
		
		if (companyStructureDetailsAdminRepo.existsById(companyDetailPK)) 
		{
			CompanyStructureDetail companyDetail = this.setCompanyStructureDetail(companyDetailDTO);			
			companyStructureDetailsAdminRepo.save(companyDetail);
		}
	}

	public void delAllCompanyStructureDetails() 
	{
		companyStructureDetailsAdminRepo.deleteAll();
	}

	public void delSelectCompanyStructureDetails(ArrayList<CompanyStructureDetailPK> companyStructureDetailPKs) 
	{
	companyStructureDetailsAdminRepo.deleteAllById(companyStructureDetailPKs);		
	}
	
	private ArrayList<CompanyStructureDetail_DTO> getCompanyStructureDetailDtos(ArrayList<CompanyStructureDetail> compDetails) {
		CompanyStructureDetail_DTO companyDetailDTO = null;
		ArrayList<CompanyStructureDetail_DTO> companyDetailDTOs = new ArrayList<CompanyStructureDetail_DTO>();

		for (int i = 0; i < compDetails.size(); i++) {
			companyDetailDTO = this.getCompanyStructureDetail_DTO(compDetails.get(i));			
			companyDetailDTOs.add(companyDetailDTO);
		}
		return companyDetailDTOs;
	}

	private CompanyStructureDetail_DTO getCompanyStructureDetail_DTO(CompanyStructureDetail compDetail) 
	{
		CompanyStructureDetail_DTO companyDetailDTO = null;
		companyDetailDTO = new CompanyStructureDetail_DTO();
		companyDetailDTO.setCompanySeqNo(compDetail.getId().getCompanySeqNo());
		companyDetailDTO.setParCompanySeqNo(compDetail.getId().getParCompanySeqNo());		
		return companyDetailDTO;
	}

	private CompanyStructureDetail setCompanyStructureDetail(CompanyStructureDetail_DTO cDTO) 
	{
		CompanyStructureDetailPK companyDetailPK = new CompanyStructureDetailPK();
		companyDetailPK.setCompanySeqNo(cDTO.getCompanySeqNo());
		companyDetailPK.setCompanyClassSeqNo(cDTO.getCompanyClassSeqNo());
		companyDetailPK.setParCompanyClassSeqNo(cDTO.getParCompanyClassSeqNo());
		companyDetailPK.setParCompanySeqNo(cDTO.getParCompanySeqNo());
		companyDetailPK.setParCompanySeqNo(cDTO.getParCompanySeqNo());
		CompanyStructureDetail cDetail = new CompanyStructureDetail();		
		cDetail.setId(companyDetailPK);
		return cDetail;
	}
	
}