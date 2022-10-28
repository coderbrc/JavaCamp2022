package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();

	public ProgrammingLanguage getById(int Id);

	public void add( ProgrammingLanguage programmingLanguage);

	public void delete(int Id);

	public void update(ProgrammingLanguage programmingLanguage);
}
