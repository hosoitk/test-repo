package usermanagement.app.user;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;

import usermanagement.domain.model.account.Account;
import usermanagement.domain.service.user.UserService;

@Controller
@SessionAttributes(value = { "userForm" }) // (1)
@RequestMapping("user")
public class UserRegisterController {

    private static final Logger logger = LoggerFactory
            .getLogger(UserRegisterController.class);

	@Inject
	UserService userService;

	@Inject
	Mapper beanMapper;

	@ModelAttribute(value = "userForm")
	public UserForm setUpUserForm() {
		return new UserForm();
	}

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/register", method = {RequestMethod.GET}, params = "form")
    public String showRegisterForm() {
           return "user/registerForm";
    }

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "confirm")
	String confirmRegister(@Validated UserForm form, BindingResult result) {

		if (result.hasErrors()) {
			return showRegisterForm();
		}

		return "user/registerConfirm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Validated UserForm form, BindingResult result) {

		if (result.hasErrors()) {
			ResultMessages messages = ResultMessages.error();
			messages.add("e.st.ac.5001");
			throw new IllegalOperationException(messages);
		}

		Account account = beanMapper.map(form, Account.class);
		userService.register(account, form.getNoEncodedPassword());

		return "redirect:/user/register?finish";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET, params = "finish")
	public String finishRegister() {
		return "user/registerFinish";
	}

}
