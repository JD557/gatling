/*
 * Copyright 2011-2024 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.gatling.http.client;

import io.gatling.http.client.body.RequestBody;
import io.gatling.http.client.proxy.ProxyServer;
import io.gatling.http.client.realm.Realm;
import io.gatling.http.client.resolver.InetAddressNameResolver;
import io.gatling.http.client.uri.Uri;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.cookie.Cookie;
import java.net.InetAddress;
import java.util.List;
import java.util.function.Function;

public final class Request {

  private final String name;
  private final HttpMethod method;
  private final Uri uri;
  private final HttpHeaders headers;
  private final List<Cookie> cookies;
  private final RequestBody body;
  private final long requestTimeout;
  private final String virtualHost;
  private final boolean autoOrigin;
  private final InetAddress localIpV4Address;
  private final InetAddress localIpV6Address;
  private final Realm realm;
  private final ProxyServer proxyServer;
  private final Function<Request, Request> signatureCalculator;
  private final InetAddressNameResolver nameResolver;
  private final boolean http2Enabled;
  private final Http2PriorKnowledge http2PriorKnowledge;
  private final String wsSubprotocol;

  public Request(
      String name,
      HttpMethod method,
      Uri uri,
      HttpHeaders headers,
      List<Cookie> cookies,
      RequestBody body,
      long requestTimeout,
      String virtualHost,
      boolean autoOrigin,
      InetAddress localIpV4Address,
      InetAddress localIpV6Address,
      Realm realm,
      ProxyServer proxyServer,
      Function<Request, Request> signatureCalculator,
      InetAddressNameResolver nameResolver,
      boolean http2Enabled,
      Http2PriorKnowledge http2PriorKnowledge,
      String wsSubprotocol) {
    this.name = name;
    this.method = method;
    this.uri = uri;
    this.headers = headers;
    this.cookies = cookies;
    this.body = body;
    this.requestTimeout = requestTimeout;
    this.virtualHost = virtualHost;
    this.autoOrigin = autoOrigin;
    this.localIpV4Address = localIpV4Address;
    this.localIpV6Address = localIpV6Address;
    this.realm = realm;
    this.proxyServer = proxyServer;
    this.signatureCalculator = signatureCalculator;
    this.nameResolver = nameResolver;
    this.http2Enabled = http2Enabled;
    this.http2PriorKnowledge = http2PriorKnowledge;
    this.wsSubprotocol = wsSubprotocol;
  }

  public Request copyWithCopiedHeaders() {
    return new Request(
        this.name,
        this.method,
        this.uri,
        this.headers.copy(),
        this.cookies,
        this.body,
        this.requestTimeout,
        this.virtualHost,
        this.autoOrigin,
        this.localIpV4Address,
        this.localIpV6Address,
        this.realm,
        this.proxyServer,
        this.signatureCalculator,
        this.nameResolver,
        this.http2Enabled,
        this.http2PriorKnowledge,
        this.wsSubprotocol);
  }

  public Request copyWithNewUri(Uri uri) {
    return new Request(
        this.name,
        this.method,
        uri,
        this.headers,
        this.cookies,
        this.body,
        this.requestTimeout,
        this.virtualHost,
        this.autoOrigin,
        this.localIpV4Address,
        this.localIpV6Address,
        this.realm,
        this.proxyServer,
        this.signatureCalculator,
        this.nameResolver,
        this.http2Enabled,
        this.http2PriorKnowledge,
        this.wsSubprotocol);
  }

  public Request copyWithNewBody(RequestBody body) {
    return new Request(
        this.name,
        this.method,
        this.uri,
        this.headers,
        this.cookies,
        body,
        this.requestTimeout,
        this.virtualHost,
        this.autoOrigin,
        this.localIpV4Address,
        this.localIpV6Address,
        this.realm,
        this.proxyServer,
        this.signatureCalculator,
        this.nameResolver,
        this.http2Enabled,
        this.http2PriorKnowledge,
        this.wsSubprotocol);
  }

  public Request copyWithHttp2PriorKnowledge(Http2PriorKnowledge http2PriorKnowledge) {
    return new Request(
        this.name,
        this.method,
        this.uri,
        this.headers,
        this.cookies,
        this.body,
        this.requestTimeout,
        this.virtualHost,
        this.autoOrigin,
        this.localIpV4Address,
        this.localIpV6Address,
        this.realm,
        this.proxyServer,
        this.signatureCalculator,
        this.nameResolver,
        this.http2Enabled,
        http2PriorKnowledge,
        this.wsSubprotocol);
  }

  public String getName() {
    return name;
  }

  public HttpMethod getMethod() {
    return method;
  }

  public Uri getUri() {
    return uri;
  }

  public HttpHeaders getHeaders() {
    return headers;
  }

  public List<Cookie> getCookies() {
    return cookies;
  }

  public RequestBody getBody() {
    return body;
  }

  public long getRequestTimeout() {
    return requestTimeout;
  }

  public String getVirtualHost() {
    return virtualHost;
  }

  public boolean isAutoOrigin() {
    return autoOrigin;
  }

  public InetAddress getLocalIpV4Address() {
    return localIpV4Address;
  }

  public InetAddress getLocalIpV6Address() {
    return localIpV6Address;
  }

  public Realm getRealm() {
    return realm;
  }

  public ProxyServer getProxyServer() {
    return proxyServer;
  }

  public Function<Request, Request> getSignatureCalculator() {
    return signatureCalculator;
  }

  public InetAddressNameResolver getNameResolver() {
    return nameResolver;
  }

  public boolean isHttp2Enabled() {
    return http2Enabled;
  }

  public Http2PriorKnowledge getHttp2PriorKnowledge() {
    return http2PriorKnowledge;
  }

  public String getWsSubprotocol() {
    return wsSubprotocol;
  }

  @Override
  public String toString() {
    return "Request{"
        + "method="
        + method
        + ", uri="
        + uri
        + ", headers="
        + headers
        + ", cookies="
        + cookies
        + ", body="
        + body
        + ", requestTimeout="
        + requestTimeout
        + ", virtualHost='"
        + virtualHost
        + '\''
        + ", localIpV4Address="
        + localIpV4Address
        + ", localIpV6Address="
        + localIpV6Address
        + ", realm="
        + realm
        + ", proxyServer="
        + proxyServer
        + ", signatureCalculator="
        + signatureCalculator
        + ", nameResolver="
        + nameResolver
        + ", http2Enabled="
        + http2Enabled
        + ", http2PriorKnowledge="
        + http2PriorKnowledge
        + ", wsSubprotocol="
        + wsSubprotocol
        + '}';
  }
}
