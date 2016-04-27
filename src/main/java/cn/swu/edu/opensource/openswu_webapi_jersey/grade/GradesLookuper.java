package cn.swu.edu.opensource.openswu_webapi_jersey.grade;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import cn.swu.edu.opensource.openswu_webapi_jersey.constant.Constant;
import cn.swu.edu.opensource.openswu_webapi_jersey.utils.Client;

/**
 * Created by 陈思定 on 2016/1/30.
 */
public class GradesLookuper implements Lookup {

    private Client client;

    public GradesLookuper(Client client) {
        this.client = client;
    }

    private GradesLookuper() {
    }

    @Override
    public String lookup(SearchParam searchParam) {
        List<NameValuePair> nameValuePair = new ArrayList<>();

        nameValuePair.add(new BasicNameValuePair("_search", "false"));
        nameValuePair.add(new BasicNameValuePair("nd", "1451922678091"));
        nameValuePair.add(new BasicNameValuePair("queryModel.currentPage", "1"));
        nameValuePair.add(new BasicNameValuePair("queryModel.showCount", "100"));
        nameValuePair.add(new BasicNameValuePair("queryModel.sortName", ""));
        nameValuePair.add(new BasicNameValuePair("queryModel.sortOrder", "asc"));
        nameValuePair.add(new BasicNameValuePair("time", "1"));
        nameValuePair.add(new BasicNameValuePair("xnm", "" + searchParam.getXnm()));
        nameValuePair.add(new BasicNameValuePair("xqm", "" + searchParam.getXqm()));

        String response = this.client.doPost(Constant.urlGradeSearch + searchParam.getSwuID(), nameValuePair);

        return response;
    }

}