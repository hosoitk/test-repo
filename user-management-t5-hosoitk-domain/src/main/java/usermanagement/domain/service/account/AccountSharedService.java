package usermanagement.domain.service.account;

import usermanagement.domain.model.account.Account;

public interface AccountSharedService {
    Account findOne(String username);
}