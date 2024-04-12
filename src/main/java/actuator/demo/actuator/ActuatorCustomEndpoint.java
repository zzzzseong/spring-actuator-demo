package actuator.demo.actuator;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring actuator custom endpoint example code
 * @implNote @WriteOperation: POST method 처럼 쓰기할때 사용
 * @implNote @ReadOperation: GET method 처럼 읽기할때 사용
 * */
@Component
@Endpoint(id = "custom")
@Slf4j(topic = "ActuatorCustomEndpoint")
public class ActuatorCustomEndpoint {

    @WriteOperation
    public void write(String data) {
        log.info("write operation: {}", data);
    }

    @ReadOperation
    public List<ActuatorCustomData> custom(@Selector String data1, String data2) {
        List<ActuatorCustomData> list = new ArrayList<>();

        for (int i = 1; i <= 3; i++) list.add(new ActuatorCustomData("custom data" + i));

        //utilize path variable
        list.add(new ActuatorCustomData(data1));

        //utilize parameter
        list.add(new ActuatorCustomData(data2));

        return list;
    }

    @Getter
    public static class ActuatorCustomData {
        private final String data;

        public ActuatorCustomData(String data) {
            this.data = data;
        }
    }
}
