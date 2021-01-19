package org.mousehole.ebaybooks.network;

import org.mousehole.ebaybooks.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.mousehole.ebaybooks.utils.Constants.BASE_URL;

public class PostsClient{

    private PostInterface postInterface;
    public static PostsClient INSTANCE;

    // Creating the builder


    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }
    // Checking if the instance is null
    // if null create the instance
    // if not null then return the non null instance!

    public static PostsClient getINSTANCE() {
        if(null == INSTANCE){
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Call<List<PostModel>> getPosts() {
        return postInterface.getPosts();
    }
}
