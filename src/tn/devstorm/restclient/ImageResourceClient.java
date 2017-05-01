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
import com.typicode.jsonplaceholder.Image;

public class ImageResourceClient {
	public static void main(String []args) throws JsonParseException, JsonMappingException, IOException{
		 ImageResourceClient src=new ImageResourceClient();
		System.out.println(src.getImage(1));
		System.out.println(src.getImages());
	}

	public List<Image> getImages(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/Image/getall");
		List<Image> Images = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Image>>() {});
		client.close();
		return Images;
		
	}
	public Image getImage(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Image");
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();;
		Image Image=response.readEntity(Image.class);
		response.close();
		client.close();
		return Image;
		
	}
		
	
	
	public int deleteImage(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Image");
		Response response=baseUrl.request().header("id", id).delete();
		return response.getStatus();
	}
	
	public int addImage(Image Image){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Image");
		Response response=baseUrl.request().post(Entity.entity(Image, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
	
	public int updateImage(Image Image){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Image");
		Response response=baseUrl.request().header("id", Image.getImageId()).put(Entity.entity(Image, MediaType.APPLICATION_JSON));
		
		return response.getStatus();
	}
    

}
