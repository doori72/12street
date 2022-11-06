package street.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "supporting", url = "${api.url.supporting}")
public interface DeliveryService {
    @RequestMapping(method = RequestMethod.GET, path = "/deliveries/{id}")
    public Delivery getDelivery(@PathVariable("id") Long id);
}
