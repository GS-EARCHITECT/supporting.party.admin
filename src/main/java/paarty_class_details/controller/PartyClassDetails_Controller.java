package paarty_class_details.controller;

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
import paarty_class_details.model.dto.PartyClassDetail_DTO;
import paarty_class_details.service.I_PartyClassDetails_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/partyClassDetailsManagement")
public class PartyClassDetails_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyClassDetails_Controller.class);

	@Autowired
	private I_PartyClassDetails_Service partyClassDetailsServ;

	@PostMapping("/new")
	public ResponseEntity<PartyClassDetail_DTO> newpartyClass(
			@RequestBody PartyClassDetail_DTO partyClassDTO) {
		PartyClassDetail_DTO partyClassDTO2 = partyClassDetailsServ.newPartyClassDetail(partyClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(partyClassDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllPartyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyClassDetail_DTO>> getAllPartyClassDetails() {
		ArrayList<PartyClassDetail_DTO> partyClassDTOs = partyClassDetailsServ.getAllPartyClassDetails();
		return new ResponseEntity<>(partyClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPartyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyClassDetail_DTO>> getSelectPartyClassDetails(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<PartyClassDetail_DTO> partyClassDTOs = partyClassDetailsServ
				.getSelectPartyClassDetails(ids);
		return new ResponseEntity<>(partyClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPartysForClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyClassDetail_DTO>> getSelectPartysForClasses(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<PartyClassDetail_DTO> partyClassDTOs = partyClassDetailsServ
				.getSelectPartysForClasses(ids);
		return new ResponseEntity<>(partyClassDTOs, HttpStatus.OK);
	}

	@PutMapping("/updPartyClassDetail")
	public void updatePartyClassDetail(@RequestBody PartyClassDetail_DTO partyClassDetailsDTO) {
		partyClassDetailsServ.updPartyClassDetail(partyClassDetailsDTO);
		return;
	}

	@DeleteMapping("/delSelectPartyClassDetails")
	public void deleteSelectpartyClassDetails(@RequestBody ArrayList<Long> ids) {
		partyClassDetailsServ.delSelectPartyClassDetails(ids);
		return;
	}

	@DeleteMapping("/delAllPartyClassDetails")
	public void deleteAllpartyClassDetails() {
		partyClassDetailsServ.delAllPartyClassDetails();
		;
		return;
	}
}