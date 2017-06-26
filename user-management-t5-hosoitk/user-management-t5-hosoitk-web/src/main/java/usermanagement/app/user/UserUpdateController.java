package usermanagement.app.user;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;



import usermanagement.app.user.UserForm.ShowUpdateForm;
import usermanagement.domain.model.account.Account;
import usermanagement.domain.service.user.UserService;

@Controller
@SessionAttributes(value = { "userForm" }) // (1)
@RequestMapping("user")
public class UserUpdateController {

    private static final Logger logger = LoggerFactory
            .getLogger(UserUpdateController.class);

	@Inject
	UserService userService;

	@Inject
	Mapper beanMapper;

	@ModelAttribute(value = "userForm")
	public UserForm setUpuserForm() {
		return new UserForm();
	}

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/update", method = {RequestMethod.GET}, params = "form")
    public String showUpdateForm(@Validated({ ShowUpdateForm.class }) UserForm form,  BindingResult result, Model model) {

    	if (result.hasErrors()) {
			ResultMessages messages = ResultMessages.error();
			messages.add("e.st.ac.5001");
			throw new IllegalOperationException(messages);
		}

    	Account account = userService.findOneByUserId(form.getUserId());
    	model.addAttribute(account);

        return "user/updateForm";
    }

	@RequestMapping(value = "/update", method = RequestMethod.POST, params = "confirm")
	String confirmUpdate(@Validated UserForm form, BindingResult result) {

		if (result.hasErrors()) {
			return "user/updateForm";
		}

		return "user/updateConfirm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Validated UserForm form, BindingResult result) {

		if (result.hasErrors()) {
			ResultMessages messages = ResultMessages.error();
			messages.add("e.st.ac.5001");
			throw new IllegalOperationException(messages);
		}

		Account account = beanMapper.map(form, Account.class);
		userService.update(account, form.getNoEncodedPassword());

		return "redirect:/user/update?finish";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET, params = "finish")
	public String finishUpdate() {
		return "user/updateFinish";
	}

}
