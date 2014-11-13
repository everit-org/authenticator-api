authenticator-api
=================

API for validating users against different datasources.

#Interface
[Authenticator][3]: validates the incoming authentication information and maps 
the principal to an other unique identifier if necessary. The authentication 
information (principal and credential) can be any kind of data that can 
authenticate a user: email address, user name, password, pin code, certificate,
etc.

#Concept
Full authentication concept is available on blog post [Everit Authentication][1].
Implemented components based on this concept are listed [here][4].

#Implementation
Available implementations:
 - [authentication-simple][2]
 - [authenticator-ldap][5]

[![Analytics](https://ga-beacon.appspot.com/UA-15041869-4/everit-org/authenticator-api)](https://github.com/igrigorik/ga-beacon)

[1]: http://everitorg.wordpress.com/2014/07/31/everit-authentication/
[2]: https://github.com/everit-org/authentication-simple
[3]: http://attilakissit.wordpress.com/2014/07/09/everit-authentication/#authenticator
[4]: http://everitorg.wordpress.com/2014/07/31/everit-authentication-implemented-and-released-2/
[5]: https://github.com/everit-org/authenticator-ldap
