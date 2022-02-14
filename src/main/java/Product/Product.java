package Product;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Product implements Comparator {
    String name;
    double prise;
    String about;
    Category category;


    public Product(String name, double prise, String about, Category category) {
        this.name = name;
        this.prise = prise;
        this.about = about;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", prise=" + prise +
                ", about='" + about + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.prise, prise) == 0 && name.equals(product.name) && about.equals(product.about) && category == product.category;
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator thenComparing(Comparator other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public Comparator thenComparingInt(ToIntFunction keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator thenComparingLong(ToLongFunction keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }

    @Override
    public Comparator thenComparing(Function keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator thenComparing(Function keyExtractor, Comparator keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prise, about, category);
    }
}
