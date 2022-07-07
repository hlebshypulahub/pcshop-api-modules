package com.capgemini.pcshop;

import com.capgemini.pcshop.data.Order;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionExistsException;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PcShopApplicationTests {

    private static Region<Integer, Order> region;

    @BeforeAll
    static void connect() {
        ClientCache cache = new ClientCacheFactory()
                .addPoolLocator("localhost", 10334)
                .create();

        try {
            region = cache.<Integer, Order>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY).create("pcshop-region");
        } catch (RegionExistsException exception) {
            region = cache.getRegion("pcshop-region");
        }
    }

    @Test
    public void whenSendMessageToRegion_thenMessageSavedSuccessfully() {

        List<Integer> listOfParts = Arrays.asList(1, 2, 2, 3);
        Order order = new Order(listOfParts).generateOrderId();
        int orderId = order.getOrderId();

        region.put(orderId, order);

        assertEquals(listOfParts, region.get(orderId).getParts());
    }

    @Test
    public void whenPutMultipleValuesAtOnce_thenValuesSavedSuccessfully() {

        List<Order> listOfOrders = new ArrayList<>() {{
            add(new Order(Arrays.asList(1, 2, 3)).generateOrderId());
            add(new Order(Arrays.asList(1, 2, 3, 3)).generateOrderId());
            add(new Order(Arrays.asList(1, 2, 2, 2, 3)).generateOrderId());
        }};

        Map<Integer, Order> mapOfOrders = listOfOrders
                .stream()
                .collect(Collectors.toMap(Order::getOrderId, Function.identity()));

        region.putAll(mapOfOrders);

        listOfOrders.forEach(order ->
                assertEquals(order.getParts().size(), region.get(order.getOrderId()).getParts().size())
        );
    }
}
