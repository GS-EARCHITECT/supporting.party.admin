package enterprise.company_unit_roles.master.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company_unit_roles.master.model.master.CompanyUnitRoleMaster;

@Repository("companyUnitRoleMasterAdminRepo")
public interface CompanyUnitRoleMastersAdmin_Repo extends JpaRepository<CompanyUnitRoleMaster, Long> 
{
	@Query(value = "SELECT * FROM Company_Unit_Role_Master a WHERE a.company_unit_SEQ_NO in :ids order by role_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitRoleMaster> getSelectCompanyUnitRoleMastersForCompanyUnits(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Unit_Role_Master a WHERE a.master_role_SEQ_NO in :ids order by role_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitRoleMaster> getSelectCompanyUnitRoleMastersForMasters(@Param("ids") ArrayList<Long> ids);
		
	@Query(value = "delete FROM Company_Unit_Role_Master a WHERE a.company_unit_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitRoleMastersForCompanyUnits(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM Company_Unit_Role_Master a WHERE a.master_role_SEQ_NO in :ids order by role_SEQ_NO", nativeQuery = true)
	void delSelectCompanyUnitRoleMastersForMasters(@Param("ids") ArrayList<Long> ids);
} 

