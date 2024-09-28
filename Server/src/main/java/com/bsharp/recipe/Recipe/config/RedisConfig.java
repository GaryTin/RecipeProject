package com.bsharp.recipe.Recipe.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.util.Arrays;
import java.util.HashSet;

@Slf4j
@Getter
@Configuration
public class RedisConfig {
    private LettuceClientConfiguration clientConfig;
    private RedisConfiguration configuration;

    public RedisConfig(
            @Value("${spring.data.redis.port}") int redisPort,
            @Value("${spring.data.redis.host}") String redisHost,
            @Value("${spring.data.redis.username}") String redisUsername,
            @Value("${spring.data.redis.password}") String redisPassword,
            @Value("${spring.data.redis.mode}") String configurationMode,
            @Value("${spring.data.redis.cluster.nodes}") String clusterNodes,
            @Value("${spring.data.redis.ssl.enabled}") boolean sslEnabled
    ) {
        var clientConfig = LettuceClientConfiguration.builder();

        if (sslEnabled) {
            clientConfig.useSsl();
        }

        this.clientConfig = clientConfig.build();

        this.configuration = switch (configurationMode) {
            case Mode.CLUSTER -> getClusterConfiguration(clusterNodes, redisUsername, redisPassword);
            default -> getStandaloneConfiguration(redisHost, redisPort, redisUsername, redisPassword);
        };
    }

    public RedisStandaloneConfiguration getStandaloneConfiguration(String host, int port, String username, String password) {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
        configuration.setUsername(username);
        configuration.setPassword(password);
        return configuration;
    }

    public RedisSentinelConfiguration getSentinelConfiguration(String master, String nodes, String username, String password) {
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration(master, new HashSet<>(Arrays.asList(nodes.split(","))));
        configuration.setUsername(username);
        configuration.setPassword(password);
        configuration.setSentinelUsername(username);
        configuration.setSentinelPassword(password);
        return configuration;
    }

    public RedisClusterConfiguration getClusterConfiguration(String nodes, String username, String password) {
        RedisClusterConfiguration configuration = new RedisClusterConfiguration();
        configuration.setUsername(username);
        configuration.setPassword(password);

        String[] replicaNodes = nodes.split(",");

        for (String node : replicaNodes) {
            configuration.addClusterNode(RedisNode.fromString(node));
        }

        return configuration;
    }

    @Bean
    public LettuceConnectionFactory reactiveRedisConnectionFactory() {
        return new LettuceConnectionFactory(configuration, clientConfig);
    }

    public static class Mode {
        public static final String STANDALONE = "standalone";

        public static final String CLUSTER = "cluster";
    }
}


