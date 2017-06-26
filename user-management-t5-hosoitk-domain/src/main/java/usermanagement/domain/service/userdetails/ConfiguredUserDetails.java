package usermanagement.domain.service.userdetails;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import usermanagement.domain.model.account.Account;

public class ConfiguredUserDetails extends User { // (1)
    private static final long serialVersionUID = 1L;

    private final Account account; // (2)

    public ConfiguredUserDetails(Account account) {
        // (3)
        super(account.getUsername(), account.getPassword(), AuthorityUtils
                .createAuthorityList("ROLE_USER")); // (4)
        this.account = account;
    }

    public Account getAccount() { // (5)
        return account;
    }

}