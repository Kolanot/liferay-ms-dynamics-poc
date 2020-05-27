package com.liferay.msdynamics.command;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.msdynamics.integration.config.MSDynamicsConfiguration;
import com.liferay.msdynamics.integration.rest.client.dto.v1_0.MSDynamicsResponse;
import com.liferay.msdynamics.integration.rest.client.resource.v1_0.IMSDynamicsResource;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;

/**
 * @author fafonso
 */
@Component(
	property = {
		"osgi.command.function=msgetaccounts", "osgi.command.scope=ms"
	},
	service = Object.class
)
public class MSGetAccountsCommand {

	public void msgetaccounts() {

		System.out.println("---------------Getting MS Dynamics Accounts using the rest client---------------");
		
		MSDynamicsConfiguration msDynamicsConfiguration;
		try {
			msDynamicsConfiguration = _configurationProvider.getSystemConfiguration(MSDynamicsConfiguration.class);
		} catch (ConfigurationException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("TOKEN: " + msDynamicsConfiguration.microsoftDynamicsOAuth2Token());
		System.out.println("HOST: " + msDynamicsConfiguration.microsoftDynamicsHost());
		
		System.out.println(getAccounts(msDynamicsConfiguration.microsoftDynamicsHost(), msDynamicsConfiguration.microsoftDynamicsOAuth2Token()));
		
	}
	
	private String getAccounts(String host, String token)  {

		IMSDynamicsResource.Builder builder = IMSDynamicsResource.builder();

		// TODO Send all this to the REST resource
		builder.endpoint(host + "/api/data/v9.0/accounts", -1, "https");
		
		// Set authoriaztion
		builder.authentication(token);

		// Set header content of post request.
		builder.header("OData-MaxVersion", "4.0");
		builder.header("OData-Version", "4.0");
		builder.header("Content-Type", "application/json");
		builder.header("Host", host);
//		builder.header("User-Agent", "PostmanRuntime/7.24.0");
		builder.header("Accept", "*/*");
//		builder.header("Accept-Encoding", "gzip, deflate, br");
//		builder.header("Connection", "keep-alive");
//		builder.header("Postman-Token", "068ff986-822c-428f-8d13-46c3176298c3");
//		builder.header("Cookie", "ARRAffinity=0ee99854aa933c9667ea58c0c10ac070465ba8e1f711ec984f2f645f512e5531; ReqClientId=3643a996-144c-4081-8813-cf8c3e321775; orgId=4bf9de81-9ab3-45a1-8359-c62413965a34");

		IMSDynamicsResource imsDynamicsResource = builder.build();

		// Set body content of post request.
		// No need to set info in the body for this case
		
		MSDynamicsResponse msDynamicsResponse;
		

		try {

			msDynamicsResponse = imsDynamicsResource.getMSDynamicsAccounts();

		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error(e);
			return null;
		}
		
		return msDynamicsResponse.getMessage();
	}

	
	@Reference
	protected ConfigurationProvider _configurationProvider;

	private static final Log _log = LogFactoryUtil.getLog(MSGetAccountsCommand.class);
}