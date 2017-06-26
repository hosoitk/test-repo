package usermanagement.domain.repository.account;

import usermanagement.domain.model.account.Account;

public interface AccountRepository {
    Account findOne(String userId);
}