package ph.edu.up.antech.controller.view;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.service.CustomerService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/general/customers")
public class CustomerController {

    private static final Logger LOGGER = Logger.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String loadCustomerPage(Model model, @PageableDefault Pageable pageable,
                                   @RequestParam(required = false) String filter) {
        Page<Customer> page = StringUtils.isNullOrEmpty(filter)
                ? customerService.findAll(pageable)
                : customerService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
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
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage(), e);
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
            customer = customerService.saveCustomer(customer);
            redirectAttributes.addFlashAttribute("successMessage", "Customer was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/general/customers/view/" + customer.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            customerService.removeCustomer(id);
            redirectAttributes.addFlashAttribute("successMessage", "Customer was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/general/customers";
    }

}
