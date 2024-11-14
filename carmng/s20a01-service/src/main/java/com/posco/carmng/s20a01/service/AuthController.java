package com.posco.carmng.s20a01.service;

import com.posco.service.config.OAuth2AuthorizationServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private OAuth2AuthorizationServerConfig oAuth2Config;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(
        @RequestParam String username,
        @RequestParam String password
    ) {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                username,
                password
            );

            Authentication authentication = authenticationManager.authenticate(
                authToken
            );
            SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

            // OAuth2 토큰 생성
            OAuth2Request oAuth2Request = new OAuth2Request(
                null,
                OAuth2AuthorizationServerConfig.CLIENT_ID,
                null,
                true,
                null,
                null,
                null,
                null,
                null
            );

            OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(
                oAuth2Request,
                authentication
            );

            OAuth2AccessToken accessToken = oAuth2Config
                .tokenStore()
                .getAccessToken(oAuth2Authentication);

            if (accessToken == null) {
                accessToken =
                    oAuth2Config
                        .accessTokenConverter()
                        .enhance(
                            new DefaultOAuth2AccessToken(""),
                            oAuth2Authentication
                        );
            }

            return ResponseEntity.ok(
                new JwtAuthenticationResponse(
                    accessToken.getValue(),
                    accessToken.getTokenType(),
                    accessToken.getExpiresIn()
                )
            );
        } catch (AuthenticationException e) {
            return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ApiResponse(false, "Invalid username or password"));
        }
    }

    public static class JwtAuthenticationResponse {

        private String accessToken;
        private String tokenType;
        private int expiresIn;

        public JwtAuthenticationResponse(
            String accessToken,
            String tokenType,
            int expiresIn
        ) {
            this.accessToken = accessToken;
            this.tokenType = tokenType;
            this.expiresIn = expiresIn;
        }

        // Getters and setters
        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }
    }

    public static class ApiResponse {

        private boolean success;
        private String message;

        public ApiResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        // Getters and setters
        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
