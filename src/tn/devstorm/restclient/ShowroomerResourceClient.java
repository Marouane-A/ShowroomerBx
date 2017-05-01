package tn.devstorm.restclient;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.typicode.jsonplaceholder.Showroomer;


public class ShowroomerResourceClient {
	public static void main (String [] args){
		ShowroomerResourceClient urc =new ShowroomerResourceClient();
		//System.out.println(urc.getShowroomer(3));
		Showroomer sh =new Showroomer();
		sh.setUsername("Showroomer");
		sh.setDescription("im not happy with testing ");
		sh.setUserId(11);
		urc.updateShowroomer(sh);
		
	}
	public List<Showroomer> getShowroomers(){
		Client client = ClientBuilder.newClient();
		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/Showroomer/getall");
		List<Showroomer> Showroomers = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Showroomer>>() {});
		client.close();
		return Showroomers;
		
	}
	public Showroomer getShowroomer(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Showroomer");		
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();
		Showroomer showroomer =response.readEntity(Showroomer.class);
		response.close();		
		return showroomer;		
	}
	
	public int deleteShowroomer(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Showroomer");		
		Response response=baseUrl.request().header("id",id).delete();
		return response.getStatus();
	}
	
	public int addShowroomer(Showroomer Showroomer){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Showroomer");
		Response response=baseUrl.request().post(Entity.entity(Showroomer, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
	
	public int updateShowroomer(Showroomer showroomer){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Showroomer");		
		Response response=baseUrl.request().header("id", showroomer.getUserId()).put(Entity.entity(showroomer, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
}