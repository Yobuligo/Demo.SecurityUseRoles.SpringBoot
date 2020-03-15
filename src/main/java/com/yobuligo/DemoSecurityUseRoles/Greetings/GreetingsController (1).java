package com.yobuligo.DemoSecurityUseRoles.Greetings;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	@Autowired
	private IGreetingsService greetingsService;

	@GetMapping("/greetings")
	public String greetings(@AuthenticationPrincipal final Principal principal) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) principal;
		usernamePasswordAuthenticationToken.getCredentials();
		return "Greetings";
	}

	@GetMapping("/userGreetings")
	@PreAuthorize("hasRole('USER')")
	public String userGreetings() {
		return "User Greetings";
	}

	@GetMapping("/adminGreetings")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminGreetings(final Principal principal) {
		return "Admin Greetings";
	}
	
	@GetMapping("/superAdminGreetings")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public String superAdminGreetings() {
		return "Super Admin Greetings";
	}

	@GetMapping("/serviceGreetings")	
	public String serviceGreetings() {		
		return greetingsService.getName();
	}

}
