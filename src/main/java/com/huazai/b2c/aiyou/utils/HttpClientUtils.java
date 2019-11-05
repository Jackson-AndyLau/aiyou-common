package com.huazai.b2c.aiyou.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.huazai.b2c.aiyou.repo.HttpResultData;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description HttpClient工具类
 *              </ul>
 * @className HttpUtil
 * @package com.huazai.b2c.aiyou.utils
 * @createdTime 2017年06月17日
 *
 * @version V1.0.0
 */
public class HttpClientUtils
{

	private CloseableHttpClient httpClient;

	public HttpClientUtils()
	{
		httpClient = HttpClients.createDefault();
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doGet
	 *        <ul>
	 * @description 带参数的doGet请求
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param uri
	 * @param map
	 * @return
	 * @throws Exception
	 * @return HttpResultData
	 *
	 * @version : V1.0.0
	 */
	public HttpResultData doGet(String uri, Map<String, Object> map) throws Exception
	{
		// 1、创建URIBuilder对象
		URIBuilder uriBuilder = new URIBuilder(uri);
		encapRequestParams(map, uriBuilder);
		// 3、创建 HttpGet对象
		HttpGet httpGet = new HttpGet(uriBuilder.build());
		// 4、使用httpClient发起请求
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 5、解析返回结果，封装返回对象HttpResultData
		HttpResultData resultData = this.parseHttpResultData(response);
		return resultData;
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doGet
	 *        <ul>
	 * @description 不带参数的doGet请求
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param uri
	 * @return
	 * @throws Exception
	 * @return HttpResultData
	 *
	 * @version : V1.0.0
	 */
	public HttpResultData doGet(String uri) throws Exception
	{
		return this.doGet(uri, null);
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doPost
	 *        <ul>
	 * @description 带参数的doPost请求
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param uri
	 * @param map
	 * @return
	 * @return HttpResultData
	 *
	 * @version : V1.0.0
	 * @throws Exception
	 */
	public HttpResultData doPost(String uri, Map<String, Object> map) throws Exception
	{
		// 1、声明 HttpPost对象
		HttpPost request = new HttpPost();
		// 2、封装请求参数，请求数据表单
		UrlEncodedFormEntity entity = this.encapRequestParams(map);
		// 3、设置请求数据表单
		request.setEntity(entity);
		// 4、通过HttpClient执行请求
		CloseableHttpResponse response = httpClient.execute(request);
		// 5、解析返回结果，封装返回对象HttpResultData
		HttpResultData resultData = this.parseHttpResultData(response);
		return resultData;
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doPost
	 *        <ul>
	 * @description 不带参数的doPost请求
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param uri
	 * @return
	 * @return HttpResultData
	 *
	 * @version : V1.0.0
	 * @throws Exception
	 */
	public HttpResultData doPost(String uri) throws Exception
	{

		return this.doPost(uri, null);
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doPut
	 *        <ul>
	 * @description 带参数的doPut请求
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param uri
	 * @param map
	 * @return
	 * @return HttpResultData
	 *
	 * @version : V1.0.0
	 * @throws Exception
	 */
	public HttpResultData doPut(String uri, Map<String, Object> map) throws Exception
	{
		// 1、生命HttpPut对象
		HttpPut request = new HttpPut();
		// 2、封装请求参数
		UrlEncodedFormEntity entity = this.encapRequestParams(map);
		// 3、设置请求表单数据
		request.setEntity(entity);
		// 4、通过HttpClient执行请求
		CloseableHttpResponse response = httpClient.execute(request);
		// 5、封装解析返回结果，封装返回对象HttpResultData
		HttpResultData resultData = this.parseHttpResultData(response);
		return resultData;
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doPut
	 *        <ul>
	 * @description 不带参数的doPut请求
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param uri
	 * @return
	 * @return HttpResultData
	 *
	 * @version : V1.0.0
	 * @throws Exception
	 */
	public HttpResultData doPut(String uri) throws Exception
	{

		return this.doPut(uri, null);
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doDelete
	 *        <ul>
	 * @description 带参数的doDelete请求
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param uri
	 * @param map
	 * @return
	 * @return HttpResultData
	 *
	 * @version : V1.0.0
	 * @throws Exception
	 */
	public HttpResultData doDelete(String uri, Map<String, Object> map) throws Exception
	{
		// 1、创建URIBuilder对象
		URIBuilder uriBuilder = new URIBuilder(uri);
		// 2、设置请求参数
		this.encapRequestParams(map, uriBuilder);
		// 3、创建 HttpGet对象
		HttpDelete request = new HttpDelete(uriBuilder.build());
		// 4、使用httpClient发起请求
		CloseableHttpResponse response = httpClient.execute(request);
		// 5、解析返回结果，封装返回对象HttpResultData
		HttpResultData resultData = this.parseHttpResultData(response);
		return resultData;
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doDelete
	 *        <ul>
	 * @description 不带参数的doDelete请求
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param uri
	 * @return
	 * @return HttpResultData
	 *
	 * @version : V1.0.0
	 * @throws Exception 
	 */
	public HttpResultData doDelete(String uri) throws Exception
	{

		return this.doDelete(uri, null);
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title parseHttpResultData
	 *        <ul>
	 * @description 解析返回结果，封装返回对象HttpResultData
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param response
	 * @return
	 * @throws IOException
	 * @return HttpResultData
	 *
	 * @version : V1.0.0
	 */
	private HttpResultData parseHttpResultData(CloseableHttpResponse response) throws IOException
	{
		// 响应状态码
		int code = response.getStatusLine().getStatusCode();
		String body = null;
		// 响应消息体
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity != null)
		{
			body = EntityUtils.toString(httpEntity, "UTF-8");
		}
		// 封装返回实体
		HttpResultData resultData = new HttpResultData(code, body);

		return resultData;
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title encapRequestParams
	 *        <ul>
	 * @description 封装请求参数，请求数据表单
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param map
	 * @return
	 * @throws Exception
	 * @return UrlEncodedFormEntity
	 *
	 * @version : V1.0.0
	 */
	private UrlEncodedFormEntity encapRequestParams(Map<String, Object> map) throws Exception
	{
		// 是否是带参数的请求
		if (map != null)
		{
			// 声明表单容器
			List<NameValuePair> parameters = new ArrayList<>();
			for (Map.Entry<String, Object> entry : map.entrySet())
			{
				// 封装容器
				BasicNameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
				parameters.add(nameValuePair);
			}
			// 创建表单实体
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, "UTF-8");

			return entity;
		}
		return null;
	}
	
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title encapRequestParams
	 *        <ul>
	 * @description 设置请求参数
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @param map
	 * @param uriBuilder
	 * @return void
	 *
	 * @version : V1.0.0
	 */
	private void encapRequestParams(Map<String, Object> map, URIBuilder uriBuilder)
	{
		// 是否是带参数的请求
		if (map != null)
		{
			for (Map.Entry<String, Object> entry : map.entrySet())
			{
				// 封装请求参数
				uriBuilder.addParameter(entry.getKey(), entry.getValue().toString());
			}
		}
	}

}
