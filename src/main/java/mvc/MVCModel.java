package mvc;

public class MVCModel {

    private String view;
    private Object data;

    public MVCModel(String view, Object data) {
        this.view = view;
        this.data = data;
    }

    public String getView() {
        return view;
    }

    public Object getData() {
        return data;
    }
}
