package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ph.edu.up.antech.domain.ProductSales;
import ph.edu.up.antech.service.ProductSalesService;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/demand-plan")
public class DemandPlanController {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${rest.domain}")
	private String domain;

	@Value("${rest.port}")
	private String port;

	private List<ProductSales> productSalesList = new ArrayList<>();

	@Autowired
	private ProductSalesService productSalesService;

	@GetMapping("")
	public String loadDemandPlanPage(Model model, @RequestParam(required = false) String productName,
			@RequestParam(required = false) Integer year) {
		model.addAttribute("productSalesList", productSalesService.findAllProductSales());
		return "demand-plan";
	}

	private String getProductSalesApiPath() {
		UriComponents uri = UriComponentsBuilder
				.fromHttpUrl("http://{domain}:{port}/api/v1/productSales")
				.buildAndExpand(domain, port);
		return uri.toUriString();
	}

	@GetMapping("/add")
	public String addEntryToPage(Model model) {
		ProductSales productSales = restTemplate.postForObject(getProductSalesApiPath(),
				null, ProductSales.class);
		productSalesList.add(productSales);
		model.addAttribute("productSalesList", productSalesList);

		return "demand-plan";
	}

}
