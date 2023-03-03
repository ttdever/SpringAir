package com.imelnykov.springair.controller;

import com.imelnykov.springair.service.DestinationService;
import com.imelnykov.springair.service.RegisteredFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class WebController {
    @Autowired
    private RegisteredFlightService flightService;

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/")
    public String getMainPage(Model model, Authentication authentication) {
        if(authentication != null) {
            String email = getEmailFromAuthentication(authentication);
            model.addAttribute("email", email);
            model.addAttribute("flights", flightService.getRegisteredFlightsByEmail(email));
        }
        return "mainPage";
    }

    @GetMapping("/available-destinations")
    public String getAvailableDestinationsPage(Model model, Authentication authentication) {
        if(authentication != null) {
            String email = getEmailFromAuthentication(authentication);
            model.addAttribute("email", email);
            model.addAttribute("destinations", destinationService.getAllDestinations());
        }
        return "availableDestinationsPage";
    }

    @GetMapping("/account-info")
    public String getAccountInformationPage(Model model) {
        // Add Account Information
        return "accountInformationPage";
    }

    private String getEmailFromAuthentication(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if(authentication instanceof OAuth2AuthenticationToken) {
            DefaultOidcUser oAuth2User = (DefaultOidcUser) principal;
            Map<String, Object> attributes = oAuth2User.getAttributes();
            return (String) attributes.get("email");
        } else {
            return authentication.getName();
        }
    }
}
