package tn.devstorm.restclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.typicode.jsonplaceholder.Purchase;


public class PurchaseResourceClient {
	public static void main (String [] args){
		PurchaseResourceClient urc =new PurchaseResourceClient();
		System.out.println(urc.getPurchase(1));
	}
	public List<Purchase> getPurchases(){
		Client client = ClientBuilder.newClient();
		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/Purchase/getall");
		List<Purchase> Purchases = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Purchase>>() {});
		client.close();
		return Purchases;
		
	}
	public Purchase getPurchase(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Purchase");		
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();
		Purchase purchase =response.readEntity(Purchase.class);
		response.close();		
		return purchase;		
	}
	
	public int deletePurchase(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Purchase");		
		Response response=baseUrl.request().header("id",id).delete();
		return response.getStatus();
	}
	
	public int addPurchase(Purchase Purchase){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Purchase");
		Response response=baseUrl.request().post(Entity.entity(Purchase, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
	
	public int updatePurchase(Purchase purchase){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Purchase");		
		Response response=baseUrl.request().header("id", purchase.getPurchaseId()).put(Entity.entity(purchase, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
}



