package tn.devstorm.restclient;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.typicode.jsonplaceholder.Buyer;

public class BuyerResourceClient {
	public static void main(String []args) throws JsonParseException, JsonMappingException, IOException{
		 BuyerResourceClient src=new BuyerResourceClient();

		System.out.println(src.getBuyer(2)); 
		System.out.println(src.getBuyers());
	
		

	}

	public List<Buyer> getBuyers(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/Buyer/getall");
		List<Buyer> buyers = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Buyer>>() {});
		client.close();
		return buyers;
		
	}
	public Buyer getBuyer(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Buyer");
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();;
		Buyer Buyer=response.readEntity(Buyer.class);
		response.close();
		client.close();
		return Buyer;
		
	}
		
	
	
	public int deleteBuyer(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Buyer");
		Response response=baseUrl.request().header("id", id).delete();
		return response.getStatus();
	}
	
	public int addBuyer(Buyer buyer){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Buyer");
		Response response=baseUrl.request().post(Entity.entity(buyer, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
	
	public int updateBuyer(Buyer buyer){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Buyer");
		Response response=baseUrl.request().header("id", buyer.getUserId()).put(Entity.entity(buyer, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}


}
