package street.domain;

import java.util.*;
import lombok.Data;
import street.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
}
