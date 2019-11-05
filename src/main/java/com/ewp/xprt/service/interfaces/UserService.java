package com.ewp.xprt.service.interfaces;

import com.ewp.xprt.model.User;

public interface UserService extends CommonService<User> {

    User getByEmail(String email);
}
