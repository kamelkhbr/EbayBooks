package org.mousehole.ebaybooks.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.mousehole.ebaybooks.R;
import org.mousehole.ebaybooks.model.PostModel;
import org.mousehole.ebaybooks.view.Adapter.PostsAdapter;
import org.mousehole.ebaybooks.viewmodel.PostViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Link the viewmodel with the main to do the job
    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        final PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}