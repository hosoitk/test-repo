package usermanagement.app.user;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
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


import usermanagement.app.user.UserForm.ShowUsers;
import usermanagement.domain.model.account.Account;
import usermanagement.domain.service.user.UserService;

@Controller
@SessionAttributes(value = { "userForm" })
@RequestMapping("user")
public class UserSearchController {

    private static final Logger logger = LoggerFactory
            .getLogger(UserSearchController.class);

	@Inject
	Mapper beanMapper;

	@Inject
	UserService userService;

	@ModelAttribute(value = "userForm")
	public UserForm setUpUserForm() {
		return new UserForm();
	}

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET}, params = "form")
	public String showSearchForm() {
		return "user/searchForm";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	String showUsers(@Validated({ ShowUsers.class }) UserForm form, BindingResult result, Pageable pageable, Model model) {

    	if (result.hasErrors()) {
			ResultMessages messages = ResultMessages.error();
			messages.add("e.st.ac.5001");
			throw new IllegalOperationException(messages);
		}

		Account account = beanMapper.map(form, Account.class);

		Page<Account> page = userService.findByAccount(account,
				pageable);
		model.addAttribute("page", page);
		return "user/searchList";
	}

}
