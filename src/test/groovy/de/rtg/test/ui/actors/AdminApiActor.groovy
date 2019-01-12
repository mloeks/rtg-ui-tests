package de.rtg.test.ui.actors

import de.rtg.test.ui.models.Post
import de.rtg.test.ui.models.User
import groovyx.net.http.RESTClient

import static groovyx.net.http.ContentType.JSON

class AdminApiActor {

    private final RESTClient restClient
    private final String adminUserId
    private final String adminUsername

    AdminApiActor(String username, String password, String apiBaseUrl) {
        adminUsername = username
        restClient = new RESTClient(apiBaseUrl, JSON)
        String accessToken = authenticate(username, password)

        restClient.headers.'Authorization' = "Token ${accessToken}"
        adminUserId = getUserIdByName(username)
    }

    void deleteUserById(int userId) {
        def response = restClient.delete(path: "/rtg/users/${userId}/")
        assert response.status == 204
    }

    void deleteUser(User user) {
        int userId = getUserIdByName(user.username)
        deleteUserById(userId)
    }

    Post addPost(Post post) {
        def response = restClient.post(path: '/rtg/posts/',
                body: [title: post.title, content: post.content, author: adminUserId, finished: true])
        assert response.status == 201
        Map newPost = response.data as Map
        return new Post(id: newPost.id, author: newPost.author, title: newPost.title, content: newPost.content)
    }

    void deletePost(Post post) {
        assert restClient.delete(path: "/rtg/posts/${post.id}/").status == 204
    }

    private String authenticate(String username, String password) {
        def response = restClient.post(path: '/api-token-auth/', body: [username: username, password: password])
        String accessToken = response.data.access
        assert accessToken
        return accessToken
    }

    private int getUserIdByName(String username) {
        List allUsers = restClient.get(path: '/rtg/users/').data
        def user = allUsers.find { it.username == username }
        assert user
        return user.pk
    }

}
