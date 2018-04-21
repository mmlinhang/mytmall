package mytmall.service;

import mytmall.pojo.Review;

import java.util.List;

public interface ReviewService
{
    List<Review> getReviewsForProduct(int pid);
}
