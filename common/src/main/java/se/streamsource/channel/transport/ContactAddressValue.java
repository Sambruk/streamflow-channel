package se.streamsource.channel.transport;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ContactAddressValue {

	public enum ContactType
	   {
	      HOME, WORK, OTHER
	   }

	   ContactType contactType;

	   String address;

	   String zipCode;

	   String city;

	   String region;

	   String country;

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
