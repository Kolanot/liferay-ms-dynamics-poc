<%@ include file="/init.jsp" %>

<%
String currentURL = (String)request.getAttribute("currentURL");
%>

<!-- Not implemented yet -->
<liferay-portlet:renderURL var="addAccountRenderURL" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="/account/form" />
	<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="title" value='<%= LanguageUtil.get(request, "add-account")%>' />
</liferay-portlet:renderURL>
<!-- Not implemented yet -->

<liferay-frontend:management-bar>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:add-menu
			inline="<%= true %>">
			<liferay-frontend:add-menu-item
				title="<%= LanguageUtil.get(request, "add-account") %>"
				url="<%= addAccountRenderURL.toString() %>"
			/>
		</liferay-frontend:add-menu>
	</liferay-frontend:management-bar-buttons>
</liferay-frontend:management-bar>

<div class="container-fluid-1280">
	<liferay-ui:search-container searchContainer="${accountsSearchContainer}">

		<liferay-ui:search-container-row
			className="ms.dynamics.accounts.portlet.data.MSAccount"
			modelVar="msAccount"
		>
			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				name="name"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				name="phone"
				property="phone"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				name="city"
				property="city"
			/>

			<liferay-ui:search-container-column-text
				cssClass="table-cell-content"
				name="mail"
				property="mail"
			/>

			<!-- Not implemented yet
			
			<liferay-portlet:actionURL var="deleteStoreURL" name="/settings/store/delete">
				<liferay-portlet:param name="demandCaptureStoreId" value="test" />
			</liferay-portlet:actionURL>

			<liferay-ui:search-container-column-text>
				<liferay-ui:icon-menu
					direction="left-side"
					markupView="lexicon"
					showWhenSingleIcon="<%= true %>"
				>
					<c:choose>
						<c:when test="${!store.active}">
							<portlet:actionURL name="/settings/store/update" var="editStoreActionUrl" >
								<portlet:param name="demandCaptureStoreId" value="${store.demandCaptureStoreId}" />
								<portlet:param name="demandCaptureSegmentId" value="${store.demandCaptureSegmentId}" />
								<portlet:param name="active" value="true" />
								<portlet:param name="storeName" value="${store.name}" />
							</portlet:actionURL>

							<liferay-ui:icon message="activate" url='test' />

							<liferay-ui:icon-delete message="delete-store" url="${deleteStoreURL}" />
						</c:when>
						<c:otherwise>

							<portlet:actionURL name="/settings/store/update" var="editStoreActionUrl" >
								<portlet:param name="demandCaptureStoreId" value="${store.demandCaptureStoreId}" />
								<portlet:param name="demandCaptureSegmentId" value="${store.demandCaptureSegmentId}" />
								<portlet:param name="active" value="false" />
								<portlet:param name="storeName" value="${store.name}" />
							</portlet:actionURL>

							<liferay-ui:icon message="edit-store" url='test' />

							<liferay-ui:icon message="deactivate" url='test' />
						</c:otherwise>
					</c:choose>
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
			-->
			
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />

	</liferay-ui:search-container>
</div>