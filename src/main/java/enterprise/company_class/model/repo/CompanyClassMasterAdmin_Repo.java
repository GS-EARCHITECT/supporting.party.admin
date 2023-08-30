package enterprise.company_class.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company_class.model.master.CompanyClassMaster;
import enterprise.unit_classes.model.master.CompanyUnitClass;

@Repository("compClassAdminRepo")
public interface CompanyClassMasterAdmin_Repo extends JpaRepository<CompanyClassMaster, Long> 
{

	@Query(value = "SELECT * FROM Company_Class_Master a WHERE a.company_class_SEQ_NO in :ids order by company_class_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitClass> getSelectCompanyClasses(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Company_Class_Master a WHERE a.company_class_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyClasses(@Param("ids") ArrayList<Long> ids);
}
