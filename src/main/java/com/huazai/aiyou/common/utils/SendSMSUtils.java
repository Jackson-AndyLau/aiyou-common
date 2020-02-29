package com.huazai.aiyou.common.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.huazai.aiyou.common.constant.TbConstant;
import com.huazai.aiyou.common.response.AiyouResultData;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 短信发送工具类
 *              </ul>
 * @className SendSMSUtils
 * @package com.huazai.b2c.aiyou.utils
 * @createdTime 2017年06月17日
 *
 * @version V1.0.0
 */
public class SendSMSUtils
{

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doSendSMS
	 *        <ul>
	 * @description 短信发送
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @return
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 */
	public static AiyouResultData doSendSMS()
	{
		DefaultProfile profile = DefaultProfile.getProfile(TbConstant.SMS_REGIONID, TbConstant.SMS_ACCESSKEYID,
				TbConstant.SMS_ACCESSSECRET);
		IAcsClient client = new DefaultAcsClient(profile);

		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		request.putQueryParameter("RegionId", TbConstant.SMS_REGIONID);
		request.putQueryParameter("PhoneNumbers", TbConstant.SMS_PHONENUMBERS);
		request.putQueryParameter("SignName", TbConstant.SMS_SIGNNAME);
		request.putQueryParameter("TemplateCode", TbConstant.SMS_TEMPLATECODE);
		try
		{
			CommonResponse response = client.getCommonResponse(request);
			System.out.println(response.getData());
		} catch (ServerException e)
		{
			e.printStackTrace();
		} catch (ClientException e)
		{
			e.printStackTrace();
		}
		return AiyouResultData.ok();
	}

}
