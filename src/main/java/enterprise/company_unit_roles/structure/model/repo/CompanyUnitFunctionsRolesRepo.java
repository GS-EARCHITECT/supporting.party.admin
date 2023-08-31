package enterprise.company_unit_roles.structure.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.company_unit_roles.structure.model.master.CompanyUnitFunctionRole;
import enterprise.company_unit_roles.structure.model.master.CompanyUnitFunctionRolePK;

@Repository("companyUnitFunctionsRolesRepo")
public interface CompanyUnitFunctionsRolesRepo extends JpaRepository<CompanyUnitFunctionRole, CompanyUnitFunctionRolePK> 
{
	@Query(value = "SELECT * FROM Company_unit_functions_Roles a WHERE (a.company_function_SEQ_NO in :fids and a.company_role_SEQ_NO in :rids) order by company_function_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitFunctionRole> getSelectCompanyRolesFunctions(@Param("rids") ArrayList<Long> rids, @Param("fids") ArrayList<Long> fids);
	
	@Query(value = "SELECT * FROM Company_unit_functions_Roles a WHERE (a.company_function_SEQ_NO in :ids) order by company_function_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitFunctionRole> getSelectCompanyRolesByFunctions(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_unit_functions_Roles a WHERE (a.company_role_SEQ_NO in :ids) order by company_role_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitFunctionRole> getSelectCompanyFunctionsByRoles(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_unit_functions_Roles a WHERE (a.company_function_SEQ_NO in :fids and a.company_role_SEQ_NO in :rids)", nativeQuery = true)
	void delSelectCompanyRolesFunctions(@Param("rids") ArrayList<Long> rids, @Param("fids") ArrayList<Long> fids);
	
	@Query(value = "DELETE FROM Company_unit_functions_Roles a WHERE (a.company_function_SEQ_NO in :ids)", nativeQuery = true)
	void delSelectCompanyRolesByFunctions(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Company_unit_functions_Roles a WHERE (a.company_role_SEQ_NO in :ids)", nativeQuery = true)
	void delSelectCompanyFunctionsByRoles(@Param("ids") ArrayList<Long> ids);} 

