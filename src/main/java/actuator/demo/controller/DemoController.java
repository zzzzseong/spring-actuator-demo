package actuator.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j(topic = "DemoController")
public class DemoController {

    @GetMapping("/hello")
    public void hello() {
        log.info("hello");
    }
}