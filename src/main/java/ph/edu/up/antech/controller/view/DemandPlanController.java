package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ph.edu.up.antech.domain.ProductSales;

import java.util.List;

@Controller
@RequestMapping("/demand-plan")
public class DemandPlanController {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${rest.domain}")
	private String domain;

	@Value("${rest.port}")
	private String port;

	@GetMapping("")
	public String loadDemandPlanPage(Model model) {
		String apiPath = getProductSalesApiPath();
		ResponseEntity<List<ProductSales>> responseEntity =
				restTemplate.exchange(apiPath, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<ProductSales>>() {
						});

		List<ProductSales> productSalesList = responseEntity.getBody();
		model.addAttribute("productSalesList", productSalesList);
		return "demand-plan";
	}

	private String getProductSalesApiPath() {
		UriComponents uri = UriComponentsBuilder
				.fromHttpUrl("http://{domain}:{port}/api/v1/productSales")
				.buildAndExpand(domain, port);
		return uri.toUriString();
	}

}
