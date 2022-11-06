package street.domain;

import java.util.*;
import lombok.*;
import street.domain.*;
import street.infra.AbstractEvent;

@Data
@ToString
public class InventoryReduced extends AbstractEvent {

    private Long id;

    public InventoryReduced(Inventory aggregate) {
        super(aggregate);
    }

    public InventoryReduced() {
        super();
    }
}
