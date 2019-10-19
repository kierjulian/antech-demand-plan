package ph.edu.up.antech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemandPlanController {

	@GetMapping("/demand-plan")
	public String loadDemandPlanPage() {
		return "demand-plan";
	}

}
