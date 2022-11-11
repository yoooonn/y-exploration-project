// package com.ycourlee.explore.springkafkaconsumer.configuration;
//
//
// import org.apache.kafka.clients.consumer.ConsumerConfig;
// import org.apache.kafka.clients.producer.ProducerConfig;
// import org.apache.kafka.common.serialization.StringDeserializer;
// import org.apache.kafka.common.serialization.StringSerializer;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.annotation.EnableKafka;
// import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
// import org.springframework.kafka.config.KafkaListenerContainerFactory;
// import org.springframework.kafka.core.*;
// import org.springframework.kafka.listener.ContainerProperties;
//
// import java.util.HashMap;
// import java.util.Map;
//
// @Configuration
// @EnableKafka
// public class KafkaConfiguration {
//
//     @Value("${spring.kafka.bootstrap-servers}")
//     private String bootstrapServers;
//
//
//     @Value("${spring.kafka.consumer.auto-offset-reset}")
//     private String autoOffsetReset;
//     @Value("${spring.kafka.consumer.enable-auto-commit}")
//     private boolean enableAutoCommit;
//     @Value("${spring.kafka.consumer.properties.heartbeat.interval.ms}")
//     private Integer heartbeatIntervalMs;
//     @Value("${spring.kafka.consumer.properties.session.timeout.ms}")
//     private Integer sessionTimeoutMs;
//     @Value("${spring.kafka.consumer.max-poll-records}")
//     private Integer maxPollRecords;
//
//     @Value("${spring.kafka.producer.retries}")
//     private Integer producerRetries;
//     @Value("${spring.kafka.producer.acks}")
//     private String producerAcks;
//     @Value("${spring.kafka.producer.properties.linger.ms}")
//     private Integer producerLingerMs;
//     @Value("${spring.kafka.producer.batch-size}")
//     private Integer producerBatchSize;
//     @Value("${spring.kafka.producer.buffer-memory}")
//     private Integer producerBufferMemory;
//
//
//     @Value("${spring.kafka.consumer.group.id}")
//     private String groupId;
//     @Value("${spring.kafka.listener.concurrency}")
//     private int listenerConcurrency;
//
//     @Bean
//     public KafkaTemplate<String, String> kafkaTemplateDefault() {
//         return new KafkaTemplate<>(producerFactory(), false);
//     }
//
//     @Bean
//     public ProducerFactory<String, String> producerFactory() {
//         return new DefaultKafkaProducerFactory<>(genProducerConfig(bootstrapServers, "producer-1st"));
//     }
//
//     private Map<String, Object> genProducerConfig(String bootstrapServers, String clientId) {
//         Map<String, Object> config = new HashMap<>(16);
//         config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//         config.put(ProducerConfig.RETRIES_CONFIG, producerRetries);
//         config.put(ProducerConfig.ACKS_CONFIG, producerAcks);
//         config.put(ProducerConfig.LINGER_MS_CONFIG, producerLingerMs);
//         config.put(ProducerConfig.BATCH_SIZE_CONFIG, producerBatchSize);
//         config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, producerBufferMemory);
//         config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//         config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//         config.put(ProducerConfig.CLIENT_ID_CONFIG, clientId);
//         return config;
//     }
//
//     @Bean
//     public KafkaListenerContainerFactory<?> kafkaListenerContainerFactory() {
//         ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
//                 new ConcurrentKafkaListenerContainerFactory<>();
//         factory.setConsumerFactory(consumerFactory());
//         factory.setBatchListener(true);
//         factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
//         factory.setConcurrency(listenerConcurrency);
//         return factory;
//     }
//
//     @Bean
//     public ConsumerFactory<Integer, String> consumerFactory() {
//         return new DefaultKafkaConsumerFactory<>(consumerConfig());
//     }
//
//     @Bean
//     public Map<String, Object> consumerConfig() {
//         return genConsumerConfig(bootstrapServers);
//     }
//
//     private Map<String, Object> genConsumerConfig(String bootstrapServers) {
//         Map<String, Object> props = new HashMap<>(16);
//         props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//         props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
//         props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
//         props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
//         props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, heartbeatIntervalMs);
//         props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMs);
//         props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
//         props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//         props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//         return props;
//     }
// }
