package com.pancm.config;

import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleSocket;
import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.net.InetGuacamoleSocket;
import org.apache.guacamole.net.SimpleGuacamoleTunnel;
import org.apache.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.apache.guacamole.protocol.GuacamoleConfiguration;
import org.apache.guacamole.servlet.GuacamoleHTTPTunnelServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
* @Title: HttpTunnelServlet
* @Description:
* @Version:1.0.0
* @Since:jdk1.8
* @author pancm
* @Date  2021/7/2
**/
@WebServlet(urlPatterns = "/tunnel")
public class HttpTunnelServlet extends GuacamoleHTTPTunnelServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -3224942386695394818L;

	@Override
	protected GuacamoleTunnel doConnect(HttpServletRequest request) throws GuacamoleException {
        System.out.println("request:"+request.getParameterMap());
        System.out.println("request2:"+request.getParameterNames());

	    String hostname = "172.22.56.11"; //guacamole server地址
        int port = 4822; //guacamole server端口
        GuacamoleConfiguration configuration = new GuacamoleConfiguration();

//        configuration.setProtocol("rdp"); // 远程连接协议
//        configuration.setParameter("hostname", "172.22.56.14");
//        configuration.setParameter("port", "6400");
//        configuration.setParameter("username", "HPC\\huangxiaojie");
//        configuration.setParameter("password", "Aa123456");
//        configuration.setParameter("ignore-cert", "true");
        configuration.setProtocol("rdp"); // 远程连接协议
        configuration.setParameter("hostname", "172.29.105.248");
        configuration.setParameter("port", "3389");
        configuration.setParameter("username", "huangxiaojie");
        configuration.setParameter("password", "Aa123456");
        configuration.setParameter("ignore-cert", "true");
        configuration.setParameter("security", "NLA");

//        configuration.setProtocol("ssh");
//        configuration.setParameter("hostname", "114.116.21.159");
//        configuration.setParameter("port", "22");
//        configuration.setParameter("username", "root");
//        configuration.setParameter("password", "13271314@hw");
//        configuration.setParameter("ignore-cert", "true");

//        configuration.setProtocol("ssh");
//        configuration.setParameter("hostname", "172.22.56.12");
//        configuration.setParameter("port", "22");
//        configuration.setParameter("username", "huangxiaojie");
//        configuration.setParameter("password", "Aa123456");
//        configuration.setParameter("ignore-cert", "true");
        GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
                new InetGuacamoleSocket(hostname, port),
                configuration
        );
        GuacamoleTunnel tunnel = new SimpleGuacamoleTunnel(socket);
        return tunnel;
	}
}
