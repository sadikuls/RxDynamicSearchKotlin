package com.sadikul.rxdynamicsearch_kotlin.Interfaces;

import android.content.Context;

import com.sadikul.rxdynamicsearch_kotlin.Model.SearchResult;
import com.sadikul.rxdynamicsearch_kotlin.Network.ApiInterface;
import com.sadikul.rxdynamicsearch_kotlin.Network.RetrofiClient;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by ASUS on 11-Oct-17.
 */

public class SearchApi {
    OnRequestComplete requestComplete;
    PublishSubject publishSubject;

    public SearchApi( Context context, String query, OnRequestComplete onRequestComplete) {
        this.requestComplete = onRequestComplete;
        ApiInterface apiInterface= RetrofiClient.INSTANCE.getApiInterface();
        if (publishSubject == null) {
            publishSubject = PublishSubject.create();
            publishSubject
                    .debounce(300, TimeUnit.MILLISECONDS)
                    .distinctUntilChanged()
                    .switchMap(searchValue -> apiInterface.getData(query)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread()))
                    .subscribeWith(new DisposableObserver<SearchResult>() {
                        @Override
                        public void onNext(SearchResult response) {
                            //Update View here
                            requestComplete.onRequestComplete(response);
                        }

                        @Override
                        public void onError(Throwable e) {
                            //On error
                            requestComplete.onRequestError("Something went wrong..");
                        }

                        @Override
                        public void onComplete() {
                            //On complete
                        }
                    });
            publishSubject.onNext(query);
        }


    }
}
