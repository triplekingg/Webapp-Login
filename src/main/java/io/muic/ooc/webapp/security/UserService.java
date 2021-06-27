package io.muic.ooc.webapp.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String,User> users =  new HashMap<>();
    {
        users.put("tripleking",new User("tripleking", "12345"));
        users.put("admin",new User("admin","12345"));
    }

    public User findByUsername(String username){
        return users.get(username);
    }

    public boolean checkIfUserExists(String username){
        return users.containsKey(username);
    }




}
