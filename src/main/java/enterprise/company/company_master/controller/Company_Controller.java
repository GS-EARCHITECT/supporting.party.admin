package enterprise.company.company_master.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import enterprise.company.company_master.model.dto.CompanyMasterDTO;
import enterprise.company.company_master.services.I_CompanyMasterService;

@RestController
@RequestMapping("/companyManagement")
public class Company_Controller {

	//private static final Logger logger = LoggerFactory.getLogger(Customer_Company_Controller.class);

	@Autowired
	private I_CompanyMasterService companyMasterServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyMasterDTO> newCompany(@RequestBody CompanyMasterDTO companyDTO) {
		CompanyMasterDTO companyDTO2 = companyMasterServ.newCompany(companyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyMasterDTO>> getAllCompanyMasters() {
		ArrayList<CompanyMasterDTO> companyDTOs = companyMasterServ.getAllCompanies();
		//logger.info("size :"+companyDTOs.size());
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyMasterDTO>> getSelectCompanyMasters(@RequestBody ArrayList<Long> customerCoSeqNos) {
		ArrayList<CompanyMasterDTO> companyDTOs = companyMasterServ.getSelectCompanies(customerCoSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompaniesForParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyMasterDTO>> getSelectCompaniesForParties(@RequestBody ArrayList<Long> customerCoSeqNos) {
		ArrayList<CompanyMasterDTO> companyDTOs = companyMasterServ.getSelectCompaniesForParties(customerCoSeqNos);		
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}	

	@PutMapping("/updCompany")
	public void updateCompany(@RequestBody CompanyMasterDTO companyDTO) {
		companyMasterServ.updCompany(companyDTO);
	}

	@DeleteMapping("/delCompany/{coSeqNo}")
	public void deleteCompany(@PathVariable String coSeqNo) {
		companyMasterServ.delCompany(Long.parseLong(coSeqNo));
	}

	@DeleteMapping("/delSelectCos")
	public void deleteSelectCos(@RequestBody ArrayList<Long> coSeqNoList) {
		companyMasterServ.delSelectCompanies(coSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompaniesForParties")
	public void delSelectCompaniesForParties(@RequestBody ArrayList<Long> coSeqNoList) {
		companyMasterServ.delSelectCompaniesForParties(coSeqNoList);
	}
	
	@DeleteMapping("/delAllCos")
	public void deleteAllCompanys() {
		companyMasterServ.delAllCompanies();
	}
	}