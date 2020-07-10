package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.binding.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ContactViewController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value="/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		
		Contact contact = contactService.getContactById(contactId);
		
		model.addAttribute("contact", contact);
		
		return "index";
	}

	
	@GetMapping(value="/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		
		contactService.deleteContact(contactId);
		
		return "redirect:/viewAllContact";
	}
}
