package de.telran.shapes.config;

import de.telran.shapes.ShapesFlow;
import de.telran.shapes.entity.Line;
import de.telran.shapes.entity.Picture;
import de.telran.shapes.entity.Rectangle;
import de.telran.shapes.entity.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class Config {

    @Bean
    @Qualifier("shapes")
    @Order(1)
    public Line line1() {
        return new Line('#', 10);
    }

    @Bean
    @Qualifier("shapes")
    @Order(2)
    public Line line2() {
        return new Line('=', 10);
    }

    @Bean
    public Line line3() {
        return new Line('M', 10);
    }

    @Bean
    @Qualifier("shapes")
    @Order(3)
    public Rectangle rectangle1() {
        return new Rectangle('+', 5, 8);
    }

    @Bean
    public Rectangle rectangle2() {
        return new Rectangle('%', 5, 8);
    }

    @Bean
    public Picture picture(@Qualifier("shapes") List<Shape> shapes) {

        Shape[] shapesArray = shapes.toArray(new Shape[0]);
        return new Picture('~', shapesArray);
    }

    @Bean
    public ShapesFlow shapesFlow(Picture picture) {
        return new ShapesFlow(picture);
    }
}
