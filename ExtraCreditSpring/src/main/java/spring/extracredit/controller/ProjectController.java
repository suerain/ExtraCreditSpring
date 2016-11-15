package spring.extracredit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.extracredit.domain.Project;
import spring.extracredit.domain.Status;
import spring.extracredit.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/projects";
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("projects", projectService.getAll());
		return "projectList";
	}

	@RequestMapping(value = "/createProject")
	public String open(Model model) {
		Project p = new Project();
		p.setStatus(Status.IN_PROGRESS);
		model.addAttribute("project", p);
		return "createProject";
	}

	@RequestMapping(value = "/createProject", method = RequestMethod.POST)
	public String add(@Valid Project project, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
            return "createProject";
		System.out.println(project);
		projectService.addProject(project);
		model.addAttribute("projects", projectService.getAll());
		return "projectList";
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String get(@PathVariable long id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("taskList", projectService.getTask(id));
		model.addAttribute("beneficiaryList", projectService.getBeneficiary(id));
		return "projectDetail";
	}

	@RequestMapping(value = "/findProjectByResource")
	public String findByResource(@RequestParam("name") String name, Model model) {
		model.addAttribute("projects", projectService.findByResource(name));
		return "projectList";
	}

	@RequestMapping(value = "/findProjectByKeyword")
	public String findByKeyword(@RequestParam("name") String name, Model model) {
		model.addAttribute("projects", projectService.findByKeyword(name));
		return "projectList";
	}

	@RequestMapping(value = "/findProjectByStatus")
	public String findByStatus(@RequestParam("name") String name, Model model) {
		model.addAttribute("projects", projectService.findByStatus(name));
		return "projectList";
	}

	@RequestMapping(value = "/findProjectByVolunteer")
	public String findByVolunteer(@RequestParam("name") String name, Model model) {
		model.addAttribute("projects", projectService.findByVolunteer(name));
		return "projectList";
	}
	
	@RequestMapping("/logout")
    public String logout() {
        return "loggedout";
    }

}
