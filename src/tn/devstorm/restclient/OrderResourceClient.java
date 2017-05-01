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
import com.typicode.jsonplaceholder.Order;

public class OrderResourceClient {
	public static void main(String []args) throws JsonParseException, JsonMappingException, IOException{
		 OrderResourceClient src=new OrderResourceClient();
		System.out.println(src.getOrder(1));
		System.out.println(src.getOrders());
	}

	public List<Order> getOrders(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/Order/getall");
		List<Order> Orders = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Order>>() {});
		client.close();
		return Orders;
		
	}
	public Order getOrder(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Order");
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();;
		Order Order=response.readEntity(Order.class);
		response.close();
		client.close();
		return Order;
		
	}
		
	
	
	public int deleteOrder(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Order");
		Response response=baseUrl.request().header("id", id).delete();
		return response.getStatus();
	}
	
	public int addOrder(Order Order){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Order");
		Response response=baseUrl.request().post(Entity.entity(Order, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateOrder(Order Order){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Order");
		Response response=baseUrl.request().header("id", Order.getUserId()).put(Entity.entity(Order, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}


}
