package dto;

public class Address extends Entity {
	private int postcode;
	private String city;
	private String street;
	private String house;
	private int flat;

	public Address() {
	}

	public Address(int id, int postcode, String city, String street, String house, int flat) {
		super(id);
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.house = house;
		this.flat = flat;
	}

	public Address(int postcode, String city, String street, String house, int flat) {
		this.postcode = postcode;
		this.city = city;
		this.street = street;
		this.house = house;
		this.flat = flat;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public int getFlat() {
		return flat;
	}

	public void setFlat(int flat) {
		this.flat = flat;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", postcode=" + postcode + ", city=" + city + ", street=" + street + ", house="
				+ house + ", flat=" + flat + "]";
	}
}
