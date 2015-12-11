package com.netwaymedia.nio.core.base;

import java.io.Serializable;
import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class SuperEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getLastOperationTime() {
		return lastOperationTime;
	}

	public void setLastOperationTime(Timestamp lastOperationTime) {
		this.lastOperationTime = lastOperationTime;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getLastOperatorId() {
		return lastOperatorId;
	}

	public void setLastOperatorId(Integer lastOperatorId) {
		this.lastOperatorId = lastOperatorId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	private Integer id; // 记录id

	private Integer status; // 状态
	
	private Integer version;//版本

	private Timestamp createTime;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Timestamp lastOperationTime;

	private Integer creatorId;

	private Integer lastOperatorId;

}
