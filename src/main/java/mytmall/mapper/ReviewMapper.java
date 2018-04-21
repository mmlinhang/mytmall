package mytmall.mapper;

import mytmall.pojo.Review;

import java.util.List;

public interface ReviewMapper
{
    List<Review> getReviewsForProduct(int pid);
}
