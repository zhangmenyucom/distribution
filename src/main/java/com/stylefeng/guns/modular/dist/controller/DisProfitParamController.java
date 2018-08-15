package com.stylefeng.guns.modular.dist.controller;

import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.controller.BaseController;
import com.stylefeng.guns.common.persistence.model.DisProfitParam;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.service.IDisProfiParamService;
import com.stylefeng.guns.modular.dist.wapper.ProfiParamWarpper;
import com.stylefeng.guns.modular.system.service.ISysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 参数设置控制器
 *
 * @author huangpu
 * @Date 2018-04-06 11:33:32
 */
@Controller
        @RequestMapping("/disProfiParam")
public class DisProfitParamController extends BaseController {


    @Autowired
    IDisProfiParamService disProfiParamService;

    @Autowired
    ISysDicService sysDicService;

    private String PREFIX = "/dist/disProfiParam/";

    /**
     * 跳转到参数设置首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "disProfiParam.html";
    }

    /**
     * 跳转到添加参数设置
     */
    @RequestMapping("/disProfiParam_add")
    public String disProfiParamAdd(Model model) {
        model.addAttribute("disProMode",sysDicService.selectListByCode("disProMode"));
        model.addAttribute("disProType",sysDicService.selectListByCode("disProType"));
        model.addAttribute("disProLevel",sysDicService.selectListByCode("disProLevel"));
        model.addAttribute("disUserType",sysDicService.selectListByCode("disUserType"));
        model.addAttribute("disUserRank",sysDicService.selectListByCode("disUserRank"));
        return PREFIX + "disProfiParam_add.html";
    }

    /**
     * 跳转到修改参数设置
     */
    @RequestMapping("/disProfiParam_update/{disProfiParamId}")
    public String disProfiParamUpdate(@PathVariable Integer disProfiParamId, Model model) {
        return PREFIX + "disProfiParam_edit.html";
    }

    /**
     * 获取参数设置列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        String account= ShiroKit.getUser().getAccount();
        if(ShiroKit.hasRole(Const.ADMIN_NAME)){
            account=null;
        }
        List<Map<String, Object>> list=disProfiParamService.selectList(account);
        return super.warpObject(new ProfiParamWarpper(list));
    }

    /**
     * 新增参数设置
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(DisProfitParam param) {
        String account= ShiroKit.getUser().getAccount();
        if(!ShiroKit.hasRole(Const.ADMIN_NAME)){
            param.setDisPlatformId(account);
        }
        disProfiParamService.save(param);
        return super.SUCCESS_TIP;
    }
    @RequestMapping(value = "/protype")
    @ResponseBody
    public Object protype() {
        return sysDicService.selectListByCode("disProType");
    }

    /**
     * 删除参数设置
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam int id) {
        disProfiParamService.delete(id);
        return SUCCESS_TIP;
    }


    /**
     * 修改参数设置
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 参数设置详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
