package com.wpaul15.cookbook.androidApp.ui.fragment.recyclerview

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wpaul15.cookbook.androidApp.databinding.FragmentRecyclerViewBinding
import java.io.Serializable

class RecyclerViewFragment<T : Parcelable> : Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arguments?.getParcelableArrayList<T>(KEY_ITEMS_LIST)?.toMutableList()!!
        val layoutResId = arguments?.getInt(KEY_LAYOUT_RES_ID)!!
        val bindHolder: View.(T) -> Unit
        try {
            bindHolder = arguments?.getSerializable(KEY_BIND_HOLDER)!! as View.(T) -> Unit
            binding.recyclerViewList.init(items, layoutResId, bindHolder)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val KEY_ITEMS_LIST: String = "com.wpaul15.cookbook.ITEMS_LIST"
        const val KEY_LAYOUT_RES_ID: String = "com.wpaul15.cookbook.LAYOUT_RES_ID"
        const val KEY_BIND_HOLDER: String = "com.wpaul15.cookbook.BIND_HOLDER"

        fun <T : Parcelable> newInstance(
            items: MutableList<T>,
            layoutResId: Int,
            bindHolder: View.(T) -> Unit
        ) = RecyclerViewFragment<T>().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(KEY_ITEMS_LIST, ArrayList<Parcelable>(items))
                putInt(KEY_LAYOUT_RES_ID, layoutResId)
                putSerializable(KEY_BIND_HOLDER, bindHolder as Serializable)
            }
        }
    }
}
