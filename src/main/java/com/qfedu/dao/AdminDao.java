package com.qfedu.dao;

import com.qfedu.entity.Admin;

public interface AdminDao {

    public Admin findByCode(String username);
    public void addOne(Admin admin);
    public void update(Admin admin);
}
