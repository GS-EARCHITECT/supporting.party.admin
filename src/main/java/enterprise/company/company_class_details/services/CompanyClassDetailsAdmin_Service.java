package enterprise.company.company_class_details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company.company_class_details.model.dto.CompanyClassDetail_DTO;
import enterprise.company.company_class_details.model.master.CompanyClassDetail;
import enterprise.company.company_class_details.model.master.CompanyClassDetailPK;
import enterprise.company.company_class_details.model.repo.CompanyClassDetailsAdmin_Repo;

@Service("companyClassDetailAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyClassDetailsAdmin_Service implements I_CompanyClassDetailsAdmin_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyClassDetailService.class);
	
	@Autowired
    private CompanyClassDetailsAdmin_Repo companyClassDetailsAdminRepo;
		
	public CompanyClassDetail_DTO newCompanyClassDetail(CompanyClassDetail_DTO companyDetailDTO) 
	{
		CompanyClassDetailPK companyClassDetailPK = new CompanyClassDetailPK();
		companyClassDetailPK.setCompanySeqNo(companyDetailDTO.getCompanySeqNo());
		companyClassDetailPK.setCompanyClassSeqNo(companyDetailDTO.getCompanyClassSeqNo());
		
		if(!companyClassDetailsAdminRepo.existsById(companyClassDetailPK))
		{
		CompanyClassDetail companyDetail = companyClassDetailsAdminRepo.save(this.setCompanyClassDetail(companyDetailDTO));
		companyDetailDTO = getCompanyClassDetail_DTO(companyDetail);
		}
		return companyDetailDTO;
	}

	public ArrayList<CompanyClassDetail_DTO> getAllCompanyClassDetails() 
	{
		ArrayList<CompanyClassDetail> companyList = (ArrayList<CompanyClassDetail>) companyClassDetailsAdminRepo.findAll();
		ArrayList<CompanyClassDetail_DTO> companyDetailDTOs = new ArrayList<CompanyClassDetail_DTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyClassDetailDtos(companyList) : null;
		return companyDetailDTOs;
	}

	public ArrayList<CompanyClassDetail_DTO> getSelectCompanyClassDetails(ArrayList<CompanyClassDetailPK> classDetailPKs) 
	{
		ArrayList<CompanyClassDetail> companyList = (ArrayList<CompanyClassDetail>) companyClassDetailsAdminRepo.findAllById(classDetailPKs);
		ArrayList<CompanyClassDetail_DTO> companyDetailDTOs = new ArrayList<CompanyClassDetail_DTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyClassDetailDtos(companyList) : null;		
		return companyDetailDTOs;
	}

	public ArrayList<CompanyClassDetail_DTO> getSelectCompanyClassDetailsByClasses(ArrayList<Long> ids) 
	{
		ArrayList<CompanyClassDetail> companyList = companyClassDetailsAdminRepo.getSelectCompanyClassDetailsByClasses(ids);
		ArrayList<CompanyClassDetail_DTO> companyDetailDTOs = new ArrayList<CompanyClassDetail_DTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyClassDetailDtos(companyList) : null;		
		return companyDetailDTOs;
	}
	
	public ArrayList<CompanyClassDetail_DTO> getSelectCompanyClassDetailsByCompanies(ArrayList<Long> ids) 
	{
		ArrayList<CompanyClassDetail> companyList = companyClassDetailsAdminRepo.getSelectCompanyClassDetailsByCompanies(ids);
		ArrayList<CompanyClassDetail_DTO> companyDetailDTOs = new ArrayList<CompanyClassDetail_DTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyClassDetailDtos(companyList) : null;		
		return companyDetailDTOs;
	}
	

	public void updCompanyClassDetail(CompanyClassDetail_DTO companyDetailDTO) 
	{		
		CompanyClassDetailPK companyClassDetailPK = new CompanyClassDetailPK();
		companyClassDetailPK.setCompanySeqNo(companyDetailDTO.getCompanySeqNo());
		companyClassDetailPK.setCompanyClassSeqNo(companyDetailDTO.getCompanyClassSeqNo());
		
		if (companyClassDetailsAdminRepo.existsById(companyClassDetailPK)) 
		{
			CompanyClassDetail companyDetail = this.setCompanyClassDetail(companyDetailDTO);			
			companyClassDetailsAdminRepo.save(companyDetail);
		}
	}

	public void delAllCompanyClassDetails() 
	{
		companyClassDetailsAdminRepo.deleteAll();
	}

	public void delSelectCompanyClassDetails(ArrayList<CompanyClassDetailPK> classDetailPKs) 
	{
	companyClassDetailsAdminRepo.deleteAllById(classDetailPKs);		
	}
	
	public void delSelectCompanyClassDetailsByCompanies(ArrayList<Long> ids) 
	{
	companyClassDetailsAdminRepo.delSelectCompanyClassDetailsByCompanies(ids);		
	}
	
	public void delSelectCompanyClassDetailsByClasses(ArrayList<Long> ids) 
	{
	companyClassDetailsAdminRepo.delSelectCompanyClassDetailsByClasses(ids);		
	}

	private ArrayList<CompanyClassDetail_DTO> getCompanyClassDetailDtos(ArrayList<CompanyClassDetail> compDetails) {
		CompanyClassDetail_DTO companyDetailDTO = null;
		ArrayList<CompanyClassDetail_DTO> companyDetailDTOs = new ArrayList<CompanyClassDetail_DTO>();

		for (int i = 0; i < compDetails.size(); i++) {
			companyDetailDTO = this.getCompanyClassDetail_DTO(compDetails.get(i));			
			companyDetailDTOs.add(companyDetailDTO);
		}
		return companyDetailDTOs;
	}

	private CompanyClassDetail_DTO getCompanyClassDetail_DTO(CompanyClassDetail compDetail) 
	{
		CompanyClassDetail_DTO companyDetailDTO = null;
		companyDetailDTO = new CompanyClassDetail_DTO();
		companyDetailDTO.setCompanySeqNo(compDetail.getId().getCompanySeqNo());
		companyDetailDTO.setCompanyClassSeqNo(compDetail.getId().getCompanyClassSeqNo());		
		return companyDetailDTO;
	}

	private CompanyClassDetail setCompanyClassDetail(CompanyClassDetail_DTO cDTO) 
	{
		CompanyClassDetailPK companyDetailPK = new CompanyClassDetailPK();
		companyDetailPK.setCompanySeqNo(cDTO.getCompanySeqNo());
		companyDetailPK.setCompanyClassSeqNo(cDTO.getCompanyClassSeqNo());			
		CompanyClassDetail cDetail = new CompanyClassDetail();		
		cDetail.setId(companyDetailPK);
		return cDetail;
	}
	
}