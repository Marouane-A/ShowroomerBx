package tn.devstorm.restclient;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.typicode.jsonplaceholder.Comment;

public class CommentResourceClient {
	public static void main(String []args) {

		
	}

	public List<Comment> getComments(){
		Client client = ClientBuilder.newClient();

		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/Comment/getall");
		List<Comment> Comments = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Comment>>() {});
		client.close();
		return Comments;
		
	}
	public Comment getComment(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Comment");
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();;
		Comment Comment=response.readEntity(Comment.class);
		response.close();
		client.close();
		return Comment;
		
	}
		
	
	
	public int deleteComment(int id){
		Client client = ClientBuilder.newClient();

		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Comment");
		Response response=baseUrl.request().header("id", id).delete();
		return response.getStatus();
	}
	
	public int addComment(Comment Comment){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Comment");
		Response response=baseUrl.request().post(Entity.entity(Comment, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
	
	public int updateComment(Comment Comment){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Comment");
		Response response=baseUrl.request().header("id", Comment.getUserId()).put(Entity.entity(Comment, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}


}
