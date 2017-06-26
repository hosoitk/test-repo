package usermanagement.domain.service.userdetails;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import usermanagement.domain.model.account.Account;
import usermanagement.domain.service.account.AccountSharedService;

@Service
public class ConfiguredUserDetailsService implements UserDetailsService { // (1)
    @Inject
    AccountSharedService accountSharedService; // (2)

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account account = accountSharedService.findOne(username); // (3)
            return new ConfiguredUserDetails(account); // (4)
        } catch (ResourceNotFoundException e) {
            throw new UsernameNotFoundException("user not found", e); // (5)
        }
    }

}