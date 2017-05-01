package tn.devstorm.restclient;

import java.io.IOException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.typicode.jsonplaceholder.Product;

public class ProductResourceClient {
	public static void main(String []args) throws JsonParseException, JsonMappingException, IOException{
		 ProductResourceClient src=new ProductResourceClient();
		System.out.println(src.getProduct(2));
		System.out.println(src.getProducts());
	}

	public List<Product> getProducts(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/Product/getall");
		List<Product> Products = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {});
		client.close();
		return Products;
		
	}
	public Product getProduct(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Product");
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();;
		Product Product=response.readEntity(Product.class);
		response.close();
		client.close();
		return Product;
		
	}
		
	
	
	public int deleteProduct(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Product");
		Response response=baseUrl.request().header("id", id).delete();
		return response.getStatus();
	}
	
	public int addProduct(Product Product){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Product");
		Response response=baseUrl.request().post(Entity.entity(Product, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateProduct(Product Product){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Product");
		Response response=baseUrl.request().header("id", Product.getProductId()).put(Entity.entity(Product, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
    

}
