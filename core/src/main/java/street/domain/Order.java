package street.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import street.CoreApplication;
import street.domain.OrderCanceled;
import street.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemId;

    private String customerId;

    private String address;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = CoreApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void 주문상태업데이트(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void 주문상태업데이트(DeliveryCanceled deliveryCanceled) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCanceled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void 고객에게알람메일발송(
        InventoryIncreased inventoryIncreased
    ) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(inventoryIncreased.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
