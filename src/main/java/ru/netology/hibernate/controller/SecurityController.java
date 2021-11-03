package ru.netology.hibernate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class SecurityController {

    @GetMapping("/role-read")
    @Secured("ROLE_READ")
    public String getRead() {
        return "Hi, " + SecurityContextHolder.getContext().getAuthentication().getName() + " - "
                + SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    @GetMapping("/role-write")
    @RolesAllowed("ROLE_WRITE")
    public String getWrite() {
        return "Hi, " + SecurityContextHolder.getContext().getAuthentication().getName() + " - "
                + SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    @GetMapping("/role-write-or-delete")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String getWriteOrDelete() {
        return "Hi, " + SecurityContextHolder.getContext().getAuthentication().getName() + " - "
                + SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    @GetMapping("/role-username")
    @PreAuthorize("#username == authentication.principal.username")
    public String getUsername(String username) {
        return "Hi, " + username + " - "
                + SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
}
