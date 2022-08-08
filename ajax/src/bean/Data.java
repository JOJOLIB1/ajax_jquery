package bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @className: bean.Data
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-08 21:34
 */
public class Data implements Serializable {
    public String data;

    public Data(String data) {
        this.data = data;
    }

    public Data() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data='" + data + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data1 = (Data) o;
        return Objects.equals(data, data1.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
