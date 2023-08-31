package enterprise.company_unit_roles.structure.controller;

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

import enterprise.company_unit_roles.structure.model.dto.CompanyUnitFunctionRoleDTO;
import enterprise.company_unit_roles.structure.services.I_CompanyUnitFunctionsRolesService;

@RestController
@RequestMapping("/companyUnitFunctionsRolesManagement")
public class CompanyUnitFunctionRoles_Controller 
{

	//private static final Logger logger = LoggerFactory.getLogger(Customer_Company_Controller.clas);

	@Autowired
	private I_CompanyUnitFunctionsRolesService companyUnitFunctionsRolesServ;

	
	@PostMapping("/new")
	public ResponseEntity<CompanyUnitFunctionRoleDTO> newCompanyUnitFunctionRole(@RequestBody CompanyUnitFunctionRoleDTO companyUnitFunctionDTO) {
		CompanyUnitFunctionRoleDTO companyUnitFunctionDTO2 = companyUnitFunctionsRolesServ.newCompanyUnitFunctionRole(companyUnitFunctionDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyUnitFunctionDTO2, httpHeaders, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/getAllCoUnitFunctionssRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionRoleDTO>> getAllCompanyUnitFunctionsRoles() {
		ArrayList<CompanyUnitFunctionRoleDTO> companyUnitFunctionDTOs = companyUnitFunctionsRolesServ.getAllCompanyUnitFunctionsRoles();
		//logger.info("size :"+companyUnitFunctionDTOs.size());
		return new ResponseEntity<>(companyUnitFunctionDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCoUnitFunctionsRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionRoleDTO>> getSelectCompanyUnitFunctionsRoles(@RequestBody ArrayList<Long> fList, @RequestBody ArrayList<Long> rList) 
	{
		ArrayList<CompanyUnitFunctionRoleDTO> companyUnitFunctionDTOs = companyUnitFunctionsRolesServ.getSelectCompanyRolesFunctions(rList, fList);		
		return new ResponseEntity<>(companyUnitFunctionDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyRolesByFunctions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionRoleDTO>> getSelectCompanyRolesByFunctions(@RequestBody ArrayList<Long> cSeqNos) 
	{
		ArrayList<CompanyUnitFunctionRoleDTO> companyUnitFunctionDTOs = companyUnitFunctionsRolesServ.getSelectCompanyRolesByFunctions(cSeqNos);		
		return new ResponseEntity<>(companyUnitFunctionDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCompanyRolesByRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitFunctionRoleDTO>> getSelectCompanyRolesByRoles(@RequestBody ArrayList<Long> cSeqNos) 
	{
		ArrayList<CompanyUnitFunctionRoleDTO> companyUnitFunctionDTOs = companyUnitFunctionsRolesServ.getSelectCompanyFunctionsByRoles(cSeqNos);		
		return new ResponseEntity<>(companyUnitFunctionDTOs, HttpStatus.OK);
	}

	@PutMapping("/updCompanyUnitFunctionRole")
	public void updateCompanyUnitFunctionRole(@RequestBody CompanyUnitFunctionRoleDTO companyUnitFunctionRoleDTO) 
	{
		companyUnitFunctionsRolesServ.updCompanyUnitFunctionRole(companyUnitFunctionRoleDTO);
	}

	@DeleteMapping("/delSelectCoUnitFunctionsRoles")
	public void delSelectCompanyRolesFunctions(@RequestBody ArrayList<Long> rList, @RequestBody ArrayList<Long> fList) 
	{
		companyUnitFunctionsRolesServ.delSelectCompanyRolesFunctions(rList, fList);;
	}
	
	@DeleteMapping("/delSelectCompanyRolesByFunctions")
	public void delSelectCompanyRolesByFunctions(@RequestBody ArrayList<Long> fSeqNoList) 
	{
		companyUnitFunctionsRolesServ.delSelectCompanyRolesByFunctions(fSeqNoList);
	}
	
	@DeleteMapping("/delSelectCompanyFunctionsByRoles")
	public void delSelectCompanyFunctionsByRoles(@RequestBody ArrayList<Long> rSeqNoList) 
	{
		companyUnitFunctionsRolesServ.delSelectCompanyFunctionsByRoles(rSeqNoList);
	}
	
	@DeleteMapping("/delAllCoUnitFunctionRoles")
	public void deleteAllCompanyUnitFunctionRoles() {
		companyUnitFunctionsRolesServ.delAllCompanyUnitFunctionRoles();
	}
	}