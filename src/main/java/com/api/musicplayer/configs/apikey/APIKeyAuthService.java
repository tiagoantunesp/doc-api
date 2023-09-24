package com.api.musicplayer.configs.apikey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class APIKeyAuthService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";

    private static String API_KEY_AUTH_TOKEN = "qrfqwV.2FG!3t2";

    public Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);

        Map<String, String> headersMap = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headersMap.put(headerName, headerValue);
        }

        if (apiKey == null || !apiKey.equals(API_KEY_AUTH_TOKEN)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
        authorities.add(new SimpleGrantedAuthority("API_KEY"));

        return new ApiKeyAuthentication(apiKey, authorities);
    }
}