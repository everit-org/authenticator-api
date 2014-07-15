/**
 * This file is part of org.everit.osgi.authenticator.api.
 *
 * org.everit.osgi.authenticator.api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * org.everit.osgi.authenticator.api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with org.everit.osgi.authenticator.api.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.authenticator;

/**
 * The Authenticator interface validates the incoming authentication information and maps the principal to an other
 * unique identifier if necessary. The authentication information (principal and credential) can be any kind of data
 * that can authenticate a user: email address, username, password, pin code, certificate, etc.
 */
public interface Authenticator {

    /**
     * Decides if the given principal and credential are valid. This can be done in database, LDAP, CAS, OpenID,
     * keystore, file, etc. It is possible to implement an {@link Authenticator} that combines these solutions by using
     * other {@link Authenticator}s. In case of successful authentication the principal can be mapped to any other
     * unique identifier (e.g. in case of LDAP, an email address can be mapped to an UID) if necessary or the original
     * principal should be returned. In case of failed authentication a <code>null</code> value must be returned.
     *
     * @param pricipal
     *            The principal to authenticate. E.g. email address, user name, etc.
     * @param credential
     *            The credential to authenticate with. E.g. password, pin code, certificate, etc.
     * @return The original principal or its mapped unique identifier if the authentication was successful. If the
     *         authentication fails a <code>null</code> value must be returned.
     */
    String authenticate(String pricipal, String credential);

}
