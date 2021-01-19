package org.mousehole.ebaybooks.network;

import org.mousehole.ebaybooks.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static org.mousehole.ebaybooks.utils.Constants.PATH;

public interface PostInterface {

    @GET(PATH)
    public Call<List<PostModel>> getPosts();
}
