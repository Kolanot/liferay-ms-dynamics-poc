package ms.dynamics.accounts.portlet.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.msdynamics.integration.config.MSDynamicsConfiguration;
import com.liferay.msdynamics.integration.rest.client.dto.v1_0.MSDynamicsResponse;
import com.liferay.msdynamics.integration.rest.client.exception.RestException;
import com.liferay.msdynamics.integration.rest.client.resource.v1_0.IMSDynamicsResource;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import ms.dynamics.accounts.portlet.constants.MsDynamicsAccountsPortletKeys;

/**
 * @author fafonso
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MsDynamicsAccounts",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MsDynamicsAccountsPortletKeys.MSDYNAMICSACCOUNTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MsDynamicsAccountsPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
		
		// Try to get MS Dynamic accounts
		MSDynamicsConfiguration msDynamicsConfiguration;
		MSDynamicsResponse msDynamicsResponse = null;
		try {
			msDynamicsConfiguration = _configurationProvider.getSystemConfiguration(MSDynamicsConfiguration.class);
		
			IMSDynamicsResource.Builder builder = IMSDynamicsResource.builder();
			IMSDynamicsResource imsDynamicsResource = builder.build();

			msDynamicsResponse = imsDynamicsResource.getMSDynamicsAccounts(msDynamicsConfiguration.microsoftDynamicsHost(), msDynamicsConfiguration.microsoftDynamicsOAuth2Token());

		} catch (RestException | IOException | ConfigurationException e) {
			_log.error(e.getMessage(), e);
		}
		
		if (msDynamicsResponse != null) {
			parseMSDynamicsAccounts(msDynamicsResponse.getContent());
		}
		
	}
	
	private void parseMSDynamicsAccounts(String content) {
		if (StringUtils.isEmpty(content)) {
			return;
		}
		
		JsonParser parser = new JsonParser();
		JsonElement jsonTree = parser.parse(content);
		
		
		if(jsonTree.isJsonObject()){
		    JsonObject jsonObject = jsonTree.getAsJsonObject();


		    JsonElement accounts = jsonObject.get("value");

		    if(accounts.isJsonArray()){
		    		for (JsonElement account : accounts.getAsJsonArray()) {
		    			
		    			_log.info(account.getAsJsonObject().get("name"));
		    		}
		    }

		}
		
	}
	
	@Reference
	protected ConfigurationProvider _configurationProvider;

	private static final Log _log = LogFactoryUtil.getLog(MsDynamicsAccountsPortlet.class);
	
}