package com.Product;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="box")
@XmlAccessorType(XmlAccessType.FIELD)
public class Box extends Product {
    @XmlElementWrapper(name = "contents")
    @XmlElement(name = "content")
    List<String> contents;

    public Box() {
        super();
    };
    public Box(String name, double weight, List<String> contents) {
        super(name, weight);
        this.contents = contents;
    }

    @Override
    public String getDetails() {
        String contents = new String();
        for (String content: this.contents) {
            if (content != this.contents.get(this.contents.size()-1)) {
                contents += content + " ";
            }
            else {
                contents += content;
            }
        }
        return "Коробка весом " + weight + "кг с " + this.contents.size() + " c типом товаров " +this.name +  ": " + contents;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }
}
