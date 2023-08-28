package party_locations.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import party_locations.model.master.PartyLocation;
import party_locations.model.master.PartyLocationPK;

@Repository("partyLocationRepo")
public interface PartyLocationRepo extends JpaRepository<PartyLocation, PartyLocationPK> 
{

	@Query(value = "SELECT * FROM Party_Locations a WHERE ((a.party_SEQ_NO in :ids) and (a.ON_DTTM BETWEEN :frDtTm  and :toDtTm)) order by a.party_SEQ_NO", nativeQuery = true)
	ArrayList<PartyLocation> getSelectPartyLocationsBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "SELECT * FROM Party_Locations a WHERE a.party_SEQ_NO in :ids order by party_SEQ_NO", nativeQuery = true)
	ArrayList<PartyLocation> getSelectPartyLocations(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM Party_Locations a WHERE a.location_SEQ_NO in :ids order by party_SEQ_NO", nativeQuery = true)
	ArrayList<PartyLocation> getSelectPartiesByLocations(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Party_Locations a WHERE ((a.party_SEQ_NO in :ids) and (a.ON_DTTM BETWEEN :frDtTm  and :toDtTm)) order by a.party_SEQ_NO", nativeQuery = true)
	void delSelectPartyLocationsBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);
	
	@Query(value = "DELETE FROM Party_Locations a WHERE a.party_SEQ_NO in :ids order by party_SEQ_NO", nativeQuery = true)
	void delSelectPartyLocations(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELTE FROM Party_Locations a WHERE a.location_SEQ_NO in :ids order by party_SEQ_NO", nativeQuery = true)
	void delSelectPartiesByLocations(@Param("ids") ArrayList<Long> ids);
}
