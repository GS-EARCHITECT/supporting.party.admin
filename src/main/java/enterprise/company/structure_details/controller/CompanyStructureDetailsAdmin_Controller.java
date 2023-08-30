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

import enterprise.company.structure_details.model.dto.CompanyStructureDetail_DTO;
import enterprise.company.structure_details.model.master.CompanyStructureDetailPK;
import enterprise.company.structure_details.services.I_CompanyStructureDetailsAdmin_Service;

@RestController
@RequestMapping("/companyStructureDetailsAdminManagement")
public class CompanyStructureDetailsAdmin_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Customer_Company_Controller.clas);

	@Autowired
	private I_CompanyStructureDetailsAdmin_Service companyStructureDetailsAdminServ;

	@PostMapping("/new")
	public ResponseEntity<CompanyStructureDetail_DTO> newCompanyStructureDetails(
			@RequestBody CompanyStructureDetail_DTO companyDTO) {
		CompanyStructureDetail_DTO companyDTO2 = companyStructureDetailsAdminServ.newCompanyStructureDetail(companyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllCoDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyStructureDetail_DTO>> getAllCompanyStructureDetails() {
		ArrayList<CompanyStructureDetail_DTO> companyDTOs = companyStructureDetailsAdminServ
				.getAllCompanyStructureDetails();
		// logger.info("size :"+companyDTOs.size());
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCoDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyStructureDetail_DTO>> getSelectCompanyStructureDetails(
			@RequestBody ArrayList<CompanyStructureDetailPK> companyStructureDetailPKs) {
		ArrayList<CompanyStructureDetail_DTO> companyDTOs = companyStructureDetailsAdminServ
				.getSelectCompanyStructureDetails(companyStructureDetailPKs);
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

	@PutMapping("/updCompanyStructureDetails")
	public void updateCompanyStructureDetails(
			@RequestBody CompanyStructureDetail_DTO companyStructureDetailsAdminRepoDTO) {
		companyStructureDetailsAdminServ.updCompanyStructureDetail(companyStructureDetailsAdminRepoDTO);
	}

	@DeleteMapping("/delSelectCoDetails")
	public void deleteSelectCoDetails(@RequestBody ArrayList<CompanyStructureDetailPK> ids) {
		companyStructureDetailsAdminServ.delSelectCompanyStructureDetails(ids);
	}

	@DeleteMapping("/delAllCoDetails")
	public void deleteAllCompanyStructureDetails() {
		companyStructureDetailsAdminServ.delAllCompanyStructureDetails();
	}
}