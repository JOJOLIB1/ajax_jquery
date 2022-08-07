package bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @className: bean.Area
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-07 11:17
 */
public class Area implements Serializable {
    private int code;
    private String name;

    public Area(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Area() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return code == area.code && Objects.equals(name, area.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
