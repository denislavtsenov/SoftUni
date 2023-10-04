package org.softuni.exam.structures;

import org.softuni.exam.entities.User;
import org.softuni.exam.entities.Video;

import java.util.LinkedHashMap;
import java.util.Map;

public class ViTubeRepositoryImpl implements ViTubeRepository {

    Map<String, User> users = new LinkedHashMap<>();
    Map<String, Video> videos = new LinkedHashMap<>();

    @Override
    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void postVideo(Video video) {
        videos.put(video.getId(), video);
    }

    @Override
    public boolean contains(User user) {
        return users.containsKey(user);
    }

    @Override
    public boolean contains(Video video) {
        return videos.containsKey(video);
    }

    @Override
    public Iterable<Video> getVideos() {
        return videos.values();
    }

    @Override
    public void watchVideo(User user, Video video) throws IllegalArgumentException {

    }

    @Override
    public void likeVideo(User user, Video video) throws IllegalArgumentException {

    }

    @Override
    public void dislikeVideo(User user, Video video) throws IllegalArgumentException {

    }

    @Override
    public Iterable<User> getPassiveUsers() {
        return null;
    }

    @Override
    public Iterable<Video> getVideosOrderedByViewsThenByLikesThenByDislikes() {
        return null;
    }

    @Override
    public Iterable<User> getUsersByActivityThenByName() {
        return null;
    }
}
