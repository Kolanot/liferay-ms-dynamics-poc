package com.liferay.msdynamics.integration.rest.client.resource.v1_0;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import com.liferay.msdynamics.integration.rest.client.dto.v1_0.MSDynamicsResponse;
import com.liferay.msdynamics.integration.rest.client.exception.RestException;
import com.liferay.msdynamics.integration.rest.client.http.HttpInvoker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Filipe Afonso
 * @generated
 */
@Generated("")
public interface IMSDynamicsResource {

	public static Builder builder() {
		return new Builder();
	}

//	public MSDynamicsResponse postIMediaResponse(MSDynamicsResponse iMediaResponse) throws Exception;
//
//	public HttpInvoker.HttpResponse postIMediaResponseHttpResponse(MSDynamicsResponse iMediaResponse) throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public IMSDynamicsResource build() {
			return new MSDynamicsResourceImpl(this);
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder header(String key, String value) {
			_headers.put(key, value);

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		public Builder parameter(String key, String value) {
			_parameters.put(key, value);

			return this;
		}

		private Builder() {
		}

		private Map<String, String> _headers = new LinkedHashMap<>();
		private String _host = "";
		private Locale _locale;
		private String _login = "";
		private String _password = "";
		private Map<String, String> _parameters = new LinkedHashMap<>();
		private int _port = 8080;
		private String _scheme = "https";

	}

	public static class MSDynamicsResourceImpl implements IMSDynamicsResource {
		
		

		public MSDynamicsResponse getMSDynamicsAccounts(MSDynamicsResponse msDynamicsResponse) throws Exception {
			
			HttpInvoker.HttpResponse httpResponse = getMSDynamicsAccountsHttpResponse(msDynamicsResponse);
			
			String content = httpResponse.getContent();
			
			if (_log.isDebugEnabled()) {
				_log.debug("HTTP response content: " + content);
				_log.debug("HTTP response message: " + httpResponse.getMessage());
				_log.debug("HTTP response status code: " + httpResponse.getStatusCode());
			}
			
			if (httpResponse.getStatusCode() != 200) {
				throw new RestException("HTTP Status Code: " + httpResponse.getStatusCode()
				+ ". HTTP Response Message: " + httpResponse.getMessage() + ". Response Content: " + content);
			}
			
			msDynamicsResponse.setMessage(httpResponse.getStatusCode() + httpResponse.getMessage() + content);
			return msDynamicsResponse;
			
		}
		
//		public MSDynamicsResponse postIMediaResponse(MSDynamicsResponse iMediaResponse) throws Exception {
//
//			HttpInvoker.HttpResponse httpResponse = postIMediaResponseHttpResponse(iMediaResponse);
//
//			String content = httpResponse.getContent();
//
//			_logger.fine("HTTP response content: " + content);
//			_logger.fine("HTTP response message: " + httpResponse.getMessage());
//			_logger.fine("HTTP response status code: " + httpResponse.getStatusCode());
//
//			if (httpResponse.getStatusCode() != 200) {
//				throw new RestException("HTTP Status Code: " + httpResponse.getStatusCode()
//						+ ". HTTP Response Message: " + httpResponse.getMessage() + ". Response Content: " + content);
//			}
//
//			// Persist Result from jitterbit.
//			iMediaResponse.setMessage(httpResponse.getStatusCode() + httpResponse.getMessage() + content);
//			return iMediaResponse;
//
//		}

		public HttpInvoker.HttpResponse getMSDynamicsAccountsHttpResponse(MSDynamicsResponse msDynamicsResponse) throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(msDynamicsResponse.toString(), "application/xml");

			if (_builder._locale != null) {
				httpInvoker.header("Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry : _builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry : _builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			httpInvoker.path(_builder._scheme + "://" + _builder._host);

			httpInvoker.userNameAndPassword(_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private MSDynamicsResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Log _log = LogFactoryUtil.getLog(MSDynamicsResourceImpl.class);

		
		private Builder _builder;

	}

}