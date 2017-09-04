import com.fasterxml.jackson.annotation.JsonValue;

public class Element {

    @JsonValue
    public Integer element;

    public Element (Integer i) {

        this.element = i;
    }
}
