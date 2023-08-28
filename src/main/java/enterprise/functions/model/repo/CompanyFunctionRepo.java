package enterprise.functions.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.functions.model.master.CompanyFunction;

@Repository("functionRepo")
public interface CompanyFunctionRepo extends JpaRepository<CompanyFunction, Long> 
{

	@Query(value = "SELECT * FROM Company_Function_Master a WHERE a.function_SEQ_NO in :ids order by function_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyFunction> getSelectFunctions(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Company_Function_Master a WHERE a.function_SEQ_NO in :ids", nativeQuery = true)
	void delSelectFunctions(@Param("ids") ArrayList<Long> ids);
}
