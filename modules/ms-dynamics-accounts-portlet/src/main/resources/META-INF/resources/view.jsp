<%@ include file="/init.jsp" %>

<%

SearchContainer msAccountsSearchContainer = (SearchContainer) request.getAttribute("accountsSearchContainer");

%>


<div class="container-fluid-1280">
	<liferay-ui:search-container searchContainer="<%= msAccountsSearchContainer %>" id="msAccountsSearchContainer">

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

			
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />

	</liferay-ui:search-container>
</div>