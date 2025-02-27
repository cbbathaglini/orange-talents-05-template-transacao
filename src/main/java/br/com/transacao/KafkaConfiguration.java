package br.com.transacao;

import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;


/*
 * configurar o consumidor
 */
@Configuration
public class KafkaConfiguration {

    private final KafkaProperties kafkaProperties;
    public KafkaConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }


    /*
     * Adicionar as propriedades do nosso consumidor, transcrevendo as propriedades em um mapa de propriedades
     */
    public Map<String, Object> consumerConfigurations() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getKeyDeserializer());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getValueDeserializer());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());

        /*  Error Handling */
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
//        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
//        properties.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);
//        properties.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());


        return properties;
    }

    /*
     * configurando o consumidor
     * 1) Criação do ConsumerFactory: deve ser configurado em duas etapas
     *  1.1) Definição de qual será o desserializador da chave e do evento/mensagem. Ex: StringDeserializer,JsonDeserializer
     *  1.2) Quais são as configurações desse consumidor
     */
    @Bean
    public ConsumerFactory<String, EventoDeTransacao> transactionConsumerFactory() {
        StringDeserializer stringDeserializer = new StringDeserializer(); // 1.1
        JsonDeserializer<EventoDeTransacao> jsonDeserializer = new JsonDeserializer<>(EventoDeTransacao.class, false); //1.1

        return new DefaultKafkaConsumerFactory<>(consumerConfigurations(), stringDeserializer, jsonDeserializer); // 1.2
    }


    /*
     * configurando o listener
     * - ele irá tratar os eventos recebidos
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EventoDeTransacao> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, EventoDeTransacao> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(transactionConsumerFactory());
        return factory;
    }

}
