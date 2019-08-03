package com.huazai.b2c.aiyou.dto;

import java.io.Serializable;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TODO
 *              </ul>
 * @className SearchItemDto
 * @package com.huazai.b2c.aiyou.dto
 * @createdTime 2017年06月15日
 *
 * @version V1.0.0
 */
public class SearchItemDto implements Serializable
{

	/**
	 * @Files serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Long id;// 商品的id
	private String title;// 商品标题
	private String sell_point;// 商品卖点
	private Long price;// 价格
	private String image;// 商品图片的路径
	private String category_name;// 商品分类名称
	private String item_desc;// 商品的描述

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getSell_point()
	{
		return sell_point;
	}

	public void setSell_point(String sell_point)
	{
		this.sell_point = sell_point;
	}

	public Long getPrice()
	{
		return price;
	}

	public void setPrice(Long price)
	{
		this.price = price;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public String getCategory_name()
	{
		return category_name;
	}

	public void setCategory_name(String category_name)
	{
		this.category_name = category_name;
	}

	public String getItem_desc()
	{
		return item_desc;
	}

	public void setItem_desc(String item_desc)
	{
		this.item_desc = item_desc;
	}

	@Override
	public int hashCode()
	{
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString()
	{
		return "SearchItemDto [id=" + id + ", title=" + title + ", sell_point=" + sell_point + ", price=" + price
				+ ", image=" + image + ", category_name=" + category_name + ", item_desc=" + item_desc + "]";
	}

	public SearchItemDto(Long id, String title, String sell_point, Long price, String image, String category_name,
			String item_desc)
	{
		super();
		this.id = id;
		this.title = title;
		this.sell_point = sell_point;
		this.price = price;
		this.image = image;
		this.category_name = category_name;
		this.item_desc = item_desc;
	}

	public SearchItemDto()
	{
		super();
	}

}
