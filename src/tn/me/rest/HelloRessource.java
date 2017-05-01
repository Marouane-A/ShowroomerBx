package tn.me.rest;



import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.typicode.jsonplaceholder.Product;
import com.typicode.jsonplaceholder.Purchase;
import com.typicode.jsonplaceholder.Rate;

import tn.devstorm.restclient.ProductResourceClient;
import tn.devstorm.restclient.PurchaseResourceClient;
import tn.devstorm.restclient.RateResouceClient;


@Path("/stats")
@RequestScoped
public class HelloRessource {
	RateResouceClient rc =new RateResouceClient();
	ProductResourceClient pc = new ProductResourceClient();
	PurchaseResourceClient prc = new PurchaseResourceClient();
	
	@GET
	public void stats(){
		
	}
	@GET @Path("/sumOfRates")
    @Produces({MediaType.APPLICATION_JSON})
    public Response sumOfRates(){
		List<Rate> rates = rc.getRates();
    	OptionalDouble x= rates.stream().mapToDouble(p->p.getMark()).average();
    	 JsonObject json = Json.createObjectBuilder().add("sum_rate", x.toString()).build();		 
		 return Response.ok(json).build();
    }
	@GET @Path("/averageRate")
    @Produces({MediaType.APPLICATION_JSON})
    public Response averageRate(){
		List<Rate> rates = rc.getRates();
    	OptionalDouble x=rates.stream().mapToDouble(p->p.getMark()).average();
    	JsonObject json = Json.createObjectBuilder().add("avg_rate", x.toString()).build();		 
		 return Response.ok(json).build();
    }
	@GET @Path("/sumOfRatesPerUser")
    @Produces({MediaType.APPLICATION_JSON})
    public Response sumOfRatesPerUser(@HeaderParam("id") int id){
		List<Rate> rates = rc.getRates();
    	double x= rates.stream().filter(m->m.getUserId()==id).count();
    	JsonObject json = Json.createObjectBuilder().add("sum_rate_user", x).build();		 
		 return Response.ok(json).build();
    }
	@GET @Path("/sumOfRatesPerProduct")
    @Produces({MediaType.APPLICATION_JSON})
    public Response sumOfRatesPerProduct(@HeaderParam("id") int id){
		List<Rate> rates = rc.getRates();
    	double x= rates.stream().filter(m->m.getProductId()==id).count();
    	JsonObject json = Json.createObjectBuilder().add("su_rate_product", x).build();		 
		 return Response.ok(json).build();
    }
	@GET @Path("/ProductsByMostQuantity")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMostQuantity(){
		List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getQuantity).reversed())
    			.collect(Collectors.toList());
    	
    }
	@GET @Path("/ProductsByMinQuantity")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMinQuantity(){
		List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getQuantity))
    			.collect(Collectors.toList());
    }
	@GET @Path("/ProductsByMaxPrice")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMaxPrice(){
		List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getPrice).reversed())
    			.collect(Collectors.toList());
    }
	@GET @Path("/ProductsByMinPrice")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMinPrice(){
		List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getPrice))
    			.collect(Collectors.toList());
    }
	@GET @Path("/ProductsByMaxInteraction")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductsByMaxInteraction(){
		List<Product> products = pc.getProducts();
    	return products.stream().sorted((e1,e2)->e1.getInteractions().size()-(e2.getInteractions()).size())
    			.collect(Collectors.toList());
    }
	@GET @Path("/SumOfPurchases")
    @Produces({MediaType.APPLICATION_JSON})
    public Response SumOfPurchases(){
		List<Purchase> purchases=prc.getPurchases();
    	double x=purchases.stream().count();
    	JsonObject json = Json.createObjectBuilder().add("sum_purchases", x).build();		 
		 return Response.ok(json).build();
    }
	@GET @Path("/ProductBestOffer")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> ProductBestOffer(){
		List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getDiscount).reversed())
    			.collect(Collectors.toList());
    }
}
