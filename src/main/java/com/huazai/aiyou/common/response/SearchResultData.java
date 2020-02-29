package com.huazai.aiyou.common.response;

import java.io.Serializable;
import java.util.List;

import com.huazai.aiyou.common.dto.SearchItemDto;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 查询返回对象
 *              </ul>
 * @className SearchResultData
 * @package com.huazai.b2c.aiyou.repo
 * @createdTime 2017年06月15日
 *
 * @version V1.0.0
 */
public class SearchResultData implements Serializable
{

	/**
	 * @Files serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private List<SearchItemDto> itemList; // 搜索结果列表
	private long recordCount; // 总记录数
	private long pageCount; // 总页数

	public List<SearchItemDto> getItemList()
	{
		return itemList;
	}

	public void setItemList(List<SearchItemDto> itemList)
	{
		this.itemList = itemList;
	}

	public long getRecordCount()
	{
		return recordCount;
	}

	public void setRecordCount(long recordCount)
	{
		this.recordCount = recordCount;
	}

	public long getPageCount()
	{
		return pageCount;
	}

	public void setPageCount(long pageCount)
	{
		this.pageCount = pageCount;
	}

	@Override
	public String toString()
	{
		return "SearchResultData [itemList=" + itemList + ", recordCount=" + recordCount + ", pageCount=" + pageCount
				+ "]";
	}

	public SearchResultData(List<SearchItemDto> itemList, long recordCount, long pageCount)
	{
		super();
		this.itemList = itemList;
		this.recordCount = recordCount;
		this.pageCount = pageCount;
	}

	public SearchResultData()
	{
		super();
	}

}
