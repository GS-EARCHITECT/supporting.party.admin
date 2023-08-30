package enterprise.company.structure_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.company.structure_details.model.master.CompanyDetail;
import enterprise.company.structure_details.model.master.CompanyDetailPK;

@Repository("companyDetailsRepo")
public interface CompanyDetailsRepo extends CrudRepository<CompanyDetail, CompanyDetailPK> 
{
	@Query(value = "SELECT * FROM Company_Details a WHERE (a.company_SEQ_NO in :ids and a.par_company_SEQ_NO in :ids) order by company_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyDetail> getSelectCompanyDetails(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM Company_Details a WHERE a.par_company_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyDetail> getSelectCompanyDetailsByParents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Company_Company_Details a WHERE (a.company_SEQ_NO in :ids and a.par_company_SEQ_NO in :ids)", nativeQuery = true)
	void delSelectCompanyDetails(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);
	
	@Query(value = "DELETE FROM Company_Details a WHERE (a.company_SEQ_NO in :ids and a.par_company_SEQ_NO in :ids)", nativeQuery = true)
	void delSelectCompanyDetailsByParents(@Param("ids") ArrayList<Long> ids);
} 

