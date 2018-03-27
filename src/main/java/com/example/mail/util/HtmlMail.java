package com.example.mail.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * @description html格式邮件
 */
public class HtmlMail {
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

	/**
	 * @description 文件集合
	 */
	private Set<File> files;

	public HtmlMail() {
	}

	public HtmlMail(String[] to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public HtmlMail(String[] to, String subject, String text, File file) {
		this.to = to;
		this.subject = subject;
		this.text = text;
		Set<File> files = new HashSet<File>();
		files.add(file);
		this.files = files;
	}

	public HtmlMail(String to, String subject, String text) {
		this.to = new String[] { to };
		this.subject = subject;
		this.text = text;
	}

	public HtmlMail(String to, String subject, String text, File file) {
		this.to = new String[] { to };
		this.subject = subject;
		this.text = text;
		Set<File> files = new HashSet<File>();
		files.add(file);
		this.files = files;
	}

	public HtmlMail(String[] to, String subject, String text, Set<File> files) {
		this.to = to;
		this.subject = subject;
		this.text = text;
		this.files = files;
	}

	public HtmlMail(String to, String subject, String text, Set<File> files) {
		this.to = new String[] { to };
		this.subject = subject;
		this.text = text;
		this.files = files;
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

	public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}
}
