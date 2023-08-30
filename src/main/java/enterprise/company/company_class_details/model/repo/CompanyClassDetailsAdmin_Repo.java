package enterprise.company.company_class_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company.company_class_details.model.master.CompanyClassDetail;
import enterprise.company.company_class_details.model.master.CompanyClassDetailPK;

@Repository("companyClassDetailsAdminRepo")
public interface CompanyClassDetailsAdmin_Repo extends JpaRepository<CompanyClassDetail, CompanyClassDetailPK> 
{
	@Query(value = "SELECT * FROM Company_Class_Details a WHERE a.company_class_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyClassDetail> getSelectCompanyClassDetailsByClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Company_Class_Details a WHERE a.company_SEQ_NO in :ids order by company_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyClassDetail> getSelectCompanyClassDetailsByCompanies(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM Company_Class_Details a WHERE a.company_class_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyClassDetailsByClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM Company_Class_Details a WHERE a.company_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyClassDetailsByCompanies(@Param("ids") ArrayList<Long> ids);
} 

