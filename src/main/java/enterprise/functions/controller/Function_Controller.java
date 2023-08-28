package enterprise.functions.controller;

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

import enterprise.functions.model.dto.CompanyFunctionDTO;
import enterprise.functions.services.I_CompanyFunctionService;

@RestController
@RequestMapping("/functionManagement")
public class Function_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Function_Function_Cuntroller.class);

	@Autowired
	private I_CompanyFunctionService functionServ;

	@PostMapping("/new")
	public ResponseEntity<CompanyFunctionDTO> newFunction(@RequestBody CompanyFunctionDTO functionDTO) {
		CompanyFunctionDTO functionDTO2 = functionServ.newFunction(functionDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(functionDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllFunctions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyFunctionDTO>> getAllFunctions() {
		ArrayList<CompanyFunctionDTO> functionDTOs = functionServ.getAllFunctions();
		// logger.info("size :"+functionDTOs.size());
		return new ResponseEntity<>(functionDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectFunctions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyFunctionDTO>> getSelectFunctions(@RequestBody ArrayList<Long> functionCuSeqNos) {
		ArrayList<CompanyFunctionDTO> functionDTOs = functionServ.getSelectFunctions(functionCuSeqNos);
		return new ResponseEntity<>(functionDTOs, HttpStatus.OK);
	}

	@PutMapping("/updFunction")
	public void updateFunction(@RequestBody CompanyFunctionDTO functionDTO) {
		functionServ.updFunction(functionDTO);
	}

	@DeleteMapping("/delSelectFunctions")
	public void deleteSelectFunctions(@RequestBody ArrayList<Long> coSeqNoList) {
		functionServ.delSelectFunctions(coSeqNoList);
	}

	@DeleteMapping("/delAllFunctions")
	public void deleteAllFunctions() {
		functionServ.delAllFunctions();
	}
}