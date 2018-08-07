package ru.javabegin.training.objects;

public class User {

	private String userName;
	private String password;
    private String status;
    private int iduser;


	public User() {}

    public User(int iduser) {

		this.iduser = iduser;
	}



	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
