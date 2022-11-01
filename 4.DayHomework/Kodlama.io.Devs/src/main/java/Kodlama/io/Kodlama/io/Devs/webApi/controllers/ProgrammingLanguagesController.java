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

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping(value = "/{id}")
	public ProgrammingLanguage getById(@PathVariable int id) throws Exception {
		return programmingLanguageService.getById(id);
	}

	@PostMapping
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.add(programmingLanguage);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id) throws Exception {
		programmingLanguageService.delete(id);
	}

	@PutMapping
	public void update(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageService.update(programmingLanguage);
	}
}
