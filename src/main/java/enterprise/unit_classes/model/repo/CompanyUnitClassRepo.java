package enterprise.unit_classes.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.unit_classes.model.master.CompanyUnitClass;

@Repository("unitClassRepo")
public interface CompanyUnitClassRepo extends JpaRepository<CompanyUnitClass, Long> 
{

	@Query(value = "SELECT * FROM Company_Unit_Class a WHERE a.unit_SEQ_NO in :ids order by unit_class_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyUnitClass> getSelectCompanyUnitClasses(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Company_Unit_Class a WHERE a.unit_class_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCompanyUnitClasses(@Param("ids") ArrayList<Long> ids);
}
