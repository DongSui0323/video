package com.qfedu.service;

import com.qfedu.entity.Admin;

public interface AdminService {
    public Admin findByCode(String username, String password);
    public void addOne(String username, String password);

    public Admin selectByCode(String username);
    public void updateHeadImg(Integer id, String imgPath);
}
