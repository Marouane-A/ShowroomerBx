package tn.me.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.typicode.jsonplaceholder.Product;

import tn.devstorm.restclient.ProductResourceClient;


@Path("/tri")
@RequestScoped
public class TriServices {
	
	@GET
	public void tri(){}

	ProductResourceClient prc = new ProductResourceClient();
	
	@GET @Path("/priceLowerThen/{l}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> priceLowerThen(@PathParam("l") int l) {
		List<Product> productsLower = prc.getProducts();
		return productsLower.stream().filter(p -> p.getPrice() < l).collect(Collectors.toList());
	}
	
	@GET @Path("/priceGreaterThen/{g}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> priceGreaterThen(@PathParam("g") int g) {
		List<Product> productsGreater = prc.getProducts();
		return productsGreater.stream().filter(p -> p.getPrice() > g).collect(Collectors.toList());
	}
	
	@GET @Path("/priceBetween/{l}/{g}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> priceBetween(@PathParam("l") int l, @PathParam("g") int g) {
		List<Product> productsBetween = prc.getProducts();
		
		return productsBetween.stream().filter(p -> (p.getPrice()) > l && (p.getPrice()) < g).collect(Collectors.toList());				
	}
}
