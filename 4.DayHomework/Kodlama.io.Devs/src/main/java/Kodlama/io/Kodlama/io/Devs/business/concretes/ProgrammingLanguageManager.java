package Kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		if (isProgrammingLanguageExist(programmingLanguage)) {
			throw new RuntimeException("Eklenmeye çalışılan isim mevcut.");
		}
		if (programmingLanguage.getName().isBlank()) {
			throw new IllegalArgumentException("Programa dili boş geçilemez.");
		}
		programmingLanguageRepository.add(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		if (isProgrammingLanguageExist(programmingLanguage)) {
			throw new RuntimeException("Eklemeye çalışılan isim mevcut.");
		}
		if (programmingLanguage.getName().isBlank()) {
			throw new IllegalArgumentException("Programa dili boş geçilemez.");
		}
		programmingLanguageRepository.update(programmingLanguage);
	}

	public boolean isProgrammingLanguageExist(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage language : programmingLanguageRepository.getAll()) {
			if (language == programmingLanguage) {
				return true;
			}
		}
		return false;
	}
}
