package com.chai.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chai.bo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    
}