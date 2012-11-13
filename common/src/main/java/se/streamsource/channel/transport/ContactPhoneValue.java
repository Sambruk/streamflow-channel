package se.streamsource.channel.transport;

public class ContactPhoneValue {

	public enum ContactType
	   {
	      HOME, WORK, MOBILE, FAX, OTHER
	   }

	   ContactType contactType;

	   String phoneNumber;

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
