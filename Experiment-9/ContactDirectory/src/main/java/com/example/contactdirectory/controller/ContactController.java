package com.example.contactdirectory.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.contactdirectory.model.Contact;
import com.example.contactdirectory.service.ContactService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping
    public Contact createContact(@Valid @RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @Valid @RequestBody Contact contact) {
        return contactService.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "Contact with ID " + id + " deleted successfully!";
    }

    @GetMapping("/search/name")
    public List<Contact> searchByName(@RequestParam String name) {
        return contactService.searchByName(name);
    }

    @GetMapping("/search/phone")
    public List<Contact> searchByPhone(@RequestParam String phone) {
        return contactService.searchByPhone(phone);
    }
}
