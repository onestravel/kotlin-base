package cn.onestravel.kotlin.base.mvp


import cn.onestravel.kotlin.base.mvp.model.User
import cn.onestravel.library.kotlin.base.adapter.BaseRecyclerAdapter
import cn.onestravel.library.kotlin.base.adapter.VH
import cn.onestravel.library.kotlin.rxrequest.activity.BaseRxActivity
import cn.onestravel.library.kotlin.rxrequest.common.BaseObserver1
import cn.onestravel.library.kotlin.rxrequest.common.ResponseResult1

class MainActivity : BaseRxActivity() {
    override fun getLayoutId(): Int {
       return R.layout.layout_test
    }

    val adapter = TestAdapter()


    override fun initView() {
        super.initView()
    }

    override fun initListener() {
        super.initListener()

//        adapter.setOnItemClick { view, position, data ->
//            showToast("点击了条目$position")
//        }
//
//        adapter.setOnItemLongClick { view, position, data ->
//            showToast("长按了条目$position")
//            return@setOnItemLongClick true
//        }
    }

    override fun initData() {
        super.initData()
//        setAdapter(adapter)
//        addData(adapter)
//        refreshComplete()
//        loadMoreComplete()
//            .compose(this.<MedicationOrderRrcordListBean>bindToLifecycle())


        val userObserver: BaseObserver1<User> = object : BaseObserver1<User>(){
             override fun onSuccess(result: ResponseResult1<User>) {


            }

            override fun onFinish() {
                super.onFinish()
            }






        }
       val loader = OrderRecordLoader()
        loader.getOrderDetailInfo(HashMap<String,String>() as Map<String, String>).compose(bindToLifecycle<ResponseResult1<User>>()).subscribe(userObserver)
//            .compose(this.bindToLifecycle()).subscribe(userObserver)
    }

    private fun addData(adapter: TestAdapter, isRefresh: Boolean = false) {
        val list = ArrayList<User>()
        val url = "http://static.open-open.com/lib/uploadImg/20150716/20150716115042_431.jpg"
        (1..10).forEach {
            val user = User()
            user.name = "我是张三 $it"
            user.headUrl = url
            list.add(user)
        }
        if (isRefresh) {
            adapter.setDatas(list)
        } else {
            adapter.addDatas(list)
        }
    }

//    override fun refreshDatas() {
//        super.refreshDatas()
//        getRecyclerView().postDelayed({
//            refreshComplete()
//            addData(adapter, true)
//        }, 2000)
//    }
//
//
//    override fun loadMoreDatas() {
//        super.loadMoreDatas()
//        getRecyclerView().postDelayed({
//            loadMoreComplete()
//            addData(adapter)
//        }, 2000)
//    }


}


class TestAdapter() : BaseRecyclerAdapter<User>() {
    override fun onBindVH(holder: VH, position: Int, data: User) {
        holder.setText(R.id.tvName, data.name)
        holder.setImageUrl(R.id.ivHead, data.headUrl)
//        holder.setOnClick(R.id.tvName){
//            showToast(data.name)
//        }
    }

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.layout_item
    }
}
