package Animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestCat {
    Cat cat = new Cat("testCat", 3, "pet");
    @Test
    public void checkCatSound() {
        //GIVEN
        String expectedSound = "meow meow";
        //WHEN
        String actualSound = cat.makeSound();
        //THEN
        Assertions.assertEquals(expectedSound, actualSound,
                String.format("Expected '%s', but was '%s'", expectedSound, actualSound));
    }

    @Test
    public void checkCatClass() {
        //GIVEN
        String expectedSimpleName = "Cat";
        //WHEN
        String actualSimpleName = cat.getClass().getSimpleName();
        //THEN
        Assertions.assertEquals(expectedSimpleName, actualSimpleName);
    }

    @Test
    public void checkAge() {
        //GIVEN
        int expectedAge = 3;
        //WHEN
        int actualAge = cat.getAge();
        //THEN
        Assertions.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void checkType() {
        //GIVEN
        String expectedType = "pet";
        //WHEN
        String actualMType = cat.getType();
        //THEN
        Assertions.assertEquals(expectedType, actualMType);
    }
}
