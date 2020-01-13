package cn.pzp.hellospringcloudalibabaprovider.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @Value("${server.port}")
    String port;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable("string") String string) {
        return "my first nacos provider:" + string;
    }

    @GetMapping("/echo/port")
    public String port() {
        return "this message is from port:" + port;
    }
}
