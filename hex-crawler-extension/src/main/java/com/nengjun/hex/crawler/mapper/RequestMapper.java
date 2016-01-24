package com.nengjun.hex.crawler.mapper;

import com.nengjun.hex.crawler.Request;
import org.apache.ibatis.annotations.Param;

public interface RequestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Request record);

    int insertSelective(Request record);

    Request selectByPrimaryKey(Integer id);

    Request selectByUrl(@Param("url") String url);

    Request selectNewUrl(@Param("source") String source);

    int updateByPrimaryKeySelective(Request record);

    int updateByPrimaryKey(Request record);
}
