package tn.devstorm.restclient;

import java.util.List;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.typicode.jsonplaceholder.User;

public class UserResourceClient {

	public static void main (String [] args){
		UserResourceClient urc =new UserResourceClient();
		System.out.println(urc.getUsers());
		User u =urc.getUser(8);
		u.setUsername("testing");
		u.setCity("Ariana");
		u.setStreet("ghazela");
		urc.updateUser(u);
		System.out.println(urc.getUsers());
	}
	public List<User> getUsers(){
		Client client = ClientBuilder.newClient();
		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/User/getall");
		List<User> Users = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<User>>() {});
		client.close();
		return Users;
		
	}
	public User getUser(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/User");		
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();
		User user =response.readEntity(User.class);
		response.close();		
		return user;		
	}
	
	public int deleteUser(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/User");		
		Response response=baseUrl.request().header("id",id).delete();
		return response.getStatus();
	}
	
	public int addUser(User User){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/User");
		Response response=baseUrl.request().post(Entity.entity(User, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
	
	public int updateUser(User user){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/User");		
		Response response=baseUrl.request().header("id", user.getUserId()).put(Entity.entity(user, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}



}
