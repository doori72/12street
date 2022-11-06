package street.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import street.SupportingApplication;
import street.domain.InventoryIncreased;
import street.domain.InventoryReduced;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        InventoryReduced inventoryReduced = new InventoryReduced(this);
        inventoryReduced.publishAfterCommit();

        InventoryIncreased inventoryIncreased = new InventoryIncreased(this);
        inventoryIncreased.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = SupportingApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    public static void reduceInventory(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);


         });
        */

    }

    public static void increaseInventory(DeliveryCanceled deliveryCanceled) {
        /** Example 1:  new item 
        Inventory inventory = new Inventory();
        repository().save(inventory);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCanceled.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);


         });
        */

    }
}
