package com.qfedu.service.impl;

import com.qfedu.dao.AdminDao;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin findByCode(String username, String password) {
        return adminDao.findByCode(username);
    }

    @Override
    public void addOne(String username, String password) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        adminDao.addOne(admin);
    }

    @Override
    public Admin selectByCode(String username) {
        return adminDao.findByCode(username);
    }

    @Override
    public void updateHeadImg(Integer id, String imgPath) {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setImgPath(imgPath);
        adminDao.update(admin);
    }
}
