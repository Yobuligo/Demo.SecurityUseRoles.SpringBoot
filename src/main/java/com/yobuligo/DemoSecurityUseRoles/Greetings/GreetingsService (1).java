package com.yobuligo.DemoSecurityUseRoles.Greetings;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class GreetingsService implements IGreetingsService {

	@PreAuthorize("hasRole('SERVICE')")
	public String getName() {
		return "Service Greetings";
	}

}
