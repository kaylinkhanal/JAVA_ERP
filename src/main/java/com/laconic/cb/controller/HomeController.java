package com.laconic.cb.controller;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Address;
import com.laconic.cb.model.Contact;
import com.laconic.cb.model.Customer;
import com.laconic.cb.service.IAddressService;
import com.laconic.cb.service.IContactService;
import com.laconic.cb.service.ICountryService;
import com.laconic.cb.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.laconic.cb.constants.AppConstants.DEFAULT_PAGE_NUMBER;

@Controller
@RequestMapping("/")
public class HomeController {

    private final ICustomerService customerService;
    private final ICountryService countryService;
    private final IAddressService addressService;
    private final IContactService contactService;

    public HomeController(ICustomerService customerService, ICountryService countryService, IAddressService addressService, IContactService contactService) {
        this.customerService = customerService;
        this.countryService = countryService;
        this.addressService = addressService;
        this.contactService = contactService;
    }

    @GetMapping("/personalRegister")
    public String personalRegister() {
        return "personal/personalRegister";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/personalContact")
    public String personalContact(Model model,
                                  @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo) {
        List<Contact> contactList = contactService.getAllContactPerson(pageNo).stream().collect(Collectors.toList());
        model.addAttribute("contacts", contactList);
        return "personal/personalContact";
    }

    @GetMapping("/personalAddress")
    public String personalAddress(Model model, @RequestParam(value = "customerId", required = false) Long customerId,
                                  @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo) {
        if (customerId != null) {
            Optional<Customer> customer = customerService.findById(customerId);
            model.addAttribute("customer", customer.get());
        }
        addressPageInformation(pageNo, model);
        return "personal/personalAddress";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer, RedirectAttributes model) {
        Customer savedCustomer = customerService.save(customer);
        model.addFlashAttribute("customer", savedCustomer);
        return "redirect:personalRegister";
    }

    @PostMapping("/addAddress")
    public String addPersonalAddress(RedirectAttributes model, Address address) {
//        if (address.getCustomer() != null) {
//            Optional<Customer> customer = customerService.findById(address.getCustomer().getCustomerId());
//        }
        Address savedAddress;
        if (address.getAddressId() != null) {
            savedAddress = addressService.updateAddress(address);
        } else savedAddress = addressService.saveAddress(address);
        model.addFlashAttribute("address", savedAddress);
        model.addFlashAttribute("customer", savedAddress.getCustomer());
        return "redirect:personalAddress?customerId="+savedAddress.getCustomer().getCustomerId();
    }

    @GetMapping("/deleteAddress/{id}")
    public String deleteAddress(@PathVariable("id") Long id) {
        addressService.softDeleteAddress(id);
        return "redirect:/personalAddress";
    }

    @GetMapping("/editAddress/{id}")
    public String editAddress(Model model, @PathVariable("id") Long id) {
        Optional<Address> address = addressService.findById(id);
        if (address.isPresent()) {
            model.addAttribute("address", address.get());
        }
        addressPageInformation(AppConstants.DEFAULT_PAGE, model);
        return "personal/personalAddress";
    }

    private void addressPageInformation(int defaultPage, Model model) {
        List<Address> addressList = addressService.getAllAddress(defaultPage).getContent().stream().collect(Collectors.toList());
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("addresses", addressList);
    }

    @PostMapping("/addContactPerson")
    public String addContactPerson(Model model, @ModelAttribute Contact contact) {
        contactService.saveContactPerson(contact);
        return "redirect:personalContact";
    }

}
