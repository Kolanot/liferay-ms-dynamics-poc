package ms.dynamics.accounts.portlet.data;

import com.google.gson.JsonElement;

public class MSAccount {

	private String name;
	private String phone;
	private String city;
	private String mail;

	public MSAccount() {
		super();
	}

	public MSAccount(String name, String phone, String city, String mail) {
		super();
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.mail = mail;
	}

	public MSAccount(JsonElement account) {
		super();
		
		this.name = getJsonElementField(account, "name");
		this.phone = getJsonElementField(account, "telephone1");
		this.city = getJsonElementField(account, "address1_city");
		this.mail = getJsonElementField(account, "emailaddress1");

		
	}
	
	private String getJsonElementField(JsonElement account, String field) {
		JsonElement jsonElement = account.getAsJsonObject().get(field);
		
		String result = "-";
		
		if (!jsonElement.isJsonNull()) {
			result = jsonElement.getAsString();
		} 
		
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "MSAccount [name=" + name + ", phone=" + phone + ", city=" + city + ", mail=" + mail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MSAccount other = (MSAccount) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

}
