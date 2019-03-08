package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.Response;
import com.fire.sdk.model.Transaction;

public class UserListResponse implements Response<UserListResponse> {
    private ArrayList<Object> users;
    
    public ArrayList<Object> getUsers() {
        return users;
    }
    public UserListResponse setUsers(ArrayList<Object> users) {
        this.users = users;
        return this;
    }

    

}
