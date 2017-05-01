package tn.me.rest;



import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import com.typicode.jsonplaceholder.*;
import tn.devstorm.restclient.*;

public class Stats {
	RateResouceClient rc =new RateResouceClient();
	ProductResourceClient pc = new ProductResourceClient();
	PurchaseResourceClient prc = new PurchaseResourceClient();
	public static void main(String[] args) {
		Stats s = new Stats();
		//System.out.println(s.averageRate());
		//System.out.println(s.sumOfRates());
		//System.out.println(s.sumOfRatesPerUser(1));
		//System.out.println(s.sumOfRatesPerProduct(2));
		ProductResourceClient pc2 = new ProductResourceClient();
		List<Product> products = pc2.getProducts();
		System.out.println(products);
		System.out.println("******************");
		System.out.println(s.ProductsByMostQuantity());
		System.out.println("******************");
		System.out.println(s.ProductsByMaxInteraction());
	}
	
    public OptionalDouble averageRate(){
    	List<Rate> rates = rc.getRates();
    	return rates.stream().mapToDouble(p->p.getMark()).average();
    }
    public double sumOfRates(){
    	List<Rate> rates = rc.getRates();
    	return rates.stream().count();
    }
    public double sumOfRatesPerUser(int id){
    	List<Rate> rates = rc.getRates();
    	return rates.stream().filter(m->m.getUserId()==id).count();
    }
    public double sumOfRatesPerProduct(int id){
    	List<Rate> rates = rc.getRates();
    	return rates.stream().filter(m->m.getProductId()==id).count();
    }
    public List<Product> ProductsByMostQuantity(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getQuantity).reversed())
    			.collect(Collectors.toList());
    }
    public List<Product> ProductsByMinQuantity(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getQuantity))
    			.collect(Collectors.toList());
    }
    public List<Product> ProductsByMaxPrice(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getPrice).reversed())
    			.collect(Collectors.toList());
    }
    public List<Product> ProductsByMinPrice(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getPrice))
    			.collect(Collectors.toList());
    }
    public List<Product> ProductsByMaxInteraction(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted((e1,e2)->e1.getInteractions().size()-(e2.getInteractions()).size())
    			.collect(Collectors.toList());
    }
    public double SumOfPurchases(){
    	List<Purchase> purchases=prc.getPurchases();
    	return purchases.stream().count();
    }
    public List<Product> ProductBestOffer(){
    	List<Product> products = pc.getProducts();
    	return products.stream().sorted(Comparator.comparing(Product::getDiscount).reversed())
    			.collect(Collectors.toList());
    }
}
