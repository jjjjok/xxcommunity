package com.gugu.community.controller;

import com.gugu.community.api.GithubApi;
import com.gugu.community.dto.AccessTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubApi githubApi;

    @GetMapping("callback")
    public String callBack(@RequestParam(name = "code") String code,@RequestParam(name = "state") String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("d592a6f654d23dfe620e");
        accessTokenDTO.setClient_secret("4e4d3810828c2d2922c5183f77111fd121b725f8");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);

        githubApi.getAccessToken(accessTokenDTO);
        return "index";

    }
}
