package com.gulko.service;

import com.gulko.entity.BasePH;
import java.util.List;


public interface BaseService {
    List<BasePH> getAll();
    BasePH save(BasePH userBase);
    List<BasePH> getAllUserBase(String login);

}
