package tn.devstorm.restclient;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.typicode.jsonplaceholder.Rate;


public class RateResouceClient {

	public static void main (String [] args){
		RateResouceClient urc =new RateResouceClient();
		System.out.println(urc.getRates());
	}
	public List<Rate> getRates(){
		Client client = ClientBuilder.newClient();
		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/Rate/getall");
		List<Rate> Rates = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Rate>>() {});
		client.close();
		return Rates;
		
	}
	public Rate getRate(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Rate");		
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();
		Rate rate =response.readEntity(Rate.class);
		response.close();		
		return rate;		
	}
	
	public int deleteRate(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Rate");		
		Response response=baseUrl.request().header("id",id).delete();
		return response.getStatus();
	}
	
	public int addRate(Rate Rate){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Rate");
		Response response=baseUrl.request().post(Entity.entity(Rate, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
	
	public int updateRate(Rate rate){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Rate");		
		Response response=baseUrl.request().header("id", rate.getInteractionId()).put(Entity.entity(rate, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}

}
