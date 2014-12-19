import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.talosdigital.safebuy.model.Category;
import com.talosdigital.safebuy.model.NaturalPersonBuyer;
import com.talosdigital.safebuy.restcontroller.dto.BuyerDto;
import com.talosdigital.safebuy.restcontroller.dto.NaturalPersonBuyerDto;
import com.talosdigital.safebuy.restcontroller.dto.ProductDto;
import com.talosdigital.safebuy.restcontroller.dto.PurchaseDto;
import com.talosdigital.safebuy.restcontroller.dto.StoreDto;


public class PurchaseIntegrationTest {
	
	private static RestTemplate restTemplate;
	private static String baseUrl = "http://localhost:8080/rest/";
	private static StoreDto storeDto;
	private static NaturalPersonBuyerDto buyerDto; 
	private static ArrayList<ProductDto> products;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		restTemplate = new RestTemplate();
		StoreDto requestStoreDto = new StoreDto();
		requestStoreDto.setName("Talos's Store");
		requestStoreDto.setNit("7357N17");
		storeDto = restTemplate.postForObject(
				baseUrl + "store/",
				requestStoreDto,
				StoreDto.class);
		
		NaturalPersonBuyerDto requestBuyerDto = new NaturalPersonBuyerDto();
		requestBuyerDto.setLastName("Carvajal");
		requestBuyerDto.setName("Mateo");
		requestBuyerDto.setStoreDto(storeDto);
		requestBuyerDto.setAge(99);
		requestBuyerDto.setDocumentNumber(9764543);
		buyerDto = restTemplate.postForObject(
				baseUrl + "buyer/natural/",
				requestBuyerDto,
				NaturalPersonBuyerDto.class);
		
		
		ProductDto requestDto = new ProductDto();
		requestDto.setCategory(Category.ELECTRONICS);
		requestDto.setName("Robodog");
		requestDto.setPrice(100000.0f);
		requestDto.setStockQuantity(2);
		requestDto.setStoreDto(storeDto);
		ProductDto product1 = restTemplate.postForObject(
				baseUrl + "product/",
				requestDto,
				ProductDto.class);
		

		requestDto.setName("TV");
		requestDto.setPrice(2000000.0f);
		requestDto.setStockQuantity(4);
		requestDto.setStoreDto(storeDto);
		ProductDto product2 = restTemplate.postForObject(
				baseUrl + "product/",
				requestDto,
				ProductDto.class);
		products = new ArrayList<ProductDto>();
		products.add(product1);
		products.add(product2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		restTemplate.delete(baseUrl + "product/" + products.get(0).getId());
		restTemplate.delete(baseUrl + "product/" + products.get(1).getId());
		restTemplate.delete(baseUrl + "buyer/" + buyerDto.getId());
		restTemplate.delete(baseUrl + "store/" + storeDto.getId());
	}

	@Test
	public void testCreatePurchase() {
		PurchaseDto requestDto = new PurchaseDto();
		requestDto.setNaturalPersonBuyer(buyerDto);
		requestDto.setStore(storeDto);
		requestDto.setProducts(products);
		
		PurchaseDto resultDto = restTemplate.postForObject(
				baseUrl + "purchase/",
				requestDto,
				PurchaseDto.class);
		
		assertEquals(requestDto.getNaturalPersonBuyer().getId(), resultDto.getNaturalPersonBuyer().getId());
		restTemplate.delete(
				baseUrl + "purchase/" +	resultDto.getId());
	}
	
	@Test
	public void testUpdatePurchase() {
		PurchaseDto requestDto = new PurchaseDto();
		requestDto.setNaturalPersonBuyer(buyerDto);
		requestDto.setStore(storeDto);
		requestDto.setProducts(products);
		
		PurchaseDto purchaseResultDto = restTemplate.postForObject(
				baseUrl + "purchase/",
				requestDto,
				PurchaseDto.class);
		
		List<ProductDto> productList = purchaseResultDto.getProducts();
		ProductDto newProduct = new ProductDto();
		newProduct.setCategory(Category.EDUCATION);
		newProduct.setName("Learn to read book");
		newProduct.setPrice(10000.0f);
		newProduct.setStockQuantity(3);
		newProduct.setStoreDto(storeDto);
		
		ProductDto productDtoResponse = restTemplate.postForObject(
				baseUrl + "product/",
				newProduct,
				ProductDto.class);
		
		productList.add(productDtoResponse);
		purchaseResultDto.setProducts(productList);
		
		restTemplate.put(baseUrl + "purchase/", purchaseResultDto);
		PurchaseDto updatedPurchaseDto = restTemplate.getForObject(
				baseUrl + "purchase/" + purchaseResultDto.getId(),
				PurchaseDto.class);
		assertEquals(productDtoResponse.getId(), updatedPurchaseDto.getProducts().get(2).getId());
		
		restTemplate.delete(
				baseUrl + "purchase/" +	purchaseResultDto.getId());
		restTemplate.delete(baseUrl + "product/" + productDtoResponse.getId());
	}
}
