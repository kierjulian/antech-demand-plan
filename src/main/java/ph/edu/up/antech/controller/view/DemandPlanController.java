package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/demand-plan")
public class DemandPlanController {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${rest.domain}")
	private String domain;

	@Value("${rest.port}")
	private String port;

	@GetMapping("")
	public String loadDemandPlanPage() {
		return "demand-plan";
	}

	private String buildApiPath() {
		UriComponents uri = UriComponentsBuilder
				.fromHttpUrl("http://{domain}:{port}/api/v1/productSales")
				.buildAndExpand(domain, port);
		return uri.toUriString();
	}

}
