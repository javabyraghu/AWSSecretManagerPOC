package com.app.raghu.testcase;

import com.app.raghu.entity.SFCustomKeys;
import com.app.raghu.util.SecretManagerUtil;

public class Test {

	public static void main(String[] args) {
		SFCustomKeys obj = new SecretManagerUtil().getCustomKeysFromAWSSecrets(); 
		System.out.println(obj);
	}
}
