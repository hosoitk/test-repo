package usermanagement.domain.service.user;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import usermanagement.domain.model.account.Account;
import usermanagement.domain.repository.user.UserRepository;

@Service
public class UserService {

	@Inject
	UserRepository userRepository;

	@Inject
	PasswordEncoder passwordEncoder;

	public Page<Account> findByAccount(Account account, Pageable pageable) {

		long total = userRepository.countByAccount(account);

		List<Account> userList = Collections.emptyList();
		if (total > 0) {
			userList = userRepository.findPageByAccount(account,
					pageable);
		}

		return new PageImpl<Account>(userList, pageable, total);
	}

	public Account findOneByUserId(String userId) {

		return userRepository.findOneByUserId(userId);
	}

	public void register(Account account, String noEncodedPassword) {

		account.setPassword(passwordEncoder.encode(noEncodedPassword));
		userRepository.register(account);
	}

	public void update(Account account, String noEncodedPassword) {

		account.setPassword(passwordEncoder.encode(noEncodedPassword));
		userRepository.update(account);
	}

}
