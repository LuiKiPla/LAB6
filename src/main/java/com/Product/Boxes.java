package com.Product;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "boxes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Boxes {

    @XmlElement(name = "box")
    List<Box> boxesList;

    public List<Box> getBoxes() {
        return boxesList;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxesList = boxes;
    }
}
