package com.huazai.b2c.aiyou.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.huazai.b2c.aiyou.repo.AiyouResultData;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 邮件发送工具类
 *              </ul>
 * @className SendMailUtils
 * @package com.huazai.b2c.aiyou.utils
 * @createdTime 2017年06月17日
 *
 * @version V1.0.0
 */
public class SendMailUtils
{

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doSendTextMail
	 *        <ul>
	 * @description 发送不同文本邮件
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @return
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 * @throws Exception
	 */
	public static AiyouResultData doSendTextMail() throws Exception
	{
		// 1、创建Properties对象，并为该对象设置相应内容
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		// 2、创建Session对象
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		// 3、创建Message对象，这个对象封装邮件的信息，如发件人、收件人、主题等
		Message msg = new MimeMessage(session);
		// 发件人
		msg.setFrom(new InternetAddress("huazai6789@aliyun.com"));
		msg.setText("Hello World !");
		// 收件人
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("who.seek.me@java98k.vip"));
		// 4、创建Transport对象，通过这个对象发送邮件
		Transport transport = session.getTransport();
		transport.connect("smtp.aliyun.com", 25, "huazai6789@aliyun.com", "!@#$%huazai12345");
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
		return AiyouResultData.ok();
	}

	public static void main(String[] args)
	{
		try
		{
			SendMailUtils.doSendTextMail();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
