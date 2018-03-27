package com.example.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mail.util.PushMail;
import com.example.mail.util.TextMail;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTest {

	@Autowired
	private PushMail pushMail;

	@Test
	public void simpleSendEmail() {
		TextMail textMail = new TextMail("718988677@qq.com", "吃饭", "请客哦");
		pushMail.pushText(textMail);
	}
}
