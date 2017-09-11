package com.chemix.Repositories;

import com.chemix.models.BusinessOpportunity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by chenshijue on 2017/9/11.
 */
public interface BusinessOpportunityRepository extends MongoRepository<BusinessOpportunity, String> {

    public BusinessOpportunity findById(String id);

}
