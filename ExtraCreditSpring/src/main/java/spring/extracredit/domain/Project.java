package spring.extracredit.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty; 

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Project {

	public Project() {
		this.status = Status.IN_PROGRESS;
	}

	public Project(String name, String location, String description, Date startDate, Date endDate) {
		this.name = name;
		this.location = location;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = Status.IN_PROGRESS;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", location=" + location + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}

	@Id
	@GeneratedValue
	private long id;

	@Lob
	private byte[] cover;

	@NotEmpty
	private String name;

	@NotEmpty
	private String location;

	@NotEmpty
	private String description;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date startDate;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date endDate;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
	private List<Task> taskList = new ArrayList<Task>();

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
	private List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void addBeneficiary(Beneficiary beneficiary) {
		beneficiaryList.add(beneficiary);
		beneficiary.setProject(this);
	}

	public void removeBeneficiary(Beneficiary beneficiary) {
		beneficiaryList.remove(beneficiary);
		beneficiary.setProject(null);
	}

	public void addTask(Task task) {
		taskList.add(task);
		task.setProject(this);
	}

	public void removeTask(Task task) {
		taskList.remove(task);
		task.setProject(null);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Beneficiary> getBeneficiaryList() {
		return beneficiaryList;
	}

	public void setBeneficiaryList(List<Beneficiary> beneficiaryList) {
		this.beneficiaryList = beneficiaryList;
	}

}
