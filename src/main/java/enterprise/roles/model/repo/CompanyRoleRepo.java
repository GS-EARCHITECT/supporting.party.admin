package enterprise.roles.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import enterprise.roles.model.master.CompanyRole;

@Repository("roleRepo")
public interface CompanyRoleRepo extends JpaRepository<CompanyRole, Long> 
{

	@Query(value = "SELECT * FROM Company_Role_Master a WHERE a.role_SEQ_NO in :ids order by role_SEQ_NO", nativeQuery = true)
	ArrayList<CompanyRole> getSelectRoles(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Company_Role_Master a WHERE a.role_SEQ_NO in :ids", nativeQuery = true)
	void delSelectRoles(@Param("ids") ArrayList<Long> ids);
}
