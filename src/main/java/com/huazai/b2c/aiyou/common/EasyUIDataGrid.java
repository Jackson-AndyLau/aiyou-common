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

	/**
	 * 总条数
	 */
	private Long total;
	/**
	 * 页大小
	 */
	private Integer pageSize;
	/**
	 * 当前页页码
	 */
	private Integer pageNum;
	/**
	 * 总页数
	 */
	private Integer pages;
	/**
	 * 分页数据集合
	 */
	private List<?> rows;

	public Long getTotal()
	{
		return total;
	}

	public void setTotal(Long total)
	{
		this.total = total;
	}

	public List<?> getRows()
	{
		return rows;
	}

	public void setRows(List<?> rows)
	{
		this.rows = rows;
	}

	public Integer getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	public Integer getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(Integer pageNum)
	{
		this.pageNum = pageNum;
	}

	public Integer getPages()
	{
		return pages;
	}

	public void setPages(Integer pages)
	{
		this.pages = pages;
	}

}
