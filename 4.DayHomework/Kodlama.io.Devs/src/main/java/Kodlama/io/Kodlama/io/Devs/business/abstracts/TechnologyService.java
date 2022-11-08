package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.business.requests.technology.TechnologyRequest;
import Kodlama.io.Kodlama.io.Devs.business.responses.technologies.TechnologyResponse;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

public interface TechnologyService {
	List<TechnologyResponse> getAll();

	public TechnologyResponse getById(int id);

	public TechnologyResponse add(TechnologyRequest createTechnologyRequest);

	public void delete(int id);

	public TechnologyResponse update(TechnologyRequest updateTechnologyRequest, int id);

	Technology getTechnologyById(int id);

	public List<TechnologyResponse> getAllByLanguageId(int languageId);
}
