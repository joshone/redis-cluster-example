package cl.joshone.redisclient.config;

import java.net.URL;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisClientConfig {

//    @Bean
//    RedissonClient redissonClient(){
//
//        Config config = new Config();
//        config.setUseLinuxNativeEpoll(false);
//        config.useSingleServer().setAddress("redis://192.168.191.128:7006");
//        RedissonClient redissonClient = Redisson.create(config);
//        return redissonClient;
//    }

    @Bean
    RedissonClient redissonClusterClient(){

        Config config = new Config();
        try{
        	config = Config.fromYAML(new URL("http://138.122.226.57:8888/redis-cluster-config-dev.yml"));
        }catch(Exception e){
        	config.useClusterServers()
            .setScanInterval(2000)
            .addNodeAddress("redis://192.168.191.128:6379", "redis://192.168.191.128:7000",
            		"redis://192.168.191.128:7001", "redis://192.168.191.128:7002", "redis://192.168.191.128:7003", "redis://192.168.191.128:7004");
        }
        
		
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}
