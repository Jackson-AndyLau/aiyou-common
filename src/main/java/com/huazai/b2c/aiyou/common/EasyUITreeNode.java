package com.huazai.b2c.aiyou.common;

import java.io.Serializable;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description EasyUI的tree控件的实体
 *              </ul>
 * @className EasyUITreeNode
 * @package com.huazai.b2c.aiyou.common
 * @createdTime 2017年06月10日
 *
 * @version V1.0.0
 */
public class EasyUITreeNode implements Serializable
{

	/**
	 * @Files serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String text;

	private String status;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

}
