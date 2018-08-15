package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.DisProfitParamMapper;
import com.stylefeng.guns.common.persistence.model.DisProfitParam;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.dao.DisProfitParamDao;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisProfiParamService;

import java.util.List;
import java.util.Map;

/**
 * 参数设置Dao
 *
 * @author huangpu
 * @Date 2018-04-06 11:33:32
 */
@Service
public class DisProfiParamServiceImpl implements IDisProfiParamService {


    @Autowired
    DisProfitParamDao disProfiParamDao;

    @Autowired
    DisProfitParamMapper disProfiParamMapper;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList(String account) {
        List<Map<String, Object>> list=disProfiParamDao.selectList(account);
        return list;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(DisProfitParam param) {
        if(param.getDisProLevel().equals("0")){
            throw  new BussinessException(BizExceptionEnum.PROFIT_LEVLE_ERROR);
        }
        param.setIsDelete("N");
        param.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        disProfiParamMapper.insert(param);
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.getNowDateTime() );
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void delete(int id) {
        disProfiParamMapper.deleteById(id);
    }
}
