package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorDAO extends JpaRepository<Visitor, String> {
	
	

	@Query("SELECT u FROM Visitor u WHERE u.house_no=?1" )
     public List <Visitor> viewMember(String to_visit);
	// public List <Visitor> findByUser_Unique_Id(String unique_id);

	
}
