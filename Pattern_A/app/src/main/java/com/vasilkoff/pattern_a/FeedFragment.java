package com.vasilkoff.pattern_a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paging.listview.PagingListView;
import com.vasilkoff.pattern_a.DB.QueryHelper;
import com.vasilkoff.pattern_a.model.VideoObject;

import java.util.List;

/**
 * Created by maxim.vasilkov@gmail.com on 02/09/15.
 */
public class FeedFragment extends Fragment {

    private static final String TAG = FeedFragment.class.getSimpleName();

    View rootView;
    PagingListView listView;
    FeedAdapter adapter;
    int items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (PagingListView) rootView.findViewById(R.id.paging_list_view);

        adapter = new FeedAdapter();
        listView.setAdapter(adapter);
        listView.setHasMoreItems(true);
        listView.setPagingableListener(new PagingListView.Pagingable() {
            @Override
            public void onLoadMoreItems() {
                if (hasMoreData()) {
                    new FeedLoader().execute();
                } else {
                    listView.onFinishLoading(false, null);
                }
            }
        });

    }



    boolean hasMoreData() {
        // TODO: return false when dont have more pages
        // now will load up to 100 entries
        return items<100;
    }

    private class FeedLoader extends SafeAsyncTask<List<VideoObject>> {

        @Override
        public List<VideoObject> call() throws Exception {
            List<VideoObject> result = QueryHelper.getVideos(items);
            return result;
        }

        @Override
        protected void onSuccess(List<VideoObject> newItems) throws Exception {
            super.onSuccess(newItems);
            items+=newItems.size();
            listView.onFinishLoading(true, newItems);
        }
    }

}
