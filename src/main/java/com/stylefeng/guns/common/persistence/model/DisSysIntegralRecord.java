package com.stylefeng.guns.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangpu
 * @since 2018-07-22
 */
@TableName("dis_sys_integral_record")
public class DisSysIntegralRecord extends Model<DisSysIntegralRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户id
     */
	@TableField("dis_user_id")
	private String disUserId;
    /**
     * 系统积分
     */
	@TableField("sys_integral")
	private Integer sysIntegral;
    /**
     * 是否使用（Y:使用,N未使用）
     */
	@TableField("is_use")
	private String isUse;
    /**
     * 使用前积分
     */
	@TableField("before_integral")
	private Integer beforeIntegral;
    /**
     * 使用后积分
     */
	@TableField("after_integral")
	private Integer afterIntegral;
    /**
     * 到期时间
     */
	@TableField("expire_time")
	private String expireTime;
    /**
     * 添加时间
     */
	@TableField("add_time")
	private String addTime;
    /**
     * 来源(交易、升级，下级升级)
     */
	@TableField("dis_pro_type")
	private String disProType;
    /**
     * 来源用户id
     */
	@TableField("source_user_id")
	private String sourceUserId;
    /**
     * 来源备注
     */
	@TableField("source_remak")
	private String sourceRemak;
    /**
     * 使用时间
     */
	@TableField("use_time")
	private String useTime;
    /**
     * 使用备注
     */
	@TableField("use_remark")
	private String useRemark;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisUserId() {
		return disUserId;
	}

	public void setDisUserId(String disUserId) {
		this.disUserId = disUserId;
	}

	public Integer getSysIntegral() {
		return sysIntegral;
	}

	public void setSysIntegral(Integer sysIntegral) {
		this.sysIntegral = sysIntegral;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public Integer getBeforeIntegral() {
		return beforeIntegral;
	}

	public void setBeforeIntegral(Integer beforeIntegral) {
		this.beforeIntegral = beforeIntegral;
	}

	public Integer getAfterIntegral() {
		return afterIntegral;
	}

	public void setAfterIntegral(Integer afterIntegral) {
		this.afterIntegral = afterIntegral;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getDisProType() {
		return disProType;
	}

	public void setDisProType(String disProType) {
		this.disProType = disProType;
	}

	public String getSourceUserId() {
		return sourceUserId;
	}

	public void setSourceUserId(String sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	public String getSourceRemak() {
		return sourceRemak;
	}

	public void setSourceRemak(String sourceRemak) {
		this.sourceRemak = sourceRemak;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getUseRemark() {
		return useRemark;
	}

	public void setUseRemark(String useRemark) {
		this.useRemark = useRemark;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DisSysIntegralRecord{" +
			"id=" + id +
			", disUserId=" + disUserId +
			", sysIntegral=" + sysIntegral +
			", isUse=" + isUse +
			", beforeIntegral=" + beforeIntegral +
			", afterIntegral=" + afterIntegral +
			", expireTime=" + expireTime +
			", addTime=" + addTime +
			", disProType=" + disProType +
			", sourceUserId=" + sourceUserId +
			", sourceRemak=" + sourceRemak +
			", useTime=" + useTime +
			", useRemark=" + useRemark +
			"}";
	}
}
