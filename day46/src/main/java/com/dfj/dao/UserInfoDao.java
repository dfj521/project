package com.dfj.dao;

import com.dfj.entity.UserInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserInfoDao {
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public List<UserInfo> findAll() {
        return sqlSessionTemplate.selectList("com.dfj.dao.UserInfoDao.findAll");
    }

    public UserInfo findById(Integer id) {
        return sqlSessionTemplate.selectOne("com.dfj.dao.UserInfoDao.findById", id);
    }

    public void save(UserInfo userInfo) {
        sqlSessionTemplate.insert("com.dfj.dao.UserInfoDao.save", userInfo);
    }

    public void updateById(UserInfo userInfo) {
        sqlSessionTemplate.update("com.dfj.dao.UserInfoDao.updateById", userInfo);
    }

    public void deleteById(Integer id) {
        sqlSessionTemplate.delete("com.dfj.dao.UserInfoDao.deleteById", id);
    }
}
