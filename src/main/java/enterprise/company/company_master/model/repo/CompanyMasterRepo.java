package enterprise.company.company_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.company.company_master.model.master.CompanyMaster;

@Repository("companyRepo")
public interface CompanyMasterRepo extends CrudRepository<CompanyMaster, Long> 
{
	@Query(value = "SELECT * FROM Company_Master a WHERE a.company_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyMaster> getSelectCompanies(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Company_Master a WHERE a.party_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyMaster> getSelectCompaniesForParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_Company_Master a WHERE a.company_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanies(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Master a WHERE a.party_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompaniesForParties(@Param("ids") ArrayList<Long> ids);
} 

