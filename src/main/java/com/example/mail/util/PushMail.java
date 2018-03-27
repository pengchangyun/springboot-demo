package com.example.mail.util;

import java.io.File;
import java.util.Date;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description 邮件推送工具类 多线程执行不关心结果
 */
@Component
public class PushMail {
	@Autowired
	private JavaMailSenderImpl mailSender;

	/**
	 * @description 推送文本格式邮件
	 */
	@Async
	public void pushText(final TextMail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mail.getTo());
		message.setFrom(mailSender.getUsername());
		message.setSubject(mail.getSubject());
		message.setText(mail.getText());
		message.setSentDate(new Date());
		mailSender.send(message);
	}

	/**
	 * @description 推送富文本格式邮件包括附件
	 */
	public void pushHtml(final HtmlMail mail) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(mail.getTo());
			helper.setFrom(mailSender.getUsername());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getText(), true);
			helper.setSentDate(new Date());
			Set<File> files = mail.getFiles();
			if (files != null) {
				for (File file : files) {
					helper.addAttachment(file.getName(), file);
				}
			}
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
