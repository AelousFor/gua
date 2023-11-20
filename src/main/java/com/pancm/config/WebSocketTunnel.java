package com.pancm.config;

import com.pancm.model.utils.AddressUtil;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleSocket;
import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.net.InetGuacamoleSocket;
import org.apache.guacamole.net.SimpleGuacamoleTunnel;
import org.apache.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.apache.guacamole.protocol.GuacamoleClientInformation;
import org.apache.guacamole.protocol.GuacamoleConfiguration;
import org.apache.guacamole.websocket.GuacamoleWebSocketTunnelEndpoint;
import org.springframework.stereotype.Component;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author pancm
 * @Title: WebSocketTunnel
 * @Description:
 * @Version:1.0.0
 * @Since:jdk1.8
 * @Date 2021/8/2
 **/
@ServerEndpoint(value = "/webSocket", subprotocols = "guacamole")
@Component
public class WebSocketTunnel extends GuacamoleWebSocketTunnelEndpoint {


    private MyConfig myConfig = (MyConfig) SpringBeanFactory.getBean("myConfig");


    /**
     * Returns a new tunnel for the given session. How this tunnel is created
     * or retrieved is implementation-dependent.
     *
     * @param session        The session associated with the active WebSocket
     *                       connection.
     * @param endpointConfig information associated with the instance of
     *                       the endpoint created for handling this single connection.
     * @return A connected tunnel, or null if no such tunnel exists.
     * @throws GuacamoleException If an error occurs while retrieving the
     *                            tunnel, or if access to the tunnel is denied.
     */
    @Override
    protected GuacamoleTunnel createTunnel(Session session, EndpointConfig endpointConfig) throws GuacamoleException {

        Map<String, List<String>> map = session.getRequestParameterMap();
        System.out.println(map);

        // 获取url的值
        Integer height = Integer.valueOf(map.get("height").get(0));
        Integer width = Integer.valueOf(map.get("width").get(0));
        GuacamoleClientInformation information = new GuacamoleClientInformation();
        information.setOptimalScreenHeight(height);
        information.setOptimalScreenWidth(width);

        //guacamole server地址 r端口
        String hostname = "172.22.56.11";
//        String hostname = "127.0.0.1";
        int port = 4822;
        GuacamoleConfiguration configuration = new GuacamoleConfiguration();

        //获取值
        String ip = AddressUtil.readConf(map.get("ip-key").get(0));
        String hostPort = map.get("port").get(0);
        String userName = map.get("username").get(0);
        String password = map.get("password").get(0);

        configuration.setProtocol("rdp");
        // 远程windows服务的地址
        configuration.setParameter("hostname", ip);
        configuration.setParameter("port", hostPort);
        configuration.setParameter("username", userName);
        configuration.setParameter("password", password);
        configuration.setParameter("ignore-cert", "true");
        configuration.setParameter("security", "NLA");

        GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
                new InetGuacamoleSocket(hostname, port),
                configuration,
                information
        );

        return new SimpleGuacamoleTunnel(socket);
    }

    private void optClose(Session session) {
        // 判断当前连接是否还在线
        if (session.isOpen()) {
            try {
                // 关闭连接
                CloseReason closeReason = new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "进行关闭！");
                session.close(closeReason);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
