package usermanagement.app.user;

import javax.validation.constraints.NotNull;

public class CheckboxesForm {
	 private String[] checkboxes;

	public String[] getCheckboxes() {
		return checkboxes;
	}

	@NotNull
	public void setCheckboxes(String[] checkboxes) {
		this.checkboxes = checkboxes;
	}

}
