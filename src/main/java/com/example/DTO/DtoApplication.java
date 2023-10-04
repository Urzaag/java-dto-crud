package com.example.DTO;

import com.example.DTO.entity.Badge;
import com.example.DTO.entity.Role;
import com.example.DTO.entity.User;
import com.example.DTO.service.BadgeService;
import com.example.DTO.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.DTO.service.UserService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DtoApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BadgeService badgeService;

	public static void main(String[] args) {
		SpringApplication.run(DtoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		// Display all users
		List<User> users = userService.getUsers();
		users.forEach(user -> System.out.println(user.getName()));

//		// Display all roles
//		List<Role> roles = roleService.getRoles();
//		roles.forEach(role -> System.out.println(role.getName()));
//
//		// Display all badges
//		List<Badge> badges = badgeService.getBadges();
//		badges.forEach(badge -> System.out.println(badge.getName()));

		// Display user with id = 1
		Optional<User> optionalUserId1 = userService.getUserById(1);
		User user1 = optionalUserId1.get();
		System.out.println(user1.getName());

//		// Display role with id = 1
//		Optional<Role> optionalRole = roleService.getRoleById(1);
//		Role role1 = optionalRole.get();
//		System.out.println(role1.getName());

//		// Display badge with id = 1
//		Optional<Badge> optionalBadge = badgeService.getBadgeById(1);
//		Badge badge1 = optionalBadge.get();
//		System.out.println(badge1.getName());

		// Display all roles of user with id = 1
		Optional<User> optionalRolesUserId1 = userService.getUserById(1);
		if (optionalRolesUserId1.isPresent()) {
			User user = optionalRolesUserId1.get();
			List<Role> user1Roles = user.getRoles();
			user1Roles.forEach(role -> System.out.println(role.getName()));
		}

		// Display all users with role id = 1
		Optional<Role> optionalRole =  roleService.getRoleById(1);
		if (optionalRole.isPresent()) {
			Role role = optionalRole.get();
			List<User> usersRoleId1 = role.getUsers();
			usersRoleId1.forEach(user -> System.out.println(user.getName()));

			// Equivalent
//			System.out.println(role.getName());
//			role.getUsers().forEach(
//					user -> System.out.println(user.getName()));
		}

		//  Display all bagdes for user id = 1
		Optional<User> optionalUserId1Badges = userService.getUserById(1);
		if (optionalUserId1Badges.isPresent()) {
			User user = optionalRolesUserId1.get();
			List<Badge> badgesUserId1 = user.getBadges();
			badgesUserId1.forEach(badge -> System.out.println(badge.getName()));
		}

		// Display user for badge id = 1
		Optional<Badge> optionalBadgeId1 = badgeService.getBadgeById(1);
		if (optionalBadgeId1.isPresent()) {
			Badge badge = optionalBadgeId1.get();
			User user = badge.getUser();
			System.out.println(badge.getName());
			System.out.println(user.getName());
		}

		// Create new role
		roleService.getRoles().forEach(role -> System.out.println(role.getName()));

		Role newRole = new Role();
		newRole.setName("Intendant");

		newRole = roleService.saveRole(newRole);

		roleService.getRoles().forEach(role -> System.out.println(role.getName()));

		// Create new user
		userService.getUsers().forEach(user -> System.out.println(user.getName()));

		User newUser = new User();
		newUser.setName("Teubs");
		newUser.setBio("lol this is a test");
		newUser.setAge(26);

		// Attach the new user to the new role
		newRole.addUser(newUser);

		newUser = userService.saveUser(newUser);

		userService.getUsers().forEach(user -> System.out.println(user.getName()));

		// Create new badge
		Badge newBadge = new Badge();
		newBadge.setName("Best employee");
		newUser.addBadge(newBadge);

		badgeService.saveBadge(newBadge);

		// With bidirectional relations, you can save 2 entities with 1 save because of the cascades

		// Update user Teubs
		Optional<User> optExistingUser = userService.getUserById(1);
		if (optExistingUser.isPresent()) {
			User existingUser = optExistingUser.get();

			existingUser.setAge(45);
			userService.saveUser(existingUser);

			System.out.println(existingUser.getAge());
		}

		// Display a user with name = Teubs
		List<User> searchResults = userService.getUserByName("Teubs");
		searchResults.forEach(user -> System.out.println(user.getId()));

		// Display users with roles name = Intendant
		searchResults = userService.getUsersByRoleName("Intendant");

	}

}
