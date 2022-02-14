package Product;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import Product.Product;
import Product.Category;


public class TestProduct {
    @Test
    public void ProductByTheirCategory() {
        // given
        List<Product> product = Arrays.asList(
                new Product("Lola", 18.5, "For girls", Category.Toy),
                new Product("Forest-09", 5.3, "For boys", Category.Toy),
                new Product("Parker", 74, "For Men", Category.Office),
                new Product("Diner", 69.3, "For everyone", Category.Furniture),
                new Product("Diner", 14.3, "For everyone", Category.Furniture),
                new Product("Venera", 125, "For everyone", Category.Garden));
        // when
        Map<Category, List<Product>> ProductByTheirCategory = product.stream().collect(Collectors.groupingBy(e -> e.getCategory()));
        // then
        assertThat(ProductByTheirCategory.get(Category.Toy).size()).isEqualTo(2);

        assertThat(ProductByTheirCategory.get(Category.Office).size()).isGreaterThan(0);

        assertThat(ProductByTheirCategory.get(Category.Garden).size()).isLessThan(5);

        assertThat(ProductByTheirCategory.get(Category.Furniture).size()).isNotEqualTo(3);

    }

    @Test
    public void ProductHaveToys() {
        // given
        List<Product> product = Arrays.asList(
                new Product("Lola", 18.5, "For girls", Category.Toy),
                new Product("Forest-09", 5.3, "For boys", Category.Toy),
                new Product("Parker", 74, "For Men", Category.Office),
                new Product("Diner", 69.3, "For everyone", Category.Furniture),
                new Product("Diner", 14.3, "For everyone", Category.Furniture),
                new Product("Venera", 125, "For everyone", Category.Garden));
        // when
        boolean ProductHaveToys = product.stream().filter(e -> e.getCategory().equals(Category.Toy)).findAny().isPresent();
        // then
        assertThat(ProductHaveToys).isTrue();
    }
}
