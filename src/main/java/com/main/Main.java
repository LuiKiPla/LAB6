package com.main;

import com.Fabrics.BoxFactory;
import com.Product.Boxes;
import com.Product.Product;
import com.Transport.Ship;
import com.Transport.Truck;
import com.Warehouse.Warehouse;
import com.Product.Box;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(Boxes.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Boxes boxes = (Boxes) unmarshaller.unmarshal(new FileReader("src/main/java/com/Product/Boxes.xml"));

        Truck truck = new Truck();
        truck.setDeliverableProducts(List.copyOf(boxes.getBoxes()));

        BoxFactory boxFactory = new BoxFactory();
        Box newBox = (Box) boxFactory.createProduct();
        newBox.setName("Канцелярия");
        newBox.setWeight(2.0);
        newBox.setContents(List.of("Карандаши", "Тетради", "Обложки"));

        Ship ship = new Ship();
        ship.setDeliverableProducts(List.of(newBox));

        Warehouse warehouse = new Warehouse();
        warehouse.getDeliver(truck.deliver());
        warehouse.getDeliver(ship.deliver());
        warehouse.showProducts();
    }
}
