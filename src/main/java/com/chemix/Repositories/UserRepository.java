package com.chemix.Repositories;

import com.chemix.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by chenshijue on 2017/9/13.
 */
public interface UserRepository extends MongoRepository<User, String> {

    public User findById(String id);

    public User findByOpenid(String openid);

}
