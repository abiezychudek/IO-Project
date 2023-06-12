package com.example.recipeswebsite.services;

import com.example.recipeswebsite.Factory.PostData;
import com.example.recipeswebsite.model.*;
import com.example.recipeswebsite.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostFactory {
    private final PostRepository postRepository;

    private List<Post> acceptedPosts;

    @Autowired
    public PostFactory(PostRepository postRepository) {
        this.postRepository = postRepository;
        acceptedPosts = new ArrayList<Post>();
    }

    public Post createPost(PostData postData) {
        String category = postData.getCategory();
        if (category == null) {
            return null;
        }

        Post post;

        if (category.equalsIgnoreCase("DESSERT")) {
            DessertPost dessertPost = new DessertPost(postData);
            dessertPost.setSweetnessLevel(postData.getSweetnessLevel());
            post = dessertPost;
        } else if (category.equalsIgnoreCase("BREAKFAST")) {
            BreakfastPost breakfastPost = new BreakfastPost(postData);
            breakfastPost.setVegetarian(postData.isVegetarian());
            post = breakfastPost;
        } else if (category.equalsIgnoreCase("LUNCH")) {
            LunchPost lunchPost = new LunchPost(postData);
            lunchPost.setFastMaking(postData.isFastMaking());
            post = lunchPost;
        } else if (category.equalsIgnoreCase("DINNER")) {
            DinnerPost dinnerPost = new DinnerPost(postData);
            dinnerPost.setLightweight(postData.isLightweight());
            post = dinnerPost;
        } else {
            return null;
        }

        return save(post);
    }

    public Post save(Post post) {
        if (post.getId() == null) {
            post.setCreatedAt(new Date());
        }
        return (Post) postRepository.save(post);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public void saveAll(List<Post> post1) {
        postRepository.saveAll(post1);
    }

    public void delete(Post post){
        postRepository.delete(post);
    }

    public List<Post> getAllAccepted() {
        return acceptedPosts;
    }

    public Optional<Post> getByIdAccepted(Long id) {
        return acceptedPosts.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).stream().findFirst();
    }

    public Long getIndexOfPost(Post post){
        for(Long i = 0L; i < acceptedPosts.size(); i++){
            if(acceptedPosts.get(Math.toIntExact(i)).equals(post)){
                return i;
            }
        }
        return 0L;
    }

    public void saveAccepted(Post post){
        acceptedPosts.add(post);
    }

    public void addCommentToPost(Long id, Comment c) {

        Optional<Post> post = getByIdAccepted(id);
        Post p = post.get();
        c.setPostId(p);
        c.setCreatedAt(new Date());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        c.setAuthor(username);
        p.getComments().add(c);
        acceptedPosts.set(Math.toIntExact(getIndexOfPost(p)), p);

    }

    public void addRatingToPost(Long id, double rating) {

        Optional<Post> post = getByIdAccepted(id);
        Post p = post.get();
        double newRate;
        newRate =  (p.getAvgRating() * p.getNumOfRatings()) + rating;
        p.setNumOfRatings(p.getNumOfRatings()+1);
        newRate = newRate/p.getNumOfRatings();
        p.setAvgRating(newRate);
        acceptedPosts.set(Math.toIntExact(getIndexOfPost(p)), p);

    }
}
