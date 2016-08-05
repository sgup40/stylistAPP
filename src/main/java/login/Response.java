package login;

public class Response {
	
	private final String success ;
	private final String reponseCode ;
	
	public Response(String success, String reponseCode) {
		super();
		this.success = success;
		this.reponseCode = reponseCode;
	}
	
	
	public String getSuccess() {
		return success;
	}
	
	public String getReponseCode() {
		return reponseCode;
	}
	
	

}
