# OIDC SPEC

OpenID Connect Specifications Constants and Serialization

### Specifications

The following is a non-exhaustive list of specifications followed:

- The OAuth 2.0 Authorization Framework [RFC6749](https://datatracker.ietf.org/doc/html/rfc6749)
- OAuth 2.0 Dynamic Client Registration Protocol [RFC7591](https://datatracker.ietf.org/doc/html/rfc7591)
- Proof Key for Code Exchange by OAuth Public Clients [RFC7636](https://datatracker.ietf.org/doc/html/rfc7636)
- Authentication Method Reference Values [RFC8176](https://datatracker.ietf.org/doc/html/rfc8176)

- JSON Web Key (JWK) [RFC7517](https://datatracker.ietf.org/doc/html/rfc7517)
- JSON Web Algorithms (JWA) [RFC7518](https://datatracker.ietf.org/doc/html/rfc7518)
- JSON Web Token (JWT) [RFC7519](https://datatracker.ietf.org/doc/html/rfc7519)

- OpenID Connect Core 1.0
  [OpenID.Core](https://openid.net/specs/openid-connect-core-1_0.html)
- OpenID Connect Discovery 1.0
  [OpenID.Discovery](https://openid.net/specs/openid-connect-discovery-1_0.html)
- OpenID Connect Dynamic Client Registration 1.0
  [OpenID.Registration](https://openid.net/specs/openid-connect-registration-1_0.html)
- OpenID Connect Core Error Code `unmet_authentication_requirements`
  [OpenID.unmet-authentication-requirements](https://openid.net/specs/openid-connect-unmet-authentication-requirements-1_0.html)
- Initiating User Registration via OpenID Connect 1.0
  [OpenID.prompt-create](https://openid.net/specs/openid-connect-prompt-create-1_0.html)
- OAuth 2.0 Multiple Response Type Encoding Practices
  [OAuth.Responses](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html)
- OAuth 2.0 Form Post Response Mode
  [OAuth.Post](http://openid.net/specs/oauth-v2-form-post-response-mode-1_0.html)

### Install

The main way of installing this library is using `jitpack.io`

```kts
repositories {
    // ...
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    // Replace TAG with the desired version
    implementation("net.lsafer.oidc-spec:jose:TAG")
    implementation("net.lsafer.oidc-spec:oauth:TAG")
    implementation("net.lsafer.oidc-spec:openid:TAG")
    implementation("net.lsafer.oidc-spec:serial:TAG")
}
```
