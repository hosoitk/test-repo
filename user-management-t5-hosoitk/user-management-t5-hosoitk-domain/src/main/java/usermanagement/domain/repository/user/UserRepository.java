/*
 * Copyright (C) 2013-2017 NTT DATA Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package usermanagement.domain.repository.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import usermanagement.domain.model.account.Account;

public interface UserRepository {

	List<Account> findPageByAccount(@Param("account") Account account,
			@Param("pageable") Pageable pageable);

	long countByAccount(@Param("account") Account account);

	Account findOneByUserId(@Param("userId") String userId);

	void register(@Param("account") Account account);

	void update(@Param("account") Account account);
}
