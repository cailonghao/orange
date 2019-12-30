package com.provider.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "orange-security")
public interface SecurityService {

    @PostMapping("/oauth/token")
    Map<String, Object> getToken(@RequestParam String grant_type,
                                 @RequestParam String code,
                                 @RequestParam String redirect_uri,
                                 @RequestParam String client_id,
                                 @RequestParam String scope
    );
}
