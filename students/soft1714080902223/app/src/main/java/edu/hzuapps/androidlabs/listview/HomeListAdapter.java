package edu.hzuapps.androidlabs.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.hzuapps.androidlabs.model.Task;
import edu.hzuapps.androidlabs.soft1714080902223.R;

public class HomeListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Task> tasks;

    public HomeListAdapter(Context context, List<Task> tasks){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.tasks = tasks;
    }

    public HomeListAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setTasks(List<Task> tasks){
        if(tasks == null) {
            return;
        }
        this.tasks = tasks;
        // 通知ListView修改了
        notifyDataSetChanged();
    }

    /**
     *
     * @return 返回ListView的个数
     */
    @Override
    public int getCount() {
        return tasks.size();
    }

    /**
     *
     * @param position 参数为第几个对象
     * @return 返回子项对应的对象
     */
    @Override
    public Object getItem(int position) {
        //获取列表中的对象
        return tasks.get(position);
    }

    /**
     *
     * @param position
     * @return 返回子项的是第几个
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView lvTitle, lvTime, lvContent;
    }

    /**
     *
     * @param position 列表中的第几个对象
     * @param convertView
     * @param parent
     * @return 返回子项视图
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = (Task) getItem(position);
        View view;
        ViewHolder holder;
        //如果不存在，就去xml中获取，存在就直接用
        if(convertView == null){
            //关联list_item及其参数
            view = mLayoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.lvTitle = view.findViewById(R.id.lv_title);
            holder.lvContent = view.findViewById(R.id.lv_content);
            holder.lvTime = view.findViewById(R.id.lv_time);
            view.setTag(holder);
        }
        else{
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        }
        //使用blog中的数据填上
        holder.lvTitle.setText(task.getTitle());
        holder.lvContent.setText(task.getContent());
        holder.lvTime.setText(task.getDate());
        return view;
    }
}
