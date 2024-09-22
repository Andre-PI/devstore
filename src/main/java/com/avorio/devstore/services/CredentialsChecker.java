package com.avorio.devstore.services;

import org.springframework.stereotype.Service;

@Service
public class CredentialsChecker {

    protected boolean checkCredential(String param){
        if(param.isBlank() || param.isEmpty() || param == null){
            return false;
        }
        return true;
    }
}
