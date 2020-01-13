package cn.pzp.hellospringcloudalibabaconsumer.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "server-provider")
public interface EchoService {

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable("string")String string);

    @GetMapping("/echo/port")
    public String echoPort();
}
