package tn.devstorm.restclient;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.typicode.jsonplaceholder.Voucher;


public class VoucherResourceClient {
	public static void main (String [] args){
		VoucherResourceClient urc =new VoucherResourceClient();
		System.out.println(urc.getVoucher(2));
	}
	public List<Voucher> getVouchers(){
		Client client = ClientBuilder.newClient();
		WebTarget baseURL = client.target("https://showroomercore.mybluemix.net/api/Voucher/getall");
		List<Voucher> Vouchers = baseURL.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Voucher>>() {});
		client.close();
		return Vouchers;
		
	}
	public Voucher getVoucher(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Voucher");		
		Response response = baseUrl.request(MediaType.APPLICATION_JSON).header("id", id).get();
		Voucher voucher =response.readEntity(Voucher.class);
		response.close();		
		return voucher;		
	}
	
	public int deleteVoucher(int id){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Voucher");		
		Response response=baseUrl.request().header("id",id).delete();
		return response.getStatus();
	}
	
	public int addVoucher(Voucher Voucher){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Voucher");
		Response response=baseUrl.request().post(Entity.entity(Voucher, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
	
	public int updateVoucher(Voucher voucher){
		Client client = ClientBuilder.newClient();
		WebTarget baseUrl = client.target("https://showroomercore.mybluemix.net/api/Voucher");		
		Response response=baseUrl.request().header("id", voucher.getVoucherId()).put(Entity.entity(voucher, MediaType.APPLICATION_JSON));		
		return response.getStatus();
	}
}


