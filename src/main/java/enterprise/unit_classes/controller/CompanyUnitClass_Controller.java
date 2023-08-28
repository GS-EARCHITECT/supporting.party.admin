package enterprise.unit_classes.controller;

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

import enterprise.unit_classes.model.dto.CompanyUnitClassDTO;
import enterprise.unit_classes.services.I_CompanyUnitClassService;

@RestController
@RequestMapping("/unitClassManagement")
public class CompanyUnitClass_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Unit_Unit_Cuntroller.class);

	@Autowired
	private I_CompanyUnitClassService companyUnitClassService;

	@PostMapping("/new")
	public ResponseEntity<CompanyUnitClassDTO> newUnit(@RequestBody CompanyUnitClassDTO unitDTO) {
		CompanyUnitClassDTO unitDTO2 = companyUnitClassService.newCompanyUnitClass(unitDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(unitDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllCompanyUnitClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassDTO>> getAllCompanyUnitClasses() {
		ArrayList<CompanyUnitClassDTO> unitDTOs = companyUnitClassService.getAllCompanyUnitClasses();
		// logger.info("size :"+unitDTOs.size());
		return new ResponseEntity<>(unitDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompanyUnitClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitClassDTO>> getSelectCompanyUnitClasses(@RequestBody ArrayList<Long> unitCuSeqNos) {
		ArrayList<CompanyUnitClassDTO> unitDTOs = companyUnitClassService.getSelectCompanyUnitClasses(unitCuSeqNos);
		return new ResponseEntity<>(unitDTOs, HttpStatus.OK);
	}

	@PutMapping("/updCompanyUnitClass")
	public void updateCompanyUnitClass(@RequestBody CompanyUnitClassDTO unitDTO) {
		companyUnitClassService.updCompanyUnitClass(unitDTO);
	}

	@DeleteMapping("/delSelectCompanyUnitClasses")
	public void deleteSelectCompanyUnitClasses(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitClassService.delSelectCompanyUnitClasses(coSeqNoList);
	}

	@DeleteMapping("/delAllCompanyUnitClasses")
	public void deleteAllCompanyUnitClasses() {
		companyUnitClassService.delAllCompanyUnitClasses();
	}
}