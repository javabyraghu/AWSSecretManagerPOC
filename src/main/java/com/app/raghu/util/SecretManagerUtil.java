package com.app.raghu.util;

import com.app.raghu.entity.SFCustomKeys;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

public class SecretManagerUtil {

	public SFCustomKeys getCustomKeysFromAWSSecrets() {
		
		String secretName = "SFSecrets";
		Region region = Region.of("ap-south-1");

		SecretsManagerClient client = SecretsManagerClient.builder().region(region).build();

		GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder().secretId(secretName).build();

		GetSecretValueResponse getSecretValueResponse;

		try {
			getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
		} catch (Exception e) {
			throw e;
		}

		String secret = getSecretValueResponse.secretString();
		
		return JsonUtil.convertToType(secret);
	}
}
