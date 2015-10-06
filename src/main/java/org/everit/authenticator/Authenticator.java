/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.biz)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.authenticator;

import java.util.Optional;

/**
 * The Authenticator interface validates the incoming authentication information and maps the
 * principal to an other unique identifier if necessary. The authentication information (principal
 * and credential) can be any kind of data that can authenticate a user: email address, user name,
 * password, pin code, certificate, etc.
 */
public interface Authenticator {

  /**
   * Decides if the given principal and credential are valid. This can be done in database, LDAP,
   * CAS, OpenID, keystore, file, etc. It is possible to implement an {@link Authenticator} that
   * combines these solutions by using other {@link Authenticator}s. In case of successful
   * authentication the principal can be mapped to any other unique identifier (e.g. in case of
   * LDAP, an email address can be mapped to an UID) if necessary or the original principal should
   * be returned. In case of failed authentication a <code>null</code> value must be returned.
   *
   * @param principal
   *          The principal to authenticate. E.g. email address, user name, etc.
   * @param credential
   *          The credential to authenticate with. E.g. password, pin code, certificate, etc.
   * @return an {@link Optional} with the original principal or its mapped unique identifier if the
   *         authentication was successful. An {@link Optional} with <code>null</code> value must be
   *         returned if the authentication fails or one of the input parameter is <code>null</code>
   *         .
   */
  Optional<String> authenticate(String principal, String credential);

}
