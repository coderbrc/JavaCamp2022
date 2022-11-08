package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.TechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.technologies.TechnologyResponse;

@RestController
@RequestMapping("api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}

	@GetMapping
	public List<TechnologyResponse> getAll() {
		return technologyService.getAll();
	}

	@GetMapping("/{id}")
	public TechnologyResponse getById(@PathVariable int id) throws Exception {
		return technologyService.getById(id);
	}

	@PostMapping
	public TechnologyResponse add(@RequestBody TechnologyRequest technologyRequest) throws Exception {
		return technologyService.add(technologyRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws Exception {
		technologyService.delete(id);
	}

	@PutMapping("/{id}")
	public TechnologyResponse update( @RequestBody TechnologyRequest technologyRequest,@PathVariable int id) throws Exception {
		return technologyService.update(technologyRequest,id);
	}
}
