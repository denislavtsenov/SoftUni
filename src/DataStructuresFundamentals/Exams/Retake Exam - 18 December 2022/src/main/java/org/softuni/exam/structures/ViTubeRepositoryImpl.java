package org.softuni.exam.structures;

import org.softuni.exam.entities.User;
import org.softuni.exam.entities.Video;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ViTubeRepositoryImpl implements ViTubeRepository {

    Map<String, User> users = new LinkedHashMap<>();
    Map<String, Integer> userLikes = new LinkedHashMap<>();
    Map<String, Integer> userViews = new LinkedHashMap<>();
    Map<String, Integer> userDislikes = new LinkedHashMap<>();
    Map<String, User> passiveUsers = new LinkedHashMap<>();
    Map<String, Video> videos = new LinkedHashMap<>();


    @Override
    public void registerUser(User user) {
        users.put(user.getId(), user);
        passiveUsers.put(user.getId(), user);
    }

    @Override
    public void postVideo(Video video) {
        videos.put(video.getId(), video);
    }

    @Override
    public boolean contains(User user) {
        return users.get(user.getId()) != null;
    }

    @Override
    public boolean contains(Video video) {
        return videos.get(video.getId()) != null;
    }

    @Override
    public Iterable<Video> getVideos() {
        return videos.values();
    }

    @Override
    public void watchVideo(User user, Video video) throws IllegalArgumentException {

        if (!contains(user) || !contains(video)) {
            throw new IllegalArgumentException();
        }
        passiveUsers.remove(user.getId());

        videos.get(video.getId()).setViews(video.getViews() + 1);

        Integer currentViews = userViews.get(user.getId());
        userViews.put(user.getId(), currentViews + 1);


    }

    @Override
    public void likeVideo(User user, Video video) throws IllegalArgumentException {

        if (!contains(user) || !contains(video)) {
            throw new IllegalArgumentException();
        }
        passiveUsers.remove(user.getId());
        videos.get(video.getId()).setLikes(video.getLikes() + 1);

        Integer currentLikes = userLikes.get(user.getId());
        userLikes.put(user.getId(), currentLikes + 1);
    }

    @Override
    public void dislikeVideo(User user, Video video) throws IllegalArgumentException {

        if (!contains(user) || !contains(video)) {
            throw new IllegalArgumentException();
        }
        passiveUsers.remove(user.getId());
        videos.get(video.getId()).setDislikes(video.getDislikes() + 1);

        Integer currentDislikes = userDislikes.get(user.getId());
        userDislikes.put(user.getId(), currentDislikes + 1);

    }

    @Override
    public Iterable<User> getPassiveUsers() {
        return passiveUsers.values();
    }

    @Override
    public Iterable<Video> getVideosOrderedByViewsThenByLikesThenByDislikes() {
        return videos.values()
                .stream()
                .sorted(Comparator.comparing(Video::getViews).reversed()
                        .thenComparing(Video::getLikes).reversed()
                        .thenComparing(Video::getDislikes))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<User> getUsersByActivityThenByName() {
//        return users.values()
//                .stream()
//                .sorted(Comparator.comparing((User u) -> userViews.get(u.getId())).reversed()
//                        .thenComparing((User u) -> userDislikes.get(u.getId())).reversed()
//                        .thenComparing(User::getUsername))
//                .collect(Collectors.toList());

        return null;
    }
}
