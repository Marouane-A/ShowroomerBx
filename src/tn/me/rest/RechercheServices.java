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


@Path("/recherche")
@RequestScoped
public class RechercheServices {
	
	@GET 
	public void recherche(){} 
	ProductResourceClient prc = new ProductResourceClient();
	
	@GET @Path("/findByName/{nomP}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> findByName(@PathParam("nomP") String nomP) {
		List<Product> products = prc.getProducts();
		return products.stream().filter(P -> P.getName().equals(nomP)).collect(Collectors.toList());
	}
	
	
	
	@GET @Path("/findByBrand/{brandP}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> findByBrand(@PathParam("brandP") String brandP) {
		List<Product> products = prc.getProducts();
		return products.stream().filter(P -> P.getBrand().equals(brandP)).collect(Collectors.toList());
	}
	

	
	@GET @Path("/findByCategory/{categoryP}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> findByCategory(@PathParam("categoryP") String categoryP) {
		List<Product> products = prc.getProducts();
		return products.stream().filter(P -> P.getCategory().equals(categoryP)).collect(Collectors.toList());
	}
	

	@GET @Path("/findGlobal/{critere}")
    @Produces({MediaType.APPLICATION_JSON})
	public List<Product> findGlobal(@PathParam("critere") String critere) {
		List<Product> result = null;
		List<Product> resultProductName = findByName(critere);
		List<Product> resultProductBrand = findByBrand(critere);
		List<Product> resultProductCategory = findByCategory(critere);
			
		if (!findByName(critere).isEmpty()) {
			result = resultProductName;
		} else if (!findByBrand(critere).isEmpty()) {
			result = resultProductBrand;
		} else if (!findByCategory(critere).isEmpty()) {
			result = resultProductCategory;
		}
		
		return result;
	}

	
	

}
