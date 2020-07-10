package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.binding.Contact;
import com.ashokit.entity.ContactEntity;
import com.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact contact) {

		ContactEntity entity = new ContactEntity();

		BeanUtils.copyProperties(contact, entity);

		ContactEntity savedEntity = contactRepo.save(entity);

		return savedEntity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {

		List<ContactEntity> contactEntityList = contactRepo.findAll();

		List<Contact> contactList = new ArrayList<>();

		for(ContactEntity entity : contactEntityList) {

			Contact contact = new Contact();

			BeanUtils.copyProperties(entity, contact);

			contactList.add(contact);
		}

		return contactList;
	}

	@Override
	public Contact getContactById(Integer contaId) {

		Optional<ContactEntity> contactEntity = contactRepo.findById(contaId);

		if(contactEntity.isPresent()) {

			ContactEntity contactEntity2 = contactEntity.get();

			Contact contact = new Contact();

			BeanUtils.copyProperties(contactEntity2, contact);

			return contact;

		}

		return null;
	}

	/*
	 * @Override public boolean deleteContact(Integer contactId) {
	 * 
	 * contactRepo.deleteById(contactId);
	 * 
	 * return false;
	 * 
	 * }
	 */
	
	@Override
	public void deleteContact(Integer contactId) {
		
		contactRepo.deleteById(contactId);
	
	
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

}
