package ru.kravchenko.kafkasender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kravchenko.kafkasender.service.KafkaProducerCustom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class KafkaSender {

    private static final String TOPIC = "nameTopic";

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaSender.class, args);
        KafkaProducerCustom kafkaProducerCustom = context.getBean(KafkaProducerCustom.class);
        String message = asString("message.json");
        kafkaProducerCustom.sendMessage(message, TOPIC);
    }

    public static String asString(String path) throws IOException {
        InputStream is = KafkaSender.class.getClassLoader().getResourceAsStream(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        for (int len; (len = is.read(bytes)) > 0; )
            baos.write(bytes, 0, len);
        return baos.toString();
    }
}
