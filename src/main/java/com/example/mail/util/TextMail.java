package com.example.mail.util;

/**
 * 文本格式邮件
 * @author pcy
 *
 */
public class TextMail {
	/**
	 * @description 发送对象 多个以数组形势
	 */
	private String[] to;
	/**
	 * @description 邮件主题
	 */
	private String subject;
	/**
	 * @description 文本内容
	 */
	private String text;

	public TextMail() {
	}

	public TextMail(String[] to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public TextMail(String to, String subject, String text) {
		this.to = new String[] { to };
		this.subject = subject;
		this.text = text;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
