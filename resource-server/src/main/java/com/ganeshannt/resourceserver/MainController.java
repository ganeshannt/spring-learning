package com.ganeshannt.resourceserver;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/private/message")
    @PreAuthorize("hasAuthority('SCOPE_message:read')")
    public String secureMessage() {
        return "secure message";
    }

    @GetMapping("/public/message")
    public String unSecureMessage() {
        return "unsecure message";
    }
}
