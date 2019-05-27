package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.AccountAction;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AccountActionsResponse;

public class AccountActionsRequest implements Request<AccountActionsRequest, AccountActionsResponse> {
	private static final Logger logger = LoggerFactory.getLogger(AccountActionsRequest.class);
	private long accountId;
	private AccountAction accountAction = new AccountAction();
	
	public AccountActionsRequest setAlias(String alias) {
		this.accountAction.setAccountName(alias);
		return this;
	}
	
    public long getAccountId() {
		return accountId;
	}

	public AccountActionsRequest setAccountId(long accountId) {
		this.accountId = accountId;
		return this;
	}

	@Override
    public String getEndpoint() {
		if (this.accountAction.getAccountName() == null) {
			logger.error("You must set the alias using .setAlias(alias)");
		} else {
			return "accounts/" + accountId;
		}
		return "";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.PUT;
    }

    @Override 
	public Class<AccountActionsResponse> getResponseClass() {
		return AccountActionsResponse.class;
	}

    @Override
    public Object getBody() {
        return accountAction;
    }


}
