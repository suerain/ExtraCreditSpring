package spring.extracredit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.extracredit.DAO.*;
import spring.extracredit.domain.*;

@Service
public class ProjectService {
	@Autowired
	private IProjectDAO iProjectDAO;
	
	public List<Project> getAll() {
		return iProjectDAO.findAll();
	}
	
	public void addProject(Project p) {
		iProjectDAO.save(p);
	}

	public List<Task> getTask(long id) {
		return iProjectDAO.findOneById(id).getTaskList();
	}
	
	public List<Beneficiary> getBeneficiary(long id) {
		return iProjectDAO.findOneById(id).getBeneficiaryList();
	}

	public List<Project> findByResource(String name) {
		return iProjectDAO.findProjectByResource(name);
	}
	
	public List<Project> findByKeyword(String name) {
		return iProjectDAO.findProjectByKeyword(name);
	}
	
	public List<Project> findByStatus(String name) {
		Status s;
		if (name.equalsIgnoreCase("inprogress"))
			s = Status.IN_PROGRESS;
		else if (name.equalsIgnoreCase("cancelled"))
			s = Status.CANCELLED;
		else if (name.equalsIgnoreCase("completed"))
			s = Status.COMPLETED;
		else
			return new ArrayList<Project>();
		return iProjectDAO.findProjectByStatus(s);
	}
	
	public List<Project> findByVolunteer(String name) {
		return iProjectDAO.findProjectByVolunteer(name);
	}
}
