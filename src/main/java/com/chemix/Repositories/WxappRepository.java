package com.chemix.Repositories;

import com.chemix.models.Wxapp;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by chenshijue on 2017/9/11.
 */
public interface WxappRepository extends MongoRepository<Wxapp, String> {

    public Wxapp findByAppName(String appName);

}
