package street.domain;

import java.util.*;
import lombok.*;
import street.domain.*;
import street.infra.AbstractEvent;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
}
