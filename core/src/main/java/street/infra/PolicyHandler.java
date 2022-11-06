package street.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import street.config.kafka.KafkaProcessor;
import street.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_주문상태업데이트(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener 주문상태업데이트 : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        Order.주문상태업데이트(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCanceled'"
    )
    public void wheneverDeliveryCanceled_주문상태업데이트(
        @Payload DeliveryCanceled deliveryCanceled
    ) {
        DeliveryCanceled event = deliveryCanceled;
        System.out.println(
            "\n\n##### listener 주문상태업데이트 : " + deliveryCanceled + "\n\n"
        );

        // Sample Logic //
        Order.주문상태업데이트(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InventoryIncreased'"
    )
    public void wheneverInventoryIncreased_고객에게알람메일발송(
        @Payload InventoryIncreased inventoryIncreased
    ) {
        InventoryIncreased event = inventoryIncreased;
        System.out.println(
            "\n\n##### listener 고객에게알람메일발송 : " +
            inventoryIncreased +
            "\n\n"
        );

        // Sample Logic //
        Order.고객에게알람메일발송(event);
    }
}
