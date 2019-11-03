package ph.edu.up.antech.controller.rest.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ph.edu.up.antech.domain.Product;

import java.util.List;

@Component
public class ProductRestClient {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${rest.domain}")
	private String domain;

	@Value("${rest.port}")
	private String port;

	public List<Product> findAllProducts() {
		ResponseEntity<List<Product>> responseEntity =
				restTemplate.exchange(getProductApiPath(), HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Product>>() {
						});
		return responseEntity.getBody();
	}

	public List<Product> findProductsByCode(String code) {
		String apiPath = getProductApiPath() + "/?code=" + code;

		ResponseEntity<List<Product>> responseEntity =
				restTemplate.exchange(apiPath, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Product>>() {
						});
		return responseEntity.getBody();
	}

	public Product findProductById(Integer id) {
		String apiPath = getProductApiPath() + "/" + id;
		return restTemplate.getForObject(apiPath, Product.class);
	}

	public void createProduct(Product product) {
		restTemplate.postForObject(getProductApiPath(), product, Product.class);
	}

	private String getProductApiPath() {
		UriComponents uri = UriComponentsBuilder
				.fromHttpUrl("http://{domain}:{port}/api/v1/products")
				.buildAndExpand(domain, port);
		return uri.toUriString();
	}

}
