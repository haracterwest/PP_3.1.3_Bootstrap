package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class RoleService {

    public RoleService() {
    }

    public ArrayList<String> getRoles() {
        ArrayList<String> list = new ArrayList<>();
        list.add("ROLE_ADMIN");
        list.add("ROLE_USER");
        return list;
    }
}
