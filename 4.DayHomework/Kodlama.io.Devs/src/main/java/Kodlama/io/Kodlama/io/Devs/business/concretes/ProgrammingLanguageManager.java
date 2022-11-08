package Kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.business.requests.programminglanguage.ProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.programminglanguages.ProgrammingLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguageList = programmingLanguageRepository.findAll();
		List<ProgrammingLanguageResponse> programmingLanguageResponse = new ArrayList<ProgrammingLanguageResponse>();
		for (ProgrammingLanguage programmingLanguage : programmingLanguageList) {
			programmingLanguageResponse.add(createProgrammingLanguageResponse(programmingLanguage));
		}
		return programmingLanguageResponse;
	}

	@Override
	public ProgrammingLanguageResponse getById(int id) {
		return createProgrammingLanguageResponse(programmingLanguageRepository.findById(id).get());
	}

	@Override
	public ProgrammingLanguageResponse add(ProgrammingLanguageRequest programmingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		if (isProgrammingLanguageExist(programmingLanguage.getName())) {
			throw new RuntimeException("Eklenmeye çalışılan isim mevcut.");
		}
		if (programmingLanguageRequest.getName().isBlank()) {
			throw new IllegalArgumentException("Programa dili boş geçilemez.");
		}
		programmingLanguage.setName(programmingLanguageRequest.getName());

		return createProgrammingLanguageResponse(programmingLanguageRepository.save(programmingLanguage));// yok hocam
	}

	@Override
	public void delete(int id) {
		if (!programmingLanguageRepository.existsById(id)) {
			throw new RuntimeException("Silinmeye çalışılan dil mevcut değildir.");
		}
		programmingLanguageRepository.deleteById(id);
	}

	@Override
	public ProgrammingLanguageResponse update(ProgrammingLanguageRequest programmingLanguageRequest, int id) {
		if (!programmingLanguageRepository.existsById(id)) {
			throw new RuntimeException("Id blnamadı.");
		}
		if (!isProgrammingLanguageExist(programmingLanguageRequest.getName())) {
			throw new RuntimeException("Güncellenmeye çalışılan isim mevcut değil.");
		}
		if (programmingLanguageRequest.getName().isBlank()) {
			throw new IllegalArgumentException("Programa dili boş geçilemez.");
		}

		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
		programmingLanguage.setName(programmingLanguageRequest.getName());
		return createProgrammingLanguageResponse(programmingLanguageRepository.save(programmingLanguage));
	}

	public boolean isProgrammingLanguageExist(String name) {
		return programmingLanguageRepository.existsByNameIgnoreCase(name);
	}

	private ProgrammingLanguageResponse createProgrammingLanguageResponse(ProgrammingLanguage programmingLanguage) {
		ProgrammingLanguageResponse programmingLanguageResponse = new ProgrammingLanguageResponse();
		programmingLanguageResponse.setId(programmingLanguage.getId());
		programmingLanguageResponse.setName(programmingLanguage.getName()); 		
		return programmingLanguageResponse;
	}

	@Override
	public ProgrammingLanguage getProgrammingLanguageById(int id) {

		return programmingLanguageRepository.findById(id).get();
	}
}
