package com.huazai.b2c.aiyou.common;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品列表查询返回数据集
 *              </ul>
 * @className EasyUIDataGrid
 * @package com.huazai.b2c.aiyou.common
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public class EasyUIDataGrid implements Serializable
{

	/** 
	 * @Files serialVersionUID : TODO 
	 */  
	private static final long serialVersionUID = 1L;

	private Long total;

	private List<?> list;

	public Long getTotal()
	{
		return total;
	}

	public void setTotal(Long total)
	{
		this.total = total;
	}

	public List<?> getList()
	{
		return list;
	}

	public void setList(List<?> list)
	{
		this.list = list;
	}

}
