package com.sunm.model.proxy;

/**
 * Created by Administrator on 2017/9/30.
 */

public class ProxySearcher implements Searcher {

    private RealSearcher mRealSearcher = new RealSearcher();
    private AccessValidator validator;

    public ProxySearcher() {
        validator = new AccessValidator();
    }

    @Override
    public String doSearch(String userId, String keyword) {
        if (validator.validator(userId)) {
            return mRealSearcher.doSearch(userId, keyword);
        }
        return null;
    }
}
