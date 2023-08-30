package enterprise.company.structure_details.controller;

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

import enterprise.company.structure_details.model.dto.CompanyDetailDTO;
import enterprise.company.structure_details.services.I_CompanyDetailsService;

@RestController
@RequestMapping("/companyDetailsManagement")
public class CompanyDetails_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_Company_Controller.clas);

	@Autowired
	private I_CompanyDetailsService companyDetailsServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyDetailDTO> newCompanyDetails(@RequestBody CompanyDetailDTO companyDTO) {
		CompanyDetailDTO companyDTO2 = companyDetailsServ.newCompanyDetail(companyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyDetailDTO>> getAllCompanyDetails() {
		ArrayList<CompanyDetailDTO> companyDTOs = companyDetailsServ.getAllCompanyDetails();
		//logger.info("size :"+companyDTOs.size());
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyDetailDTO>> getSelectCompanyDetails(@RequestBody ArrayList<Long> coSeqNoList, @RequestBody ArrayList<Long> parCoSeqNoList) 
	{
		ArrayList<CompanyDetailDTO> companyDTOs = companyDetailsServ.getSelectCompanyDetails(coSeqNoList, parCoSeqNoList);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompaniesByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyDetailDTO>> getSelectCompaniesByParties(@RequestBody ArrayList<Long> customerCoSeqNos) {
		ArrayList<CompanyDetailDTO> companyDTOs = companyDetailsServ.getSelectCompanyDetailsByParents(customerCoSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompanyDetails")
	public void updateCompanyDetails(@RequestBody CompanyDetailDTO companyDetailDTO) {
		companyDetailsServ.updCompanyDetail(companyDetailDTO);
	}

	@DeleteMapping("/delSelectCoDetails")
	public void deleteSelectCoDetails(@RequestBody ArrayList<Long> coSeqNoList, @RequestBody ArrayList<Long> parCoSeqNoList) 
	{
		companyDetailsServ.delSelectCompanyDetails(coSeqNoList, parCoSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyDetailsByParties")
	public void delSelectCompanyDetailsByParties(@RequestBody ArrayList<Long> coSeqNoList) {
		companyDetailsServ.delSelectCompanyDetailsByParents(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCoDetails")
	public void deleteAllCompanyDetails() {
		companyDetailsServ.delAllCompanyDetails();
	}
	}