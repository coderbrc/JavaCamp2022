package Kodlama.io.Kodlama.io.Devs.business.responses.technologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyResponse {
	private int id;
	private String name;
	private int programmingLanguageId;
}
