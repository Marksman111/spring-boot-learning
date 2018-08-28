package com.marksman.dao.impl;

import com.marksman.dao.UserDao;
import com.marksman.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author weilb
 * @date 2018/8/28
 * @description
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(UserEntity userEntity) {
        mongoTemplate.save(userEntity);
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        return mongoTemplate.findOne(query,UserEntity.class);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        Query query = new Query(Criteria.where("id").is(userEntity.getId()));
        Update update = new Update().set("userName",userEntity.getUseName()).set("passWord",userEntity.getPassWord());
        mongoTemplate.updateFirst(query,update,UserEntity.class);

        mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }
}
