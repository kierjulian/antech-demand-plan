package ph.edu.up.antech.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.service.CustomerService;
import ph.edu.up.antech.util.StringUtils;

import java.util.List;

@Controller
@RequestMapping("/general/customers")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String loadCustomerPage(Model model, @RequestParam(required = false) String code) {
        List<Customer> customerList = !StringUtils.isNullOrEmpty(code) ?
                customerService.findAllCustomersByCustomerCode(code) :
                customerService.findAllCustomers();

        model.addAttribute("searchedCode", code);
        model.addAttribute("customerList", customerList);
        return "customer";
    }

    @GetMapping("/view/{id}")
    public String viewCustomer(Model model, @PathVariable Integer id) {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer-view";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(Model model, @PathVariable Integer id) {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer-edit";
    }

    @PostMapping("/update")
    public String updateCustomer(RedirectAttributes redirectAttributes,
                                 @ModelAttribute(value = "customer") Customer customer) {
        try {
            customerService.updateCustomer(customer);
            redirectAttributes.addFlashAttribute("successMessage", "Customer was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/general/customers/view/" + customer.getId();
    }

    @GetMapping("/add")
    public String addCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-add";
    }

    @PostMapping("/create")
    public String createCustomer(RedirectAttributes redirectAttributes,
                                 @ModelAttribute(value = "customer") Customer customer) {
        try {
            customer = customerService.createCustomer(customer);
            redirectAttributes.addFlashAttribute("successMessage", "Customer was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/general/customers/view/" + customer.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            customerService.deleteCustomer(id);
            redirectAttributes.addFlashAttribute("successMessage", "Customer was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/general/customers";
    }

}
