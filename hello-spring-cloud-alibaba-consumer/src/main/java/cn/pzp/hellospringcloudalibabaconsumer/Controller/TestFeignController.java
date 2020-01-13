package cn.pzp.hellospringcloudalibabaconsumer.Controller;

import cn.pzp.hellospringcloudalibabaconsumer.Service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFeignController {

    @Autowired
    EchoService echoService;

    @Value("${user.str}")
    String userName;

    @GetMapping("/feign/echo/{str}")
    public String feignEcho(@PathVariable("str")String string){
        return echoService.echo(string)+"from feign client";
    }

    @GetMapping("/feign/echo/port")
    public String echoPort(){
        return echoService.echoPort();
    }

    @GetMapping("/echo/userName")
    public String echoConfigUserName(){
        return echoService.echo(userName);
    }
}
