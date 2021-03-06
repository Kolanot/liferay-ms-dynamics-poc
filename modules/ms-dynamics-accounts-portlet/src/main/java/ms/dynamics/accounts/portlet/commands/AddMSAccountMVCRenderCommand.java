/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ms.dynamics.accounts.portlet.commands;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import ms.dynamics.accounts.portlet.constants.MsDynamicsAccountsPortletKeys;

/**
 * @author Fiipe Afonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + MsDynamicsAccountsPortletKeys.MSDYNAMICSACCOUNTS,
		"mvc.command.name=addAccount"
	},
	service = MVCRenderCommand.class
)
public class AddMSAccountMVCRenderCommand implements MVCRenderCommand {

	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {
		
		return "/addMsAccount.jsp";
	}


}