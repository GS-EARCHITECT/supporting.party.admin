package enterprise.company.structure_details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import enterprise.company.structure_details.model.dto.CompanyDetailDTO;
import enterprise.company.structure_details.model.master.CompanyDetail;
import enterprise.company.structure_details.model.master.CompanyDetailPK;
import enterprise.company.structure_details.model.repo.CompanyDetailsRepo;

@Service("companyDetailServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyDetailsService implements I_CompanyDetailsService 
{
	//private static final Logger logger = LoggerFactory.getLogger(CompanyDetailService.class);
	
	@Autowired
    private CompanyDetailsRepo companyDetailsRepo;
		
	public CompanyDetailDTO newCompanyDetail(CompanyDetailDTO companyDetailDTO) 
	{
		CompanyDetailPK companyDetailPK = new CompanyDetailPK();
		companyDetailPK.setCompanySeqNo(companyDetailDTO.getCompanySeqNo());
		companyDetailPK.setParCompanySeqNo(companyDetailDTO.getParCompanySeqNo());
		
		if(!companyDetailsRepo.existsById(companyDetailPK))
		{
		CompanyDetail companyDetail = companyDetailsRepo.save(this.setCompanyDetail(companyDetailDTO));
		companyDetailDTO = getCompanyDetailDTO(companyDetail);
		}
		return companyDetailDTO;
	}

	public ArrayList<CompanyDetailDTO> getAllCompanyDetails() 
	{
		ArrayList<CompanyDetail> companyList = (ArrayList<CompanyDetail>) companyDetailsRepo.findAll();
		ArrayList<CompanyDetailDTO> companyDetailDTOs = new ArrayList<CompanyDetailDTO>();
		companyDetailDTOs = companyList != null ? this.getCompanyDetailDtos(companyList) : null;
		return companyDetailDTOs;
	}

	public ArrayList<CompanyDetailDTO> getSelectCompanyDetails(ArrayList<Long> companySeqNos, ArrayList<Long> parCompanySeqNos) 
	{
		ArrayList<CompanyDetail> companyList = companyDetailsRepo.getSelectCompanyDetails(companySeqNos, parCompanySeqNos);
		ArrayList<CompanyDetailDTO> companyDetailDTOs = new ArrayList<CompanyDetailDTO>();
		CompanyDetailDTO companyDetailDTO = null;

		for (int i = 0; i < companySeqNos.size(); i++) 
		{
			companyDetailDTO = this.getCompanyDetailDTO(companyList.get(i));			
			companyDetailDTOs.add(companyDetailDTO);
		}
		
		return companyDetailDTOs;
	}

	public ArrayList<CompanyDetailDTO> getSelectCompanyDetailsByParents(ArrayList<Long> ids) 
	{
		ArrayList<CompanyDetail> companyList = companyDetailsRepo.getSelectCompanyDetailsByParents(ids);
		ArrayList<CompanyDetailDTO> companyDetailDTOs = new ArrayList<CompanyDetailDTO>();
		CompanyDetailDTO companyDetailDTO = null;

		for (int i = 0; i < companyList.size(); i++) 
		{
			companyDetailDTO = this.getCompanyDetailDTO(companyList.get(i));			
			companyDetailDTOs.add(companyDetailDTO);
		}
		
		return companyDetailDTOs;
	}
	

	public void updCompanyDetail(CompanyDetailDTO companyDetailDTO) 
	{		
		CompanyDetailPK companyDetailPK = new CompanyDetailPK();
		companyDetailPK.setCompanySeqNo(companyDetailDTO.getCompanySeqNo());
		companyDetailPK.setParCompanySeqNo(companyDetailDTO.getParCompanySeqNo());
		
		if (companyDetailsRepo.existsById(companyDetailPK)) 
		{
			CompanyDetail companyDetail = this.setCompanyDetail(companyDetailDTO);			
			companyDetailsRepo.save(companyDetail);
		}
	}

	public void delAllCompanyDetails() 
	{
		companyDetailsRepo.deleteAll();
	}

	public void delSelectCompanyDetails(ArrayList<Long> companySeqNos, ArrayList<Long> parCompanySeqNos) 
	{
	companyDetailsRepo.delSelectCompanyDetails(companySeqNos,parCompanySeqNos);		
	}
	
	public void delSelectCompanyDetailsByParents(ArrayList<Long> ids) 
	{
	companyDetailsRepo.delSelectCompanyDetailsByParents(ids);		
	}

	private ArrayList<CompanyDetailDTO> getCompanyDetailDtos(ArrayList<CompanyDetail> compDetails) {
		CompanyDetailDTO companyDetailDTO = null;
		ArrayList<CompanyDetailDTO> companyDetailDTOs = new ArrayList<CompanyDetailDTO>();

		for (int i = 0; i < compDetails.size(); i++) {
			companyDetailDTO = this.getCompanyDetailDTO(compDetails.get(i));			
			companyDetailDTOs.add(companyDetailDTO);
		}
		return companyDetailDTOs;
	}

	private CompanyDetailDTO getCompanyDetailDTO(CompanyDetail compDetail) 
	{
		CompanyDetailDTO companyDetailDTO = null;
		companyDetailDTO = new CompanyDetailDTO();
		companyDetailDTO.setCompanySeqNo(compDetail.getId().getCompanySeqNo());
		companyDetailDTO.setParCompanySeqNo(compDetail.getId().getParCompanySeqNo());		
		return companyDetailDTO;
	}

	private CompanyDetail setCompanyDetail(CompanyDetailDTO cDTO) 
	{
		CompanyDetailPK companyDetailPK = new CompanyDetailPK();
		companyDetailPK.setCompanySeqNo(cDTO.getCompanySeqNo());
		companyDetailPK.setParCompanySeqNo(cDTO.getParCompanySeqNo());			
		CompanyDetail cDetail = new CompanyDetail();		
		cDetail.setId(companyDetailPK);
		return cDetail;
	}
	
}