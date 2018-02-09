package org.future.ims.test;

import org.future.ims.pojo.EamilPassword;
import org.future.ims.utils.IOEamilPassword;

public class IOTest {
	public static void main(String[] args) {
		EamilPassword eamilPassword = new EamilPassword();
		eamilPassword.setEmailName("1719982754@qq.com");
		eamilPassword.setEamilPassword("ogmqdtlyhbvzdfbf");
		IOEamilPassword ioEamilPassword = new IOEamilPassword();
		ioEamilPassword.save(eamilPassword);
		/*EamilPassword load = ioEamilPassword.load();
		System.out.println(load.toString());
		System.out.println(load.getEmailName());
		System.out.println(load.getEamilPassword());*/
	}
}
