package com.laconic.cb.controller;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Address;
import com.laconic.cb.model.Contact;
import com.laconic.cb.model.Customer;
import com.laconic.cb.model.Site;
import com.laconic.cb.service.IAddressService;
import com.laconic.cb.service.IContactService;
import com.laconic.cb.service.ICountryService;
import com.laconic.cb.service.ICustomerService;
import com.laconic.cb.utils.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
        return "/templates/register";
    }

    @GetMapping("/personalContact")
    public String personalContact(Model model, @RequestParam(value = "customerId", required = false) Long customerId,
                                  @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                  ModelMap modelMap) {
        Page<Contact> contactList = contactService.getAllContactPerson(pageNo);
        model.addAttribute("contacts", contactList.getContent().stream().collect(Collectors.toList()));
        List<Contact> contacts = contactList.getContent().stream().collect(Collectors.toList());
        long totalContact = contactService.getTotalContact();
        Pagination.getPagination(modelMap, contactList, totalContact, contacts, "/personalContact");
        getCustomer(model, customerId);
        return "personal/personalContact";
    }

    @GetMapping("/personalAddress")
    public String personalAddress(Model model, ModelMap modelMap,
                                  @RequestParam(value = "customerId", required = false) Long customerId,
                                  @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo) {
        getCustomer(model, customerId);
        addressPageInformation(pageNo, model, modelMap);
        return "personal/personalAddress";
    }

    private void getCustomer(Model model, Long customerId) {
        if (customerId != null) {
            Optional<Customer> customer = customerService.findById(customerId);
            model.addAttribute("customer", customer.get());
        }
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
    public String editAddress(Model model, @PathVariable("id") Long id, ModelMap modelMap) {
        Optional<Address> address = addressService.findById(id);
        if (address.isPresent()) {
            model.addAttribute("address", address.get());
        }
        addressPageInformation(AppConstants.DEFAULT_PAGE, model, modelMap);
        return "personal/personalAddress";
    }

    private void addressPageInformation(int defaultPage, Model model, ModelMap modelMap) {
        Page<Address> addresses = addressService.getAllAddress(defaultPage);
        List<Address> addressList = addresses.getContent().stream().collect(Collectors.toList());
        long totalAddress = addressService.getTotalAddress();
        Pagination.getPagination(modelMap, addresses, totalAddress, addressList, "/personalAddress");
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("addresses", addressList);
    }

    @PostMapping("/addContactPerson")
    public String addContactPerson(RedirectAttributes model, Contact contact) {
        Contact savedContact;
        if (contact.getContactId() != null) {
            savedContact = contactService.updateContactPerson(contact);
        } else savedContact = contactService.saveContactPerson(contact);
        model.addFlashAttribute("customer", savedContact.getCustomer());
        model.addFlashAttribute("contact", savedContact);
        return "redirect:personalContact";
    }
    @GetMapping("/editContactPerson/{id}")
    public String editContactPerson(@PathVariable("id") Long contactId, RedirectAttributes model) {
        Optional<Contact> contact = contactService.findById(contactId);
        if (contact.isPresent()) {
            model.addFlashAttribute("contact", contact.get());
            model.addFlashAttribute("customer", contact.get().getCustomer());
        }
        return "redirect:/personalContact";
    }

    @GetMapping("/deleteContactPerson/{id}")
    public String deleteContactPerson(@PathVariable("id") Long contactId) {
        contactService.softDeleteContact(contactId);
        return "redirect:/personalContact";
    }
}
