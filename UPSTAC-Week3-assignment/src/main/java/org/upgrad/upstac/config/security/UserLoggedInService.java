package org.upgrad.upstac.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;
import org.upgrad.upstac.users.UserService;

import java.util.List;


@Component
public class UserLoggedInService {

    private static UserService userService;

    @Autowired
    public UserLoggedInService(UserService userService) {
        this.userService = userService;
    }


    public static User getLoggedInUser() {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userService.findByUserName(principal.getUsername());

    }


    public List<TestRequest> findByTester(User currentLoggedInUser) {
        return null;
    }

    public List<TestRequest> findByDoctor(User currentLoggedInUser) {
        return null;
    }

    public static class getLoggedInUser extends User {
    }
}
