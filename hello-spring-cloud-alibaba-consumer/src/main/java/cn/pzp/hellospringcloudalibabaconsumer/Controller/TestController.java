package cn.pzp.hellospringcloudalibabaconsumer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
public class TestController {

    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable("str")String string){
        return restTemplate.getForObject("http://server-provider/echo/"+string,String.class);
    }
}
