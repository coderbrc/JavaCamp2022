package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.programminglanguage.ProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.programminglanguages.ProgrammingLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.business.responses.technologies.TechnologyResponse;

@RestController
@RequestMapping("api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;
	private TechnologyService technologyService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService,
			TechnologyService technologyService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
		this.technologyService = technologyService;
	}

	@GetMapping
	public List<ProgrammingLanguageResponse> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping("/{id}")
	public ProgrammingLanguageResponse getById(@PathVariable int id) throws Exception {
		return programmingLanguageService.getById(id);
	}

	@PostMapping
	public ProgrammingLanguageResponse add(@RequestBody ProgrammingLanguageRequest programmingLanguageRequest)
			throws Exception {
		return programmingLanguageService.add(programmingLanguageRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws Exception {
		programmingLanguageService.delete(id);
	}

	@PutMapping("/{id}")
	public ProgrammingLanguageResponse update(@RequestBody ProgrammingLanguageRequest programmingLanguageRequest,
			@PathVariable int id) throws Exception {
		return programmingLanguageService.update(programmingLanguageRequest, id);
	}

	@GetMapping("/{id}/technologies")
	public List<TechnologyResponse> getTechnologiesByLanguageId(@PathVariable int id) {
		return technologyService.getAllByLanguageId(id);
	}
}







