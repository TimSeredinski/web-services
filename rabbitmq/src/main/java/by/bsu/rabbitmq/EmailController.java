package by.bsu.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmailController {

    @Autowired
    AmqpTemplate template;

    @GetMapping("/")
    public String welcome() {
        return "welcome.html";
    }

    @GetMapping(value = "/send", params = "message")
    @ResponseBody
    public String sendEmail(@RequestParam String message) {
        template.convertAndSend("emails", message);
        return "I just send this message '" + message + "' to azure-functions. You will find the result on your email";
    }

}
