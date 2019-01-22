package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.Account;
import com.fire.sdk.model.Response;

public class AccountListResponse implements Response<AccountListResponse> {
	public ArrayList<Account> accounts;

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public AccountListResponse setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
        return this;
    }
	
	

}
