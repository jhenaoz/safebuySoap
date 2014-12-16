
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.talosdigital.safebuy.model.Category;
import com.talosdigital.safebuy.persistence.dao.StoreDao;
import com.talosdigital.safebuy.restcontroller.dto.ProductDto;
import com.talosdigital.safebuy.restcontroller.dto.StoreDto;

public class ProductIntegrationTest {

	private RestTemplate restTemplate;
	private String baseUrl = "http://localhost:8080/rest/";
	private StoreDto storeDto;
	
	@Before
	public void setUp() throws Exception {
		restTemplate = new RestTemplate();
		StoreDto requestStoreDto = new StoreDto();
		requestStoreDto.setName("Talos's Store");
		requestStoreDto.setNit("7357N17");
		this.storeDto = restTemplate.postForObject(
				baseUrl + "store/",
				requestStoreDto,
				StoreDto.class);
	}

	@Test
	public void testCreateProduct() {
		ProductDto requestDto = new ProductDto();
		requestDto.setCategory(Category.ELECTRONICS);
		requestDto.setName("Robodog");
		requestDto.setPrice(100000.0f);
		requestDto.setStockQuantity(2);
		requestDto.setStoreDto(storeDto);
		
		ProductDto productDto = restTemplate.postForObject(baseUrl + "product/", requestDto, ProductDto.class);
		assertEquals(Category.ELECTRONICS, productDto.getCategory());
		assertEquals("Robodog", productDto.getName());
		assertEquals(new Float(100000.0f), new Float(productDto.getPrice()));
		assertEquals(2, productDto.getStockQuantity());
		restTemplate.delete(baseUrl + "product/" + productDto.getId());
	}
	
	@Test
	public void testUpdateProduct(){
		ProductDto requestDto = new ProductDto();
		requestDto.setCategory(Category.ELECTRONICS);
		requestDto.setName("Robodog");
		requestDto.setPrice(100000.0f);
		requestDto.setStockQuantity(2);
		requestDto.setStoreDto(storeDto);
		ProductDto productDto = restTemplate.postForObject(
				baseUrl + "product/",
				requestDto,
				ProductDto.class);
		productDto.setStockQuantity(productDto.getStockQuantity() - 1);
		restTemplate.put(baseUrl + "product/", productDto);
		ProductDto updatedProductDto = restTemplate.getForObject(
				baseUrl + "product/" + productDto.getId(),
				ProductDto.class);
		assertEquals(productDto.getStockQuantity(), updatedProductDto.getStockQuantity());
		restTemplate.delete(baseUrl + "product/" + productDto.getId());
	}

	@After
	public void tearDown() throws Exception {
		restTemplate.delete(baseUrl + "store/" + storeDto.getId());
	}

}
