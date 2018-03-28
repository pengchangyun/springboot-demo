package com.example.mail;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
	public void simpleSendEmail() throws InterruptedException, ExecutionException {
		TextMail textMail = new TextMail("718988677@qq.com", "吃饭", "请客哦");
		Future<String> task = pushMail.pushText(textMail);
		
		while(true) {
			if(task.isDone()) {
				System.out.println(task.get());
				break;
			}
			Thread.sleep(500);
		}
	}
}
