package com.huazai.livehouse.wechat.subscription.platform.factory;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @apiNote 发送https请求工厂类
 * @author        :林尚华
 * @date    : 2019/01/02 16:55
 */
public class HttpsClientRequestFactory extends SimpleClientHttpRequestFactory {

    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        try {
            if (!(connection instanceof HttpsURLConnection)){
                throw new RuntimeException("An instance of HttpsURLConnection is expected");
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;

            TrustManager[] trustManagers = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }
            };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(new MyCustomSSLSocketFactory(sslContext.getSocketFactory()));
            httpsURLConnection.setHostnameVerifier((s,sslSession) -> (true));
            super.prepareConnection(connection, httpMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyCustomSSLSocketFactory extends SSLSocketFactory{

        private final SSLSocketFactory delegate;

        public MyCustomSSLSocketFactory(SSLSocketFactory delegate) {
            this.delegate = delegate;
        }

        /**
         * 返回默认启用的密码套件。除非一个列表启用，对SSL连接的握手会使用这些密码套件。
         * 这些默认的服务的最低质量要求保密保护和服务器身份验证
         * @return
         */
        @Override
        public String[] getDefaultCipherSuites() {
            return delegate.getDefaultCipherSuites();
        }

        /**
         * 返回的密码套件可用于SSL连接启用的名字
         * @return
         */
        @Override
        public String[] getSupportedCipherSuites() {
            return delegate.getSupportedCipherSuites();
        }

        @Override
        public Socket createSocket(final Socket socket,final String host,final int port,final boolean autoClose) throws IOException {
            final Socket underlyingSocket = delegate.createSocket(socket, host, port, autoClose);
            return overrideProtocol(underlyingSocket);
        }

        @Override
        public Socket createSocket(final String host, final int port) throws IOException, UnknownHostException {
            final Socket underlyingSocket = delegate.createSocket(host, port);
            return overrideProtocol(underlyingSocket);
        }

        @Override
        public Socket createSocket(final String host, final int port, final InetAddress localAddress, final int localPort) throws IOException, UnknownHostException {
            final Socket underlyingSocket = delegate.createSocket(host, port, localAddress, localPort);
            return overrideProtocol(underlyingSocket);
        }

        @Override
        public Socket createSocket(final InetAddress host, final int port) throws IOException {
            final Socket underlyingSocket = delegate.createSocket(host, port);
            return overrideProtocol(underlyingSocket);
        }

        @Override
        public Socket createSocket(InetAddress host, int port, InetAddress localAddress, int localPort) throws IOException {
            final Socket underlyingSocket = delegate.createSocket(host, port, localAddress, localPort);
            return overrideProtocol(underlyingSocket);
        }

        private Socket overrideProtocol(final Socket socket) {
            if (!(socket instanceof SSLSocket)) {
                throw new RuntimeException("An instance of SSLSocket is expected");
            }
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1"});
            return socket;
        }
    }
}
