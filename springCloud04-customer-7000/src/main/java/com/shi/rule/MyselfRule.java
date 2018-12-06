package com.shi.rule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * 自定义我们的LB算法规则
 * 注意：不能把该类放在@ComponentScan注解包含的所有包及子包下面
 * MySelfRule必须不能是spring所扫描的包，
 * @author SHF
 * @version 创建时间：2018年11月30日  上午11:32:23
 */
public class MyselfRule extends AbstractLoadBalancerRule {

    private static Logger log = LoggerFactory.getLogger(MyselfRule.class);
    
    /*
     *  需求：让每个服务被调用5次之后再切换到下一台服务器
     */
    private int total = 0; //总共被调用的次数，目前要求每台被调用5次
    private int currentIndex = 0; //当前提供服务的机器号

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();//获取所有的服务器

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            //int index = chooseRandomInt(serverCount);
            if(total < 5) {
            	server = upList.get(currentIndex);
            	total++;
            }else {
            	total = 0;
            	currentIndex++;
            	if(currentIndex >= upList.size()) {
            		currentIndex = 0;
            	}
            }
            

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }


    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}