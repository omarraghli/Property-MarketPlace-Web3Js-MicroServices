package fstt.lsi.Controller;


import lombok.Data;

@Data
public class SaveContartResponse {

	private String response;

	public SaveContartResponse(String response) {
		super();
		this.response = response;
	}
}
