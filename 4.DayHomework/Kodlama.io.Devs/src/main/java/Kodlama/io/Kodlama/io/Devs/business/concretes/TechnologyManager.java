package Kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Kodlama.io.Devs.business.requests.technology.TechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.technologies.TechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageService programmingLanguageService;

	public TechnologyManager(TechnologyRepository technologyRepository,
			ProgrammingLanguageService programmingLanguageService) {
		super();
		this.technologyRepository = technologyRepository;
		this.programmingLanguageService = programmingLanguageService;
	}

	@Override
	public List<TechnologyResponse> getAll() {
		List<Technology> technologies = this.technologyRepository.findAll();
		List<TechnologyResponse> getAllTechnologyResponseList = new ArrayList<TechnologyResponse>();
		for (Technology technology : technologies) {
			getAllTechnologyResponseList.add(createTechnologyResponse(technology));
		}
		return getAllTechnologyResponseList;
	}

	@Override
	public TechnologyResponse getById(int id) {
		return createTechnologyResponse(technologyRepository.findById(id).get());
	}

	@Override
	public TechnologyResponse add(TechnologyRequest technologyRequest) {
		Technology technology = new Technology();
		if (isTechnologyExist(technologyRequest.getName())) {
			throw new RuntimeException("Eklenmeye çalışılan isim mevcut.");
		}
		if (technologyRequest.getName().isBlank()) {
			throw new IllegalArgumentException("Programa dili boş geçilemez.");
		}
		technology.setName(technologyRequest.getName());

		technology.setProgrammingLanguage(
				programmingLanguageService.getProgrammingLanguageById(technologyRequest.getProgrammingLanguageId()));
																														
		return createTechnologyResponse(technologyRepository.save(technology));
	}

	@Override
	public void delete(int id) {
		if (!technologyRepository.existsById(id)) {
			throw new RuntimeException("Silinmeye çalışılan dil mevcut değildir.");
		}
		technologyRepository.deleteById(id);
	}

	@Override
	public TechnologyResponse update(TechnologyRequest technologyRequest, int id) {
		Technology technology = technologyRepository.findById(technologyRequest.getId()).get();
		ProgrammingLanguage programmingLanguage = programmingLanguageService
				.getProgrammingLanguageById(technologyRequest.getProgrammingLanguageId());
		if (isTechnologyExist(technologyRequest.getName())) {
			throw new RuntimeException("Eklemeye çalışılan isim mevcut.");
		}
		if (technologyRequest.getName().isBlank()) {
			throw new IllegalArgumentException("Programa dili boş geçilemez.");
		}
		technology.setName(technologyRequest.getName());
		technology.setProgrammingLanguage(programmingLanguage);
		return createTechnologyResponse(technologyRepository.save(technology));
	}

	public boolean isTechnologyExist(String name) {
		for (Technology technologyLoop : technologyRepository.findAll()) {
			if (technologyLoop.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Technology getTechnologyById(int id) {
		return this.technologyRepository.findById(id).get();
	}

	private TechnologyResponse createTechnologyResponse(Technology technology) {
		TechnologyResponse technologyResponse = new TechnologyResponse();
		technologyResponse.setId(technology.getId());
		technologyResponse.setName(technology.getName());
		technologyResponse.setProgrammingLanguageId(technology.getProgrammingLanguage().getId());
		return technologyResponse;
	}

	@Override
	public List<TechnologyResponse> getAllByLanguageId(int languageId) {
		List<TechnologyResponse> technologyResponseList = new ArrayList<TechnologyResponse>();
		for (Technology technology : technologyRepository.findAllByProgrammingLanguage_Id(languageId)) {
			technologyResponseList.add(createTechnologyResponse(technology));
		}
		return technologyResponseList;

	}

}
