package com.fire.sdk.model.request;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AspspListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class AspspListRequest implements Request<AspspListRequest, AspspListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(AspspListRequest.class);

    private int limit;
    private int offset;

    public int getLimit() {
        return limit;
    }

    public AspspListRequest setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public AspspListRequest setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    @Override
	public String getEndpoint() {
        ArrayList<String> queryStrings = new ArrayList<String>();
        String queryString = "";

        if (getLimit() != 0) {
            queryStrings.add("limit=" + getLimit());
        }

        if (getOffset() != 0) {
            queryStrings.add("offset=" + getOffset());
        }

        if (queryStrings.size() > 0) {
            StringBuilder sb = new StringBuilder(128);
            int end = 0;
            for (Object s : queryStrings.toArray()) {
                sb.append(s);
                end = sb.length();
                sb.append("&");
            }
            queryString = "?" + sb.substring(0, end);
        }

        return "aspsps" + queryString;

	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<AspspListResponse> getResponseClass() {
		return AspspListResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
