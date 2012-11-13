package se.streamsource.channel.transport;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@JsonAutoDetect
public class ContactValue {
	
	   String name;

	   String contactId;

	   String company;

	   Boolean isCompany;

	   List<ContactPhoneValue> phoneNumbers;

	   List<ContactEmailValue> emailAddresses;

	   List<ContactAddressValue> addresses;

	   String picture;

	   String note;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Boolean getIsCompany() {
		return isCompany;
	}

	public void setIsCompany(Boolean isCompany) {
		this.isCompany = isCompany;
	}

	public List<ContactPhoneValue> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<ContactPhoneValue> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<ContactEmailValue> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(List<ContactEmailValue> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public List<ContactAddressValue> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<ContactAddressValue> addresses) {
		this.addresses = addresses;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

   public void appendName(String nextName)
   {
      if (name == null || name.isEmpty()) {
         name = nextName;
      } else {
         name = name + " " + nextName;
      }
      
   }

   public void addAddress(ContactAddressValue av)
   {
      handleAddressesNull();
      addresses.add( av );
   }

   private void handleAddressesNull()
   {
      if ( addresses == null) {
         addresses = new ArrayList<ContactAddressValue>();
      }
      
      
   }
}
