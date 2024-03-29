package com.laconic.cb.controller;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Address;
import com.laconic.cb.model.ContactPerson;
import com.laconic.cb.model.Customer;
import com.laconic.cb.model.dto.CustomerResponse;
import com.laconic.cb.service.IAddressService;
import com.laconic.cb.service.IContactPersonService;
import com.laconic.cb.service.ICountryService;
import com.laconic.cb.service.ICustomerService;
import com.laconic.cb.utils.Pagination;
import com.laconic.cb.utils.SessionStorage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    private final IContactPersonService contactService;

    public HomeController(ICustomerService customerService, ICountryService countryService, IAddressService addressService, IContactPersonService contactService) {
        this.customerService = customerService;
        this.countryService = countryService;
        this.addressService = addressService;
        this.contactService = contactService;
    }

    @GetMapping("/personalRegister")
    public String personalRegister() {
        return "personal/personalRegister";
    }

    @GetMapping("/")
    public String register(HttpSession session) {
        return "/templates/register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        SessionStorage.destroy(session);
        return "/templates/register";
    }

    @GetMapping("/personalContact")
    public String personalContact(Model model, HttpSession session,
                                  @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                  ModelMap modelMap) {
        Customer customer = getCustomer(model, session);
        Page<ContactPerson> contactList = contactService.getAllContactPerson(pageNo, customer.getCustomerId());
        model.addAttribute("contacts", contactList.getContent().stream().collect(Collectors.toList()));
        List<ContactPerson> contacts = contactList.getContent().stream().collect(Collectors.toList());
        long totalContact = contactService.getTotalContact();
        Pagination.getPagination(modelMap, contactList, totalContact, contacts, "/personalContact");

        return "personal/personalContact";
    }

    @GetMapping("/personalAddress")
    public String personalAddress(Model model, ModelMap modelMap,
                                  HttpSession session,
                                  @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo) {
        getCustomer(model, session);
        addressPageInformation(pageNo, model, modelMap, session);
        return "personal/personalAddress";
    }

    private Customer getCustomer(Model model, HttpSession session) {
        Customer customer = (Customer) SessionStorage.getStorage(session, "customer");
        if (customer != null) {
            model.addAttribute("customer", customer);
            return customer;
        }
        return null;
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer, RedirectAttributes model, HttpSession session) {
        Customer savedCustomer;
        if (customer.getCustomerId() != null) {
            savedCustomer = customerService.update(customer);
        } else {
            savedCustomer = customerService.save(customer);
        }
        SessionStorage.setStorage(session, "customer", savedCustomer);
        model.addFlashAttribute("customer", savedCustomer);
        model.addFlashAttribute("success", true);
        return customer.getCompanyName() != null  ? "redirect:companyRegister" : "redirect:personalRegister";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.softDelete(id);
        return "redirect:/customerList";
    }

    @GetMapping("/customerList")
    public String customerList(Model model, HttpSession session,
                               @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                               ModelMap modelMap) {
        Page<Customer> customerPage = customerService.getAllCustomer(pageNo);
        List<Customer> customerList = customerPage.getContent().stream().collect(Collectors.toList());
        model.addAttribute("customers", customerList);
        long totalCustomers = customerService.getTotalCustomers();
        Pagination.getPagination(modelMap, customerPage, totalCustomers, customerList, "/customerList");
        getCustomer(model, session);
        return "personal/customerList";
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> getCustomerList() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/findCustomer/{id}")
    @ResponseBody
    public Customer findCustomer(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            return  customer.get();
        }
        return null;
    }

    @GetMapping("/searchCustomer")
    @ResponseBody
    public List<Customer> searchCustomer(@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword) {
        return customerService.findCustomer(keyword);
    }

    @GetMapping("/editCustomer/{id}")
    public String editCustomer(Model model, @PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
        }
        return "personal/personalRegister";
    }

    @PostMapping("/addAddress")
    public String addPersonalAddress(RedirectAttributes model, Address address) {
        Address savedAddress;
        if (address.getAddressId() != null) {
            savedAddress = addressService.updateAddress(address);
        } else savedAddress = addressService.saveAddress(address);
//        model.addFlashAttribute("address", savedAddress);
        model.addFlashAttribute("success", true);
        return "redirect:/personalAddress";
    }

    @GetMapping("/deleteAddress/{id}")
    public String deleteAddress(@PathVariable("id") Long id) {
        addressService.softDeleteAddress(id);
        return "redirect:/personalAddress";
    }

    @GetMapping("/editAddress/{id}")
    public String editAddress(Model model, @PathVariable("id") Long id, ModelMap modelMap, HttpSession session) {
        Optional<Address> address = addressService.findById(id);
        if (address.isPresent()) {
            model.addAttribute("address", address.get());
            getCustomer(model, session);
        }
        addressPageInformation(AppConstants.DEFAULT_PAGE, model, modelMap, session);
        return "personal/personalAddress";
    }

    private void addressPageInformation(int defaultPage, Model model, ModelMap modelMap, HttpSession session) {
        Customer customer = getCustomer(model, session);
        Page<Address> addresses = addressService.getAllAddress(defaultPage, customer.getCustomerId());
        List<Address> addressList = addresses.getContent().stream().collect(Collectors.toList());
        long totalAddress = addressService.getTotalAddress();
        Pagination.getPagination(modelMap, addresses, totalAddress, addressList, "/personalAddress");
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("addresses", addressList);
    }

    @PostMapping("/addContactPerson")
    public String addContactPerson(RedirectAttributes model, ContactPerson contact) {
        ContactPerson savedContact;
        if (contact.getContactPersonId() != null) {
            savedContact = contactService.updateContactPerson(contact);
        } else savedContact = contactService.saveContactPerson(contact);
//        model.addFlashAttribute("customer", savedContact.getCustomer());
//        model.addFlashAttribute("contact", savedContact);
        model.addFlashAttribute("success", true);
        return "redirect:personalContact";
    }
    @GetMapping("/editContactPerson/{id}")
    public String editContactPerson(@PathVariable("id") Long contactId, RedirectAttributes model) {
        Optional<ContactPerson> contact = contactService.findById(contactId);
        if (contact.isPresent()) {
            model.addFlashAttribute("contact", contact.get());
//            model.addFlashAttribute("customer", contact.get().getCustomer());
        }
        return "redirect:/personalContact";
    }

    @GetMapping("/deleteContactPerson/{id}")
    public String deleteContactPerson(@PathVariable("id") Long contactId) {
        contactService.softDeleteContact(contactId);
        return "redirect:/personalContact";
    }

    @GetMapping("/companyRegister")
    public String companyInformation() {
        return "company/companyInformation";
    }

    @GetMapping("/editCompanyRegister/{id}")
    public String editCompanyRegister(@PathVariable("id") Long id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
        }
        return "company/companyInformation";
    }

}
