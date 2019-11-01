package ph.edu.up.antech.controller.rest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ph.edu.up.antech.domain.ProductSales;

import java.util.List;

@Ignore
public class ProductSalesControllerTest {

	@Test
	public void accessApiForSalesProductController_ifApplicationIsDeployed_shouldBeSuccessful() {
		String uri = "http://localhost:8080/api/v1/productSales/";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<ProductSales>> responseEntity =
				restTemplate.exchange(uri, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<ProductSales>>() {
						});
		List<ProductSales> productSalesList = responseEntity.getBody();
		Assert.assertNotNull(productSalesList);
	}

	@Test
	public void createSalesProductObject_usingDummyData_shouldBeSuccessful() {
		String uri = "http://localhost:8080/api/v1/productSales/";
		RestTemplate restTemplate = new RestTemplate();
		ProductSales productSales = restTemplate.postForObject(uri, "", ProductSales.class);
		Assert.assertNotNull(productSales);
	}

}
