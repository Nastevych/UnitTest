package Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import Blogs.BlogPost;
import Blogs.BlogPostType;

public class TestStream {
    @Test
    public void shouldCountSumOfNumbersInTheList() {
        // given
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5);
        // when
        Long quantity = listOfNumbers.stream().mapToLong(e -> e).sum();
        // then
        assertThat(quantity).isEqualTo(15L);
    }

    @Test
    public void shouldFilterAllNumbersGreaterThan5AndDividedBy2() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // when
        List<Integer> numbersGreaterThan5 = numbers.stream().filter(e -> e > 5 && e % 2 == 0).collect(Collectors.toList());
        // then
        assertThat(numbersGreaterThan5).isEqualTo(Arrays.asList(6, 8));
    }

    @Test
    public void shouldMultiplyAndTransformIntoStringEachElement() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // when
        List<String> multipliedNumbersAsString = numbers.stream().map(e -> String.valueOf(e * 2)).collect(Collectors.toList());
        // then
        Assertions.assertThat(multipliedNumbersAsString).containsExactly("2", "4", "6", "8", "10");
    }

    @Test
    public void shouldCheckIfThereIsANumberGreaterThan4() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // when
        boolean anyNumberGreaterThan4 = numbers.stream().filter(e -> e > 4).findAny().isPresent();
        // then
        assertThat(anyNumberGreaterThan4).isTrue();
    }

    @Test
    public void shouldCheckIfEachNumberIsEven() {
        // given
        List<Integer> numbers = Arrays.asList(2, 4, 6);
        // when
        boolean eachNumberIsEven = numbers.stream().allMatch(e -> e % 2 == 0);

        // then
        assertThat(eachNumberIsEven).isTrue();
    }

    @Test
    public void shouldSortTheList() {
        // given
        List<String> listOfWords = Arrays.asList("B", "A", "D", "E", "C");
        // when
        List<String> sortedList = listOfWords.stream().sorted().collect(Collectors.toList());
        // then
        Assertions.assertThat(sortedList).containsExactly("A", "B", "C", "D", "E");
    }

    @Test
    public void shouldReduceOnlyPositiveValuesToCalculateMultiplyThem() {
        // given
        List<BigDecimal> numbers = Arrays.asList(
                BigDecimal.valueOf(15),
                BigDecimal.valueOf(-8),
                BigDecimal.valueOf(10),
                BigDecimal.valueOf(-8.6),
                BigDecimal.valueOf(2));

        // when
        Optional<BigDecimal> reduced = numbers.stream().filter(e -> e.compareTo(BigDecimal.ZERO) > 0).reduce((bigDecimal, multiplicand) -> bigDecimal.multiply(multiplicand));

        // then
        assertThat(reduced.isPresent()).isTrue();
        assertThat(reduced.get()).isEqualByComparingTo("300");
    }

    @Test
    public void shouldGroupBlogPostsByTheirTypes() {
        // given
        List<BlogPost> posts = Arrays.asList(
                new BlogPost("News item 1", "Author 1", BlogPostType.NEWS, 15),
                new BlogPost("Tech review 1", "Author 2", BlogPostType.REVIEW, 5),
                new BlogPost("Programming guide", "Author 1", BlogPostType.GUIDE, 20),
                new BlogPost("News item 2", "Author 2", BlogPostType.NEWS, 35),
                new BlogPost("Tech review 2", "Author 1", BlogPostType.REVIEW, 15));
        // when
        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream().collect(Collectors.groupingBy(BlogPost::getType));
        // then
        assertThat(postsPerType.get(BlogPostType.NEWS).size()).isEqualTo(2);
        assertThat(postsPerType.get(BlogPostType.GUIDE).size()).isEqualTo(1);
        assertThat(postsPerType.get(BlogPostType.REVIEW).size()).isEqualTo(2);
    }

    @Test
    public void shouldBeCollectedToMapWithBlogPostTitleAsKey() {
        // given
        List<BlogPost> posts = Arrays.asList(
                new BlogPost("News item 1", "Author 1", BlogPostType.NEWS, 15),
                new BlogPost("Tech review 1", "Author 2", BlogPostType.REVIEW, 5),
                new BlogPost("Programming guide", "Author 1", BlogPostType.GUIDE, 20),
                new BlogPost("News item 2", "Author 2", BlogPostType.NEWS, 35),
                new BlogPost("Tech review 2", "Author 1", BlogPostType.REVIEW, 15));
        // when
        Map<String, BlogPost> postPerTitle = posts.stream().collect(Collectors.toMap(e -> e.getTitle(), Function.identity()));
        // then
        assertThat(postPerTitle.get("News item 1").getTitle()).isEqualTo("News item 1");
        assertThat(postPerTitle.get("Tech review 1").getTitle()).isEqualTo("Tech review 1");
        assertThat(postPerTitle.get("Programming guide").getTitle()).isEqualTo("Programming guide");
        assertThat(postPerTitle.get("News item 2").getTitle()).isEqualTo("News item 2");
        assertThat(postPerTitle.get("Tech review 2").getTitle()).isEqualTo("Tech review 2");
    }
}
