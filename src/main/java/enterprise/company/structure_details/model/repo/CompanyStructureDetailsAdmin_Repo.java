package enterprise.company.structure_details.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import enterprise.company.structure_details.model.master.CompanyStructureDetail;
import enterprise.company.structure_details.model.master.CompanyStructureDetailPK;

@Repository("companyStructureDetailsAdminRepo")
public interface CompanyStructureDetailsAdmin_Repo extends JpaRepository<CompanyStructureDetail, CompanyStructureDetailPK> 
{} 

