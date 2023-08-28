package enterprise.designations.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.designations.model.master.CompanyDesignation;

@Repository("designationRepo")
public interface CompanyDesignationRepo extends JpaRepository<CompanyDesignation, Long> 
{

	@Query(value = "SELECT * FROM Company_Designation_Master a WHERE a.designation_SEQ_NO in :ids order by designation_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyDesignation> getSelectDesignations(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Company_Designation_Master a WHERE a.designation_SEQ_NO in :ids", nativeQuery = true)
	void delSelectDesignations(@Param("ids") ArrayList<Long> ids);
}
