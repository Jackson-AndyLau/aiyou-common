package com.huazai.aiyou.common.response;

import java.io.Serializable;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 自定义数据体
 *              </ul>
 * @className AiyouResultData
 * @package com.huazai.b2c.aiyou.repo
 * @createdTime 2017年06月10日
 *
 * @version V1.0.0
 */
public class AiyouResultData implements Serializable
{

	/**
	 * @Files serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 业务响应状态
	 */
	private Integer status;
	/**
	 * 业务响应消息
	 */
	private String msg;
	/**
	 * 业务响应数据
	 */
	private Object data;

	public AiyouResultData(Integer status, String msg, Object data)
	{
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public AiyouResultData()
	{
		super();
	}

	public AiyouResultData(Object data)
	{
		super();
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public static AiyouResultData ok()
	{
		return new AiyouResultData(null);
	}

	public static AiyouResultData ok(Object data)
	{
		return new AiyouResultData(data);
	}

	public static AiyouResultData build(Integer status, String msg)
	{
		return new AiyouResultData(status, msg, null);
	}

	public static AiyouResultData build(Integer status, String msg, Object data)
	{
		return new AiyouResultData(status, msg, data);
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

}
