package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Customer;
import peaksoft.service.CustomerService;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerApi {
    private final CustomerService customerService;

    @GetMapping()
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "Customer";
    }

    @GetMapping("/new")
    public String createCustomer(Model model) {
        model.addAttribute("newCustomer", new Customer());
        return "newCustomer";
    }
    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable ("id")Long id,Model model) {
        model.addAttribute("customers", customerService.getCustomerById(id));
        return "CustomerInfo";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") Long id,
                         Model model) {
        model.addAttribute("editCustomer", customerService.getCustomerById(id));
        return "updateCustomer";
    }

    @PostMapping("/updateCustomer/{id}")
    public String saveUpdate(@ModelAttribute("editCustomer") Customer customer,
                             @PathVariable("id") Long id) {
        customerService.updateCustomer(id, customer);
        return "redirect:/customers";
    }
}