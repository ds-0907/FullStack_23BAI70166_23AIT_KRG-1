package com.example.contactdirectory.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.contactdirectory.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Custom query methods
    List<Contact> findByNameContainingIgnoreCase(String name);
    List<Contact> findByPhoneContaining(String phone);
}
