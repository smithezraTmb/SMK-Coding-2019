package com.EzraSmithTambunan.smkcoding


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.EzraSmithTambunan.smkcoding.connection.ConfigRetrofit
import com.EzraSmithTambunan.smkcoding.connection.MovieInterface
import com.hanifabdullah21.smkcoding.Movie
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_movie, container, false)

//        val list = Movie.listMovie as ArrayList<MovieModel>
//        val layoutmanager = LinearLayoutManager(activity)
//        val adapter = MovieAdapter(list, activity!!.applicationContext)
//        return rootView.rv_movie.apply {
//            layoutManager = layoutmanager
//            setAdapter(adapter)

            getListMovie()

            return rootView
        }
        private fun getListMovie(){
            val movieNowPlaying = ConfigRetrofit.retrofitConfig()
                .create(MovieInterface::class.java)
                .getListMovieNowPlaying(
                    apiKey = "467dc4bdc6e9a124c7b0affdad96d1a9"
                )

            movieNowPlaying
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    val list = response.results

                    val layoutmanager =
                        LinearLayoutManager(activity)
                    val adapter =
                        MovieAdapter(list,activity!!.applicationContext)

                    rootView.rv_movie.apply {
                        layoutManager = layoutmanager
                        setAdapter(adapter)
                    }

                }, {

                })
    }

}
