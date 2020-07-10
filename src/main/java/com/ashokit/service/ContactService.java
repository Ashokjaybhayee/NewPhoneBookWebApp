package com.ashokit.service;

import java.util.List;
import com.ashokit.binding.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer contaId);
	
	//public boolean deleteContact(Integer contactId);
	
	public void deleteContact(Integer contactId);
	
	public boolean updateContact(Contact contact);
}
