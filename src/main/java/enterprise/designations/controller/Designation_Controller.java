package enterprise.designations.controller;

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

import enterprise.designations.model.dto.CompanyDesignationDTO;
import enterprise.designations.services.I_CompanyDesignationService;

@RestController
@RequestMapping("/designationManagement")
public class Designation_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Designation_Designation_Cuntroller.class);

	@Autowired
	private I_CompanyDesignationService designationServ;

	@PostMapping("/new")
	public ResponseEntity<CompanyDesignationDTO> newDesignation(@RequestBody CompanyDesignationDTO designationDTO) {
		CompanyDesignationDTO designationDTO2 = designationServ.newDesignation(designationDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(designationDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllDesignations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyDesignationDTO>> getAllDesignations() {
		ArrayList<CompanyDesignationDTO> designationDTOs = designationServ.getAllDesignations();
		// logger.info("size :"+designationDTOs.size());
		return new ResponseEntity<>(designationDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDesignations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyDesignationDTO>> getSelectDesignations(@RequestBody ArrayList<Long> designationCuSeqNos) {
		ArrayList<CompanyDesignationDTO> designationDTOs = designationServ.getSelectDesignations(designationCuSeqNos);
		return new ResponseEntity<>(designationDTOs, HttpStatus.OK);
	}

	@PutMapping("/updDesignation")
	public void updateDesignation(@RequestBody CompanyDesignationDTO designationDTO) {
		designationServ.updDesignation(designationDTO);
	}

	@DeleteMapping("/delSelectDesignations")
	public void deleteSelectDesignations(@RequestBody ArrayList<Long> coSeqNoList) {
		designationServ.delSelectDesignations(coSeqNoList);
	}

	@DeleteMapping("/delAllDesignations")
	public void deleteAllDesignations() {
		designationServ.delAllDesignations();
	}
}