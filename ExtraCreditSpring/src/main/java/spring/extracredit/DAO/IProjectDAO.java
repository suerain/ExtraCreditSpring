package spring.extracredit.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.extracredit.domain.*;

public interface IProjectDAO extends JpaRepository<Project, Long> {
	public List<Project> findAll();

	public Project saveAndFlush(Project p);

	public Project findOneById(long id);

	@Query("Select distinct p from Project p join p.taskList t join t.resourceList r where LOWER(r.type) like LOWER(:name))")
	public List<Project> findProjectByResource(@Param("name") String name);

	@Query("Select distinct p from Project p where LOWER(p.name) like LOWER(:name) OR  LOWER(p.location) like LOWER(:name))")
	public List<Project> findProjectByKeyword(@Param("name") String name);

	@Query("Select distinct p from Project p where p.status = :s)")
	public List<Project> findProjectByStatus(@Param("s") Status s);

	@Query("SELECT DISTINCT p FROM Project p JOIN p.taskList t join t.volunteerList v WHERE LOWER(v.name) = LOWER(:name) ORDER BY t.endDate")
	public List<Project> findProjectByVolunteer(@Param("name") String name);
}
