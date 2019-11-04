package com.huazai.b2c.aiyou.repo;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description Http 返回实体
 *              </ul>
 * @className HttpResultData
 * @package com.huazai.b2c.aiyou.repo
 * @createdTime 2017年06月17日
 *
 * @version V1.0.0
 */
public class HttpResultData
{

	/**
	 * 响应状态码
	 */
	private int code;

	/**
	 * 响应消息体
	 */
	private String body;

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

}
