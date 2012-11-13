package se.streamsource.channel.transport;

public class ContactEmailValue {
	public enum ContactType
	   {
	      HOME, WORK, OTHER
	   }

	   ContactType contactType;

	   String emailAddress;

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
