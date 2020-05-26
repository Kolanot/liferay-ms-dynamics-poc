package com.liferay.msdynamics.integration.rest.client.dto.v1_0;

import java.util.Objects;

import com.liferay.msdynamics.integration.rest.client.function.UnsafeSupplier;

/**
 * @author Filipe Afonso
 */
public class MSDynamicsResponse {

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String message;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MSDynamicsResponse)) {
			return false;
		}

		MSDynamicsResponse iMediaResponse = (MSDynamicsResponse) object;

		return Objects.equals(toString(), iMediaResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	@Override
	public String toString() {
		return getMessage();
	}

}