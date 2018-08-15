package com.stylefeng.guns.modular.dist.dao;

import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 分销Dao
 *
 * @author huangpu
 * @Date 2018-04-05 21:49:44
 */
public interface DisMemberInfoDao {

    List<Map<String, Object>> selectList(@Param("account")  String account);

}
