package com.example.springcloudconfig.config;

import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("mybatis")
public class MybatisEnvironmentRepository implements EnvironmentRepository {

    /**
     *
     * @param application
     * @param profile
     * @param label
     * @return
     */
    @Override
    public Environment findOne(String application, String profile, String label) {

        Map<String,String> map = new HashMap<String,String>();
        map.put("key1","key");
        map.put("key2","key");
        map.put("key3","key");
        map.put("application","config-client");
        if(application.equals("config-client")){
            map.put("myww","look at here");
        }

        Environment environment = new Environment(application,new String[]{profile},label,"1.0",null);
        environment.add(new PropertySource("application.properties",map));
        return environment;//new Environment(application,profile);
    }
}
