package login;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LoginController {
	
	@RequestMapping("/login")
	public Response login(@RequestParam(value="user") String user, @RequestParam(value = "password") String password){
		System.out.println("test");
		if(user.equals("Swati") && password.equals("asd")){
			Response resp = new Response("true", "200Ok");
			return resp;
		}
		Response resp = new Response("false", "404");
		return resp;
	}

}
