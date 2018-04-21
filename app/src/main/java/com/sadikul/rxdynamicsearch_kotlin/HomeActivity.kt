package com.sadikul.rxdynamicsearch_kotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.sadikul.rxdynamicsearch_kotlin.Adapter.MainRecyclerAdapter
import com.sadikul.rxdynamicsearch_kotlin.Interfaces.MainActivityView
import com.sadikul.rxdynamicsearch_kotlin.Model.SearchItem
import com.sadikul.rxdynamicsearch_kotlin.Model.SearchResult
import com.sadikul.rxdynamicsearch_kotlin.Presenter.Presenter


class HomeActivity : AppCompatActivity(),MainActivityView {
    override fun getAppContext(): Context {
        return this
    }

    @BindView(R.id.searchview)
    lateinit var searchview: SearchView
    @BindView(R.id.myrecyler)
    lateinit var myrecyler: RecyclerView

    lateinit var adapter: MainRecyclerAdapter

    var list: MutableList<SearchItem>? = null

    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        //apiInterface = RetrofiClient.getApiInterface()

        searchview.setIconifiedByDefault(false)

        list = mutableListOf()

        adapter = MainRecyclerAdapter(this)
        myrecyler.setLayoutManager(LinearLayoutManager(this))

        myrecyler.setAdapter(adapter)
        adapter.notifyDataSetChanged()
        presenter = Presenter(this)
        searchview.setOnQueryTextListener(
                object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String): Boolean {
                        //Here we request a search
                        presenter.getSearchResult(newText)
                        return false
                    }
                })
    }

    override fun showSearchData(searchResult: SearchResult) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        list = searchResult.getSearchItems()
        if (list != null) {
            adapter.setData(list!!)
        } else {
            adapter.clear()
        }

        if (searchResult != null) {

            if (searchResult.getSearchItems() != null) {
                for (noticeItem in searchResult.getSearchItems()!!) {

                    Log.e("notice", noticeItem.getTitle())
                }
            }
        }
    }

    override fun startLoading() {
    }

    override fun stopLoading() {
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
