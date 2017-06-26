package usermanagement.app.user;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class UserForm implements Serializable {

    // (1)
    public static interface ShowUsers {
    };

    public static interface ShowUpdateForm {
    };

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(groups = { ShowUpdateForm.class })
	@Size(min = 0, max = 255, groups = { ShowUsers.class, ShowUpdateForm.class })
	private String userId;

	@NotNull
	@Size(min = 0, max = 255, groups = { ShowUsers.class })
	private String username;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date birthday;

	@NotNull
	@Size(min = 0, max = 255, groups = { ShowUsers.class })
	private String address;

	@NotNull
	@Size(min = 0, max = 255, groups = { ShowUsers.class })
	private String telNum;

	@NotNull
	@Size(min = 0, max = 255, groups = { ShowUsers.class })
	private String roles;

	@NotNull
	@Size(min = 1, max = 255)
	private String noEncodedPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getNoEncodedPassword() {
		return noEncodedPassword;
	}

	public void setNoEncodedPassword(String password) {
		this.noEncodedPassword = password;
	}

}
