package party_locations.controller;

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

import party_locations.model.dto.PartyLocationDTO;
import party_locations.services.I_PartyLocationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/partyLocationManagement")
public class PartyLocationController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyLocation_Controller.class);

	@Autowired
	private I_PartyLocationService partyLocationServ;

	@PostMapping("/new")
	public ResponseEntity<PartyLocationDTO> newPartyLocation(@RequestBody PartyLocationDTO PartyLocationDTO) 
	{
		PartyLocationDTO PartyLocationDTO2 = partyLocationServ.newPartyLocation(PartyLocationDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(PartyLocationDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectPartyLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyLocationDTO>> getSelectPartyLocations(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<PartyLocationDTO> PartyLocationDTOs = partyLocationServ.getSelectPartyLocations(ids);
		return new ResponseEntity<>(PartyLocationDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPartiesByLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyLocationDTO>> getSelectPartiesByLocations(@RequestBody ArrayList<Long> ids)
	{
		ArrayList<PartyLocationDTO> PartyLocationDTOs = partyLocationServ.getSelectPartiesByLocations(ids);
		return new ResponseEntity<>(PartyLocationDTOs, HttpStatus.OK);
	}

	
	@GetMapping(value = "/getAllPartyLocation", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyLocationDTO>> getAllPartyLocation() {
		ArrayList<PartyLocationDTO> PartyLocationDTOs = partyLocationServ.getAllPartyLocations();
		return new ResponseEntity<>(PartyLocationDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPartyLocationsBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<PartyLocationDTO>> getSelectPartyLocationsBetweenTimes(@RequestBody ArrayList<Long> ids, @PathVariable String fr, @PathVariable String to)
	{
		ArrayList<PartyLocationDTO> PartyLocationDTOs = partyLocationServ.getSelectPartyLocationsBetweenTimes(ids, fr, to);
		return new ResponseEntity<>(PartyLocationDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updPartyLocation")
	public void updatePartyLocation(@RequestBody PartyLocationDTO PartyLocationDTO) {
		partyLocationServ.updPartyLocation(PartyLocationDTO);
		return;
	}

	@DeleteMapping("/delSelectPartyLocations")
	public void delSelectPartyLocations(@RequestBody ArrayList<Long> ids)
	{
		partyLocationServ.delSelectPartyLocations(ids);
	}
	
	@DeleteMapping("/delSelectPartiesByLocations")
	public void delSelectPartiesByLocations(@RequestBody ArrayList<Long> ids)
	{
		partyLocationServ.delSelectPartiesByLocations(ids);
	}

	@DeleteMapping("/delSelectPartyLocationsBetweenTimes/{fr}/{to}")	
	public void delSelectPartyLocationsBetweenTimes(@RequestBody ArrayList<Long> ids, @PathVariable String fr, @PathVariable String to) 
	{
		partyLocationServ.delSelectPartyLocationsBetweenTimes(ids, fr, to);
		return;
	}

	@DeleteMapping("/delAllPartyLocation")
	public void deleteAllPartyLocation() {
		partyLocationServ.delAllPartyLocations();
		return;
	}
}