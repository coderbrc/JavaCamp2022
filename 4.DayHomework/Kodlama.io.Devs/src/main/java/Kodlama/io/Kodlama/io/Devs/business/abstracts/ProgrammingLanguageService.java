package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.business.requests.programminglanguage.ProgrammingLanguageRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.programminglanguages.ProgrammingLanguageResponse;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguageResponse> getAll();

	public ProgrammingLanguageResponse getById(int id);

	public ProgrammingLanguageResponse add(ProgrammingLanguageRequest programmingLanguageRequest);

	public void delete(int id);

	public ProgrammingLanguageResponse update(ProgrammingLanguageRequest programmingLanguageRequest, int id);

	public ProgrammingLanguage getProgrammingLanguageById(int id);
}
