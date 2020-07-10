package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.binding.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;

	@GetMapping(value={ "/" , "/loadform"}) 
	public String loadForm(Model model) {

		Contact contact = new Contact(); 
		model.addAttribute("contact", contact);
		return "index";

	}



	@PostMapping(value="/saveContact")
	public String handelSubmitBtn(@ModelAttribute("contact") Contact contact,RedirectAttributes attribute) {

		boolean saveContact = contactService.saveContact(contact);

			if(saveContact) {
				attribute.addFlashAttribute("successMsg","Contact Saved.");
			}
			else {
				attribute.addFlashAttribute("errorMsg", "contactNot saved.");
			}

		return "redirect:/loadform"; 

	}

	@GetMapping(value="/viewAllContact")
	public String viewAllContact(Model model) {

		List<Contact> allContacts = contactService.getAllContacts();

		model.addAttribute("contactList",allContacts);

		return "viewAllContact";

	}

}
