package rahulpahuja.com.databindingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*A Very Simple Display of Data Binding Using the MVC and View Holder Pattern*/
public class SimpleBindingActivity extends AppCompatActivity {

    /*This Method Loads the UI*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadUI();
    }

    /*This Method Connects the view holder to the data model*/
    private void loadUI(){
        Data data=loadData();
        DataHolder holder=loadDataHolder();
        holder.loadData(data.getHeader(),data.getPara());
    }

    /*This Method Fills Data in the Model*/
    private Data loadData(){
        Data data=new Data();
        data.setHeader("This is the Heading");
        data.setPara("Paragraph is the one you are able to see here");
        return data;
    }

    /*Fetches the Controls and Loads the Data Holder*/
    private DataHolder loadDataHolder(){
        DataHolder holder=new DataHolder();
        holder.setPara((TextView) findViewById(R.id.text_para));
        holder.setHeader((TextView) findViewById(R.id.text_header));
        return holder;
    }

    /*Creates a mock view(Data) Holder*/
    class DataHolder{



        public void loadData(String header,String para){
            this.header.setText(header);
            this.para.setText(para);
        }

        private TextView header;

        public TextView getPara() {
            return para;
        }

        public void setPara(TextView para) {
            this.para = para;
        }

        public TextView getHeader() {
            return header;
        }

        public void setHeader(TextView header) {
            this.header = header;
        }

        private TextView para;
    }

    /*Model Class for the Data handling*/
    class Data{
        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getPara() {
            return para;
        }

        public void setPara(String para) {
            this.para = para;
        }

        private String header;
        private String para;
    }
}
