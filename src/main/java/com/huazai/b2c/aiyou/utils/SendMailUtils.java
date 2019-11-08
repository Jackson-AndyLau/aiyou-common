package com.huazai.b2c.aiyou.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.huazai.b2c.aiyou.common.Constant;
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
	public static AiyouResultData doSendTextMail()
	{
		// 1、创建Properties对象，并为该对象设置相应内容
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		// 2、创建Session对象
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		try
		{
			// 3、创建Message对象，这个对象封装邮件的信息，如发件人、收件人、主题等
			Message msg = new MimeMessage(session);
			// 发件人
			msg.setFrom(new InternetAddress("huazai6789@aliyun.com"));
			// 邮件文本内容
			msg.setText("【这是发送的普通的文本邮件】");
			// 主题
			msg.setSubject("aiyou-exception-warning");
			// 收件人
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("who.seek.me@java98k.vip"));
			// 4、创建Transport对象，通过这个对象发送邮件
			Transport transport = session.getTransport();
			transport.connect("smtp.aliyun.com", Constant.EMAIL_USER_NAME, Constant.EMAIL_USER_PASSWORD);
			transport.sendMessage(msg, msg.getAllRecipients());
			// 关闭连接
			transport.close();
		} catch (AddressException e)
		{
			e.printStackTrace();
		} catch (MessagingException e)
		{
			e.printStackTrace();
		}
		return AiyouResultData.ok();
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doSendBunchTextMail
	 *        <ul>
	 * @description
	 *              <li>群发邮件
	 *              <li>有些参数设置是比较灵活的，比如邮箱主机地址smtp.163.com、用户名、密码既可以利用props对象进行设置，也可以在Transport对象与服务器连接时进行指定
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @return
	 * @throws Exception
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 */
	public static AiyouResultData doSendBunchTextMail()
	{
		// 1、创建Properties对象，并为该对象设置相应内容
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.aliyun.com");
		// 2、创建Session对象
		Session session = Session.getInstance(props, new Authenticator()
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(Constant.EMAIL_USER_NAME, Constant.EMAIL_USER_PASSWORD);
			}
		});
		session.setDebug(true);
		try
		{
			// 3、创建MimeMessage对象，这个对象封装邮件的信息，如发件人、收件人、主题等
			MimeMessage msg = new MimeMessage(session);
			// 发件人
			msg.setFrom(new InternetAddress("huazai6789@aliyun.com"));
			// 主题
			msg.setSubject("aiyou-exception-warning");
			// 邮件内容
			msg.setContent("<span style='color:red;margin:0 auto'>【这是批量发送的文本邮件】</span>", "text/html;charset=utf-8");
			// 收件人
			msg.setRecipients(RecipientType.TO,
					InternetAddress.parse("who.seek.me@java98k.vip,dl.herbert@foxmail.com"));
			// 4、发送消息
			Transport.send(msg);
		} catch (AddressException e)
		{
			e.printStackTrace();
		} catch (MessagingException e)
		{
			e.printStackTrace();
		}
		return AiyouResultData.ok();
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doSendTextWithAttachment
	 *        <ul>
	 * @description 发送普通附件邮件
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @return
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 * @throws Exception
	 */
	public static AiyouResultData doSendTextWithAttachment()
	{
		// 1、创建Properties对象，并为该对象设置相应内容
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.aliyun.com");
		// 2、创建Session对象
		Session session = Session.getDefaultInstance(props);
		try
		{
			// 3、创建MimeMessage对象，这个对象封装邮件的信息，如发件人、收件人、主题等
			MimeMessage msg = new MimeMessage(session);
			// 设置邮件主题
			msg.setSubject("aiyou-exception-warning");
			// 发件人
			msg.setFrom(new InternetAddress("huazai6789@aliyun.com"));
			// 收件人
			msg.setRecipient(RecipientType.TO, new InternetAddress("who.seek.me@java98k.vip"));
			// 4、创建对象
			MimeMultipart multipart = new MimeMultipart();
			// 5、创建BodyPart对象封装内容
			BodyPart bodyPart = new MimeBodyPart();
			// 发送的内容
			bodyPart.setContent("<font color='red'>【这是发送的带附件的邮件】</font>", "text/html;charset=utf8");
			multipart.addBodyPart(bodyPart);
			// 每一个部分实例化一个bodypart，故每个附件也需要实例化一个bodypart
			bodyPart = new MimeBodyPart();
			// 添加发送的邮件附件
			File file = new File("F:\\迅雷下载\\apache-maven-3.6.1-bin.zip");
			DataSource ds = new FileDataSource(file.getAbsolutePath());
			DataHandler dh = new DataHandler(ds);
			bodyPart.setDataHandler(dh);
			// 设置附件标题，使用MimeUtility进行名字转码，否则接收到的是乱码
			bodyPart.setFileName(MimeUtility.encodeText(file.getName()));
			multipart.addBodyPart(bodyPart);
			// 6、设置消息发送内容
			msg.setContent(multipart);
			// 7、创建Transport对象，通过这个对象发送邮件
			Transport transport = session.getTransport();
			transport.connect("smtp.aliyun.com", Constant.EMAIL_USER_NAME, Constant.EMAIL_USER_PASSWORD);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (MessagingException e)
		{
			e.printStackTrace();
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return AiyouResultData.ok();
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title doSendBunchTextWithAttachment
	 *        <ul>
	 * @description 群发的带附件的邮件
	 *              </ul>
	 * @createdTime 2017年06月17日
	 * @return
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 * @throws Exception
	 */
	public static AiyouResultData doSendBunchTextWithAttachment()
	{
		// 1、创建Properties对象，并为该对象设置相应内容
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.aliyun.com");
		// 2、创建Session对象
		Session session = Session.getDefaultInstance(props);
		try
		{
			// 3、创建MimeMessage对象，这个对象封装邮件的信息，如发件人、收件人、主题等
			MimeMessage msg = new MimeMessage(session);
			// 设置邮件主题
			msg.setSubject("aiyou-exception-warning");
			// 发件人
			msg.setFrom(new InternetAddress("huazai6789@aliyun.com"));
			// 收件人
			msg.setRecipients(RecipientType.TO,
					InternetAddress.parse("who.seek.me@java98k.vip,dl.herbert@foxmail.com"));
			// 4、创建对象
			MimeMultipart multipart = new MimeMultipart();
			// 5、创建BodyPart对象封装内容
			BodyPart bodyPart = new MimeBodyPart();
			// 发送的内容
			bodyPart.setContent("<font color='red'>【这是批量发送的带附件的邮件】</font>", "text/html;charset=utf8");
			multipart.addBodyPart(bodyPart);
			// 每一个部分实例化一个bodypart，故每个附件也需要实例化一个bodypart
			bodyPart = new MimeBodyPart();
			// 添加发送的邮件附件
			File file = new File("F:\\迅雷下载\\apache-maven-3.6.1-bin.zip");
			DataSource ds = new FileDataSource(file.getAbsolutePath());
			DataHandler dh = new DataHandler(ds);
			bodyPart.setDataHandler(dh);
			// 设置附件标题，使用MimeUtility进行名字转码，否则接收到的是乱码
			bodyPart.setFileName(MimeUtility.encodeText(file.getName()));
			multipart.addBodyPart(bodyPart);
			// 6、设置消息发送内容
			msg.setContent(multipart);
			// 7、创建Transport对象，通过这个对象发送邮件
			Transport transport = session.getTransport();
			transport.connect("smtp.aliyun.com", Constant.EMAIL_USER_NAME, Constant.EMAIL_USER_PASSWORD);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (MessagingException e)
		{
			e.printStackTrace();
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return AiyouResultData.ok();
	}
}
