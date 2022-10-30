package Kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {
	List<ProgrammingLanguage> programmingLanguages;

	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(0, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(1, "PYTHON"));
		programmingLanguages.add(new ProgrammingLanguage(2, "JAVA"));
		programmingLanguages.add(new ProgrammingLanguage(3, "KOTLİN"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int Id) {
		return programmingLanguages.get(Id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void delete(int Id) {
		programmingLanguages.remove(Id);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		ProgrammingLanguage updateToProgrammingLanguage=getById(programmingLanguage.getId());
		updateToProgrammingLanguage.setName(programmingLanguage.getName());
//		for (ProgrammingLanguage language : programmingLanguages) {
//			if (language.getId() == programmingLanguage.getId()) {
//				language.setName(programmingLanguage.getName());
//			}
//		}
	}
}
