package enterprise.company.company_class_details.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import enterprise.company.company_class_details.model.dto.CompanyClassDetail_DTO;
import enterprise.company.company_class_details.model.master.CompanyClassDetailPK;
import enterprise.company.company_class_details.services.I_CompanyClassDetailsAdmin_Service;

@RestController
@RequestMapping("/companyClassDetailsAdminManagement")
public class CompanyClassDetailsAdmin_Controller 
{

	//private static final Logger logger = LoggerFactory.getLogger(Customer_Company_Controller.clas);

	@Autowired
	private I_CompanyClassDetailsAdmin_Service companyClassDetailsAdminServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyClassDetail_DTO> newCompanyClassDetails(@RequestBody CompanyClassDetail_DTO companyDTO) {
		CompanyClassDetail_DTO companyDTO2 = companyClassDetailsAdminServ.newCompanyClassDetail(companyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoClassDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyClassDetail_DTO>> getAllCompanyClassDetails() {
		ArrayList<CompanyClassDetail_DTO> companyDTOs = companyClassDetailsAdminServ.getAllCompanyClassDetails();
		//logger.info("size :"+companyDTOs.size());
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoClassDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyClassDetail_DTO>> getSelectCompanyClassDetails(@RequestBody ArrayList<CompanyClassDetailPK> classDetailPKs) 
	{
		ArrayList<CompanyClassDetail_DTO> companyDTOs = companyClassDetailsAdminServ.getSelectCompanyClassDetails(classDetailPKs);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyClassDetailsByClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyClassDetail_DTO>> getSelectCompanyClassDetailsByClasses(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<CompanyClassDetail_DTO> companyDTOs = companyClassDetailsAdminServ.getSelectCompanyClassDetailsByClasses(ids);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@GetMapping(value = "/getSelectCompanyClassDetailsByCompanies", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyClassDetail_DTO>> getSelectCompanyClassDetailsByCompanies(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<CompanyClassDetail_DTO> companyDTOs = companyClassDetailsAdminServ.getSelectCompanyClassDetailsByCompanies(ids);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updCompanyClassDetails")
	public void updateCompanyClassDetails(@RequestBody CompanyClassDetail_DTO companyDetailDTO) {
		companyClassDetailsAdminServ.updCompanyClassDetail(companyDetailDTO);
	}

	@DeleteMapping("/delSelectCoDetails")
	public void deleteSelectCoDetails(@RequestBody ArrayList<CompanyClassDetailPK> classDetailPKs) 
	{
		companyClassDetailsAdminServ.delSelectCompanyClassDetails(classDetailPKs);
	}
	
	@DeleteMapping("/delSelectCompanyClassDetailsByClasses")
	public void delSelectCompanyClassDetailsByClasses(@RequestBody ArrayList<Long> coSeqNoList) 
	{
		companyClassDetailsAdminServ.delSelectCompanyClassDetailsByClasses(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyClassDetailsByCompanies")
	public void delSelectCompanyClassDetailsByCompanies(@RequestBody ArrayList<Long> coSeqNoList) 
	{
		companyClassDetailsAdminServ.delSelectCompanyClassDetailsByCompanies(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCoDetails")
	public void deleteAllCompanyClassDetails() {
		companyClassDetailsAdminServ.delAllCompanyClassDetails();
	}
	}