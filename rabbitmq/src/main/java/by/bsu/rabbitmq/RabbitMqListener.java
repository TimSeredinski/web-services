package by.bsu.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {

    @Autowired
    private EmailService emailService;
    @Autowired
    private AzureService azureService;

    @RabbitListener(queues = "emails")
    public void listen(String message) {
        message = azureService.sendMessageToAzureFunction(message);
        emailService.send("t.seredinski@gmail.com", "Email from rabbitMQ", message);
    }

}
