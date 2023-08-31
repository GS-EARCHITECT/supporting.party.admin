package enterprise.company_unit_roles.master.controller;

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
import enterprise.company_unit_roles.master.model.dto.CompanyUnitRoleMaster_DTO;
import enterprise.company_unit_roles.master.services.I_CompanyUnitRoleMasterAdmin_Service;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/companyUnitRoleAdminManagement")
public class CompanyUnitRoleAdmin_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Customer_CompanyUnit_Controller.class);

	@Autowired
	private I_CompanyUnitRoleMasterAdmin_Service companyUnitRolesAdminServ;

	@PostMapping("/new")
	public ResponseEntity<CompanyUnitRoleMaster_DTO> newCompanyUnitRole(
			@RequestBody CompanyUnitRoleMaster_DTO companyUnitRoleDTO) {
		CompanyUnitRoleMaster_DTO companyDTO2 = companyUnitRolesAdminServ.newCompanyUnitRole(companyUnitRoleDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(companyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllCoUnitRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitRoleMaster_DTO>> getAllCompanyUnitRoles() {
		ArrayList<CompanyUnitRoleMaster_DTO> companyDTOs = companyUnitRolesAdminServ.getAllCompanyUnitRoles();
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCoUnitRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitRoleMaster_DTO>> getSelectCompanyUnits(
			@RequestBody ArrayList<Long> companyUnitRoleSeqNos) {
		ArrayList<CompanyUnitRoleMaster_DTO> companyDTOs = companyUnitRolesAdminServ
				.getSelectCompanyUnitRoles(companyUnitRoleSeqNos);
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompanyUnitsForCompanyUnits", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitRoleMaster_DTO>> getSelectCompanyUnitsForCompanyUnits(
			@RequestBody ArrayList<Long> companyUnitSeqNos) {
		ArrayList<CompanyUnitRoleMaster_DTO> companyDTOs = companyUnitRolesAdminServ
				.getSelectCompanyUnitRoleMastersForCompanyUnits(companyUnitSeqNos);
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompanyUnitsForMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<CompanyUnitRoleMaster_DTO>> getSelectCompanyUnitsForMasters(
			@RequestBody ArrayList<Long> mSeqNos) {
		ArrayList<CompanyUnitRoleMaster_DTO> companyDTOs = companyUnitRolesAdminServ
				.getSelectCompanyUnitRoleMastersForMasters(mSeqNos);
		return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
	}

	@PutMapping("/updCompanyUnitRole")
	public void updateCompanyUnit(@RequestBody CompanyUnitRoleMaster_DTO companyUnitRoleDTO) {
		companyUnitRolesAdminServ.updCompanyUnitRole(companyUnitRoleDTO);
	}

	@DeleteMapping("/delSelectCoUnitRoles")
	public void deleteSelectCoUnitRoles(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitRolesAdminServ.delSelectCompanyUnitRoles(coSeqNoList);
	}

	@DeleteMapping("/delSelectCompanyUnitsForCompanyUnits")
	public void delSelectCompanyUnitsForCompanyUnits(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitRolesAdminServ.delSelectCompanyUnitRoleMastersForCompanyUnits(coSeqNoList);
	}

	@DeleteMapping("/delSelectCompanyUnitsForMasters")
	public void delSelectCompanyUnitsForMasters(@RequestBody ArrayList<Long> coSeqNoList) {
		companyUnitRolesAdminServ.delSelectCompanyUnitRoleMastersForMasters(coSeqNoList);
	}

	@DeleteMapping("/delAllCoUnitRoles")
	public void deleteAllCompanyUnits() {
		companyUnitRolesAdminServ.delAllCompanyUnitRoles();
	}
}