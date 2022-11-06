package street.external;

import java.util.Date;
import lombok.Data;

@Data
public class Delivery {

    private Long id;
    private String orderId;
    private String address;
}
