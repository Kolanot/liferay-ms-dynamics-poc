package com.liferay.msdynamics.integration.config;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
	category = MSDynamicsConfigurationCategory._CATEGORY_KEY,
	scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
	id = MSDynamicsConfiguration.PID,
	localization = "content/ConfigurationLanguage",
	name = "configuration.name.ms.dynamics"
)
public interface MSDynamicsConfiguration {

	public static final String PID =
			"com.liferay.msdynamics.integration.config.MSDynamicsConfiguration";

	
	@Meta.AD(
			deflt = "",
			description = "configuration.ms.dynamics.token.desc",
			name = "configuration.ms.dynamics.token",
			required = false, type = Meta.Type.String
		)
	public String microsoftDynamicsOAuth2Token();

	@Meta.AD(
			deflt = "liferay.crm.dynamics.com",
			description = "configuration.ms.dynamics.host.desc",
			name = "configuration.ms.dynamics.host",
			required = true, type = Meta.Type.String
			)
	public String microsoftDynamicsHost();
	
	

}