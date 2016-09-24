package dto;

public class Reader extends Entity {
	private String surname;
	private String forename;
	private String login;
	private String password;
	private int idAddress;
	private int adminFlag;

	public Reader() {
	}

	public Reader(int id, String surname, String forename, String login, String password, int idAddress,
			int adminFlag) {
		super(id);
		this.surname = surname;
		this.forename = forename;
		this.login = login;
		this.password = password;
		this.idAddress = idAddress;
		this.adminFlag = adminFlag;
	}

	public Reader(String surname, String forename, String login, String password, int idAddress, int adminFlag) {
		this.surname = surname;
		this.forename = forename;
		this.login = login;
		this.password = password;
		this.idAddress = idAddress;
		this.adminFlag = adminFlag;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public int getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(int adminFlag) {
		this.adminFlag = adminFlag;
	}

	@Override
	public String toString() {
		return "Reader [id=" + id + ", surname=" + surname + ", forename=" + forename + ", login=" + login
				+ ", password=" + password + ", idAddress=" + idAddress + ", adminFlag=" + adminFlag + "]";
	}
}
